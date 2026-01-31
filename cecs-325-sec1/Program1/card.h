/*
 * Author: Vincent Nguyen
 * CECS 325-01 Program 1
 * Due 02/11/2026
 * 
 * Honorary Statement 
 */

// These are header guards to prevent multiple class definitions
#ifndef CARD_H // if not defined
#define CARD_H // defines it here

#include <string>
using namespace std;

class Card
{
   private:
      int rank;
      char suit;  

   public:
      Card();
      Card(string r, string s);
      void show();
      void compare();
};
#endif // ends the preprocessor block like a }