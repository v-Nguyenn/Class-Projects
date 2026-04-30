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

// Copied From Program 6 doc. 
int main()
{
      int space = 10;
      cout << "\a\nTestUnit:\n" << flush;
      cout << "User Name:" << flush;
      system("whoami");
      system("date");
      BigInt n1(25);
      BigInt s1("25");
      BigInt n2(1234);
      BigInt s2("1234");
      BigInt n3(n2);
      BigInt X(3000);
      BigInt Y(50);
      BigInt Z1(123);
      BigInt Z2("9893452745657");
      BigInt Z3(X.fibo());
      BigInt imax = INT_MAX;
      BigInt big("9223372036854775807");

}