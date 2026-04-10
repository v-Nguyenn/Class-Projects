// Author: Vincent Nguyen
// CECS 325
// Program 4
//
// I certify that this program is my own original work. I 
// did not copy any part of this program from any other 
// source including AI use. I did not share this program with anyone.
// I further certify that I typed each and every line of code in this
// program.

#include <iostream>
#include <fstream>
#include <vector>
#include <thread>
#include <mutex>

using namespace std;

// As we said in class global variable is not ideal
// We use long long here because I want to gurantee that it can
// handle the amount of swaps. Int only goes up to 2.1 billion.
long long totalSwaps = 0;

// Bubble sort from last program, but based off geeks for geeks.
void bubble(vector<int>& arr, int size, int processNum, long long& localSwaps)
{
   int n = arr.size();
   bool swapped;
   localSwaps = 0;
   
   for (int i = 0; i < n - 1; i++)
   {
      swapped = false;
      for (int j = 0; j < n - i - 1; j ++)
      {
         if (arr[j] > arr[j + 1])
         {
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
            swapped = true;
         }
      }
      // If no two elements were swapped, then break
      if (!swapped)
         break;
   }

   swapMutex.lock();
   cout << "Process " << processNum << "  swap count:" << localSwaps << endl;
   totalSwaps += localSwaps;
   swapMutex.unlock();
}