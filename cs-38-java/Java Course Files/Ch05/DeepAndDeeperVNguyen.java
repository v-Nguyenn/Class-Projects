/**
   This program demonstrates hierarchical method calls.
*/

public class DeepAndDeeperVNguyen   //pg 123
{
   public static void main(String[] args)
   {
      System.out.println("Vincent starting in main.");
      deep();
      System.out.println("Now I am back in main.");   
   }
   
   /**
      The deep method displays a message and then calls
      the deeper method.
   */
   
   public static void deep()
   {
      System.out.println("Vincent now in deep.");
      deeper();
      System.out.println("Now I am back in deep.");
   }

   /**
      The deeper method simply displays a message.
   */
   
   public static void deeper()
   {
      System.out.println("Vincent now in deeper.");
   }
}
