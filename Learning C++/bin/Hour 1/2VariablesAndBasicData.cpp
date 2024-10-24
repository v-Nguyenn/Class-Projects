#include <iostream>

int main(){

   //integer (whole number)   
   int x = 5; 
   int y = 6; 

   int age = 21;
   int year = 2023;
   int days = 6;

   //double (number including decimal)
   double price = 10.99;
   double gpa = 2.5;
   double temperature = 25.1;

   // single character
   char grade = 'A';
   char initial = 'B'; // chars can only store a single character
   char currency = 'S';

   // boolean (true or false)
   bool student = false;
   bool power = true;
   bool forSale = false;

   // string (objects that represent a sequence of texts)
   std::string name = "Vincent";
   std::string food = "pizza";
   std::cout << days;
   std::cout << food;


   std::cout << "Hello " << name << '\n';
   std::cout << x <<  '\n';
   std::cout << y << std::endl;

   return 0;
}