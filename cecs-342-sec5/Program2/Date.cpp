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
   int *datePtr;
   static int count;

   public:
   // Default constructor (Set the date to Jan 1, 1970 (Unix Epoch time)) 
   Date()
   {
      datePtr = new int[3];
      datePtr[0] = 1;
      datePtr[1] = 1;
      datePtr[2] = 1970;
      count++;
   }

   // Overloaded constructor (Set the date for valid arguments are provided).
   // Falls back to Default construtor if not set using : Date() 
   Date(int Month, int Day, int Year) : Date()
   {
      datePtr = new int[3];
      datePtr[0] = Month;
      datePtr[1] = Day;
      datePtr[2] = Year;
      count++;
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

   // Destructor (de-allocate any memory assigned in constructor)
   // C++ provides one but would not affect our count
   ~Date()
   {
      delete [] datePtr;
      count--;
   }

   // Returns the month in integer form 
   int getMonth()
   {
      return datePtr[0];
   }

   //
   int getDay()
   {
      return datePtr[1];
   }
   
   int getYear()
   {
      return datePtr[2];
   }


};