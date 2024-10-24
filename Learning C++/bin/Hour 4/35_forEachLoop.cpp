#include <iostream>

// foreach loop = loop that easess the traversal over an iterable data 
//             = set

int main()
{
   std::string students[] = {"Spongebob", "Patrick", "Squidward"};
   int grades[] =  {65, 72, 81, 93};
    
   // add data type that you are going to iterate over
   // ex. std::string
   for(std::string student : students){
      std::cout << student << '\n';
   }

   for (int grade : grades)
   {
      std::cout << grade << '\n';
   }
   
   return 0;

   // Generally used to show an array and has limited uses
}