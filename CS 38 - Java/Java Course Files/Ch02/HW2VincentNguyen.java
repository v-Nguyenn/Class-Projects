import java.awt.Font; // Big Font
import java.util.Scanner; // Needed for Scanner class to take input from user 
/**
 * Chapter 2: Programming Challenges PG 109
 * 1. Name, Age, and Annual income
 *    Write a program that declares a string name, int age, double annualPay
 *    Store your age, name, and desired annualIncome as literals in these variables
 *    
 * 3. Personal Information
 *    Write a program that display your personal information
 *    Use only a single println statement in the program
 *  
 * 5. Sales Tax Prediction
 *    The East Coast sales division of a company generates 62 percent of total sales.
 *    Based on that percentage, write a program that will predict how much the East Coast 
 *    division will generate if the company has $4.6 million in sales this year. 
 *    
 * 7. Sales Tax
 *    Write a program that will ask the user to enter the amount of a purchase. The program 
 *    should then compute the state and county sales tax. Assume the state sales tax is 4 percent
 *    and the county sales tax is 2 percent. The program should display the amount of the purchase, 
 *    the state sales tax, the county sales tax, the total sales tax, and the total of the sale 
 *    (which is the sum of the amount of purchase plus the total sales tax). 
 * 
 * 9. Miles-Per-Gallon
 *    A car’s miles-per-gallon (MPG) can be calculated with the following formula:  
 *    MPG = Miles driven/Gallons of Gas used
 *    Write a program that asks the user for the number of miles driven and the gallons of 
 *    gas used. It should calculate the car’s miles-per-gallon and display the result on the screen.
 *    
 * 11. Circuit Board Profit
 *    An electronics company sells circuit boards at a 40 percent profit. 
 *    If you know the retail price of a circuit board, you can calculate its profit with the following 
 *    formula: Profit = Retail price x 0.4
 *    Write a program that asks the user for the retail price of a circuit board, calculates the amount 
 *    of profit earned for that product, and displays the results on the screen.
 *    
 * 13. Restaurant Bill
 * ______________________
 * @author Vincent Nguyen
 * @version 09/06/24
 */
public class HW2VincentNguyen
{
    public static void main(String[] args)
    { 
        System. out. print('\u000C');               // clears terminal
    }
    public static void nameAgeIncome()
    {
        String name = "Vincent Nguyen"; 
        int age = 23;                   
        double annualPay = 100000;      
        
        // Prints line "My name is Vincent Nguyen, my age is 23 and"
        System.out.println("My name is " + name + 
                          ", my age is " + age + " and");
        
        // Prints line "I hope to earn $100000.0 per year."
        System.out.println("I hope to earn $" + annualPay 
                                              + " per year.\n"); 
    }

    public static void personalInfo()
    {
        String name = "Vincent Nguyen";              
        String address = "15965 Sapphire St, " +    
                         "Garden Grove, CA, 92650";                
        String teleNum = "714-864-3699";                                             
        String major = "Computer Science";          
        
        // Prints each information on a seperate line
        System.out.println("Name: " + name + "\n" +                      
                           "Address: " + address + "\n" +    
                           "Telephone Number: " + teleNum +  
                           "\n" +
                           "College Major: " + major + "\n");
    }

    public static void salesPredict()
    {
       // Note can assign variable type to multiple variables, can also be int, char
       double companySales, eastCoastSales, eastCoastPercent;     
       
       companySales = 4600000;                                      
       eastCoastPercent = 0.62;                                  
       
       // Multiplied total company sales and east coast percentage earned to get eastcoast sales
       eastCoastSales  = companySales * eastCoastPercent;        
       
       System.out.println("The East Coast Division will generate $" 
                           + eastCoastSales);
    }
    
    public static void salesTax()
    {
        double purchaseAmt,totalSale,totalSalesTax,STATE_SALES_TAX, COUNTY_SALES_TAX;
                                    
        // Requires Scanner Class import refer to line 2
        // 'Scanner keyboard' Declares keyboard as a variable to reference an object of the scanner class
        // 'new Scanner' creates a Scanner object in memory and will be read from System.in
        Scanner keyboard = new Scanner(System.in); 
        
        System.out.println("Enter the amount purchased: "); // Prints out comment so user can read
        purchaseAmt = keyboard.nextDouble();                // returns purchase amount as a double
        
        STATE_SALES_TAX = 0.04;  
        COUNTY_SALES_TAX = 0.02; 
        
        // Calculation
        totalSalesTax = (purchaseAmt * STATE_SALES_TAX) + 
                        (purchaseAmt * COUNTY_SALES_TAX);
        totalSale = purchaseAmt + totalSalesTax; 
        
        // Display the tax
        System.out.println("Amount purchased: $" + purchaseAmt + 
                           "\nState Sales Tax: $" + STATE_SALES_TAX +
                           "\nCounty Sales Tax: $" + COUNTY_SALES_TAX +
                           "\nTotal Sales Tax: $" + totalSalesTax +
                           "\nTotal Sale: $" + totalSale);
        
    }
    
