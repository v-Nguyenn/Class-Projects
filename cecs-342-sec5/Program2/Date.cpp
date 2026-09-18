//    Name: Vincent Nguyen
//    Class: CECS 342 Section 5
//    Project Name: Prog 1 - Fibo Race
//    Due Date: 09/24/2026
//
//    I certify that this program is my own original work. I did not
//    copy any part of this program from any other source including
//    inappropriate AI use. I did not share this program with anyone.
//    I further certify that I typed each and every line of code in this program.

// Figuring out Leap Year ?
// if year div by 4, leapyear
// if year div by 100 not leap year
// if year div by 400 is leap 

// How to know what day it is ?
// Julian day mod 7 to figure out day?  
#include <iostream>
using namespace std;

class Date
{
   private:
   int *dptr;

   public:
   // Default constructor to set the date to Jan 1, 1970(Unix Epoch time) 
   Date()
   {
      dptr = new int[3];
      dptr[0] = 1;
      dptr[1] = 1;
      dptr[2] = 1970;
   }

   // Overloaded constructor to set the date to the desired values.
   // Falls back to Default construtor if not set. 
   Date(int Month, int Day, int Year)
   {
      dptr = new int[3];
      dptr[0] = Month;
      dptr[1] = Day;
      dptr[2] = Year;
   }

   // Overloaded constructor to Julian date based on Unix Epoch time
   Date(int JulianDate)
   {
      int Month, Day, Year;
      // Based on Fliegel and van Flandern computer algorithm for converting
      // between Julian dates in Fortran. 
      JulianDate = Day - 32075 + 1461 * 
         (Year + 4800 + (Month - 14) / 12) / 4 + 367 *
         (Month - 2 - (Month - 14) / 12 * 12) / 12 - 3 * 
         ((Year + 4900 + (Month - 14) / 12) / 100 / 4);
   }
};