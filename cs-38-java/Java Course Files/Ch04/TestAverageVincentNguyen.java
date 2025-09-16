import java.util.Scanner;   // Needed for the Scanner class
import java.awt.Font;
/**
   This program demonstrates a user controlled loop.
   
   author: Vincent Nguyen
   version: 10/03/24
*/

// modified so it displays 1 decimal place accuracy
public class TestAverageVincentNguyen
{
   public static void main(String[] args)
   {
      int score1, score2, score3;  // Three test scores
      double average;              // Average test score
      char repeat;                 // To hold 'y' or 'n'
      String input;                // To hold input
      
      System.out.println("This program calculates the " +
                         "average of three test scores.");

      // Create a Scanner object for keyboard input.
      Scanner keyboard = new Scanner(System.in);
                
      // Get as many sets of test scores as the user wants.
      do
      {
         // Get the first test score in this set.
         System.out.print("Enter score #1: ");
         score1 = keyboard.nextInt();
         
         // Get the second test score in this set.
         System.out.print("Enter score #2: ");
         score2 = keyboard.nextInt();
         
         // Get the third test score in this set.
         System.out.print("Enter score #3: ");
         score3 = keyboard.nextInt();
         
         // Consume the remaining newline.
         keyboard.nextLine();

         // Calculate and print the average test score.
         average = (score1 + score2 + score3) / 3.0;
         System.out.println("The average is " + average);
         System.out.println();   // Prints a blank line
        
         // Graphics & String formatting
         Draw avg = new Draw();
         Font ft = new Font("Courier", Font.PLAIN, 123);
         avg.setFont( ft );
         String twoDecimal = String.format("%.1f", average);
         avg.clear(Draw.LIGHT_GRAY);
         String msg1 = "" + score1 +", "+ score2 + ", " + score3;
         avg.text(0.123,0.123, msg1);
         avg.text(0.123,0.123, ("The average is "+twoDecimal));
         
         // Does the user want to average another set?
         System.out.println("Would you like to average " +
                            "another set of test scores?");
         System.out.print("Enter Y for yes or N for no: ");
         input = keyboard.nextLine();  // Read a line.
         
         repeat = input.charAt(0);     // Get the first char.

      } while (repeat == 'Y' || repeat == 'y');
   }
   
}