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
   int currentCar; // To keep track of index

   public:
      Deck(); // default constructor
      Card deal();
      void show();
      void shuffle();
};
#endif