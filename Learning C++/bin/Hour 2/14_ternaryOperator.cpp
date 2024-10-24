#include <iostream>

int main()
{
   // ternary operator ?: = replacement to an if/else statement
   // condition ? expression1 : expression2;
/*

   int grade = 75;

   if(grade >= 60)
   {
      std::cout << "You pass!";
   }
   else{
      std::cout << "You fail!";
   }
*/

   // can write it like this
   // int grade = 50;
   // grade >= 60 ? std::cout << "You Pass!" : std::cout << "You fail!";

   int number = 9;
   number % 2 == 1 ? std::cout << "ODD" : std::cout << "EVEN";

   bool hungry = false;

   // hungry ? std::cout << "You are hungry": std::cout << "You are full";
   std::cout << (hungry ? "You are hungry" : "You are full"); // : else 

   return 0;
}