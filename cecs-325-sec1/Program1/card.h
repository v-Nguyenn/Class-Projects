// Author: Vincent Nguyen
// CECS 325-01 
// Program 1 - One Card War
// Due 02/11/2026
//
// I certify that this program is my own original work. I did not copy any
// part of this program from any other source including inappropriate AI use.
// I did not share this program with anyone. I further certify that I typed each
// and every line of code in this program.

#ifndef CARD_H // This is a guard to prevent multiple inclusions
#define CARD_H
#include <string>
using namespace std;

class Card
{
   private:
      char rank; // A, 2-9, J, Q, K
      char suit; // H, D, C, S (hearts, diamonds, clubs, spades);
      
   public:
      Card();           // Default constructor
      Card(char rank, char suit); // Constructor for card, sets suit and rank
      void show();      // Show the card example: AC, 10S, KD
      int compare(Card); // Returns 1 for win, 0 for tie, -1 for lose
};
#endif // End of the guard