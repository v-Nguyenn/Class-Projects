// Author: Vincent Nguyen
// CECS 325-01 Prog 1
// Due 02/11/2026

#ifndef CARD_H // This is a guard to prevent multiple inclusions

#include <string>
using namespace std;

class Card
{
   private:
      char suit; // H, D, C, S (hearts, diamonds, clubs, spades)
      char rank; // A, 2-9, J, Q, K
   public:
      Card();           // Default constructor
      Card(char suit, char rank); // Constructor for card, sets suit and rank
      void show();      // Show the card example: AC, 10S, KD
      int compare(Card); // Returns 1 for win, 0 for tie, -1 for lose
}
#endif // End of the guard