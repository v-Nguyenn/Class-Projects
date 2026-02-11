// Author: Vincent Nguyen
// CECS 325-01 
// Program 1 - One Card War
// Due 02/11/2026
//
// I certify that this program is my own original work. I did not copy
// any part of this program from any other source including inappropriate
// AI use. I did not share this program with anyone. I further certify that
// I typed each and every line of code in this program.

#ifndef DECK_H
#define DECK_H

#include "card.h"
using namespace std;

class Deck
{
   private:
   Card cards[52]; // initialize array
   int currentCard; // To keep track of index
   char ranks[13] = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
   char suits[4] = {'S', 'C', 'D', 'H'};

   public:
      Deck(); // default constructor
      Card deal();
      void show();
      void shuffle();
};
#endif