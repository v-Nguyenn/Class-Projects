#include <iostream>

int main(){

   std::string cars[][3] = {{"Mustang", "Escape", "F-150"},
                           {"Corvette", "Equinox", "Silverado"},
                           {"Challenger", "Durango", "Ram 1500"}};
   
   // The fords in row 1
   // cars[row][column]
   std::cout << cars[0][0] << " ";
   std::cout << cars[0][1] << " ";
   std::cout << cars[0][2] << "\n";

   // The cars from Chevy
   std::cout << cars[1][0] << " ";
   std::cout << cars[1][1] << " ";
   std::cout << cars[1][2] << "\n";

   // The cars from Dodge
   std::cout << cars[2][0] << " ";
   std::cout << cars[2][1] << " ";
   std::cout << cars[2][2] << "\n";

   // This can also be done in nested loops

   return 0;
}