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
#include <time.h>
#include <iomanip>
using namespace std;
#include <map>
// Overflowed at fibo 23 
//#define INTEGER short 

// Overflowed at fibo 46
// #define INTEGER int

#define INTEGER long long

// This is from Prog 5 Gold rabbits doc
INTEGER goldRabbits(INTEGER n)
{
   // Create the map and initialize it for the first two values
   static map<INTEGER, INTEGER> fibo = 
   {
      {0, 1},
      {1, 1}
   };
   map<INTEGER, INTEGER>:: iterator fiboIt; 

   // If parameter is -1 function prints the contents of the map.
   if (n == -1)
   {
      cout << "Displaying fibo map: \n";
      if (fibo.size() == 0)
      {
         cout << "The fibonacci sequence is empty\n";
      }
      else
      {
         for (fiboIt = fibo.begin(); fiboIt != fibo.end(); fiboIt++)
         {
            cout << fiboIt -> first << ":" << fiboIt -> second << endl;
         }
      }
      return 0;
   }
}

int main()
{
   int const months = 47; // 120 months
   int start = time(0); // number of seconds since Jan 1, 1970
   for (int i = 0; i < months; i++)
   {
      int current = time(0);
      cout << setw(5) << current-start<< ":";
      cout << " goldRabbits(" << setw(2)<<i<<") = ";
      cout << setw(11) << goldRabbits(i) << endl; // call to gold rabbits
   }
}

// Output for int data type and command line to send output to log
// $ (time goldrabbits 4 -1 6 -1 3 -1 monkey 9000 horse 45 47) &> goldrabbits.log

// argv[1] = 4 ... argv[11] = 47
// &> - Directs output and errors to log file.