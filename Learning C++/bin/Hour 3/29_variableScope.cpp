#include <iostream>

   // local variables = declared inside a function or block
   // Global variables = declared outside of all functions

//functions cant see inside other functions

int myNum = 3; // this is a global variable, best to avoid this because this
// pollutes the global namespace and variables in functions are more secure

void printNum();

int main() // a function will use the local varible first
{
   int myNum = 1;
   printNum(); // this must be done to make the func aware
   std::cout << "Main: " << myNum << "\n";

   // the scope resolution operator :: 
   std::cout << "Global version: " << ::myNum << "\n";
   return 0;
}

void printNum()
{  // we can have the same name because they are different
   // variable scopes
   int myNum = 2; 
   std::cout << "printNum: " << myNum << "\n";
}