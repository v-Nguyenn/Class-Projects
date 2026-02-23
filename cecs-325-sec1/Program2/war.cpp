// Author: Vincent Nguyen
// CECS 325-0
// Program 2 - One Card War
// Due 02/23/2026
// 
// I certify that this program is my own original work. I did not copy 
// any part of this program from any other source including AI use. I 
// did not share this program with anyone. I further certify that I typed
// each and every line of code in this program.

#include <iostream>
#include <vector>
using namespace std;

/**
 * @brief Represents a card and has functions to compare cards and display the cards
 */
class Card
{
   private:
      char rank;
      char suit;

   public:
      Card(char, char); // constructor to create a card, setting the suit and rank
      // Display and compare are public because they are used by other functions
      void display() // display the card example: AC, 10S, KD 
      {
      
      }
      
      int compare(Card) // return 1 for win, 0 for tie, -1 for lose
      {

      }
}; // I keep forgetting to put this semicolon, must do for classes and structs 

/**
 * @brief A deck of 52 cards and has functions to deal, display, shuffle, and check
 * if the deck is empty.
 */
class Deck
{
   private:
      vector<Card> cards;
      char ranks[13] = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
      char suits[4] = {'S', 'C', 'D', 'H'};

   public:
      Deck();
      // deal a card if you can - otherwise we raise an exception
      Card deal()
      {

      }

      void display()
      {

      }
      void shuffle()
      {

      }
      bool isEmpty()
      {

      }
};

/**
 * @brief A struct to keep track of player name and statistics.
 */
struct Player
{
   string name;
   int win;
   int lose;
   int tie;
};

int main()
{

};