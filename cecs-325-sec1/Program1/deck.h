// Author: Vincnt Nguyen
// CECS 325-01 Prog 1
// Due 02/11/2026

#ifndef DECK_H
#define DECK_H

#include "card.h"
using namespace std;

class Deck
{
   private:
   Card cards[52];
   int currentCar; // To keep track   

   public:
      Deck(); // default constructor
      Card deal();
      void show();
      void shuffle();
}