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
   int scoreTies = 0;
   int name1wins = 0;
   int name2wins = 0;
   Deck playDeck;
   string name1, name2;

   // Get player names from user
   cout << "Enter the name of the first player: ";
   cin >> name1;
   cout << "Enter the name of the second player: ";
   cin >> name2; 
   cout << endl;

   // Display the original deck ordered
   cout << "Original Deck\n";
   playDeck.show();
   cout << endl;

   // Display the deck shuffled
   cout << "Shuffled Deck\n";
   playDeck.shuffle();
   playDeck.show();

// Add counter, maybe clean up i + 1
   for(int i = 0; i < 26; i++) // Goes from 0 - 25 which is 26 games
      {

         Card card1 = playDeck.deal();
         Card card2 = playDeck.deal();

         cout << endl;
         cout << "Game" << i + 1 << endl;
         cout << "------" << endl;
         cout << "      " << name1 << " => ";
         card1.show();
         cout << endl;
         cout << "      " << name2 << " => ";
         card2.show();
         cout << endl;

         int result = card1.compare(card2);
         if (result == 1)
         {
            cout << name1 << " ==> Winner " << endl;
            name1wins += 1;
         }
         else if (result == 0)
         {
            cout << "Tie game " << endl;
            scoreTies += 1;
         }
         else
         {
            cout << name2 << " ==> Winner " << endl; 
            name2wins += 1;
         }
      }

      // Print final stat board
      cout << endl;
      cout << "------ Final Stats -------\n";
      cout << "   " << name1 << " vs. " << name2 << endl;
      cout << "Wins:   " << name1wins << "     " << name2wins << endl;
      cout << "Losses: " << name2wins << "      " << name1wins << endl;
      cout << "Ties:   " << scoreTies << "      " << scoreTies << endl;

   return 0;
};
