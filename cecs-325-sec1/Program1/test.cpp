// Author: Vincent Nguyen
// CECS 325-01 
// Program 1 - One Card War
// Due 02/11/2026
//
// I certify that this program is my own original work. I did not copy any part
// of this program from any other source including inappropriate AI use. I did not
// share this program with anyone. I further certify that I typed each and every line
// of code in this program.

#include <iostream>
#include "card.h"
#include "deck.h"
using namespace std;

int main()
{
// Verify Card Deck::show() return all 52 unique cards before error 
cout << endl;
cout << "Testing Deck creation and show():\n";
cout << "Should display 4 x 13 deck: \n";
Deck warDeck; // constructor 
warDeck.show();

// Verify Card::show() to display a single card
cout << "Testing Card::Show()" << endl;
cout << "Should display ?? " << endl;
Card defaultCard;
defaultCard.show();
cout << endl;

// Verify Card::Card(char cardRank, char cardSuit) to display in proper format 'AS'
cout << "Testing Card::Card(Char cardRank, char cardSuit):\n";
cout << "Should display AS " << endl;
Card parameterizedCard('A', 'S');
parameterizedCard.show();
cout << endl;

// Verify Card Deck::deal() returns the card in the correct order
cout << "Testing Card Deck::deal():\n";
cout << "Should display first card: AS" << endl;
Card dealtCard = warDeck.deal(); 
dealtCard.show();
cout << endl;

// Verify Card Deck::deal and show 5 cards in proper order
cout << "Testing Card Deck::deal():\n";
cout << "Should display 5 cards:\n";
for (int i = 0; i < 5; i++)
{
   warDeck.deal().show();
   cout << " ";
   if ((i + 1) % 13 == 0) cout << endl;
}
cout << endl;

// Verify void Deck::shuffle() if cards are randomly shuffled properly
cout << "Testing void Deck::shuffle()\n";
cout << "Should be a shuffled deck:\n";
warDeck.shuffle();
warDeck.show();


// Verify Card::compare(Card other) and returns correct value, 1, -1, 0
cout << "Testing Card::compare(Card other): \n";
cout << "Should display 1, -1, or 0 \n";
cout << "Player 1 card: ";
warDeck.shuffle();
Card playerOneCard = warDeck.deal();
playerOneCard.show();
cout << endl;

cout << "Player 2 card: ";
Card playerTwoCard = warDeck.deal();
playerTwoCard.show();
cout << endl;
cout << playerOneCard.compare(playerTwoCard) << endl;

return 0;
}

