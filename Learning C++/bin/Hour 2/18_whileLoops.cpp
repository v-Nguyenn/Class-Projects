#include <iostream>

int main()
{
   std::string name;

   while (name.empty()) // checks this condition once and runs the code again if it is not met
   {
      std::cout << "Enter your name: ";
      std::getline(std::cin, name);
   }
   
   std::cout << "Hello " << name;
   return 0;
}
// it is great to force the user to do something 