    public static void milesPerGal()
    {
        double milesDriven, gallonsUsed, milesPerGallon;
        
        // Asks the user for miles driven 
        Scanner milesInput = new Scanner(System.in); // Uses Scanner class to receive user input variable milesInput
        System.out.println("Enter number of miles driven: "); // Prints a line for user to input
        milesDriven = milesInput.nextDouble();                // Returns milesDriven as a double from milesInput 
                                                              // Can also return .nextInt(), .nextFloat(), .nextLine();
        
        // Method is already declared so line 128 can be removed 
        Scanner galsInput = new Scanner(System.in); 
        System.out.println("Enter number of gallons of gas used: ");
        gallonsUsed = galsInput.nextDouble(); // gallonsUsed = milesInput.nextDouble() works because scanner declared
        
        // Calculation - MPG (miles per gallon) = Miles Driven / Gallons of Gas Used
        milesPerGallon = milesDriven / gallonsUsed; 
        
        // Prints output 
        System.out.println("Miles Driven: " + milesDriven +
                           "\nGallons Used: " + gallonsUsed +
                           "\nMiles Per Gallon: " + milesPerGallon);
    }
    
    public static void circuitBoard()
    {
        double retailPrice,SELL_PERCENT, profit;
        
        // Asks for user Input
        Scanner Keyboard = new Scanner(System.in);
        System.out.println("Retail price of circuit board: ");
        retailPrice = Keyboard.nextDouble();
        
        // Constant of electronic company percentage profit
        SELL_PERCENT = 0.4;
        
        // Calculation
        profit = retailPrice * SELL_PERCENT;
        
        // Display all information
        System.out.println("Retail price: $" + retailPrice +
                            "\nPercentage Profit: $" + SELL_PERCENT +
                            "\nProfit: $" + profit);
        
    }
    
    public static void restaurantBill()
    {
        double mealCharge, SALES_TAX, TIP, taxAmt, tipAmt, totalBill;
        
        // Asks User to input meal charge
        Scanner Input = new Scanner(System.in);
        System.out.println("Meal Charge:");
        mealCharge = Input.nextDouble();
        
        SALES_TAX =.0675; // 6.75 percent Sales tax
        TIP = .2;         // 20 percent tip 
        
        // Calculation
        taxAmt = mealCharge * SALES_TAX;           // Tax multiplied by meal
        tipAmt = (mealCharge + taxAmt) * TIP;      // Tip multipled after meal and tax are added
        totalBill = (mealCharge + taxAmt + tipAmt);// Add all variables to get total bill
        
        // Displaying meal charge, tax amount, tip amount, and total bill on screen
        System.out.println("Meal Charge: $" + mealCharge +
                           "\nTax Amount: $" + taxAmt +
                           "\nTip Amount: $" + tipAmt +
                           "\nTotal Bill: $" + totalBill);
    }
    public static void bigFont()
    {
        // Set Screen 
        Draw big = new Draw( );
        big.clear(Draw.LIGHT_GRAY);
        big.setXscale(0, 400); // Setting Screen Parameters
        big.setYscale(400, 0);
        big.setTitle("All Program Challenge problems output by Vincent Nguyen"); 
                
        big.setPenColor(Draw.YELLOW);
        Font fntSize = new Font("Arial", Font.PLAIN, 11);
        big.setFont(fntSize);
        
        // Output 1
        big.textLeft(0, 180, "Output 1");
        big.textLeft(0, 190, "My name is Vincent Nguyen, my age is 23 and");
        big.textLeft(0, 200, "I hope to earn $100000.0 per year.");
        
        // Output 3
        big.textLeft(0, 210, "Output 3");
        big.textLeft(0, 220, "Name: Vincent Nguyen");
        big.textLeft(0, 230, "15965 Sapphire St, Garden Grove, CA, 92650");
        big.textLeft(0, 240, "Telephone number: 714-864-3699");
        big.textLeft(0, 250, "College Major: Computer Science");
        
        // Output 5
        big.textLeft(0, 260, "Output 5");
        big.textLeft(0, 270, "The East Coast Division will generate $285200.0");
        
        // Output 7
        big.textLeft(0, 280, "Output 7");
        big.textLeft(0, 290, "Amount purchased: $200.0");
        big.textLeft(0, 300, "State Sales Tax: $0.04");
        big.textLeft(0, 310, "County Sales Tax: $0.02");
        big.textLeft(0, 320, "Total Sales Tax: $12.0");
        big.textLeft(0, 330, "Total Sale: $212.0");
        
        // Output 9
        big.textLeft(0, 340, "Output 9");
        big.textLeft(0, 350, "Miles Per Gallon: 20.0");
        
        // Output 11
        big.textLeft(0, 360, "Output 11");
        big.textLeft(0, 370, "Profit: $8.0");
        
        // Output 13
        big.textLeft(0, 379, "Output 13");
        big.textLeft(0, 388, "Meal Charge: $400.0, Tax Amount: $27.0,"); 
        big.textLeft(0, 396, "Tip Amount: $85.4, Total Bill: $512.4"); 
    
        Font fnt = new Font("Arial", Font.PLAIN, 48);
        big.setFont( fnt );
        big.textLeft(75, 100, "Vincent Nguyen");
        
    }

}
/**
   
    
 **/