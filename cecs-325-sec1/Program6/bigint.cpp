// Author: Vincent Nguyen
// CECS  325
// Program 6 - Big Int class
// 
// I certify that this program is my own original work
// I did not copy any part of this program from any other soruce 
// including AI use. I did not share this program with anyone.
// I further certify that I typed each and every line of code 
// in this program.

#include <iostream>
using namespace std;
#include <vector>

// Start with this definition of BigInt class

class BigInt
{
   private: 
         vector<char> v; // we use a vector of char 
   public:
         BigInt();
         BigInt(int);
         BigInt(string);

         BigInt operator+ (BigInt);
         BigInt operator- (BigInt);
         BigInt operator- (int);
         BigInt operator* (BigInt);

         BigInt operator/ (BigInt);
         BigInt operator% (BigInt);
         BigInt operator++(int);
         BigInt operator++( );
         BigInt operator[](int); // index function

         int size();
         void print();
         BigInt fibo(); // Fibonacci of current number
         BigInt fact(); // Factorial of current number
         friend BigInt operator+ (int, BigInt);
         friend ostream& operator<<(ostream&, const BigInt&);
};