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
#include <thread>
#include <mutex>

using namespace std;

// As we said in class global variable is not ideal
// We use long long here because I want to gurantee that it can
// handle the amount of swaps. Int only goes up to 2.1 billion.
long long totalSwaps = 0;
mutex swapMutex; // Threads share the same mutex object.

// Bubble sort worker function for each thread
// Sorts only the section [startIndex, endIndex)
void bubble(int* arr, int startIndex, int endIndex, int processNum, long long& localSwaps)
{
   localSwaps = 0;
   int sectionSize = endIndex - startIndex;

   // Bubble sort only inside this chunk
   for (int pass = 0; pass < sectionSize - 1; pass = pass + 1)
   {
      bool swapped = false;

      for (int j = startIndex; j < endIndex - 1 - pass; j = j + 1)
      {
         if (arr[j] > arr[j + 1])
         {
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;

            swapped = true;
            localSwaps = localSwaps + 1;
         }
      }

      if (!swapped)
      {
         break;
      }
   }

   // Protect shared output and global counter with mutex
   swapMutex.lock();
   cout << "Process " << processNum << " swap count: " << localSwaps << endl;
   totalSwaps = totalSwaps + localSwaps;
   swapMutex.unlock();
}

// Read numbers from file into dynamic array
// We pass by reference the actualCount so the caller knows how many we read
void readNumbers(const string& filename, int* numbers, int maxCount, int& actualCount)
{
   ifstream infile(filename);
   if (!infile)
   {
      cout << "Error: Could not open input file '" << filename << "'." << endl;
      exit(1);
   }

   actualCount = 0;
   // Read numbers one at a time until we hit the limit or run out of numbers
   while (actualCount < maxCount && (infile >> numbers[actualCount]))
   {
      actualCount = actualCount + 1;
   }
   // actualCount now holds how many numbers we successfully read
}

// Write numbers from dynamic array to file
void writeNumbers(const string& filename, int* numbers, int count)
{
   ofstream outfile(filename);
   if (!outfile)
   {
      cout << "Error: Could not open output file '" << filename << "'." << endl;
      exit(1);
   }

   for (int i = 0; i < count; i = i + 1)
   {
      outfile << numbers[i] << endl;
   }
}

// Merge based on geeksforgeeks two-pointer merge 
// Merges two adjacent sorted sections: [start1, end1) with [start2, end2)
void mergeArrays(int* arr, int start1, int end1, int start2, int end2)
{
   int size1 = end1 - start1;
   int size2 = end2 - start2;
   int totalSize = size1 + size2;

   int* temp = new int[totalSize];

   int i = start1;   // pointer for first section
   int j = start2;   // pointer for second section
   int k = 0;        // pointer for the temp array

   // compare elements from both sorted sections and take the smaller
   // we combine two sorted lists into one sorted list in linear time
   while (i < end1 && j < end2)
   {
      if (arr[i] <= arr[j])
      {
         // first element is smaller, take it and move to next in first section
         temp[k++] = arr[i++];  // k++, i++ both happen after assignment
      }
      else
      {
         // second element is smaller, take it and move to next in second section
         temp[k++] = arr[j++];
      }
   }

   // After one section runs out, copy any leftover elements from first section
   // the second section is already exhausted at this point
   while (i < end1)
   {
      temp[k++] = arr[i++];
   }

   // Copy any leftover elements from second section
   while (j < end2)
   {
      temp[k++] = arr[j++];
   }

   // Copy the merged result back into the original array
   for (int p = 0; p < totalSize; p = p + 1)
   {
      arr[start1 + p] = temp[p];
   }

   delete[] temp;
}

int main(int argc, char* argv[])
{
   if (argc != 3)
   {
      cout << "Usage: " << argv[0] << " inputfile outputfile -test" << endl;
      return 1;
   }

   string inputFile = argv[1];
   string outputFile = argv[2];

   // Check if -test flag is present 
   // If -test mode, use 10,000 numbers for faster testing
   // Otherwise use the full 1,000,000 numbers
   int TOTAL_NUMBERS;
   if (argc == 4 && string(argv[3]) == "-test")
   {
      TOTAL_NUMBERS = 10000;  // Test smaller data set
   }
   else 
   {
      TOTAL_NUMBERS = 1000000;  // Normal the full 1 million set
   }

   const int THREAD_COUNT = 16;

   int* numbers = new int[TOTAL_NUMBERS];
   int actualCount = 0;

   readNumbers(inputFile, numbers, TOTAL_NUMBERS, actualCount);

   if (actualCount == 0)
   {
      cout << "Error: No numbers read from input file." << endl;
      delete[] numbers;
      return 1;
   }

   // Calculate how many numbers each thread will sort
   // Example: 1,000,000 / 16 = 62,500 per thread
   int chunkSize = actualCount / THREAD_COUNT;
   
   // Safety check if somehow we have fewer numbers than threads
   if (chunkSize == 0)
   {
      chunkSize = 1;
   }

   long long swaps[THREAD_COUNT] = {0};
   thread* threads = new thread[THREAD_COUNT];

   // Create 16 sorting threads
   // Each thread gets a portion of the array to sort independently
   for (int i = 0; i < THREAD_COUNT; i = i + 1)
   {
      // Calculate the starting index for this thread
      // Thread 0 goes from [0, 62500), Thread 1 goes from [62500, 125000), so on.
      int start = i * chunkSize;
      int end;

      // Last thread gets any leftover numbers due to integer division
      if (i == THREAD_COUNT - 1)
      {
         end = actualCount;  // last thread gets remainder
      }
      else
      {
         end = start + chunkSize;
         // Bounds check just in case
         if (end > actualCount)
         {
            end = actualCount;
         }
      }

      // Create thread, pass the array, its portion to sort, and swap counter
      // i + 1 is the process number (1-indexed instead of 0-indexed)
      threads[i] = thread(bubble, numbers, start, end, i + 1, ref(swaps[i]));
   }

   // Wait for all threads to finish
   for (int i = 0; i < THREAD_COUNT; i = i + 1)
   {
      threads[i].join();
   }
   delete[] threads;

   // Merge the 16 sorted chunks into one fully sorted array
   // This happens in rounds 16 chunks 8 to 4 to 2 to 1
   // Each round merges adjacent pairs of sorted sections
   int runSize = chunkSize;  // Start with size of one chunk
   
   while (runSize < actualCount)  // Keep merging until we have one giant sorted chunk
   {
      int blockSize = 2 * runSize;  // Size of the pair we are merging

      // Loop through pairs of sorted sections
      for (int start1 = 0; start1 < actualCount; start1 = start1 + blockSize)
      {
         // First section: [start1, end1)
         int end1 = start1 + runSize;
         
         // Second section: [start2, end2)
         int start2 = end1;
         int end2 = start1 + blockSize;

         // Bounds checking so don't go past the actual data
         if (end1 > actualCount) end1 = actualCount;
         if (start2 > actualCount) start2 = actualCount;
         if (end2 > actualCount) end2 = actualCount;

         // Only merge if there is actually a second section to merge with
         if (start2 < end2)
         {
            mergeArrays(numbers, start1, end1, start2, end2);
         }
      }

      // Double the runSize for the next round
      // Round 1 merge 62K + 62K = 125K chunks
      // Round 2 merge 125K + 125K = 250K chunks and so on.
      runSize = runSize * 2;
   }

   writeNumbers(outputFile, numbers, actualCount);
   cout << "Total swaps: " << totalSwaps << endl;

   delete[] numbers;
   return 0;
}