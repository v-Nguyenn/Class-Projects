#include <iostream>

int main()
{
   std::string name;
   std::cout << "Enter your name: ";
   std::getline(std::cin, name);

   if(name.length() > 12){
      std::cout << "Your name can't be over 12 characters!";
   }else if (name.empty()) // check if the string is empty
   {
      std::cout << "You didn't enter your name";
   }else{
      std::cout << "Welcome " << name;
   }

   name.clear(); // this clears the name
   name = "dude";
   name.insert(0, "@");
   name.append("gmail.com"); // add a string to another string
   std::cout << "Your username is now \n" << name;
   std::cout << name.at(0);
   std::cout << name.find(' ');

   name.erase(0, 3); // erase part of a string (beginning index, ending index)
   return 0;
}