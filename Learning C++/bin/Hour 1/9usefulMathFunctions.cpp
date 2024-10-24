#include <iostream>
#include <cmath>

int main()
{
   double x = 3.14;
   double y = 4;
   double z;

   //z = std::max (x, y);
   //z = std::min (x, y);

   //z = pow(2, 3); // 2 to the power of three
   //z = sqrt(9); // square root function
   //z = abs(-3); // absolute value function
   //z = round(x);
   //z = ceil(x); // round up
   z = floor(x); // x rounded down

   std::cout << z;
   return 0;
}