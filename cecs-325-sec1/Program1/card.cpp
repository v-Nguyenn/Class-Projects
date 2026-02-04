// Author: Vincent Nguyen
// CECS 325-01 Prog 1
// Due 02/11/2026

#include <iostream>
#include <card.h>
using namespace std;

Card::Card() // Default Constructor
{
   rank = 'A';
   suit = 'S';
}

Card::Card(char r, char s)
{
   rank = r;
   suit = s;
}

void Card::show()
{
   cout  << rank << suit << endl;
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