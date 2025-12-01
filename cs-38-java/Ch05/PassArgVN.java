/**
   This program demonstrates a method with a parameter.
*/

public class PassArgVN
{
   public static void main(String[] args)
   {
      Draw scr = new Draw();
      int x = 10;

      System.out.println("I am passing values to displayValue.");
      scr.pause(2000);
      System.out.println("Line: 14");
      displayValue(5); // Pass 5
     
      scr.pause(2000);
      System.out.println("Line: 18");
      displayValue(x); // Pass 10
      
      scr.pause(2000);
      System.out.println("Line: 22");
      displayValue(x * 4);                   // Pass 40
      
      scr.pause(2000);
      displayValue(Integer.parseInt("700")); // Pass 700
      System.out.println("Now I am back in main.");
   }
   
   /**
      The displayValue method displays the value
      of its integer parameter.
   */
   
   public static void displayValue(int num)
   {
      System.out.println("The value is " + num);
   }
}
