#include <iostream>

int main()
{
   // size of() = determines the size in bytes of a variable
   //             variable, data type, class, objects, etc.

   std::string name = "Bro code"; // a string is a reference data type
   double gpa = 2.5;
   char grade = 'F';
   bool student = true;
   char grades[] = {'A', 'B', 'C', 'D', 'F'};

   std::cout << "grades: ";
   std::cout << sizeof(grades)/sizeof(char) << " elements\n";
   
   std::cout << "student: ";
   std::cout << sizeof(student) <<  " bytes\n";

   return 0;
}