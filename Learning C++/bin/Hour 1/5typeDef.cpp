#include <iostream>
#include <vector>

// A good convention is done below
// the name usually has the _t at the end to signify it is a type

// typedef std::vector<std::pair<std::string, int>> pairlist_t;
// typedef std::string text_t;
// typedef int number_t;
 using text_t = std::string; // can also be done like this 
 using number_t = int;
 using std::cout;
 using double_t = double;


int main(){

   text_t firstName = "Bro";
   number_t age = 21;
   text_t lastName = "Ski";
   double_t money = 42069;
   
   std::cout <<  firstName << '\n';
   std::cout << age << '\n';
   cout << lastName << '\n';
   cout << money << '\n'; 
   
   // typedef = reserved keyword used to create an additional name
   // (alias) for another data type.
   // New identifier for an existing type
   // Helps with readibility and reduces typos
   // Use when there is a clear benefit
   // Replaced with 'using' (works better w/ templates)
   // kinda like a nickname and helps with readability


   return 0;

}