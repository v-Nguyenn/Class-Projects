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
   Deck mydeck;
   string name1, name2;
   cout << "Enter two player names: ";
   cout << "First name: ";
   cin >> name1;
   cout << "Second name: ";
   cin >> name2; 
   mydeck.show();
   mydeck.shuffle();
   mydeck.show();

// Add counter, maybe clean up i + 1
   for(int i=0; i < 26; i++) // Goes from 0 - 25 which is 26 games
      {
         Card c1 = mydeck.deal();
         Card c2 = mydeck.deal();
         int p1 = c1.compare(c2);
         if (p1 == 1)
         {
            cout << name1 << " won game " << i + 1 << endl;
         }
         else if (p1==0)
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