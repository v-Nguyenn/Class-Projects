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
#include <string>
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
   Date(int month, int day, int year) : Date()
   {
      datePtr = new int[3];
      datePtr[0] = month;
      datePtr[1] = day;
      datePtr[2] = year;
      count++;
   }

   // Overloaded constructor to create a date using the Julian
   Date(int julianDate)
   {
      // Based on Fliegel and van Flandern Julian date to Gregorian date.
      // Kept variables to match the temp variables used for the math.
      // Changed I, J, K to year, month, day respectively.
      int year, month, day, L, N; 
      L = julianDate + 68569;
      N = 4 * L / 146097;
      L = L - (146097 * N + 3) / 4;
      year = 4000 * (L + 1) / 1461001;
      L = L - 1461 * year / 4 + 31;
      month = 80 * L / 2447;
      day = L - 2447 * month / 80;
      L = month / 11;
      month = month + 2 - 12 * L;
      year = 100 * (N - 49) + year + L;
      datePtr[0] = month;
      datePtr[1] = day;
      datePtr[2] = year;
      count++;
   }

   // Function to convert Gregorian to Julian date 
   int gregToJulian(int month, int day, int year)
   {
      int month, day, year;
      month = getMonth();
      day = getDay();
      year = getYear();
      // Based on Fliegel and van Flandern computer algorithm for converting
      // between Julian dates in Fortran. Changed variables to be readable.
      int julianDate = day - 32075 + 1461 * 
         (year + 4800 + (month - 14) / 12) / 4 + 367 *
         (month - 2 - (month - 14) / 12 * 12) / 12 - 3 * 
         ((year + 4900 + ((month - 14) / 12) / 100) / 4);
      return julianDate;
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

   // Returns the day in integer form
   int getDay()
   {
      return datePtr[1];
   }
   
   // Returns the year in integer form
   int getYear()
   {
      return datePtr[2];
   }

   // Returns the name of the month - 3 letters only
   string getMonthName()
   {
      int month = datePtr[0];
      if (month == 1) return "Jan";
      else if (month == 2) return "Feb";
      else if (month == 3) return "Mar";
      else if (month == 4) return "Apr";
      else if (month == 5) return "May"; 
      else if (month == 6) return "Jun";
      else if (month == 7) return "Jul";
      else if (month == 8) return "Aug";
      else if (month == 9) return "Sep";
      else if (month == 10) return "Oct";
      else if (month == 11) return "Nov"; 
      else if (month == 12) return "Dec";
      return "Please enter a valid integer date (1 - 12).";
   }

   // Returns the week day name, Monday, Tuesday, etc 
   string getDayName()
   {
      int m = getMonth();
      int d = getDay();
      int y = getYear();
      int julianNumber = gregToJulian(m, d, y); // Grab Julian date
      int day = julianNumber % 7 + 1; // Mod julian number to get day of week 1 - 7  
      if (day == 1) return "Monday";
      else if (day == 2) return "Tuesday";
      else if (day == 3) return "Wednesday";
      else if (day == 4) return "Thursday";
      else if (day == 5) return "Friday";
      else if (day == 6) return "Saturday";
      else if (day == 7) return "Sunday";
      return "Not a valid day. ";
   }

};

int main(){
   cout << "My own test" << endl;
   Date d; // Test default constructor
}