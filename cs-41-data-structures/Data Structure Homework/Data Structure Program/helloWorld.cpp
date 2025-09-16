#include <iostream>

int main()
{
   std::cout << "Hello World" << std::endl;
   return 0;
}


int test()
{
   END - Destroy variables with scope of 1 
   PRINT X -> X IS UNDEFINED

   Collection of HashTAbles, Scope 1 - table
   Scope 2 table, scope 2 leaves, destroy the whole hash table

   PRINT X
   Table 1 - x
   Table 2 - x

   START
      VAR X = 10
      START
         VAR X - 20
         PRINT X -> 20
      END
      PRINT X -> 10
      START
         PRINT X -> 10

   HashTable 1 - x, 10
   HashTable 2 - X, 29

   HashTable
   0 - 
   1 - [X, 20, 2] > [X, 10, 1]
   2 - [Y, 15, 2]
}