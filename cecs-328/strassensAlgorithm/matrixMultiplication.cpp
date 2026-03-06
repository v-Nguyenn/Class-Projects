// Author: Vincent Nguyen
// CECS 328
// Due 03/05/2026

// Multiplies two matrices using standard multiplication and Strassen's algorithm.
// The goal is to keep this readable for students while still being robust.

#include <iostream>
#include <fstream>
#include <string>
#include <stdexcept>
#include <vector>
#include <cctype>
#include <chrono>
#include <filesystem>
#include <algorithm>
#include <iomanip>
#include <thread>

using namespace std;
namespace fs = filesystem;

using Matrix = vector<vector<long long>>;

class MatrixParser
{
private:
	// Entire file text goes here so the parser can walk through it character-by-character.
	string text;
	// Current position in the text.
	size_t index;

	void skipWhitespace()
	{
		// Ignore spaces/newlines/tabs so formatting in the file does not matter.
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

		// If the next character is not what we expected, fail early with a clear message.
		if (currentChar() != expected)
		{
			throw runtime_error("Parser error: expected '" + string(1, expected) + "' at position " + to_string(index));
		}

		index++;
	}

	long long parseInteger()
	{
		skipWhitespace();

		size_t start = index;

		// Optional sign first.
		if (currentChar() == '+' || currentChar() == '-')
		{
			index++;
		}

		bool hasDigit = false;

		// Then consume as many digits as we can.
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
	explicit MatrixParser(const string &input)
		: text(input), index(0)
	{
	}

	Matrix parseMatrix()
	{
		// Expected format is like: {{1, 2}, {3, 4}}
		Matrix matrix;

		skipWhitespace();
		expectChar('{');

		skipWhitespace();
		if (currentChar() == '}')
		{
			throw runtime_error("Parser error: matrix cannot be empty");
		}

		while (true)
		{
			// Parse one row at a time: { ... }
			expectChar('{');

			vector<long long> row;
			row.push_back(parseInteger());

			while (true)
			{
				skipWhitespace();

				if (currentChar() == ',')
				{
					index++;
					row.push_back(parseInteger());
					continue;
				}

				if (currentChar() == '}')
				{
					index++;
					break;
				}

				throw runtime_error("Parser error: expected ',' or '}' at position " + to_string(index));
			}

			matrix.push_back(row);

			skipWhitespace();

			if (currentChar() == ',')
			{
				index++;
				continue;
			}

			if (currentChar() == '}')
			{
				index++;
				break;
			}

			throw runtime_error("Parser error: expected ',' or '}' at position " + to_string(index));
		}

		skipWhitespace();
		if (index != text.size())
		{
			// If we still have characters left, input had extra junk at the end.
			throw runtime_error("Parser error: unexpected trailing characters at position " + to_string(index));
		}

		// Make sure every row has the same number of columns.
		size_t columnCount = matrix[0].size();
		if (columnCount == 0)
		{
			throw runtime_error("Parser error: matrix rows cannot be empty");
		}

		for (size_t row = 0; row < matrix.size(); row++)
		{
			if (matrix[row].size() != columnCount)
			{
				throw runtime_error("Parser error: ragged matrix (rows have different lengths)");
			}
		}

		return matrix;
	}
};

Matrix createMatrix(size_t rows, size_t cols, long long initialValue = 0)
{
	// Small utility to keep matrix allocation consistent everywhere.
	// Best practice: centralize repeated construction logic in one helper.
	return Matrix(rows, vector<long long>(cols, initialValue));
}

Matrix readMatrixFromFile(const string &filePath)
{
	// Reads an entire file and parses one matrix from it.
	// Best practice: keep file I/O separate from algorithm code so each part is testable.
	// Open and read entire file as one string so parser can process it.
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

	MatrixParser parser(content);
	return parser.parseMatrix();
}

Matrix multiplyStandard(const Matrix &a, const Matrix &b)
{
	// Regular O(n^3) multiply. This is our baseline and our fallback for small sizes.
	if (a.empty() || b.empty())
	{
		throw runtime_error("Cannot multiply empty matrices");
	}

	size_t aRows = a.size();
	size_t aCols = a[0].size();
	size_t bRows = b.size();
	size_t bCols = b[0].size();

	if (aCols != bRows)
	{
		// Core compatibility check: inner dimensions must match.
		throw runtime_error("Dimension mismatch: A columns must match B rows");
	}

	Matrix result = createMatrix(aRows, bCols, 0);

	for (size_t i = 0; i < aRows; i++)
	{
		for (size_t k = 0; k < aCols; k++)
		{
			for (size_t j = 0; j < bCols; j++)
			{
				// result[i][j] += A row dot B column contribution
				result[i][j] += a[i][k] * b[k][j];
			}
		}
	}

	return result;
}

Matrix addMatrix(const Matrix &a, const Matrix &b)
{
	// Element-wise addition for same-size matrices.
	// Best practice: use focused helpers so Strassen formulas stay readable.
	// Helper used heavily by Strassen.
	size_t rows = a.size();
	size_t cols = a[0].size();

	Matrix result = createMatrix(rows, cols);

	for (size_t i = 0; i < rows; i++)
	{
		for (size_t j = 0; j < cols; j++)
		{
			result[i][j] = a[i][j] + b[i][j];
		}
	}

	return result;
}

Matrix subtractMatrix(const Matrix &a, const Matrix &b)
{
	// Element-wise subtraction for same-size matrices.
	// Best practice: keep arithmetic helpers small and predictable.
	// Another helper used heavily by Strassen.
	size_t rows = a.size();
	size_t cols = a[0].size();

	Matrix result = createMatrix(rows, cols);

	for (size_t i = 0; i < rows; i++)
	{
		for (size_t j = 0; j < cols; j++)
		{
			result[i][j] = a[i][j] - b[i][j];
		}
	}

	return result;
}

size_t nextPowerOfTwo(size_t value)
{
	// Rounds up size to power-of-two for Strassen padding.
	// Best practice: isolate dimension math to avoid duplicate bugs.
	// Strassen likes power-of-two square sizes.
	size_t power = 1;

	while (power < value)
	{
		power <<= 1;
	}

	return power;
}

Matrix getSubMatrix(const Matrix &matrix, size_t rowStart, size_t colStart, size_t size)
{
	// Extracts one square block used as a quadrant in recursion.
	// Best practice: pass source by const reference to avoid accidental copies.
	// Copy out one quadrant block.
	Matrix sub = createMatrix(size, size);

	for (size_t i = 0; i < size; i++)
	{
		for (size_t j = 0; j < size; j++)
		{
			sub[i][j] = matrix[rowStart + i][colStart + j];
		}
	}

	return sub;
}

Matrix combineQuadrants(const Matrix &c11, const Matrix &c12, const Matrix &c21, const Matrix &c22)
{
	// Builds one matrix from four equal quadrants.
	// Best practice: keep "split" and "combine" logic symmetrical.
	// Merge 4 quadrants back into one full matrix.
	size_t half = c11.size();
	size_t size = half * 2;
	Matrix combined = createMatrix(size, size);

	for (size_t i = 0; i < half; i++)
	{
		for (size_t j = 0; j < half; j++)
		{
			combined[i][j] = c11[i][j];
			combined[i][j + half] = c12[i][j];
			combined[i + half][j] = c21[i][j];
			combined[i + half][j + half] = c22[i][j];
		}
	}

	return combined;
}

Matrix strassenRecursive(const Matrix &a, const Matrix &b, size_t threshold)
{
	// Core Strassen recursion.
	// Best practice: always include a base case threshold to avoid slow tiny recursions.
	// Assumes square matrices with size that is a power of two.
	// We guarantee that by padding in multiplyStrassen.
	size_t n = a.size();

	// For small subproblems, standard multiplication is usually faster.
	if (n <= threshold)
	{
		// Important practical optimization: stop recursing and use standard multiply.
		return multiplyStandard(a, b);
	}

	size_t half = n / 2;

	Matrix a11 = getSubMatrix(a, 0, 0, half);
	Matrix a12 = getSubMatrix(a, 0, half, half);
	Matrix a21 = getSubMatrix(a, half, 0, half);
	Matrix a22 = getSubMatrix(a, half, half, half);

	Matrix b11 = getSubMatrix(b, 0, 0, half);
	Matrix b12 = getSubMatrix(b, 0, half, half);
	Matrix b21 = getSubMatrix(b, half, 0, half);
	Matrix b22 = getSubMatrix(b, half, half, half);

	Matrix m1 = strassenRecursive(addMatrix(a11, a22), addMatrix(b11, b22), threshold);
	Matrix m2 = strassenRecursive(addMatrix(a21, a22), b11, threshold);
	Matrix m3 = strassenRecursive(a11, subtractMatrix(b12, b22), threshold);
	Matrix m4 = strassenRecursive(a22, subtractMatrix(b21, b11), threshold);
	Matrix m5 = strassenRecursive(addMatrix(a11, a12), b22, threshold);
	Matrix m6 = strassenRecursive(subtractMatrix(a21, a11), addMatrix(b11, b12), threshold);
	Matrix m7 = strassenRecursive(subtractMatrix(a12, a22), addMatrix(b21, b22), threshold);

	// Rebuild output quadrants from Strassen's 7 products.
	Matrix c11 = addMatrix(subtractMatrix(addMatrix(m1, m4), m5), m7);
	Matrix c12 = addMatrix(m3, m5);
	Matrix c21 = addMatrix(m2, m4);
	Matrix c22 = addMatrix(subtractMatrix(addMatrix(m1, m3), m2), m6);

	return combineQuadrants(c11, c12, c21, c22);
}

Matrix multiplyStrassen(const Matrix &a, const Matrix &b, size_t threshold = 64)
{
	// Public Strassen entry point for any valid A(mxn) * B(nxp).
	// Best practice: validate first, pad once, recurse, then trim once.
	// Public wrapper: validates dimensions, pads matrices, runs recursion, then unpads.
	if (a.empty() || b.empty())
	{
		throw runtime_error("Cannot multiply empty matrices");
	}

	size_t aRows = a.size();
	size_t aCols = a[0].size();
	size_t bRows = b.size();
	size_t bCols = b[0].size();

	if (aCols != bRows)
	{
		throw runtime_error("Dimension mismatch: A columns must match B rows");
	}

	// Pad both matrices to a square matrix with power-of-two dimensions.
	// This lets Strassen work even when original matrices are not square or not powers of two.
	size_t paddedSize = nextPowerOfTwo(max(aRows, max(aCols, bCols)));

	Matrix paddedA = createMatrix(paddedSize, paddedSize, 0);
	Matrix paddedB = createMatrix(paddedSize, paddedSize, 0);

	for (size_t i = 0; i < aRows; i++)
	{
		for (size_t j = 0; j < aCols; j++)
		{
			paddedA[i][j] = a[i][j];
		}
	}

	for (size_t i = 0; i < bRows; i++)
	{
		for (size_t j = 0; j < bCols; j++)
		{
			paddedB[i][j] = b[i][j];
		}
	}

	Matrix paddedResult = strassenRecursive(paddedA, paddedB, threshold);

	Matrix result = createMatrix(aRows, bCols);

	// Trim back to the real result size (ignore padding area).
	for (size_t i = 0; i < aRows; i++)
	{
		for (size_t j = 0; j < bCols; j++)
		{
			result[i][j] = paddedResult[i][j];
		}
	}

	return result;
}

bool areMatricesEqual(const Matrix &a, const Matrix &b)
{
	// Development guard: confirms both algorithms produce identical output.
	// Best practice: verify optimized code against a known-correct baseline.
	// Handy safety check while developing/testing.
	if (a.size() != b.size())
	{
		return false;
	}

	if (!a.empty() && a[0].size() != b[0].size())
	{
		return false;
	}

	for (size_t i = 0; i < a.size(); i++)
	{
		for (size_t j = 0; j < a[0].size(); j++)
		{
			if (a[i][j] != b[i][j])
			{
				return false;
			}
		}
	}

	return true;
}

long long sumEntries(const Matrix &matrix)
{
	// Computes assignment output metric (sum of all entries).
	// Best practice: keep reporting calculations in dedicated helpers.
	// Assignment asks for the sum of all entries in the product matrix.
	long long sum = 0;

	for (size_t i = 0; i < matrix.size(); i++)
	{
		for (size_t j = 0; j < matrix[0].size(); j++)
		{
			sum += matrix[i][j];
		}
	}

	return sum;
}

struct TestPair
{
	string label;
	string aPath;
	string bPath;
};

struct RunRecord
{
	string label;
	string fileA;
	string fileB;
	string status;
	long long standardSum;
	long long strassenSum;
	double standardMs;
	double strassenMs;
	double totalMs;
	string note;
};

string getPairKeyFromFilename(const string &fileName)
{
	// Pulls test id from names like 7a.txt / 7b.txt so files can be paired.
	// Best practice: parse naming rules in one place, not inside menu logic.
	// Examples: 1a.txt -> "1", 10b.txt -> "10"
	if (fileName.size() < 5)
	{
		return "";
	}

	if (fileName.substr(fileName.size() - 4) != ".txt")
	{
		return "";
	}

	char role = fileName[fileName.size() - 5];
	if (role != 'a' && role != 'b')
	{
		return "";
	}

	return fileName.substr(0, fileName.size() - 5);
}

bool isAllDigits(const string &text)
{
	// Simple input validation helper.
	// Best practice: validate user input before converting to numbers.
	if (text.empty())
	{
		return false;
	}

	for (size_t i = 0; i < text.size(); i++)
	{
		if (!isdigit(static_cast<unsigned char>(text[i])))
		{
			return false;
		}
	}

	return true;
}

vector<TestPair> discoverMatrixPairs(const string &directoryPath)
{
	// Scans matrixData and builds valid a/b file pairs.
	// Best practice: discover available tests dynamically instead of hard-coding file names.
	if (!fs::exists(directoryPath))
	{
		throw runtime_error("Directory not found: " + directoryPath);
	}

	if (!fs::is_directory(directoryPath))
	{
		throw runtime_error("Not a directory: " + directoryPath);
	}

	vector<TestPair> pairs;

	for (const auto &entry : fs::directory_iterator(directoryPath))
	{
		if (!entry.is_regular_file())
		{
			continue;
		}

		string fileName = entry.path().filename().string();
		string key = getPairKeyFromFilename(fileName);

		if (key.empty())
		{
			continue;
		}

		fs::path aFile = fs::path(directoryPath) / (key + "a.txt");
		fs::path bFile = fs::path(directoryPath) / (key + "b.txt");

		if (fs::exists(aFile) && fs::exists(bFile))
		{
			bool alreadyAdded = false;
			for (size_t i = 0; i < pairs.size(); i++)
			{
				if (pairs[i].label == key)
				{
					alreadyAdded = true;
					break;
				}
			}

			if (!alreadyAdded)
			{
				TestPair pair;
				pair.label = key;
				pair.aPath = aFile.string();
				pair.bPath = bFile.string();
				pairs.push_back(pair);
			}
		}
	}

	sort(pairs.begin(), pairs.end(), [](const TestPair &left, const TestPair &right)
	{
		bool leftDigits = isAllDigits(left.label);
		bool rightDigits = isAllDigits(right.label);

		if (leftDigits && rightDigits)
		{
			return stoll(left.label) < stoll(right.label);
		}

		if (leftDigits != rightDigits)
		{
			return leftDigits;
		}

		return left.label < right.label;
	});

	return pairs;
}

void renderProgressBar(int percent)

{
	// Renders a single-line progress bar: [#####...NN%]
	// Best practice: keep terminal rendering in one function for consistent output style.
	int width = 25;
	int filled = static_cast<int>((percent * width) / 100.0);

	cout << "\r[";

	for (int i = 0; i < width; i++)
	{
		if (i < filled)
		{
			cout << "#";
		}
		else
		{
			cout << " ";
		}
	}

	cout << percent << "%]";
	cout.flush();

	if (percent == 100)
	{
		cout << '\n';
	}
}

void animateProgress(int &currentPercent, int targetPercent)
{
	// Moves progress forward smoothly from current to target percentage.
	// Best practice: progress should only move forward to avoid confusing output.
	if (targetPercent < currentPercent)
	{
		return;
	}

	for (int p = currentPercent; p <= targetPercent; p++)
	{
		renderProgressBar(p);
		this_thread::sleep_for(chrono::milliseconds(8));
	}

	currentPercent = targetPercent;
}

RunRecord runSingleTest(const TestPair &pair, size_t threshold)
{
	// Executes one selected test end-to-end and captures timing + result metadata.
	// Best practice: return a structured record so final reporting stays simple.
	RunRecord record;
	record.label = pair.label;
	record.fileA = fs::path(pair.aPath).filename().string();
	record.fileB = fs::path(pair.bPath).filename().string();
	record.status = "FAIL";
	record.standardSum = 0;
	record.strassenSum = 0;
	record.standardMs = 0.0;
	record.strassenMs = 0.0;
	record.totalMs = 0.0;
	record.note = "";

	auto totalStart = chrono::high_resolution_clock::now();
	int progress = 0;

	cout << "Testing " << pair.label << " : " << record.fileA << " x " << record.fileB << '\n';
	renderProgressBar(0);

	try
	{
		Matrix a = readMatrixFromFile(pair.aPath);
		animateProgress(progress, 20);

		Matrix b = readMatrixFromFile(pair.bPath);
		animateProgress(progress, 40);

		auto standardStart = chrono::high_resolution_clock::now();
		Matrix standardResult = multiplyStandard(a, b);
		auto standardEnd = chrono::high_resolution_clock::now();
		animateProgress(progress, 70);

		auto strassenStart = chrono::high_resolution_clock::now();
		Matrix strassenResult = multiplyStrassen(a, b, threshold);
		auto strassenEnd = chrono::high_resolution_clock::now();
		animateProgress(progress, 90);

		if (!areMatricesEqual(standardResult, strassenResult))
		{
			throw runtime_error("standard and Strassen results did not match");
		}

		record.standardSum = sumEntries(standardResult);
		record.strassenSum = sumEntries(strassenResult);
		record.standardMs = chrono::duration<double, milli>(standardEnd - standardStart).count();
		record.strassenMs = chrono::duration<double, milli>(strassenEnd - strassenStart).count();
		record.status = "PASS";
		record.note = "ok";
		animateProgress(progress, 100);
	}
	catch (const exception &ex)
	{
		record.note = ex.what();
		animateProgress(progress, 100);
	}

	auto totalEnd = chrono::high_resolution_clock::now();
	record.totalMs = chrono::duration<double, milli>(totalEnd - totalStart).count();

	if (record.status == "PASS")
	{
		cout << "Result sum = " << record.standardSum << "\n\n";
	}
	else
	{
		cout << "Result failed: " << record.note << "\n\n";
	}

	return record;
}

void printTestMenu(const vector<TestPair> &pairs)
{
	// Prints current test choices every loop.
	// Best practice: show both numeric id and underlying filenames for clarity.
	cout << "Available matrix tests in matrixData:\n";

	for (size_t i = 0; i < pairs.size(); i++)
	{
		cout << setw(2) << (i + 1) << ") " << pairs[i].label << "  ("
			 << fs::path(pairs[i].aPath).filename().string() << ", "
			 << fs::path(pairs[i].bPath).filename().string() << ")\n";
	}

	cout << "Type a number to run that test, or q to quit and show summary.\n";
}

void printSummaryTable(const vector<RunRecord> &records)
{
	// Prints all attempted runs in one table after user quits.
	// Best practice: aggregate results at the end so runs are easy to compare.
	cout << "\n==================== Run Summary ====================\n";

	if (records.empty())
	{
		cout << "No tests were run.\n";
		return;
	}

	cout << left
		 << setw(8) << "Test"
		 << setw(8) << "Status"
		 << setw(15) << "StandardSum"
		 << setw(15) << "StrassenSum"
		 << setw(14) << "Std(ms)"
		 << setw(14) << "Str(ms)"
		 << setw(14) << "Total(ms)"
		 << "Note" << '\n';

	cout << string(90, '-') << '\n';

	for (size_t i = 0; i < records.size(); i++)
	{
		cout << left
			  << setw(8) << records[i].label
	        << setw(8) << records[i].status
			  << setw(15) << records[i].standardSum
			  << setw(15) << records[i].strassenSum
			  << setw(14) << fixed << setprecision(3) << records[i].standardMs
			  << setw(14) << fixed << setprecision(3) << records[i].strassenMs
			  << setw(14) << fixed << setprecision(3) << records[i].totalMs
			  << records[i].note << '\n';
	}
}

int main()
{
	// Interactive driver loop: choose tests, run them, quit with q, print summary.
	// Best practice: keep main focused on orchestration, not heavy logic.
	try
	{
		string matrixDataDirectory = "matrixData";
		vector<TestPair> pairs = discoverMatrixPairs(matrixDataDirectory);

		if (pairs.empty())
		{
			throw runtime_error("No valid matrix pairs found in matrixData (expected files like 1a.txt and 1b.txt)");
		}

		size_t threshold = 64;
		vector<RunRecord> records;

		while (true)
		{
			printTestMenu(pairs);
			cout << "Selection: ";

			string input;
			getline(cin, input);

			if (input == "q" || input == "Q")
			{
				break;
			}

			if (!isAllDigits(input))
			{
				cout << "Please enter a valid number or q.\n\n";
				continue;
			}

			size_t choice = static_cast<size_t>(stoul(input));

			if (choice == 0 || choice > pairs.size())
			{
				cout << "Choice out of range. Pick 1 to " << pairs.size() << ".\n\n";
				continue;
			}

			RunRecord record = runSingleTest(pairs[choice - 1], threshold);
			records.push_back(record);
		}

		printSummaryTable(records);
	}
	catch (const exception &ex)
	{
		cerr << "Error: " << ex.what() << '\n';
		return 1;
	}

	return 0;
}