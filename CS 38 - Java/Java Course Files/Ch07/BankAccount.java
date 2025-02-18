
/**
 * Write a description of class BankAccountVNguyen here.
 * 
 * First thirty minutes of class we wrote an 
 *
 * @author (Vincent Nguyen)
 * @version (12/03/24)
 */
public class BankAccount
{
    // instance variables - replace the example below with your own
    private double balance;
    private String owner;

    /**
     * Constructor for objects of class BankAccountVNguyen
     */
    public BankAccount()
    {
        // initialise instance variables
        balance = 0.0;
    }
    
    public BankAccount(double startingBalance)
    {
        balance = startingBalance;
    }
    
    public BankAccount(double startingBalance,  String name)
    {
        owner = name;
        balance = startingBalance;
    }

    public void deposit(double amount)
    {
        // put your code here
       balance = balance + amount;
    }
    
    public void withdraw(double amount)
    {
        // What about blocking over withdraws
        balance -= amount;
    }
    
    public double getBalance()
    {
        double ans = balance;
        return ans;
    }
    
    public String toString()
    {
        String ans = owner + "'s account $" + getBalance();
        return ans;
    }
}
