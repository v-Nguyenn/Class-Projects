//    Name: Vincent Nguyen
//    Class: CECS 342 Section 5
//    Project Name: Prog 1 - Fibo Race
//    Due Date: 09/03/2026
//
//    I certify that this program is my own original work. I did not 
//    copy any part of this program from any other source including
//    inappropriate AI use. I did not share this program with anyone. I 
//    further certify that I typed each and every line of code in this program.

#include <iostream>
#include <chrono> 
using namespace std;
using namespace std::chrono;

// Fibo function from Prog 1 pdf
// Changed fibo function to contain long long instead of int
long long fibo(int n) 
{
   // Growth rate with recursion is O(2^n)
   if (n == 1 || n == 0)
      return 1;
   else
      return fibo(n - 1) + fibo(n - 2);
}

int main()
{
   // Prints 50 Fibonacci numbers and uses chrono library to keep track of times
   int num = 30;

   for(int i = 1; i <= num; i++)
   {
      // Measure start time of function
      // We use steady_clock over high_resolution_clock because hrc depends on the 
      // system and may not be as consistent with steady_clock. system_clock uses 
      // the real-world calendar and can be jump depending on synchronization of time.
      auto start = steady_clock::now(); 

      // Call function after starting timer
      int result = fibo(num);

      // auto determines return type automatically
      // Measure its end time
      auto end = steady_clock::now();

      // We subtract the end and start to find overall time it took to finish.
      auto elapsed = duration_cast<milliseconds>(end - start); 


      cout << i << result << "Time elapsed: " << elapsed.count() << endl;
   }  
   return 0;
}