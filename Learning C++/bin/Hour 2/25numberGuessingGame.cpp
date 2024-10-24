#include <iostream>
#include <ctime>

int main()
{
   int num;
   int guess; // holds the player guess
   int tries; // how many tries it takes for the user to guess the num

   srand(time(NULL));
   num = (rand() % 100) + 1;
   
   std::cout << "****** Number Guessing Game ******\n";
   
   do
   {
      std::cout << "Enter a guess between (1-100): ";
      std::cin >> guess;
      tries++;

      if (guess > num)
      {
         std::cout << "Too high!\n";
      } 
      else if (guess < num)
      {
         std::cout << "Too low!\n";
      }
      else
      std::cout << "CORRECT! # of tries: " << tries << '\n';
   }
   while (guess != num);

   std::cout << "****** NUMBER GUESSING GAME ******";
   
   return 0;
}