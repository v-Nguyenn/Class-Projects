#include <iostream>

// arrays are static structures

int main()
{
   std::string foods[5];
   int size = sizeof(foods)/sizeof(foods[0]);
   std::string temp;

   for(int i = 0; i < size; i++){
      std::cout << "Enter a food you like or 'q' to quit #" << i + 1 << ": ";
      // use getline function because user may have spaces
      std::getline(std::cin, temp);

      // This will check what we will put in the array
      if(temp == "q"){
         break;
      }
      else{
         foods[i] = temp;
      }
   }

   std::cout << "You like the following food:\n";

   // This for loop shouldn't display anything that is empty   
   for(int i = 0; !foods[i].empty(); i++)
   {
      std::cout << foods[i] << '\n';
   }
   return 0;
}

