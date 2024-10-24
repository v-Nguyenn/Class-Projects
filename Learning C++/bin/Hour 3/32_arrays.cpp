#include <iostream>

// array = a data structure that can hold multiple values 
//         values are accessed by an index number
//         "kind of like a variable that holds multiple values;"

int main()
{
   
   std::string car[] = {"Corvette", "Mustang", "Camry"};

   // can create an array and assign values later
   std::string cars[] = {};
   
   cars[0] = "Camaro";
   cars[1] = "Mustang";
   cars[2] = "Camry";


   std::cout << car << '\n'; // this gives a memory address

   std::cout << car[0] << '\n';
   std::cout << car[1] << '\n';
   std::cout << car[2] << '\n';

   double prices;
   
   return 0;
}