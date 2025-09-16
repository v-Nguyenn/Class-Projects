#include <iostream>
#include <string>

using namespace std;


int main (void)
{
	//
	// Arrays
	//
	// Arrays are lists of the same data type
	// Typically this data has logical coherence
	// Such as an array of months:
	
	int months[12] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
	//
	// Arrays can also have no logical coherence
	// but this somewhat defeats the purpose of
	// having the array in the first place:
	string junk[10] = {"apple", "My Friend", "3.14159", "Guitar"};

	//
	// These arrays were one dimensional arrays, just like a line
	// from 0, 1, 2, ..., n
	// Multidimensional arrays also exist, such as:
	int twoDimensionalArray[2][5] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

	for (int i = 0; i < 2; i++)
	{
		for (int j = 0; j < 5; j++)
			cout << twoDimensionalArray[i][j] << " ";
		cout << endl;
	}

	//
	// Looking at the output of these loops we get:
	// 0 1 2 3 4
	// 5 6 7 8 9
	//
	// The data in the arrays are being stored in a row-major fashion
	// That means that we fill up the row before we fill up the columns
	//
	// Row-major order isn't the only way that data could be stored,
	// Column-major order could be used, this implementation fills up 
	// the columns before it fills up the rows, if C/C++ used this style
	// we would end up with this:
	// 0 2 4 6 8
	// 1 3 5 7 9
	//
	// We won't very often have to worry about this issue, but if we are
	// using a file as a medium of exchange between applications that
	// use different orderings, we may encounter a problem
	//

	int septaDimensionalArray[4][5][1][2][3][2][3] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
	//
	// Oh ya, our good old 7-dimensional array, basically things are getting
	// a little out of hand here, but it is perfectly legal, if we need this
	// many dimensions we can have it, I'm not sure if there is a limit to the
	// number of dimensions or not, they all get converted into one dimension
	// when they are put into memory, so the actual limit may come from the
	// physical limit of the system, as the grammer is likely to be recursive,
	// allowing as many dimensions as we please
	//

	//
	// The problem with multi-dimensional arrays is that the are rectangular
	// in nature, with every new dimension building up from line, to rectangle,
	// to cubic rectangle, then 4th dimension and so on, so adding a dimension
	// multiplies how much space it takes by the size of the new dimension, ie.
	// a [2][5] takes up 2 * 5, or 10 slots, a [2][3][4] would take up 24 slots
	//
	// To get around this we can have arrays of arrays, this may sound like a
	// multidimensional array, and it is, however, its dimensions aren't required
	// to follow the regular geometry as multidimensional arrays
	//
	// We can achieve an array of arrays by having an array of objects, such as the string object
	// array we had earlier: junk when I run the debugger on my machine it gives me
	// the memory address of junk as 0012fea4
	// the memory address of [0] or "apple" is 003207b9
	//						 [1] = 00322731 1f78 from [0]
	//						 [2] = 00322799 68h from [1]
	//						 [3] = 00322801 68h from [2]
	//						 [4] = 00000000
	//
	// The way this works is that the first array is just a list of pointers to 
	// the first element of the second array, which can then be of whatever length
	// in the case of strings, the string object, or the system makes this determination
	//




	return 0;
}