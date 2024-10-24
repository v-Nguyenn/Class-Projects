#include <iostream>
#include <ctime>

int main ()
{
   // pseudo-random = NOT truly random (but close)

   srand(time(NULL));

   int num1 = (rand() % 6) + 1; // should give us a random number between 1-6
   int num2 = (rand() % 6) + 1; // This is how we do three die
   int num3 = (rand() % 6) + 1;

   std::cout << num1 << '\n';
   std::cout << num2 << '\n';
   std::cout << num3 << '\n';

   return 0;
}