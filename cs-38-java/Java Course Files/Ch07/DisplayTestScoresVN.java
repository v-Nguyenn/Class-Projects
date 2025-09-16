import java.util.Scanner; // Needed for Scanner class

/**
   This program demonstrates how the user may specify an
   array's size.
*/

public class DisplayTestScoresVN //pg 443
{
   public static void main(String[] args)
   {
      int numTests;     // The number of tests
      int[] tests;     // Array of test scores

      // Create a Scanner object for keyboard input.
      Scanner data = new Scanner(System.in);

      // Get the number of test scores.
      System.out.print("How many tests do you have? ");
      numTests = data.nextInt();; //QQQ

      // Create an array to hold that number of scores.
      tests = new int[numTests];

      // Get the individual test scores.
      for (int index = 0; index < numTests; index++)
      {
         System.out.print("Enter a score :");
         tests[index] = data.nextInt(); // Step2 - put data in array
      }

      // Display the test scores.
      System.out.println();
      System.out.println("Here are the scores you entered:");
      for (int idx = 0; idx < numTests; idx++)
      {
         System.out.print(tests[idx] + " " + "\n");
      }
   }
}