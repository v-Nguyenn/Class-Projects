#    Name: Vincent Nguyen
#    Class: CECS 342 Section 5
#    Project Name: Prog 1 - Fibo Race
#    Due Date: 09/03/2026
#
#    I certify that this program is my own original work. I did not 
#    copy any part of this program from any other source including
#    inappropriate AI use. I did not share this program with anyone. I 
#    further certify that I typed each and every line of code in this program.

import time

def fibo(n):
   """ Recursively computes nth Fibonacci number with a growth rate of O(2^n). """
   if (n == 1 or n == 0):
      return 1
   else:
      return fibo(n - 1) + fibo(n - 2)

def main():
   """ Measures the execution time for Fibonacci Sequence. """
   num = 50
   for i in range (1, num + 1):
      # Measure start time 
      startTime = time.perf_counter()
      result = fibo(i)
      endTime = time.perf_counter()

      # Measures the execution time 
      elapsedTime = endTime - startTime

      # Print the results with 4 decimal spaces.
      print(f"{i}: {result}  Time: {elapsedTime:.4f} seconds") 

if __name__ == "__main__":
   main()
