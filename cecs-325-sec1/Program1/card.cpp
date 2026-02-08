// Author: Vincent Nguyen
// CECS 325-01 
// Program 1 - One Card War 
// Due 02/11/2026
//
// I certify that this program is my own original work. I did not copy
// any part of this program from any other source including AI use. I did 
// not share this program with anyone. I further certify that I typed each 
// and every line of code in this program.

#include <iostream>
#include <card.h>
using namespace std;

Card::Card() // Default Constructor
{
   rank;
   suit;
}

Card::Card(char r, char s)
{
   char rank = r;
   char suit = s;
}

void Card::show()
{
   cout  << rank << suit;
}

int Card::compare(Card other)
{
   int myValue;
   int otherValue;

   // Convert rank to integer values to compare
   // Use ASCII arithmetic to make integers
   if (rank >= '2' && rank <= '9')
   {
      myValue = rank - '0'; // 50 - 48 = 2 (ASCII values)
   } 
   else if (rank == 'T')
   {
      myValue = 10;
   }
   else if (rank == 'J')
   {
      myValue = 11;
   }
   else if (rank == 'Q')
   {
      myValue = 12;
   }
   else if (rank == 'K')
   {
      myValue = 13;
   }
   // Did explicit as opposed to else in case of invalid rank character 
   else if (rank == 'A')
   {
      myValue = 14;
   }

   // Converts the other card to integer value to compare
   if (other.rank  >= '2' && other.rank <= '9')
   {
      otherValue = other.rank - '0';
   }
   else if (other.rank == 'T')
   {
      otherValue = 10;
   }
   else if (other.rank == 'J')
   {
      otherValue = 11;
   }
   else if (other.rank == 'Q')
   {
      otherValue = 12;
   }
   else if (other.rank == 'K')
   {
      otherValue = 13;
   }
   else if (other.rank == 'A')
   {
      otherValue = 14;
   }

   // Compare user's value and other card value
   if (myValue < otherValue)
   {
      return -1;
   } 
   else if (myValue > otherValue)
   {
      return 1;
   } 
   return 0; // tie
}