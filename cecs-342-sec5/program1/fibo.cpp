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
#include <iomanip>
using namespace std;
using namespace std::chrono;

// Recursively computes nth Fibonacci Sequence with a growth rate of O(2^n) 
long long fibo(int n) // long long can safely hold 18 digits. Int 9 digits
{
   if (n == 1 || n == 0)
      return 1;
   else
      return fibo(n - 1) + fibo(n - 2);
}

int main()
{
   // Prints Fibonacci numbers and uses chrono library to keep track of times
   int num = 50;

   for(int i = 1; i <= num; i++)
   {
      // auto determines return type automatically
      auto startTime = steady_clock::now(); 

      // Call function after starting timer
      long long result = fibo(i);

      auto endTime = steady_clock::now();

      // We subtract the end and start to find overall time it took to finish.
      auto elapsedTime = duration<double>(endTime - startTime); 

      cout << i << ": " << result << " Time: " // fixed for decimal seconds
      << fixed << setprecision(4) << elapsedTime.count() << " seconds" << endl;
   }  
   return 0;
}