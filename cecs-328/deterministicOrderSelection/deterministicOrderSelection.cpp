/**
 * Author: Vincent Nguyen
 * CECS 328
 * Due 03/05/2026
 *
 * For each of the following sets of numbers, determine the correct value of the order statistic.
 * The input will be of the form:
 *
 *   {9, {-384510907, 977350089, -447882330, 1565902303, 1911035140,
 *        -2006928812, -1874555214, 1274434577, 1917928800, 768922581}}
 *
 * The first number is i, and the second is the data set.
 * Find the i-th smallest number (1-indexed), so i=1 means the smallest.
 * The correct answer for the example above is 1911035140.
 *
 * Program flow:
 *   1. Scan the data/ folder for .txt input files.
 *   2. Parse each file — each file holds one test case in the format above.
 *   3. Run deterministic order selection (Median of Medians, O(n)) to find the answer.
 *   4. Write results to results.txt.
 */

#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <vector>
#include <stdexcept>
#include <cctype>
#include <algorithm>
#include <filesystem>
#include <iomanip>

using namespace std;
namespace fs = filesystem;

// ---------------------------------------------------------------------------
// Parser
// Handles the format: {i, {a, b, c, ...}}
// Same character-by-character approach as MatrixParser in matrixMultiplication.cpp.
// ---------------------------------------------------------------------------
class TestCaseParser
{
private:
   string text;
   size_t index;

   void skipWhitespace()
   {
      while (index < text.size() && isspace(static_cast<unsigned char>(text[index])))
      {
         index++;
      }
   }

    char currentChar() const
    {
        if (index >= text.size())
        {
            return '\0';
        }
        return text[index];
    }

    void expectChar(char expected)
    {
        skipWhitespace();
        if (currentChar() != expected)
        {
            throw runtime_error("Parser error: expected '" + string(1, expected) +
                                "' at position " + to_string(index));
        }
        index++;
    }

    long long parseInteger()
    {
        skipWhitespace();
        size_t start = index;

        // Allow an optional leading sign.
        if (currentChar() == '+' || currentChar() == '-')
        {
            index++;
        }

        bool hasDigit = false;
        while (index < text.size() && isdigit(static_cast<unsigned char>(text[index])))
        {
            hasDigit = true;
            index++;
        }

        if (!hasDigit)
        {
            throw runtime_error("Parser error: expected integer at position " + to_string(start));
        }

        try
        {
            return stoll(text.substr(start, index - start));
        }
        catch (...)
        {
            throw runtime_error("Parser error: integer out of range near position " + to_string(start));
        }
    }

public:
    explicit TestCaseParser(const string &input)
        : text(input), index(0)
    {
    }

    // Parses one test case: {i, {a, b, c, ...}}
    // Returns i in outI and the dataset in outNumbers.
    void parse(long long &outI, vector<long long> &outNumbers)
    {
        // Outer opening brace.
        expectChar('{');

        // First value is i.
        outI = parseInteger();

        // Comma separating i from the array.
        skipWhitespace();
        expectChar(',');

        // Now parse the inner array: {a, b, c, ...}
        skipWhitespace();
        expectChar('{');

        skipWhitespace();
        if (currentChar() == '}')
        {
            throw runtime_error("Parser error: dataset cannot be empty");
        }

        outNumbers.push_back(parseInteger());

        while (true)
        {
            skipWhitespace();

            if (currentChar() == ',')
            {
                index++;
                outNumbers.push_back(parseInteger());
                continue;
            }

            if (currentChar() == '}')
            {
                index++;
                break;
            }

            throw runtime_error("Parser error: expected ',' or '}' at position " + to_string(index));
        }

        // Outer closing brace.
        expectChar('}');

        skipWhitespace();
        if (index != text.size())
        {
            throw runtime_error("Parser error: unexpected trailing characters at position " + to_string(index));
        }
    }
};

// ---------------------------------------------------------------------------
// File I/O
// Keeping file reading and writing separate from the algorithm, same as Strassen.
// ---------------------------------------------------------------------------

