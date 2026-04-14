// Author: Vincent Nguyen
// CECs 325-0
// Program 3 - Sorting Contest
//
// I certify that this program is my own original work. I did not copy
// any part of this program from any other source including AI use. I 
// did not share this program with anyone. I further certify that I typed
// each and every line of code in this program.

#include <iostream>
#include <fstream>
#include <random>
#include <string>
using namespace std;

// Open and write a file numbers.nat
// Generating a number within the range we are looking for 
void generate(int count, int min, int max)
{
   ofstream outfile("numbers.dat"); // Create file "numbers.dats"
   for (int i = 0; i < count; ++i)
   {
      // Generate a random integer between min and max inclusive
      int randomNumber = rand() % (max - min + 1) + min;
      outfile << randomNumber << endl; // Add the randomNumber to the file
   }
   outfile.close();
};

// We pass in these two arguments because when we run ./generate 1000000 -100000 100000 
// in the script it is considered 4 arguments
// argc is number of command-line arguments and argv is an array of argument values as strings
int main(int argc, char* argv[])
{
   if (argc != 4) // argc includes program name, so 3 args is actually 4
   {
      cout << "Usage: " << argv[0] << " COUNT MIN MAX" << endl;
      return 1;
   }

   srand(time(0)); // Seed for the random number generator
   // Convert arguments to ints
   int count = stoi(argv[1]);
   int min = stoi(argv[2]);
   int max = stoi(argv[3]);
   generate(count, min, max);
}