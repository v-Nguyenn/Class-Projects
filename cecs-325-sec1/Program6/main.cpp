// Author: Vincent Nguyen
// CECS 325
// Program 6 - Big Int class
// 
// I certify that this program is my own original work
// I did not copy any part of this program from any other soruce 
// including AI use. I did not share this program with anyone.
// I further certify that I typed each and every line of code 
// in this program.

#include <iostream>
#include <vector>
using namespace std;

// Start with this definition of BigInt class
class BigInt
{
   private: 
         vector<char> v; // we use a vector of char 
         // tail recursive logic we put here 
         // Copied from Overflow.pptx Fibonacci Function with tail recursion
         BigInt fiboHelper(BigInt n, BigInt a, BigInt b)
         {
            if (n == 0)
               return a;
            else if (n == 1)
               return b;
            else
               return fiboHelper(n - 1, b, a + b);
         }
   public:
         BigInt();
         // given from overloading operators pt 2 docx
         // extract digits lease-significant first using % 10 and / 10
         BigInt(int n)
         {
            char digit;
            while (n > 9)
            {
               digit = n % 10;
               n /= 10;
               v.push_back(digit);
            }
            digit = n;
            v.push_back(digit);
         }

         // stores the digits in the vector like the same way as the constructor
         BigInt(string s)
         {
            for (int i = s.size() - 1; i >= 0; i--)
            {
               // convert any character digit to a digit
               v.push_back(s[i] - '0');
            }
         }

         BigInt operator+ (BigInt);
         BigInt operator- (BigInt);
         BigInt operator- (int);
         BigInt operator* (BigInt);

         // overload the == operator
         bool operator==(BigInt b)
         {
            if (b.v.size() != v.size())
               return false;
            else
               for(int i = 0; i < v.size(); i++)
               {
                  if(v[i] != b.v[i])
                     return false;
               }
               return true;
         }

         BigInt operator/ (BigInt);
         BigInt operator% (BigInt);
         BigInt operator++(int);
         BigInt operator++( );
         BigInt operator[](int); // index function

         int size();
         void print();
         // Fibonacci of a current number
         BigInt fibo()
         {
            return fiboHelper(*this, BigInt(1), BigInt(1));
         }

         // Factorial of current number
         BigInt fact(); 
         friend BigInt operator+ (int, BigInt);

         // overloads << to print BigInt digits in the desired order
         friend ostream& operator<<(ostream& out, const BigInt& n)
         {
            for(auto it = n.v.rbegin(); it != n.v.rend(); it++)
               cout << (int)*it;
            return out;
         }
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