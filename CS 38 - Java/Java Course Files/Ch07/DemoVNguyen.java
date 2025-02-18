import java.util.Scanner;

/**
 * Write a description of class DemoVNguyen here.
 * Run main if you want to see all the results but can also be 
 * called individually.
 *
 * @author (Vincent Nguyen)
 * @version (12/08/24)
 */
public class DemoVNguyen
{
    public static void main(String[] args)
    {
        demoRainfallVN(); 
    }

    public static void demoRainfallVN() {
        System.out.println("Programming Challenge #1: Rainfall Class");

        // test data for rainfall (in inches)
        double[] monthlyRainfall = {2.5, 3.0, 1.8, 4.2, 2.9, 3.5, 1.2, 3.6, 2.7, 3.9, 4.1, 5.0};

        // instantiate rainfallVN object
        rainfallVN rainfall = new rainfallVN(monthlyRainfall);

        // this is to store the results so it was easier to print
        double yearlyRain = rainfall.yearlyRainfall();
        double avgMonthlyRain = rainfall.avgMonthlyRainfall();
        int mostRainMonth = (int) rainfall.mostMonthlyRainfall() + 1; // Add 1 for readable month
        int leastRainMonth = (int) rainfall.leastMonthlyRainfall() + 1; // Add 1 for readable month
        double mostRain = monthlyRainfall[(int) rainfall.mostMonthlyRainfall()];
        double leastRain = monthlyRainfall[(int) rainfall.leastMonthlyRainfall()];

        // print the results and display here
        System.out.printf("Yearly Rainfall: %.2f inches\n", yearlyRain);
        System.out.printf("Average Monthly Rainfall: %.2f inches\n", avgMonthlyRain);
        System.out.printf("Month with Most Rain: %d with %.2f inches\n", mostRainMonth, mostRain);
        System.out.printf("Month with Least Rain: %d with %.2f inches\n", leastRainMonth, leastRain);
        System.out.println();
    }

    public static void demoChargeAccValVN()
    {
        int accountNumber; // number to validate

        // Create scanner
        Scanner keyboard = new Scanner(System.in);

        // Create a validator object
        ChargeAccValVN validate = new ChargeAccValVN();

        // Ask user for account number
        System.out.print("Enter the charge account number: ");
        accountNumber = keyboard.nextInt();

        // Determine whetehr it is valid
        if (validate.isValid(accountNumber))
        {
            System.out.println("That's a valid account number.");
        }
        else  
        {
            System.out.println("That's an invalid account number.");
        }
        keyboard.close();
    }

    public static void demoLargerThanNVNzs()
    {
        int[] numbers = {10, 25, 30, 5, 50, 45, 3};

        int n = 20;
        largerThanNVN.displayNumLargerthanN(numbers, n);
    }
}
