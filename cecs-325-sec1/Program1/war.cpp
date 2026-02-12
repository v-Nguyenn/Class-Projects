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
#include "deck.h" // Use double quotes <> is for system library
#include "card.h" // naming convention lower case and camel case for files
#include <string>
using namespace std;

int main()
{
   Deck playDeck;
   string name1, name2;

   // Get player names from user
   cout << "Enter the name of the first player: ";
   cin >> name1;
   cout << "Enter the name of the second player: ";
   cin >> name2; 

   // Display the original deck ordered
   playDeck.show();

   // Display the deck shuffled
   playDeck.shuffle();
   playDeck.show();

// Add counter, maybe clean up i + 1
   for(int i = 0; i < 26; i++) // Goes from 0 - 25 which is 26 games
      {

         Card card1 = playDeck.deal();
         Card card2 = playDeck.deal();

         cout << "Game" << i + 1 << endl;
         cout << "------" << endl;
         cout << "      " << name1 << " => " << ;
         cout << "      " << name2 << " => " << card2;

         int result = card1.compare(card2);
         if (result == 1)
         {
            cout << name1 << " ==> Winner" << endl;
         }
         else if (result == 0)
         {
            cout << "tie game " << i + 1 << endl;
         }
         else
         {
            cout << name1 << " lost game " << i + 1 << endl; 
         }
      }

   return 0;
};

// Class Feb 11
// We went over Program 2
// - 
// We went over vectors