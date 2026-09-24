//    Name: Vincent Nguyen
//    Class: CECS 342 Section 5
//    Project Name: Prog 2 - Overloading Operators in C++
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

#include <iostream>
#include <string>
using namespace std;

class Date
{
   private:
   int *datePtr;
   static int objectCount;

   public:
   // Default constructor (Set the date to Jan 1, 1970 (Unix Epoch time)) 
   Date()
   {
      datePtr = new int[3];
      datePtr[0] = 1;
      datePtr[1] = 1;
      datePtr[2] = 1970;
      objectCount++;
   }

   // Overloaded constructor (Set the date for valid arguments are provided).
   // Falls back to Default construtor if not set using : Date() 
   Date(int month, int day, int year) : Date()
   {
      if(isValid(month, day, year))
      {
      datePtr[0] = month;
      datePtr[1] = day;
      datePtr[2] = year;
      }
   }

   // Copy constructor to copy values from datePtr without modifying the original
   Date(const Date &copyFrom) // const protects the object by not modifying og
   {
      // new object's slot [i] = orginal's object slot[i]
      datePtr = new int[3];
      datePtr[0] = copyFrom.datePtr[0];
      datePtr[1] = copyFrom.datePtr[1];
      datePtr[2] = copyFrom.datePtr[2];
      objectCount++;
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
      datePtr = new int[3];
      datePtr[0] = month;
      datePtr[1] = day;
      datePtr[2] = year;
      objectCount++;
   }

   // Function to convert Gregorian to Julian date 
   int gregToJulian(int month, int day, int year)
   {
      // Based on Fliegel and van Flandern computer algorithm for converting
      // between Julian dates in Fortran. Changed variables to be readable.
      int sum = year + 4900 + (month - 14) / 12;
      int julianDate = day - 32075 + 1461 * 
         (year + 4800 + (month - 14) / 12) / 4 + 367 *
         (month - 2 - (month - 14) / 12 * 12) / 12 - 3 * 
         (sum / 100) / 4;
      return julianDate;
   }

   // Destructor (de-allocate any memory assigned in constructor)
   // C++ provides one but would not affect our count
   ~Date()
   {
      delete [] datePtr;
      objectCount--;
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

   // Overload = assignment operator
   // Copies Date into an existing Date
   Date & operator= (const Date &copyFrom) 
   {
      // Check for self-assignment because d1 = d1 would read itself
      // free its own array and then assign garbage and copies garbage. 
      if(this != &copyFrom) // this keyword is the address of left object (d1, etc)
      {                     // &copyFrom is the address of the right object
         delete[] datePtr;
         datePtr = new int[3];
         datePtr[0] = copyFrom.datePtr[0];
         datePtr[1] = copyFrom.datePtr[1];
         datePtr[2] = copyFrom.datePtr[2];
      }
      return *this; // * makes the address in to an object returns the object.
   }

   // Overload + operator
   Date operator+ (int day)
   {

   }

   // Use the friend operator to access the private members of the named friend class
   friend Date operator+ (int day, const Date &date)
   {

   }

   // Overload += operator
   Date & operator+=(int day)
   {

   }

   Date & operator-=(int day)
   {

   }


   // if we do Date it calls the copy constructor for every comparison.
   // We use Date&
   Date operator> (const Date&) 
   {
      // return bool;
   }
   bool isLeapYear(int year)
   {
      if (year % 400 == 0) // if divisible by 400, leapyear.
      {
         return true;
      }
      else if (year % 100 == 0) // if divisible by 100, not a leapyear..
      {
         return false;
      }
      else if (year % 4 == 0) // if divisible by 4, leap year.
      {
         return true;
      } 
      else 
      {
         return false;
      }
   }

   // Checks if the the month, day, and year are valid.
   bool isValid(int month, int day, int year)
   {  
      int daysInMonth[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
      

      if (month > 12 || month < 1) // if month out of range.
      {
         return false;
      }
      // Gives us the maximum number of days in the month based on which number was given.
      int lastDayOfMonth = daysInMonth[month - 1]; 

      if (month == 2 && isLeapYear(year)) // checks february for leap year
      {
         // To account for leap year which would be 29 instead of 28.
         lastDayOfMonth += 1; 
      }
      
      if (day > lastDayOfMonth || day < 1) // if day out of range.
      {
         return false;
      }
      else if (year < 0)
      {
         return false;
      } 
      else 
      {
         return true;
      }
   }

};

// Initializes and defines objectCount because static int objectCount does not create memory
// only tells the compiler it exists by declaring it.
int Date::objectCount = 0;

int main(){
   cout << "My own test: " << endl;
   cout << "--- Testing default Constructor..." << endl;
   Date d1; // default constructor
   cout << "d1: results expected: 1/1/1970" << endl;
   cout << "d1: actual: ";
   cout << d1.getMonth() << "/" << d1.getDay() << "/" << d1.getYear() << endl;
   cout << "Day of the week expected: Thursday" << endl;
   cout << "Day of the week actual: " << d1.getDayName() << "\n" << endl;

   cout << "--- Testing overloaded constructor..." << endl;
   Date d2(10, 27, 2010); // overloaded constructor from pdf
   cout << "Day of the week expected: Wednesday" << endl;
   cout << "Day of the week actual: " << d2.getDayName() << "\n" << endl;

   // Overloaded constructor to test if it goes back to default constructor
   cout << "--- Testing out of bounds overloaded constructor with validity..." << endl;
   Date d3(13, 31, 2081);
   cout << "d3: results expected: 1/1/1970" << endl; // return to default
   cout << "d3: actual: ";
   cout << d3.getMonth() << "/" << d3.getDay() << "/" << d3.getYear() << endl;
   cout << "Day of the week expected: Thursday" << endl;
   cout << "Day of the week actual: " << d3.getDayName() << "\n" << endl;

   cout << "--- Testing copy constructor..." << endl;
   Date d4(d1); // Tests copy constructor
   cout << d4.getMonth() << "/" << d4.getDay() << "/" << d4.getYear() << endl;
   cout << "Day of the week expected: Thursday" << endl;
   cout << "Day of the week actual: " << d4.getDayName() << "\n" << endl;

   // Check Gregorian to Julian function
   d1.gregToJulian(1, 1, 1970);
   cout << "Gregorian To Julian member function: ";
   cout << d1.gregToJulian(1, 1, 1970);
};