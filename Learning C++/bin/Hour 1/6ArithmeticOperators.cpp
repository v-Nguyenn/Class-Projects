#include <iostream>

// arithmetic operators = return the result of a specific arithmetic
// operation ( + - * /)

// There is an order of operations of arithmetic operators

// parenthesis
// multiplication & division
// addition & subtraction

int main(){

   int students = 20;
   students = students + 1; 
   students += 1; //  add 1 to itself
   students ++; // this is how you add one as well

   students -= 1;
   students --; // subtracts 1 from the variable
   students = students * 2;
   students *= 2;

   students = students / 2;
   students /= 2;

   std::cout << students;

   students = 20;
   int remainder = students % 2; // modulus operator is a good way to determine if a number 
                                 // odd or even
                                 // gives you the remainder of any division


   std::cout << remainder;
   

   return 0;
}