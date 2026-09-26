//    Name: Vincent Nguyen
//    Class: CECS 342 Section 5
//    Project Name: Prog 2 - Overloading Operators in C++
//    Due Date: 09/24/2026
//
//    I certify that this program is my own original work. I did not
//    copy any part of this program from any other source including
//    inappropriate AI use. I did not share this program with anyone.
//    I further certify that I typed each and every line of code in this program.

//    g++ myTest.cpp -o  myTest
//    .\myTest (for windows)
//    This is date.cpp just including my tests at the bottom as well as professor Gold's

#include <iostream>
#include <string>
#include <cstdio> // for driver program (getchar()).
using namespace std;

class Date
{
   private:
   int *datePtr;
   static int objectCount; // Static means it belongs to class as a whole 

   // ========================= Private Helper functions ========================= 

   // Checks of the month is a leap year, returns bool based on result.
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
   // Used in the Date(M/D/Y constructor)
   bool isValidDate(int month, int day, int year)
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

   public:

   // ======================== Constructors & Destructor =========================

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
      if(isValidDate(month, day, year))
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

   // Destructor (de-allocate any memory assigned in constructor)
   // C++ provides one but would not affect our count
   ~Date()
   {
      delete [] datePtr;
      objectCount--;
   }

   // ========================== Julian Conversion =========================

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
   static int gregToJulian(int month, int day, int year) 
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

   // julian() is the name called in driver program. This wraps gregToJulian for the date.
   int julian() const // const so call function doesn't change object.
   {
      return gregToJulian(getMonth(), getDay(), getYear());
   }

   // ========================= Getters & Other Information ========================== 

   // Returns the month in integer form 
   int getMonth() const 
   {
      return datePtr[0];
   }

   // Returns the day in integer form
   int getDay() const
   {
      return datePtr[1];
   }
   
   // Returns the year in integer form
   int getYear() const
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
      int julianNumber = julian(); // Grab Julian date 
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

   // Returns all the Dates being constructed
   static int GetDateCount()
   {
      return objectCount; // the variable we declared initially read only.
   }

   static int count()
   {
      return objectCount;
   }
   
   // ======================== Operators =========================

   // Date = Date: returns the copied date in the object.
   Date & operator=(const Date &copyFrom) 
   {
      // Check for self-assignment because d1 = d1 would read itself,
      // free its own array, and then assign garbage, and copies garbage. 
      if(this != &copyFrom) // this keyword is the address of left object (d1, etc)
      {                     // &copyFrom is the address of the right object
         delete[] datePtr;
         datePtr = new int[3];
         datePtr[0] = copyFrom.datePtr[0];
         datePtr[1] = copyFrom.datePtr[1];
         datePtr[2] = copyFrom.datePtr[2];
      }
      return *this; // * makes the address into an object, returns the object.
   }

   // Date += int: moves this day forward day days and returns itself.
   // Date constructor uses julian() to convert current date into julian number
   // day is an int which adds to that julian number and then calls the 
   // Date(int julianDate) to covert that number back into M/D/Y
   Date & operator+=(int day)
   {
      // *this uses the assignment operator to copy it into the current array
      return *this = Date(julian() + day); 
   }

   // Date -= int; moves this day backward day days and returns itself.
   Date & operator-=(int day)
   {
      return *this = Date(julian() - day); 
   }

   // Date + int: returns a new Date day after.
   Date operator+(int day) const
   {
      // Copy  constructor creating a local date named result. ex. Date D2(D1)
      // This is a deep copy and does not change the original values.
      Date newDate = *this; // Copies the current object to the local object.
      return newDate += day;
   }

   // int + date: returns a new date object that has been added by the amount of days.
   friend Date operator+(int day, const Date &date)
   // Use the friend operator to access the private members of the named friend class
   // This is because int is on the left, so it can't be a member of Date.
   {
      Date newDate = date; // copy the parameter
      return newDate += day;
   }

   // Date - int: return a new Date day earlier.
   Date operator-(int day) const
   {
      Date newDate = *this;
      return newDate -= day;
   }

   // Date - Date: days in between two dates returns the integer difference.
   friend int operator-(const Date &date, const Date &other)
   {
      // Subtract julian values to receive the integer difference or days inbetween.
      int difference = (date.julian()) - (other.julian());
      return difference;
   }