string readFileContents(const string &filePath)
{
    // Opens the file and returns its entire contents as a string.
    // Best practice: keep file I/O isolated from algorithm code.
    ifstream file(filePath);

    if (!file)
    {
        throw runtime_error("Could not open file: " + filePath);
    }

    string content((istreambuf_iterator<char>(file)), istreambuf_iterator<char>());

    if (content.empty())
    {
        throw runtime_error("File is empty: " + filePath);
    }

    return content;
}

struct TestResult
{
    string fileName;
    long long i;
    long long answer;
    string status;
    string note;
};

void writeResultsToFile(const string &outputPath, const vector<TestResult> &results)
{
    // Writes all test results to a plain-text results file.
    // Best practice: separate output formatting from algorithm logic.
    ofstream out(outputPath);

    if (!out)
    {
        throw runtime_error("Could not open output file: " + outputPath);
    }

    out << "Deterministic Order Selection Results\n";
    out << string(42, '=') << "\n\n";

    for (size_t idx = 0; idx < results.size(); idx++)
    {
        const TestResult &r = results[idx];
        out << "File   : " << r.fileName << "\n";
        out << "i      : " << r.i << "\n";

        if (r.status == "PASS")
        {
            out << "Answer : " << r.answer << "\n";
            out << "Status : PASS\n";
        }
        else
        {
            out << "Status : FAIL\n";
            out << "Note   : " << r.note << "\n";
        }

        out << "\n";
    }

    out.flush();
}

// ---------------------------------------------------------------------------
// Deterministic Order Selection (Median of Medians)
// Finds the i-th smallest element in O(n) worst-case time.
//
// How it works:
//   1. Split the array into groups of 5.
//   2. Sort each group and find its median.
//   3. Collect all those medians and recursively find their median -- the "pivot".
//   4. Partition the full array around the pivot.
//   5. The pivot is now at its sorted position. If that matches i, return it.
//      Otherwise recurse into the correct half.
// ---------------------------------------------------------------------------

void insertionSort(vector<long long> &arr, size_t lo, size_t hi)
{
    // Sorts arr[lo..hi] in-place using insertion sort.
    // Used on small groups of 5 -- insertion sort is fast for tiny arrays.
    for (size_t j = lo + 1; j <= hi; j++)
    {
        long long key = arr[j];
        size_t k = j;
        while (k > lo && arr[k - 1] > key)
        {
            arr[k] = arr[k - 1];
            k--;
        }
        arr[k] = key;
    }
}

size_t partition(vector<long long> &arr, size_t lo, size_t hi, long long pivot)
{
    // Rearranges arr[lo..hi] so everything < pivot is left, everything > pivot is right.
    // Returns the final index of the pivot.
    // Find pivot in the range and move it to the end temporarily.
    for (size_t k = lo; k <= hi; k++)
    {
        if (arr[k] == pivot)
        {
            swap(arr[k], arr[hi]);
            break;
        }
    }

    size_t store = lo;
    for (size_t k = lo; k < hi; k++)
    {
        if (arr[k] < pivot)
        {
            swap(arr[k], arr[store]);
            store++;
        }
    }

    swap(arr[store], arr[hi]);
    return store;
}

long long medianOfMedians(vector<long long> arr, size_t lo, size_t hi, size_t rank);

long long getPivot(vector<long long> &arr, size_t lo, size_t hi)
{
    // Computes the median-of-medians pivot for arr[lo..hi].
    // Step 1: divide into groups of 5, sort each, collect medians.
    vector<long long> medians;

    size_t i = lo;
    while (i <= hi)
    {
        size_t groupEnd = min(i + 4, hi);
        insertionSort(arr, i, groupEnd);
        size_t mid = (i + groupEnd) / 2;
        medians.push_back(arr[mid]);
        i += 5;
    }

    // Step 2: recursively find the true median of those group medians.
    if (medians.size() == 1)
    {
        return medians[0];
    }

    return medianOfMedians(medians, 0, medians.size() - 1, (medians.size() - 1) / 2);
}

