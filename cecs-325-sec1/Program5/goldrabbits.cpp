// Author: Vincent Nguyen
// CECS 325
// Program 5 - Gold Rabbits - Maps
// 
// I certify that this program is my own original work
// I did not copy any part of this program from any other 
// source including AI use. I did not share this program with
// anyone. I further certify that I typed each and every line 
// of code in this program.

#include <iostream>
using namespace std;
#include <map>
#include <string>
#include <sstream>
// Overflowed at fibo 23 
//#define INTEGER short 

// Overflowed at fibo 46
#define INTEGER int

// #define INTEGER long long

// This is from Prog 5 Gold rabbits doc
INTEGER goldRabbits(INTEGER n)
{
   // Static map keeps the previously computed Fibonacci values
   // Key = month n, value = fibo(n)
   static map<INTEGER, INTEGER> fibo = 
   {
      {0, 1},
      {1, 1}
   };
   map<INTEGER, INTEGER>:: iterator fiboIt; 

   // -1 means print the map contents 
   if (n == -1)
   {
      for (fiboIt = fibo.begin(); fiboIt != fibo.end(); fiboIt++)
      {
         cout << fiboIt->first << ":" << fiboIt->second << endl;
      }
      cout << "end of Fibo map" << endl << endl;
      return 0;
   }

   if (n < 0)
   {
      // Any negative value except -1 is invalid input for Fibonacci.
      throw string("negative n is invalid");
   }

   // If we already computed fibo(n), return it right away (memoization).
   fiboIt = fibo.find(n);
   if (fiboIt != fibo.end())
   {
      return fiboIt->second;
   }

   // First Fibonacci index that cannot fit in this INTEGER type.
   INTEGER overflowAt;
   if (sizeof(INTEGER) == sizeof(short))
   {
      overflowAt = 23;
   }
   else if (sizeof(INTEGER) == sizeof(int))
   {
      overflowAt = 46;
   }
   else
   {
      overflowAt = 92;
   }

   // Prevent deep recursion for very large n and report where overflow begins.
   if (n >= overflowAt)
   {
      throw string("overflow error at fib(") + to_string(static_cast<long long>(overflowAt)) + ")";
   }

   // Recursive definition with memoization support from the map.
   INTEGER a = goldRabbits(n - 1);
   INTEGER b = goldRabbits(n - 2);

   // Save newly computed value so future calls are fast.
   fibo[n] = a + b;

   return fibo[n];
}

int main(int argc, char* argv[])
{
   // Process every command-line argument one by one.
   for (int i = 1; i < argc; i++)
   {
      // Parse directly into INTEGER. This also fails on out-of-range values.
      stringstream convert(argv[i]);
      INTEGER n;
      char extra;

      if (!(convert >> n) || (convert >> extra))
      {
         // Non-numeric strings or out-of-range values are reported and skipped.
         cout << argv[i] << " is not an integer" << endl;
         continue;
      }

      if (n == -1)
      {
         // print the current fibo map.
         goldRabbits(n);
         continue;
      }

      try
      {
         // Compute first, then print. If overflow happens, catch block handles it.
         INTEGER result = goldRabbits(n);
         cout << "fibo(" << n << "): " << result << endl;
      }
      catch (const string& msg)
      {
         // Keep going to next argument even after an overflow/input error.
         cout << "fibo(" << n << "): " << msg << endl;
      }
   }

   return 0;
}

// Output for int data type and command line to send output to log
// $ (time goldrabbits 4 -1 6 -1 3 -1 monkey 9000 horse 45 47) &> goldrabbits.log

// argv[1] = 4 ... argv[11] = 47
// &> - Directs output and errors to log file.