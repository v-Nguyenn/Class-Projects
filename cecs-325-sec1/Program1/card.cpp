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
#include "card.h"
using namespace std;

Card::Card() // Default Constructor
{
   rank = '?';
   suit = '?';
}

Card::Card(char cardRank, char cardSuit)
{
   rank = cardRank;
   suit = cardSuit;
}

void Card::show()
{
   if (rank == 'T')
   {
      cout << "10" << suit;
   }
   else
   {
      cout << rank << suit;
   }
}

int Card::compare(Card other)
{
   int thisRankIndex = -1;
   int otherRankIndex = -1;
   char rankOrder[] = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
   for (int i = 0; i < sizeof(rankOrder); i++)
   {
      if (rank == rankOrder[i])
      {
         thisRankIndex = i;
      }
      if (other.rank == rankOrder[i]) 
      {
         otherRankIndex = i;
      }
   }
   // Compare user's value and other card value based on index
   if (otherRankIndex < otherRankIndex)
   {
      return 1;
   } 
   else if (otherRankIndex > otherRankIndex)
   {
      return -1;
   } 
   return 0; // tie
}