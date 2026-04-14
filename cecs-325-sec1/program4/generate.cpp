// Author: Vincent Nguyen
// CECS 325
// Program 4 - Thread sorting or something 
//
// I certify that this program is my own original work. I did not 
// copy any part of this program from any other source including
// AI use. I did not share this program with anyone. I further 
// certify that I typed each and every line of code in this program.
// Code here is from program 3.

#include <iostream>
#include <fstream>
#include <random>
#include <string>
using namespace std;

// Function to generate numbers.dat file for the random numbers
void generate(int count, int min, int max)
{
   ofstream outfile("numbers.dat"); // Create file "numbers.dat"
   for (int i = 0; i < count; ++i)
   {
      // Generate random integer between min and max
      int randomNumber = rand() % (max - min + 1) + min;
      outfile << randomNumber << endl; // Add the randomNumber to the file
   }
   outfile.close();
}

// argc is number of command-line arguments and argv is an array of argument values 
int main(int argc, char* argv[])
{
   if (argc != 4) // argc includes program name, so 3 args is actually 4
   {
      cout << "Usage: " << argv[0] << " COUNT MIN MAX" << endl;
      return 1;
   }

   srand(time(0)); // Seed for the random number generator
   // Convert arguments to ints
   int count = stoi(argv[1]); // stoi converts string to int
   int min = stoi(argv[2]);
   int max = stoi(argv[3]);
   generate(count, min, max);
   cout << "Generated " << count << " numbers. " << endl; 
}