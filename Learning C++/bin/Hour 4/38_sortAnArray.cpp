#include <iostream>

// We are going to use bubble sort to sort an array 
void sort(int array[], int size);

int main()
{
   int array[] = {1, 3, 5, 2, 9, 10, 4, 7, 6, 8};
   // size of array 
   // sizeof(array variable) / sizeof(array element);
   int size = sizeof(array) / sizeof(array[0]);

   std::cout << "Array before: ";
   for(int element : array){
      std::cout << element << " ";
   }
   std::cout << '\n';
   
    // do not need to declare variables when passing to function
   sort(array, size);
   
   std::cout << "Array sorted: ";

   // this is going to iterate through the array using a for each loop
   for(int element : array){
      std::cout << element << " ";
      }

   return 0;
}

// This function takes an array then a variable of size and sorts the array
void sort(int array[], int size){
   int temp;
   // size - 1 because we don't need to check last variable in array
   for(int i = 0; i < size - 1; i++){ 
      for(int j = 0; j < size - i - 1; j++){

         // if the element on the left is larger than the element on the right
         if(array[j] > array[j + 1]){ // use less than < for descending order
            temp = array[j];
            array[j] = array[j + 1];
            array[j + 1]= temp;
         }
      }
   }
