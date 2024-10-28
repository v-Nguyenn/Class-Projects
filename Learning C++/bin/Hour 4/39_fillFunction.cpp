#include <iostream>


int main()
{
   // fill() = Fills a range of elements with a specified
   //          value
   //          fill(begin, end, value)
   
   const int SIZE = 10;
   std::string foods[SIZE];

   fill(foods, foods + (SIZE/2), "tacoes");
   fill(foods + (SIZE/2), foods + (SIZE/3)*2, "burritos");
   fill(foods + (SIZE/3)*2, foods + SIZE, "hotdog");

   for(std::string food : foods){
      std::cout << food << '\n';
   }


}