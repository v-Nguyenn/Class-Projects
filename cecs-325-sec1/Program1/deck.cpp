// Author: Vincent Nguyen
// CECS 326-01
// Program 1 - One Card War
// Due 02/11/2026
//
// I certify that this program is my own original work. I did not copy
// any part of this program from any other source including AI use.
// I did not share this program with anyone. I further certify that I 
// typed each and every line of code in this program.

#include <iostream>
#include <deck.h>
#include <card.h>
#include <cstdlib>

Deck::Deck()
{
   // Declare a rank array and suit array
   char ranks[13] = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
   char suits[4] = {'S', 'C', 'D', 'H'};
   currentCard = 0;

   // Populate the deck using two loops 
   // Outer loop for the rank and inner loop for the suit
   for (int i = 0; i < 13; i++)
   {
      for (int j = 0; j < 4; j++)
      {
         cards[i * 4 + j] = Card(ranks[i], suits[j]);
      }
   }
}

void Deck::deal()
{
   // Use random function to pick a random card?
   // If the currentCard counter is not empty (zero), deal a card
   if (currentCard != 52)
   {
      for (i = 0; i < 52; i++)
      {
         cou
      }

   }
} 

void Deck::show()
{
   int sum(int listOfCards[], int size)
   {
      int total = 0;
      for (int i = 0; i < size; i++)
         total += listOfCards[i];
      return total;
   }
}
