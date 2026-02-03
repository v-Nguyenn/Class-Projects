// Author: Vincent Nguyen
// CECS 325-01 Prog 1
// Due 02/11/2026

#include <iostream>
#include <card.h>
using namespace std;

Card::Card() // Default Constructor
{
   rank = "A";
   suit = "S";
}

Card::Card(char r, char s)
{
   rank = r;
   suit = s;
}

void Card::show()
{
   cout  << rank << suit << endl;
}

int Card::compare(Card other)
{
   if(rank < other){
      return 1
   } else if {

   }
}