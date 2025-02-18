#include<iostream>

using namespace std;

#define PRINT_INTERMEDIATE

void MergeSort(int array[], int tempArray[], int left, int right)
{
  int i, j, k, middle;

  if(right > left) 
  {
    middle = (right + left) / 2; // find the middle of the array, since we are using ints, it will round down
    MergeSort(array, tempArray, left, middle); // Recursive call for the left side of the array
    MergeSort(array, tempArray, middle + 1, right); // Recursive call for the right side of the array

	//
	// Copy array elements into the temporary array (left side)
    for (i = middle + 1; i > left; --i)
		tempArray[i-1] = array[i-1];

	//
	// Copy array elements into the temporary array (right side)
    for(j = middle; j < right; ++j) 
		tempArray[right + middle - j] = array[j+1];

	//
	// Grab elements from the temporary array and put
	// them into the array (We are grabbing the first
	// element from each sorted subarray, merging them together
    for(k = left; k <= right; ++k) 
		array[k] = (tempArray[i] < tempArray[j]) ?  tempArray[i++] : tempArray[j--];

	//
	// If you forgot the how the ternary operator (?) works, the equivalent of
	// array[k] = (tempArray[i] < tempArray[j]) ?  tempArray[i++] : tempArray[j--];
	// is
	// if (tempArray[i] < tempArray[j])
	//		array[k] = tempArray[i++];
	// else
	//		array[k] = tempArray[j--];
#ifdef PRINT_INTERMEDIATE
	cout << "From left: " << left << " to right: " << right << endl;
	for(i = left; i <= right; i++)
		cout << array[i] << " ";
	cout << endl;
#endif
  }
}

int main (void)
{
	int array[10] = {12, 71, 9, 11, 4, 181, 24, 171, 19, 21};
	int temp[10];
	
	cout << "Unsorted\n";
	for (int i = 0; i < 10; i++)
		cout << i << ": " << array[i] << "\t";

	MergeSort(array, temp, 0, 9); 
	// passing the array to be sorted, 
	// a temporary array so that we don't have to 
	// do any swaps, the lower & upper bound of the array

	cout << "Sorted\n";
	for (int i = 0; i < 10; i++)
		cout << i << ": " << array[i] << "\t";

	return 0;
}