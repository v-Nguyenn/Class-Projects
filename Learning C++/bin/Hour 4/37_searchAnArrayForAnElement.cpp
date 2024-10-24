#include <iostream>


int searchArrayOfString(std::string array[], int size, std::string element);
 
int searchArrayOfNum(int array[], int size, int element);

int main()
{  


   int numbers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

   // We can get the size of the array by the following:
   // sizeof(array) / sizeof([first element]);
   int size = sizeof(numbers) / sizeof(numbers[0]);

   // variable to keep track of an index
   int index;
   int myNum;

   std::cout << "Enter element to search for: ";
   std::cin >> myNum;

   index = searchArrayOfNum(numbers, size, myNum);

   if(index != -1){
      std::cout << myNum << " is at index " << index << '\n';
   }
   else{
      std::cout << myNum << " is not in the array. ";
   }

  
/* 
   // comment and uncomment for string variation
   std::string foods[] = {"pizza", "hamburger", "hotdog"};

   int size = sizeof (foods) / sizeof (foods[0]);
   int index;
   std::string myFood;

   std::cout << "Enter an element to search for: " << '\n';
   std::getline(std::cin, myFood); // used getline because user input could have spaces

   index = searchArrayOfString(foods, size, myFood);
   if(index != -1){
      std::cout << myFood << " is at index " << index << '\n';
   }
   else {
      std::cout << myFood << " is not in the array. ";
   }
 */


    return 0;
}

// function to return our array 
int searchArrayOfNum(int array[], int size, int element){
   
   // this would technically be a linear search
   for(int i = 0; i < size; i++)
   {
      if(array[i] == element){
         return i;
      } 
   }
   return -1; // a sentinel value and typically means that something
             // wasn't found
}

int searchArrayOfString(std::string array[], int size, std::string element){
   
   for(int i= 0; i < size; i++)
   {
      if (array[i] == element){
         return i;
      }
   }
   return -1;
}
