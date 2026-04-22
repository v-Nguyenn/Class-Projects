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
#include <cstdlib>
// Overflowed at fibo 23 
//#define INTEGER short 

// Overflowed at fibo 46
#define INTEGER int

// #define INTEGER long long

// This is from Prog 5 Gold rabbits doc
INTEGER goldRabbits(INTEGER n)
{
   // Static map keeps the previously computed Fibonacci values
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
      throw string("negative n is invalid");
   }

   fiboIt = fibo.find(n);
   if (fiboIt != fibo.end())
   {
      return fiboIt->second;
   }

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

   INTEGER a = goldRabbits(n - 1);
   INTEGER b = goldRabbits(n - 2);

   INTEGER maxValue;
   if (sizeof(INTEGER) == sizeof(short))
   {
      maxValue = 32767;
   }
   else if (sizeof(INTEGER) == sizeof(int))
   {
      maxValue = 2147483647;
   }
   else
   {
      maxValue = static_cast<INTEGER>(9223372036854775807LL);
   }

   if (a > maxValue - b)
   {
      throw string("overflow error at fib(") + to_string(static_cast<long long>(n)) + ")";
   }

   fibo[n] = a + b;

   return fibo[n];
}

int main(int argc, char* argv[])
{
   for (int i = 1; i < argc; i++)
   {
      char* end = nullptr;
      long long value = strtoll(argv[i], &end, 10);

      long long minValue;
      long long maxValue;
      if (sizeof(INTEGER) == sizeof(short))
      {
         minValue = -32768;
         maxValue = 32767;
      }
      else if (sizeof(INTEGER) == sizeof(int))
      {
         minValue = -2147483648LL;
         maxValue = 2147483647LL;
      }
      else
      {
         minValue = -9223372036854775807LL - 1;
         maxValue = 9223372036854775807LL;
      }

      if (*argv[i] == '\0' || *end != '\0' ||
         value < minValue || value > maxValue)
      {
         cout << argv[i] << " is not an integer" << endl;
         continue;
      }

      INTEGER n = static_cast<INTEGER>(value);

      if (n == -1)
      {
         goldRabbits(n);
         continue;
      }

      try
      {
         INTEGER result = goldRabbits(n);
         cout << "fibo(" << n << "): " << result << endl;
      }
      catch (const string& msg)
      {
         cout << "fibo(" << n << "): " << msg << endl;
      }
   }

   return 0;
}

// Output for int data type and command line to send output to log
// $ (time goldrabbits 4 -1 6 -1 3 -1 monkey 9000 horse 45 47) &> goldrabbits.log

// argv[1] = 4 ... argv[11] = 47
// &> - Directs output and errors to log file.