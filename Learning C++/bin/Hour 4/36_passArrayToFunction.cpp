#include <iostream>

// need a function declaration
double getTotal(double prices[], int size);

int main()
{
   double prices[] = {49.99, 15.92, 63, 9.99};
   int size = sizeof(prices) / sizeof(prices[0]); // size is in for loop
   double total = getTotal(prices, size); // when passing an array you only need the
                                    // the name and not the []


   std::cout << "$" << total;


   return 0;
}

double getTotal(double prices[], int size){ 
// this isn't going to work without int size because 
// when we pass an array into a function
// it becomes a pointer

   double total = 0; // variables can have the same name as long 
                     // as they are in a different function

   for (int i = 0; i < size; i++)
   {
      total += prices[i];
   }
   return total;
}