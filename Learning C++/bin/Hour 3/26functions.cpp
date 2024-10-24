#include <iostream>

void happyBirthday(std::string name, int age);
// If we want to put the function after we have to 
// declare the function at the top and then we can put 
// put it after main

int main()
{
   // function = a block of reusable code
   std::string name = "Vince";
   int age;
   std::cout << "Enter your age: ";
   std::cin >> age;

   happyBirthday(name, age); // this calls the function

   return 0;
}

void happyBirthday(std::string name, int age)
{
   std::cout << "Happy Birthday to " << name << '\n';
   std::cout << "Happy Birthday to " << name << '\n';
   std::cout << "Happy Birthday dear " << name << '\n';
   std::cout << "Happy Birthday to " << name << '\n';
   std::cout << "You are " << age << " years old\n";
}
