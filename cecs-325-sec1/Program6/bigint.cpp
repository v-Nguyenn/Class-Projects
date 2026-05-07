// Author: Vincent Nguyen
// CECS 325
// Program 6 - Big Int class
// 
// I certify that this program is my own original work
// I did not copy any part of this program from any other soruce 
// including AI use. I did not share this program with anyone.
// I further certify that I typed each and every line of code 
// in this program.
// Due: 05/06/2026

#include <iostream>
#include <iomanip>
#include <vector>
using namespace std;

// Start with this definition of BigInt class
class BigInt
{
   private: 
         vector<char> v; // we use a vector of char 
         // Based off the Overflow.pptx Fibonacci Function with tail recursion
         BigInt fiboHelper(BigInt count, BigInt prev, BigInt curr)
         {
            if (count == 0)
               return prev;
            else if (count == 1)
               return curr;
            else
               return fiboHelper(count - 1, curr, prev + curr);
         }
         // tail recursive factorial - accumulates product as it counts down
         BigInt factHelper(BigInt n, BigInt acc)
         {
            if (n == BigInt(0) || n == BigInt(1))
               return acc;
            return factHelper(n - BigInt(1), acc * n);
         }
   public:
         // empty vector so we can build result digit by digit in operator+
         BigInt() {}

         // Given from overloading operators pt 2 docx
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

         // Stores the digits in the vector like the same way as the constructor
         BigInt(string numStr)
         {
            for (int i = numStr.size() - 1; i >= 0; i--)
            {
               // convert any character digit to a digit
               v.push_back(numStr[i] - '0');
            }
         }

         // Overload for addition 
         BigInt operator+ (BigInt other)
         {
            BigInt result;
            int carry = 0;
            int i = 0;
            while (i < v.size() || i < other.v.size())
            {
               // if one number is shorter, treat missing digits as 0
               int digit1 = (i < v.size()) ? v[i] : 0;
               int digit2 = (i < other.v.size()) ? other.v[i] : 0;
               int sum = digit1 + digit2 + carry;
               result.v.push_back(sum % 10); // only keep the ones place
               carry = sum / 10;             // pass the tens place to next digit
               i++;
            }
            // leftover carry means we need one more digit (99 + 1 = 100)
            if (carry > 0)
               result.v.push_back(1);
            return result;
         }
         
         // Overload for subtraction
         BigInt operator- (BigInt other)
         {
            BigInt result;
            int borrow = 0;
            int i = 0;
            while (i < v.size() || i < other.v.size())
            {
               // if one number is shorter, treat missing digits as 0
               int digit1 = (i < v.size()) ? v[i] : 0;
               int digit2 = (i < other.v.size()) ? other.v[i] : 0;
               int diff = digit1 - digit2 - borrow;
               if (diff < 0)
               {
                  diff += 10; // add 10 since we borrowed from the next digit
                  borrow = 1;
               }
               else
                  borrow = 0; // no borrow needed
               result.v.push_back(diff);
               i++;
            }
            // strip leading zeros (100 - 99 = [1,0,0] becomes [1])
            while (result.v.size() > 1 && result.v.back() == 0)
               result.v.pop_back();
            return result;
         }

         // converts int to BigInt then subtracts using operator-(BigInt)
         BigInt operator- (int n)
         {
            return *this - BigInt(n);
         }
         
         // multiplication is repeated addition - loop the smaller number of times
         BigInt operator* (BigInt other)
         {
            BigInt result(0);
            BigInt addend; // the number we add each loop
            BigInt count;  // how many times we loop
            // use fewer digits as the loop counter so we do less work
            if (v.size() < other.v.size())
            {
               addend = other; // add the bigger one
               count = *this;  // loop the smaller number of times
            }
            else
            {
               addend = *this;  // add the bigger one
               count = other;   // loop the smaller number of times
            }
            while (!(count == BigInt(0)))
            {
               result = result + addend;
               count = count - BigInt(1);
            }
            return result;
         }

         // Overload the == operator 
         bool operator==(BigInt other)
         {
            if (other.v.size() != v.size())
               return false;
            else
               for(int i = 0; i < v.size(); i++)
               {
                  if(v[i] != other.v[i])
                     return false;
               }
               return true;
         }

         // fewer digits = smaller number, same digits = compare from most significant
         bool operator< (BigInt other)
         {
            if(v.size() != other.v.size())
               return v.size() < other.v.size(); // fewer digits means smaller
            for (int i = v.size() - 1; i >= 0; i--)
            {
               if (v[i] != other.v[i])
                  return v[i] < other.v[i]; // first digit that differs decides it
            }
            return false; // they are equal, not less than
         }

         // division is repeated subtraction - count how many times divisor fits
         BigInt operator/ (BigInt other)
         {
            BigInt quotient(0);
            BigInt remainder = *this;
            while (!(remainder < other))
            {
               remainder = remainder - other;
               quotient = quotient + BigInt(1);
            }
            return quotient;
         }

         BigInt operator% (BigInt other)
         {
            BigInt quotient(0);
            BigInt remainder = *this;
            while (!(remainder < other))
            {
               remainder = remainder - other;
               quotient = quotient + BigInt(1);
            }
            return remainder;
         }
         // postfix++ saves the current value, increments, returns the old one
         BigInt operator++(int)
         {
            BigInt temp = *this;
            *this = *this + BigInt(1);
            return temp;
         }
         // prefix++ increments first then returns the new value
         BigInt operator++()
         {
            *this = *this + BigInt(1);
            return *this;
         }
         BigInt operator[](int); // index function

         int size() { return v.size(); }

         // prints ALL digits with no exponential shortcut
         void print()
         {
            for (auto it = v.rbegin(); it != v.rend(); it++)
               cout << (int)*it;
         }

         // Fibonacci of a current number
         BigInt fibo()
         {
            return fiboHelper(*this, BigInt(0), BigInt(1));
         }

         // kicks off tail recursive factorial with accumulator starting at 1
         BigInt fact()
         {
            return factHelper(*this, BigInt(1));
         }
         // allows int + BigInt by converting int to BigInt first
         friend BigInt operator+ (int n, BigInt other)
         {
            return BigInt(n) + other;
         }

         // prints all digits if 12 or fewer, otherwise exponential notation to 7 sig figs
         friend ostream& operator<<(ostream& out, const BigInt& n)
         {
            string s = "";
            if (n.v.size() <= 12)
            {
               for (auto it = n.v.rbegin(); it != n.v.rend(); it++)
                  s += ('0' + *it);
            }
            else
            {
               // build string so setw applies to the whole thing at once
               s += ('0' + n.v.back());
               s += '.';
               for (int i = (int)n.v.size() - 2; i >= (int)n.v.size() - 7; i--)
                  s += ('0' + n.v[i]);
               s += 'e';
               s += to_string(n.v.size() - 1);
            }
            out << s;
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