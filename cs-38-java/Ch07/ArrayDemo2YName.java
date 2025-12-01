import java.util.Scanner;   // Needed for Scanner class

/**
   This program shows an array being processed with loops.
*/

public class ArrayDemo2YName 
{
   public static void main(String[] args)
   {
      final int EMPLOYEES = 3;           // Number of employees
      int[] hours = new int[EMPLOYEES];  // Array of hours
      
      // Create a Scanner object for keyboard input.
      Scanner keyboard = new Scanner(System.in);

      System.out.println("Enter the hours worked by " +
                         EMPLOYEES + " employees.");

      // Get the hours for each employee.
      for (int index = 0; index < EMPLOYEES; index++)
      {
         System.out.print("Employee " + (index + 1) + ": ");
         hours[index] = keyboard.nextInt();
      }

      System.out.println("The hours you entered are:");

      // Display the values entered.
      for (int index = 0; index < EMPLOYEES; index++)
         System.out.println(hours[index]);
   }
   
   public static void demoPayroll()
   {
       Payroll[] mcdIrv = new Payroll[3];
       //                      name    id   payRate  hoursWorked  
       mcdIrv[0] = new Payroll("Mike", 100, 20.00,   10);
       mcdIrv[1] = new Payroll("Jane", 101, 25.00,   20);
       mcdIrv[2] = new Payroll("Dave", 102, 30.00,   30);
       
       //How much was paid?
       double totalPaid=0;
       for(int i=0; i<mcdIrv.length; i++)
       {
           double pay = mcdIrv[i].getTotalPay();
           System.out.println(mcdIrv[i].getName()+" made $"+pay);
       }
       
   }
}     
