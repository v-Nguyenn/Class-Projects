// Author: Vincent Nguyen
// CECS 325-0
// Program 3 - Sorting Contest
//
// I certify that this program is my own original work. I did not copy
// any part of this program from any other source including AI use. I
// did not share this program with anyone. I further certify that I typed
// each and every line of code in this program.

#include <iostream>
#include <fstream>
#include <vector>
using namespace std;

// Bubble sort from geeks for geeks. I swapped elements without using the library
void bubble(vector<int>& arr)
{
   int n = arr.size();
   bool swapped;

   for (int i = 0; i < n - 1; i++)
   {
      swapped = false;
      for (int j = 0; j < n - i - 1; j++)
      {
         if (arr[j] > arr[j + 1])
         {
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
            swapped = true;
         }
      }
      // If no two elements were swapped, then break (This is from geeks for geeks)
      if (!swapped)
         break;
   }
}

// Reads integers from the given filename and returns them as a vector
vector<int> readNumbers(const string& filename)
{
   ifstream infile(filename);
   // Handle error just in case
   if(!infile)
   {
      cout << "Error: Could not open input file. " << filename << "'." << endl;
      exit(1);
   }

   int num;
   vector<int> numbers;
   // Use the extraction operator with while loop to read each number 
   while (infile >> num) // >> for reading, << for writing
   {
      numbers.push_back(num);
   }
   return numbers;
}

// Writes the integers from the vector to the given filename, one line at at time
void writeNumbers(const string& filename, const vector<int>& numbers)
{
   ofstream outfile(filename);
   if(!outfile)
   {
      cout << "Error: Could not open output file '" << filename << "'." << endl;
      exit(1);
   }
   for (int num : numbers)
   {
      outfile << num << endl;
   }
}

// Main program to run the command line arguements
// Uses 2 command line parameters 
int main(int argc, char* argv[])
{
   // Check for the correct number of command-line arguments
   if (argc < 3)
   {
      cout << "Usage: " << argv[0] << " inputfile outputfile" << endl;
      return 1;
   }

   // Gets the input and output file names from command-line arguments
   string inputFile = argv[1];
   string outputFile = argv[2]; 

   // Reads the numbers from command line converting to int storing to the vector numbers, sorts with bubble, then writes it to output
   vector<int>numbers = readNumbers(inputFile); // I used numbers.dat originally but changed it from hardcoding.
   bubble(numbers); 
   writeNumbers(outputFile, numbers);           

   return 0;
}