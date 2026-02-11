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
#include "deck.h"
#include "card.h"
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

Card Deck::deal()
{
   if (currentCard < 52)
   {
      return cards[currentCard++]; 
   }
   cout << "No Cards left!" << endl;
   return Card();
} 

void Deck::show()
{
   for (int i = 0; i < 52; i++)
   {
      // Calls the show card function 52 times.
      cards[i].show();
      cout << " ";
      // Every thirteen lines goes to new line
      if ((i + 1) % 13 == 0)
      {
         cout << endl;
      }
   }
}

void Deck::shuffle()
{
   srand(time(0)); // Seed random number generator from in class
   for (int i = 0; i < 52; i++)
   {
      int randomIndex = rand() % 52; // limit random numbers to 0 - 51
      Card temp = cards[i];
      cards[i] = cards[randomIndex];
      cards[randomIndex] = temp;
   }
}
