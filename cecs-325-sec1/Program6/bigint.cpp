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

      cout << "n1(int)     :" << setw(space) << n1 << endl;
      cout << "s1(str)     :" << setw(space) << s1 << endl;
      cout << "n2(int)     :" << setw(space) << n2 << endl;
      cout << "s2(str)     :" << setw(space) << s2 << endl;
      cout << "n3(n2)      :" << setw(space) << n3 << endl;
      cout << "X.fibo(1234):" << setw(space) << X.fibo() << endl;
      cout << "Y.fact(50)  :" << setw(space) << Y.fact() << endl;
      cout << "imax        :" << setw(space) << imax << endl;
      cout << "big         :" << setw(space) << big << endl;
      cout << "big.print() : "; big.print(); cout << endl;
      
      cout << n2 << "/" << n1 << " = " << n2/n1 <<" rem " <<n2%n1<<endl;
      cout << "fibo("<<X<<") = " <<X.fibo() << endl;
      cout << "fact("<<Y<<") = " <<Y.fact() << endl;
      
      cout << "10 + n1 = " << BigInt(10) + n1 << endl;
      cout << "n1 + 10 = " << n1 + BigInt(10) << endl;
      
      cout << "(n1 == s1)? --> " <<((n1==s1)?"true":"false")<<endl;
      cout << "n1++ = ? --> before:"<<n1++<<" after:" << n1 << endl;
      cout << "++s1 = ? --> before:"<<++s1<<" after:" << s1 << endl;

      cout << "s2 * big = ? --> "<< s2 * big << endl;
      cout << "big * s2 = ? --> "<< big * s2 << endl;

      cout << endl;
      system("date");

      return 0;

}