#include <iostream>

int main()
{
   // &&  = check if two conditions are true
   // || = check if at least one of two conditions are true
   // ! = reverses the logical state of its operand

   int temp;

   std::cout << "What is the temperature: ";
   std::cin >> temp;

   if(temp > 0 && temp < 30) // both of these conditions must be true otherwise skip
   { 
      std::cout << "The temperature is good!\n";
   }
   else
   {
      std::cout << "The temperature is bad!\n"; 
   }

   if( temp <= 0 || temp >= 30)
   {
      std::cout << "The temperature is bad!\n";
   }else{
      std::cout << "The temperature is good!\n";
   }    
   
   bool sunny  = false;

   if(sunny) // can also just type (sunny == true)
   {
      std::cout << "It is sunny outside";
   }else{
      std::cout << "It is cloudy outside!";
   }


   return 0;
}