import java.util.Scanner;

/**
   This program calculates a running total.
   
   author: Vincent Nguyen
   version: 10/08/24
*/

public class TotalSalesVincentNguyen
{
   public static void main(String[] args)
   {
      int days;            // The number of days
      double sales;        // A day's sales figure
      double totalSales;   // Accumulator

      // Create a Scanner object for keyboard input.
      Scanner keyboard = new Scanner(System.in);

      // Get the number of days.
      System.out.print("For how many days do you have sales amounts? ");
      days = keyboard.nextInt();

      // Set the accumulator to 0.
      totalSales = 0.0;

      // Get the sales figures and calculate a running total.
      // line 27 starts at 1 and is determined by days which 
      // is determined by user input 
      for (int count = 1; count <= days; count++)
      {
         System.out.print("Enter the sales for day " + count + ": ");
         sales = keyboard.nextDouble();
         totalSales += sales;   // Add sales to totalSales.
      }

      // Display the total sales.
      // You should have %.2f inside printf to display 2 decimals
      System.out.printf("The total sales are $%,.2f", totalSales);
   }
}