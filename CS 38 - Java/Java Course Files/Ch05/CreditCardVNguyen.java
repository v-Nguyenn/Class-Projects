import java.util.Scanner;

/**
   This program uses two void methods.
*/

public class CreditCardVNguyen  //pg 123
{
   public static void main(String[] args)
   {
      double salary;    // Annual salary
      int creditRating; // Credit rating
      
      // Create a Scanner object for keyboard input.
      Scanner keyboard = new Scanner(System.in);
      
      // Get the user's annual salary.
      System.out.print("What is your annual salary? ");
      salary = keyboard.nextDouble();

      // Get the user's credit rating (1 through 10).
      System.out.println("On a scale of 1 through 10, what is your");
      System.out.print("credit rating? (10=excellent, 1=very bad): ");
      creditRating = keyboard.nextInt();
      
      // Determine whether the user qualifies.
      if (salary >= 30000 && creditRating >= 7)
         qualify();
      else
         noQualify();
   }
   
   /**
      The qualify method informs the user that he
      or she qualifies for the credit card.
   */
   
   public static void qualify()
   {
      System.out.println("Congratulations! You qualify!");
   }

   /**
      The noQualify method informs the user that he
      or she does not qualify for the credit card.
   */
   
   public static void noQualify()
   {
      System.out.print("I'm sorry.  You do not qualify.");   
   }
}