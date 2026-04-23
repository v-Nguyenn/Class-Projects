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
// Overflowed at fibo 23 
//#define INTEGER short 

// Overflowed at fibo 46
#define INTEGER int

// #define INTEGER long long

// Calculates the given Fiboonacci number using a map to store the past values
INTEGER goldRabbits(INTEGER n)
{
   // Static map keeps the previously computed Fibonacci values
   // Key = month n, value = fibo(n)
   static map<INTEGER, INTEGER> fibo = 
   {
      {0, 1}, {1, 1} // base case where sequence in fibo is 0 or 1, they both are 1
   };

   // -1 means print the map contents 
   if (n == -1)
   {
      map<INTEGER, INTEGER>:: iterator fiboIt;
      for (fiboIt = fibo.begin(); fiboIt != fibo.end(); fiboIt++)
      {
         cout << fiboIt->first << ":" << fiboIt->second << endl;
      }
      cout << "end of Fibo map" << endl << endl;
      return 0;
   }

   // Check if we already computed fibo(n), return it right away. 
   // find() returns end() if the key is not in the map.
   if (fibo.find(n) != fibo.end())
   {
      return fibo[n];
   }

   // Note: checking (result < 0) after recursion didnt work for fibo(9000)
   // Pick overflow based on the INTEGER size we #define at the top.
   INTEGER overflowLimit;
   if (sizeof(INTEGER) == sizeof(short))
      overflowLimit = 23;
   else if (sizeof(INTEGER) == sizeof(int))
      overflowLimit = 46;
   else
      overflowLimit = 92; // long long

   if (n >= overflowLimit)
   {
      throw string("overflow error at fib(") + to_string(overflowLimit) + ")";
   }

   // Use recursion for Fibonacci value
   INTEGER result = goldRabbits(n - 1) + goldRabbits(n - 2);
   
   // We save the result in the map so we can use later
   fibo[n] = result;
   return result;
}

int main(int argc, char* argv[])
{
   // Go through every command line argument one by one.
   for (int i = 1; i < argc; i++)
   {
      // convert argv[i] into string to use
      string arg = argv[i];

      // Check if it is a valid integer
      bool isNumber = true;
      
      // if first character is a minus sign we skip it bc it is a char, but we
      // are checking if isdigit so it will return false if it sees -
      int start = 0; 
      if (arg[0] == '-')
      {
         start = 1;
      }

      // Now we check every character to make sure it is a number
      for (int j = start; j < arg.length(); j++)
      {
         if(!isdigit(arg[j])) 
         {
            isNumber = false; 
            break;
         }
      }

      if (!isNumber)
      {
         cout << arg << " is not an integer" << endl;
         continue;
      }

      // convert the string back to integer bc we know its a integer new.
      INTEGER n = stoi(arg);

      // Try Fibonacci and if not catch the overflow 
      try
      {
         INTEGER result = goldRabbits(n);
         if (n != -1)
            cout << "fibo(" << n << "):" << result << endl;
      }
      catch(string msg) 
      {
         cout << "fibo(" << n << "):" << msg << endl;
      }
   }

   return 0;
}

// Output for int data type and command line to send output to log
// $ (time goldrabbits 4 -1 6 -1 3 -1 monkey 9000 horse 45 47) &> goldrabbits.log

// argv[1] = 4 ... argv[11] = 47
// &> - Directs output and errors to log file.