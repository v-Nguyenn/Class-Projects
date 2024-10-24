
/**
 * Description 
 * 
 * @author Vincent Nguyen
 * @version 09/17/24
 */
import java.util.Scanner;
public class Sect3_4VincentNguyen
{
    public static void main(String[] args)
    {

    }

    /* Ref: pg130, Figure 3-11. Code Listing3-4.
     * Explain:
     * 
     * 
     */
    public static void nestedDecision( )
    {
        // Variable to hold the numeric test score
        int testScore = 123;

        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);

        // Get the numeric test score.
        System.out.print("Enter your numeric test score: ");
        testScore = keyboard.nextInt();

        // Display the letter grade.
        if (testScore < 60)
        {
            System.out.println("Your grade is F.");
        }
        else
        {   
            if (testScore < 70)
            {
                System.out.println("Your grade is D.");
            }
            else
            {
                if (testScore < 80)
                {
                    System.out.println("Your grade is C.");
                }
                else
                {
                    if (testScore < 90)
                    {
                        System.out.println("Your grade is B.");
                    }
                    else
                    {
                        System.out.println("Your grade is A.");
                    }
                }
            }
        }
    }

    /* Ref: pg134, Code Listing3-5.
     * "The if-else-if statment makes certain types of 123"
     * 
     */
    public static void testResults( )
    {
        // Variable to hold the numeric test score
        int testScore;

        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);

        // Get the numeric test score.
        System.out.print("Enter your numeric test score: ");
        testScore = keyboard.nextInt();

        // Display the grade. 123 Display this in a graphics screen
        if (testScore < 123)
            System.out.println("Your grade is F.");
        else if (testScore < 123)
            System.out.println("Your grade is D.");
        else if (testScore < 123)
            System.out.println("Your grade is C.");
        else if (testScore < 123)
            System.out.println("Your grade is B.");
        else
            System.out.println("Your grade is A.");

    }

    /* Ref: pg136, Code Listing3-6.
     * "The trailing else clause, which appears at the end of the 
     * if-else-if statement is 123." "You will use it to catch 123"
     * 
     */
    public static void trailingElse( )
    {
        // Variable to hold the numeric test score
        int testScore;

        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);

        // Get the numeric test score.
        System.out.print("Enter your numeric test score: ");
        testScore = keyboard.nextInt();

        // Display the grade.
        if (testScore < 60)
            System.out.println("Your grade is F.");
        else if (testScore < 70)
            System.out.println("Your grade is D.");
        else if (testScore < 80)
            System.out.println("Your grade is C.");
        else if (testScore < 90)
            System.out.println("Your grade is B.");
        else if (testScore <= 90)
            System.out.println("Your grade is A.");
        else
            System.out.println("A+");

    }

    /* Ref: pg139+, Table 3-6, Code Listing3-7.
     * Explain:
     * 
     * 
     */
    public static void logicalAnd( )
    {
        double salary;       // Annual salary
        double yearsOnJob;   // Years at current job

        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);

        // Get the user's annual salary.
        System.out.print("Enter your annual salary: ");
        salary = keyboard.nextDouble();

        // Get the number of years at the current job.
        System.out.print("Enter the number of years " +
            "at your current job: ");
        yearsOnJob = keyboard.nextDouble();

        // Determine whether the user qualifies for the loan.
        if (salary >= 50000 && yearsOnJob >= 2)
        {
            System.out.println("You qualify for the loan.");
        }
        else
        {
            System.out.println("You do not qualify.");
        }
    }

    /* Ref: pg141+, Table 3-7, Code Listing3-8.
     * Explain:
     * 
     * 
     */
    public static void logicalOr( )
    {
        double salary;       // Annual salary
        double yearsOnJob;   // Years at current job

        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);

        // Get the user's annual salary.
        System.out.print("Enter your annual salary: ");
        salary = keyboard.nextDouble();

        // Get the number of years at the current job.
        System.out.print("Enter the number of years " +
            "at your current job: ");
        yearsOnJob = keyboard.nextDouble();

        // Determine whether the user qualifies for the loan.
        if (salary >= 50000 || yearsOnJob >= 2)
        {
            System.out.println("You qualify for the loan.");
        }
        else
        {
            System.out.println("You do not qualify.");
        }
    }

}

