import java.util.Random;
/**
 * Description 
 * ____________
 * ____________
 * @author Vincent Nguyen   
 * @version 12/10/24
 */
public class Demo2DVNguyen
{
    public static void main(String[] args)
    {

    }
    
    public static void olympicMedals() {
        int[][] metals = { // G S B
                {3, 0, 1}, // 0 = Canada
                {2, 1, 5}, // 1 = China
                {0, 4, 1}, // 2 = Germany
                {2, 4, 0}, // 3 = Korea
                {1, 1, 1}, // 4 = Japan
                {0, 1, 0}, // 5 = Russia
                {1, 1, 0}  // 6 = USA
        };

        String[] countries = {"Canada", "China", "Germany", "Korea", "Japan", "Russia", "USA"};

        // Q1 - Total number of nations
        int totalNations = metals.length;
        System.out.println("The total number of nations: " + totalNations);

        // Q2 - Update for next event winners: China, Japan, USA, Korea
        metals[1] = new int[]{3, 1, 5};  // China
        metals[4] = new int[]{1, 2, 1};  // Japan
        metals[6] = new int[]{1, 1, 1};  // USA
        metals[3] = new int[]{2, 4, 0};  // Korea (unchanged)

        System.out.println("After China, Japan, USA, Korea =====");
        printArray(metals, countries);

        // Q4 - Referee correction: China disqualified
        metals[1] = new int[]{0, 0, 0}; // China’s medals reset
        System.out.println("After correction from the ref =====");
        printArray(metals, countries);

        // Q5 - Next event winners: USA, Canada, China, Russia
        metals[6][0] += 1; // USA gets 1 gold
        metals[0][1] += 1; // Canada gets 1 silver
        metals[1][2] += 1; // China gets 1 bronze
        metals[5][2] += 1; // Russia gets 1 bronze

        System.out.println("After USA, Canada, China, Russia =====");
        printArray(metals, countries);

        // Q6 - Find the country with the most medals
        int maxMedals = 0;
        String topCountry = "";
        for (int i = 0; i < metals.length; i++) 
        {
            int sum = metals[i][0] + metals[i][1] + metals[i][2];
            if (sum > maxMedals) {
                maxMedals = sum;
                topCountry = countries[i];
            }
        }
        System.out.println("Country with the most medals: " + topCountry + " (" + maxMedals + " medals)");
    }

    // Method to print the medal table
    public static void printArray(int[][] metals, String[] countries) 
    {
        System.out.printf("%-10s %5s %5s %5s\n", "Country", "Gold", "Silver", "Bronze");
        for (int i = 0; i < metals.length; i++) 
        {
            System.out.printf("%-10s %5d %5d %5d\n", countries[i], metals[i][0], metals[i][1], metals[i][2]);
        }
    }

    public static void phoneBills1() 
    {
        System.out.println("familyCellBills=====");

        // Constants for rows (months) and columns (persons)
        final int NUM_MONTHS = 3;
        final int NUM_PERSONS = 4;

        // Declare and initialize the array
        double[][] familyCellBills = new double[NUM_MONTHS][NUM_PERSONS];

        // Assign values to array elements
        familyCellBills[0][0] = 45.24;  // July bills
        familyCellBills[0][1] = 54.67;
        familyCellBills[0][2] = 32.55;
        familyCellBills[0][3] = 25.61;

        familyCellBills[1][0] = 65.29;  // August bills
        familyCellBills[1][1] = 49.75;
        familyCellBills[1][2] = 32.08;
        familyCellBills[1][3] = 26.11;

        familyCellBills[2][0] = 75.24;  // September bills
        familyCellBills[2][1] = 54.53;
        familyCellBills[2][2] = 34.55;
        familyCellBills[2][3] = 28.16;

        printArray(familyCellBills);

        System.out.println("The first monthly cell bill for the first family member is\n" + familyCellBills[0][0]);
        System.out.println("The last monthly cell bill for the last family member is\n" + familyCellBills[NUM_MONTHS - 1][NUM_PERSONS - 1]);

        int numRows = familyCellBills.length;
        System.out.println("\nThe number of rows is " + numRows);

        for (int i = 0; i < numRows; i++) 
        {
            System.out.print("The number of columns in row " + i + " is ");
            System.out.println(familyCellBills[i].length);
        }

        // How much did the family spend for July? (Row 0)
        double julyBill = 0;
        for (int col = 0; col < familyCellBills[0].length; col++) 
        {
            julyBill += familyCellBills[0][col];
        }
        System.out.printf("July bill = $%.2f\n", julyBill);

        // How much did the family spend for August? (Row 1)
        double augustBill = 0;
        for (int col = 0; col < familyCellBills[1].length; col++) 
        {
            augustBill += familyCellBills[1][col];
        }
        System.out.printf("August bill = $%.2f\n", augustBill);

        // Total bill calculation (all rows and columns)
        double totalBill = 0;
        for (int row = 0; row < familyCellBills.length; row++) 
        {
            for (int col = 0; col < familyCellBills[row].length; col++) 
            {
                totalBill += familyCellBills[row][col];
            }
        }
        System.out.printf("Total bill = $%.2f\n", totalBill);

        // Q1: Change one of the bills (e.g., update [1][1]) and print
        System.out.println("\nBefore bill change:");
        printArray(familyCellBills);

        familyCellBills[1][1] = 59.99;  // Update a bill for demonstration
        System.out.println("After bill change:");
        printArray(familyCellBills);

        // Q2: Increase Mom's July bill by $10 and print
        System.out.println("Increasing Mom's July bill by $10:");
        familyCellBills[0][1] += 10;  // Mom's bill is at row 0, column 1
        printArray(familyCellBills);
    }

    public static void printArray( double[][] ary )
    {
        for(int row=0; row<ary.length; row++)
        {
            for(int col=0; col<ary[row].length; col++)
            {
                System.out.print("$%.2f\t ary[row][col] +  " );
            }
            System.out.println();
        }
        System.out.println();
    }

    // This is an example of an overloaded array which has the same name 
    // but passes a different variable type.
    public static void printArray( int[][] ary )
    {
        for(int row=0; row<ary.length; row++)
        {
            for(int col=0; col<ary[row].length; col++)
            {
                System.out.print( ary[row][col] + " " );
            }
            System.out.println();
        }
        System.out.println();
    }

    // public static void demoJogger1( )
    // {
        // Jogger2D_ANS bob = new Jogger2D_ANS( );
        // bob.printAll();
    // }

    public static void dailyTemperatureDemo()
    {
        double [][] dailyTemperature = new double[52][7];
        Random rand = new Random();
        // You have two loops, the outer one is row
        // The Inner loop is the column
        for (int row = 0; row < dailyTemperature.length; row++)
        {
            for (int col = 0; col < dailyTemperature[row].length; col++)
            {
                dailyTemperature[row][col] = rand.nextDouble() * 25 + 35;
            }
        }
        printArray(dailyTemperature);
    }
}