   // ++Date: adds one and returns the date one day forward
   Date & operator++()
   {
      return *this += 1; 
   }

   // --Date: subtracts one and returns the date one day backward.
   Date & operator--()
   {
      return *this -= 1;
   }

   // Date++: moves forward one day, returns the old date.
   Date operator++(int day)
   {
      Date oldDate = *this; // copy this to local object
      *this += 1;           // add *this by 1
      return oldDate;       // returned the saved old value.
   } 

   // Date--: moves backward one day, returns the old date.
   Date operator--(int day)
   {
      Date oldDate = *this;
      *this -=1;
      return oldDate;
   }

   // cout << Date: prints M/D/Y, friend because cout is on the left like int. 
   friend ostream & operator<< (ostream &out, const Date &date)
   {
      out << date.getMonth() << "/" << date.getDay() << "/" << date.getYear();
      return out; 
   }

   // Date > Date: returns bool whether one date is ahead of a date.
   friend bool operator>(const Date &date, const Date &other)
   {
      // We compare julian dates and return when left side is larger. 
      // If is not needed because this is already true or false.
      return date.julian() > other.julian();
   }

   // Date < Date: returns bool whether one date is behind a date.
   friend bool operator<(const Date &date, const Date &other)
   {
      return date.julian() < other.julian();
   }

   // Date == Date: returns bool if both dates are equal.
   friend bool operator==(const Date &date, const Date &other)
   {
      return date.julian() == other.julian(); 
   }
};

// Initializes and defines objectCount because static int objectCount does not create memory
// only tells the compiler it exists by declaring it.
int Date::objectCount = 0;


/*
========================= Main Driver program =========================
testDate.cpp provided by Author.
Author: Master Steven H. Gold
*/

int main()
{
	Date epoch;
	Date duedate(10,24,2026);
	Date today(duedate);


	cout << endl;
	cout << "Today is " << today << endl;
	cout << "This program is due on " << duedate;
	cout << endl;

	cout << "(3)Right now there are "<<Date::GetDateCount() << " Date objects\n";
	{
		Date d1, d2, d3, d4;
		cout << "(7)Inside this block there are "<<Date::GetDateCount() << " Date objects\n";
	}
	cout << "(3)Outside the block there are "<<Date::GetDateCount() << " Date objects\n";

	Date dtemp(duedate);
	dtemp++;
	cout << "If you turn this assignment in on "<<dtemp<<" then is will be late.\n";
	cout << "It is due on "<<--dtemp<<" so don't be late.\n";
	cout << "One week from due date is "<<duedate+7<<endl;
   cout << "One week from due date is "<<7+duedate<<endl;
	cout << "One week earlier from due date is "<<duedate-7<<endl;

	cout << "The EPOCH date is "<<epoch<<" : ";
	cout << "That was "<< duedate - epoch << " days ago\n";
	
	Date bday(5,11,1959);
	cout << "Master Gold is "<< today - bday << " days old today\n";
	
	cout << "Today is Julian date "<<duedate.julian()<<endl;;
	cout << "Tomorrrow is Julian date "<<(++duedate).julian()<<endl;;

	cout << "The very first Julian date was " << Date(1,1,1970)-Date(1,1,1970).julian()<<endl;

	cout << "The very first Julian date was " << today - today.julian()<<endl;

	Date yesterday, tomorrow;
	yesterday = today-1;
	tomorrow = today+1;
	
	cout << "Yesterday was "<<yesterday << endl;
	cout << "Today is "<<today<<endl;
	cout << "Tomorrow is "<<tomorrow<<endl;

	cout << "Today is ";
	cout << ((today>tomorrow)?"greater than":"not greater than");
	cout << " than tomorrow\n";

	cout << "Today is ";
	cout << ((today<tomorrow)?"less than":"not less than");
	cout << " than tomorrow\n";

	cout << "Today is ";
	cout << ((today==tomorrow)?"equal to":"not equal to");
	cout << " tomorrow\n";

   // ========================= My Own Tests =========================

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
   cout << "Expected: " << "2440588" << endl;
   cout << "Actual: " << d1.gregToJulian(1, 1, 1970);

	getchar(); // Keep console open.

   
}