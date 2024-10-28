/**
   This program defines and calls a simple method.
*/

public class SimpleMethodVincent //pg 123
{
   public static void main(String[] args)
   {
      System.out.println("displayMessage(); in main method says hello.");
      displayMessage();
      System.out.println("displayMessage(); says we are back in the main method.");
   }
   
   /**
      The displayMessage method displays a greeting.
   */
   
   public static void displayMessage()
   {
      System.out.println("_____ is now in the displayMessage method.");
   }
}