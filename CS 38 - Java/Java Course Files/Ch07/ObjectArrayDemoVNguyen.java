import java.util.Scanner; // Needed for the Scanner class
import java.util.Random;

/**
   This program works with an array of three
   BankAccount objects.
*/

public class ObjectArrayDemoVNguyen
{
   public static void main(String[] args)
   {
      final int NUM_ACCOUNTS = 3;  // Number of accounts
      
      // Create an array that can reference
      // BankAccount objects.
      BankAccount[] accounts = new BankAccount[NUM_ACCOUNTS];

      // Create objects for the array.
      createAccounts(accounts);

      // Display the balances of each account.
      System.out.println("Here are the balances " +
                         "for each account:");

      for (int index = 0; index < accounts.length; index++)
      {
         System.out.println("Account " + (index + 1) +
                   ": $" + accounts[index].getBalance());
      }
   }

   /**
      The createAccounts method creates a BankAccount
      object for each element of an array. The user
      is asked for each account's balance.
      @param array The array to reference the accounts
   */

   private static void createAccounts(BankAccount[] array)
   {
      double balance;  // To hold an account balance

      // Create a Scanner object.
      Scanner keyboard = new Scanner(System.in);

      // Create the accounts.
      for (int index = 0; index < array.length; index++)
      {
         // Get the account's balance.
         System.out.print("Enter the balance for " +
                          "account " + (index + 1) + ": ");
         balance = keyboard.nextDouble();

         // Create the account.
         array[index] = new BankAccount(balance);
      }
   }
   
   /**
    *  A more robust test of BankAccount
    *  1-Make an array of BankAccounts, not just 3 above
    *  2-Print the array of BankAccounts, not just 3 above
    *  3-Do some withdraws and deposits
    */
   public static void demoWithMoreAcct()
   {
       Random rand = new Random();
       // Step 1 - Create storage to hold the data
       BankAccount[] more  = new BankAccount[20];
       // more[0].deposit(100); // common error, there is nothing in he
       
       more[0] = new BankAccount(123, "JDoe");
       // System.out.println("Element 0 is" + more[0]);
       
       
       // Step 2 - Put data into the array
       for(int i = 0; i <more.length; i++)
       {
           int dollars = rand.nextInt(40, 100);
           BankAccount oneAcct = new BankAccount(dollars, ("Ben" + i));
           more[i] = oneAcct;
       }
       
       // Check by printing all the accounts
       printArray(more);
       
       // go and add $10 to each account
       // need to know the exam
       System.out.println();
       System.out.println("Depositing Money..." + "\n");
       for(int i = 0; i < more.length; i++)
       {
           more[i].deposit(10);
       }
       printArray(more);
       
       // Not in MW: let's withdraw 1c from each account
       System.out.println();
       System.out.println("Withdrawing Money..." + "\n");
       for(int i = 0; i < more.length; i++)
       {
           more[i].withdraw(0.01);
       }
       printArray(more);
   }
   
   public static void printArray(BankAccount[] acct)
   {
       // for (int i = 0; i < acct.length; i++)
       // {
           // System.out.println(acct[i]);
       // }
       for(BankAccount each : acct)
       {
           System.out.println( each ); // acct[1];
       }
   }
}