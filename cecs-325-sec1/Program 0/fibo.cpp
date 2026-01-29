// Author: Vincent Nguyen
// CECS 325-01 Prog 0
// Due 01/28/2026
#include <iostream> // library to use cin and cout
#include <string> 

// Fibo function

int fibo(int n) // We declare functions before they are used
{
	if (n == 1 || n == 0)
		return 1;
	else
		return fibo(n-1) + fibo(n-2); // recursion
}

int main()
{
	std:: string name;
	int number;
	std::cout << "What is your name? ";
	std::cin >> name;
	std::cout << "What is your favorite number? ";
	std::cin >> number;

	if (number % 2 == 0)
		std::cout << "Your number is even" << std::endl;
	else
		std::cout << "Your number is odd" << std::endl;

	std::cout << "Welcome to class " << name << std::endl;
	for (int i = 0; i <= 20; i++)
		std::cout << i << ":" << fibo(i) << std::endl;

	return 0;
}