long long medianOfMedians(vector<long long> arr, size_t lo, size_t hi, size_t rank)
{
    // Recursively selects the element at position 'rank' in arr[lo..hi] in O(n) time.
    // rank is 0-indexed within the slice [lo..hi].
    if (lo == hi)
    {
        return arr[lo];
    }

    long long pivot = getPivot(arr, lo, hi);
    size_t pivotIndex = partition(arr, lo, hi, pivot);

    size_t pivotRank = pivotIndex - lo;

    if (rank == pivotRank)
    {
        return arr[pivotIndex];
    }
    else if (rank < pivotRank)
    {
        return medianOfMedians(arr, lo, pivotIndex - 1, rank);
    }
    else
    {
        return medianOfMedians(arr, pivotIndex + 1, hi, rank - pivotRank - 1);
    }
}

long long orderSelect(vector<long long> numbers, long long i)
{
    // Public entry point for order selection.
    // i is 1-indexed: i=1 means the smallest, i=n means the largest.
    // Best practice: validate i before doing any work.
    if (numbers.empty())
    {
        throw runtime_error("Dataset is empty");
    }

    long long n = static_cast<long long>(numbers.size());

    if (i < 1 || i > n)
    {
        throw runtime_error("i=" + to_string(i) + " is out of range for a dataset of size " + to_string(n));
    }

    // Convert 1-indexed i to 0-indexed rank.
    size_t rank = static_cast<size_t>(i - 1);
    return medianOfMedians(numbers, 0, numbers.size() - 1, rank);
}

// ---------------------------------------------------------------------------
// File discovery -- scans the data/ folder for .txt input files.
// Same pattern as discoverMatrixPairs in matrixMultiplication.cpp.
// ---------------------------------------------------------------------------

vector<string> discoverInputFiles(const string &directoryPath)
{
    // Returns sorted list of .txt file paths found in the given directory.
    if (!fs::exists(directoryPath))
    {
        throw runtime_error("Directory not found: " + directoryPath);
    }

    if (!fs::is_directory(directoryPath))
    {
        throw runtime_error("Not a directory: " + directoryPath);
    }

    vector<string> files;

    for (const auto &entry : fs::directory_iterator(directoryPath))
    {
        if (!entry.is_regular_file())
        {
            continue;
        }

        string ext = entry.path().extension().string();

        // Only pick up .txt files.
        if (ext == ".txt")
        {
            files.push_back(entry.path().string());
        }
    }

    sort(files.begin(), files.end());
    return files;
}

// ---------------------------------------------------------------------------
// Main
// ---------------------------------------------------------------------------

int main()
{
    cout << "Deterministic Order Selection\n";
    cout << string(42, '=') << "\n\n";

    string dataDir = "data";
    string outputFile = "results.txt";

    // Make sure the data directory exists.
    if (!fs::exists(dataDir))
    {
        fs::create_directory(dataDir);
        cout << "Created data/ folder. Place your .txt input files there and re-run.\n";
        return 0;
    }

    vector<string> inputFiles;

    try
    {
        inputFiles = discoverInputFiles(dataDir);
    }
    catch (const exception &ex)
    {
        cerr << "Error scanning data folder: " << ex.what() << "\n";
        return 1;
    }

    if (inputFiles.empty())
    {
        cout << "No .txt files found in data/. Add your input files and re-run.\n";
        return 0;
    }

    cout << "Found " << inputFiles.size() << " input file(s).\n\n";

    vector<TestResult> results;

    for (size_t idx = 0; idx < inputFiles.size(); idx++)
    {
        string path = inputFiles[idx];
        string fileName = fs::path(path).filename().string();

        cout << "Processing: " << fileName << " ... ";

        TestResult result;
        result.fileName = fileName;
        result.i = 0;
        result.answer = 0;
        result.status = "FAIL";

        try
        {
            string content = readFileContents(path);

            long long i = 0;
            vector<long long> numbers;
            TestCaseParser parser(content);
            parser.parse(i, numbers);

            result.i = i;
            result.answer = orderSelect(numbers, i);
            result.status = "PASS";

            cout << "Answer = " << result.answer << "\n";
        }
        catch (const exception &ex)
        {
            result.note = ex.what();
            cout << "FAILED: " << ex.what() << "\n";
        }

        results.push_back(result);
    }

    // Write all answers to results.txt.
    try
    {
        writeResultsToFile(outputFile, results);
        cout << "\nResults written to " << outputFile << "\n";
    }
    catch (const exception &ex)
    {
        cerr << "Could not write results file: " << ex.what() << "\n";
    }

    return 0;
}

