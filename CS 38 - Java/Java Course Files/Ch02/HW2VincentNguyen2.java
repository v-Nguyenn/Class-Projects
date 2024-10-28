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
wd * 13. Restaurant Bill
 * ______________________
 * @author Vincent Nguyen
 * @version 09/06/24
 */
public class HW2VincentNguyen2
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
        
        // Graphics Screen Setup 
        Draw big = new Draw( );         
        big.clear(Draw.LIGHT_GRAY); 
        big.setXscale(0, 400); 
        big.setYscale(400, 0);
        big.setTitle("Name, Age, Income problems output by Vincent Nguyen"); 
        
        // Big Name on Graphics Screen
        Font bigFnt = new Font("Arial", Font.PLAIN, 40); // create variable bigFnt 
        big.setFont(bigFnt);
        big.textLeft(85, 100, "Vincent Nguyen");
        
        // Output 1 in graphics screen
        int xPos = 0, yPos = 200;
        Font smallFnt = new Font("Arial", Font.PLAIN, 20); 
        big.setFont(smallFnt);
        big.setPenColor(Draw.YELLOW);
        
        big.textLeft(xPos, yPos, "Output 1");
        big.textLeft(xPos, yPos + 15, "My name is " + name + ", my age is " + age + " and");
        big.textLeft(xPos, yPos + 30, "I hope to earn $" + annualPay + " per year.");
    }

    public static void personalInfo()
    {
        String name = "Vincent Nguyen";              
        String address = "15965 Sapphire St, " +    
                         "Garden Grove, CA, 92650";                
        String teleNum = "714-864-3699";                                             
        String major = "Computer Science";    
        
        // Graphics Screen Setup 
        Draw big = new Draw( );         
        big.clear(Draw.BLACK); 
        big.setXscale(0, 400); 
        big.setYscale(400, 0);
        big.setTitle("Personal Information problems output by Vincent Nguyen"); 
        
        // Big Name on Graphics Screen
        Font bigFnt = new Font("Arial", Font.PLAIN, 40); // create variable bigFnt 
        big.setFont(bigFnt);
        big.setPenColor(Draw.PINK);
        big.text(200, 100, "Vincent Nguyen", 180);
        
        // Output 3 in graphics screen
        int xPos = 0, yPos = 200;
        Font smallFnt = new Font("Arial", Font.PLAIN, 20); 
        
        big.setFont(smallFnt);       // sets the font on variable big to smallFnt
        big.setPenColor(Draw.GREEN); // sets pen color to green 
        
        // Display output on graphics screen
        big.textLeft(xPos, yPos, "Output 3");
        big.textLeft(xPos, yPos + 15, "Name: " + name);
        big.textLeft(xPos, yPos + 30, "Address: " + address);
        big.textLeft(xPos, yPos + 45, "Telephone number: " + teleNum);
        big.textLeft(xPos, yPos + 60, "College Major: " + major);
    }

    public static void salesPredict()
    {
       // Note can assign variable type to multiple variables, can also be int, char
       double companySales, eastCoastSales, eastCoastPercent;     
       companySales = 4600000;                                      
       eastCoastPercent = 0.62; 
       
       // Calculation
       eastCoastSales = companySales * eastCoastPercent; 
       
       // Graphics Screen Setup 
       Draw big = new Draw( );         
       big.clear(Draw.WHITE); 
       big.setXscale(0, 400); 
       big.setYscale(400, 0);
       big.setTitle("Sales Prediction output by Vincent Nguyen"); 
        
       // Rectangle for bottom left Quadrant
       big.filledSquare(100, 300, 100);
        
       // Big Name on Graphics Screen
       Font bigFnt = new Font("Arial", Font.PLAIN, 40); // create variable bigFnt 
       big.setFont(bigFnt);
       big.setPenColor(Draw.BLACK);
       big.text(200, 100, "Vincent Nguyen", 300);
        
       // Output 5 in graphics screen
       int xPos = 0, yPos = 210;
       Font smallFnt = new Font("Arial", Font.PLAIN, 20); 
        
       big.setFont(smallFnt);       // sets the font on variable big to smallFnt
       big.setPenColor(Draw.GREEN); // sets pen color to green 
                                                      
       // Output 5 in graphics screen
       big.textLeft(xPos, yPos, "Output 5");
       big.textLeft(xPos, yPos + 15 , "The East Coast Division will "); 
       big.textLeft(xPos, yPos + 30 , "generate $" + eastCoastSales);
    }
    
    public static void salesTax()
    {
        double purchaseAmt,totalSale,totalSalesTax,STATE_SALES_TAX, COUNTY_SALES_TAX;
                                    
        // Requires Scanner Class import refer to line 2
        // 'Scanner keyboard' Declares keyboard as a variable to reference an object of the scanner class
        // 'new Scanner' creates a Scanner object in memory and will be read from System.in
        Scanner keyboard = new Scanner(System.in); 
            
        
        System.out.println("Output 7");
        System.out.println("Enter the amount purchased or 0 to exit: "); // Prints out comment so user can read
        purchaseAmt = keyboard.nextDouble();                // returns purchase amount as a double
        
        // Exit Condtion: if the amount purchase is less that 0, exit the program 
        if (purchaseAmt <= 0){
            System.out.println("Invalid purchase amount. Exiting program");
            System.exit(0); // exit program with status 0
        }
        
        STATE_SALES_TAX = 0.04;  
        COUNTY_SALES_TAX = 0.02; 
        
        // Calculation
        totalSalesTax = (purchaseAmt * STATE_SALES_TAX) + 
                        (purchaseAmt * COUNTY_SALES_TAX);
        totalSale = purchaseAmt + totalSalesTax; 

        // Graphics Screen Setup 
        Draw big = new Draw( );         
        big.clear(Draw.GREEN); 
        big.setXscale(0, 400); 
        big.setYscale(400, 0);
        big.setTitle("Sale Tax problems output by Vincent Nguyen"); 
        
        // Circle for name
        big.setPenColor(Draw.PINK);
        big.filledCircle(200, 100, 150);
       
        // Rectangle for bottom left Quadrant
        big.setPenColor(Draw.LIGHT_GRAY);
        big.filledSquare(100, 300, 100);
       
        // Big Name on Graphics Screen
        Font bigFnt = new Font("Arial", Font.PLAIN, 40); // create variable bigFnt 
        big.setFont(bigFnt);
        big.setPenColor(Draw.BLACK);
        big.text(200, 100, "Vincent Nguyen", 0);
        
        // Output 7 in graphics screen
        int xPos = 0, yPos = 210;
        Font smallFnt = new Font("Arial", Font.PLAIN, 20); 
        
        big.setFont(smallFnt);       // sets the font on variable big to smallFnt
        big.setPenColor(Draw.BLACK); // sets pen color to BLACK
                           
        // Output 7 in graphics Screen
        big.textLeft(0, yPos, "Problem 7");
        big.textLeft(0, yPos + 15, "Amount purchased: $" + purchaseAmt);
        big.textLeft(0, yPos + 30, "State Sales Tax: $" + STATE_SALES_TAX);
        big.textLeft(0, yPos + 45, "County Sales Tax: $" + COUNTY_SALES_TAX);
        big.textLeft(0, yPos + 60, "Total Sales Tax: $"+ totalSalesTax);
        big.textLeft(0, yPos + 75, "Total Sale: $" + totalSale);
        
    }
    
    public static void milesPerGal()
    {
        double milesDriven, gallonsUsed, milesPerGallon;
        
        // Asks the user for miles driven 
        System.out.println("Problem 9");
        Scanner Input = new Scanner(System.in); // Uses Scanner class to receive user input variable Input
        System.out.println("Enter number of miles driven or 0 to exit: "); // Prints a line for user to input
        milesDriven = Input.nextDouble();                // Returns milesDriven as a double from milesInput 
                                                              // Can also return .nextInt(), .nextFloat(), .nextLine();
                                                              
         // Exit Condtion: if the miles are less that 0, exit the program 
        if (milesDriven <= 0){
            System.out.println("Invalid purchase amount. Exiting program");
            System.exit(0); // exit program with status 0
        }
        
          
        System.out.println("Enter number of gallons of gas used: ");
        gallonsUsed = Input.nextDouble(); 
        
        // Calculation - MPG (miles per gallon) = Miles Driven / Gallons of Gas Used
        milesPerGallon = milesDriven / gallonsUsed; 
        
        
        // Graphics Screen Setup 
        Draw big = new Draw( );         
        big.clear(Draw.LIGHT_GRAY); 
        big.setXscale(0, 400); 
        big.setYscale(400, 0);
        big.setTitle("Miles Per Gallon output by Vincent Nguyen"); 
        
        // Ellipse for Name
        big.setPenColor(Draw.PINK);
        big.filledEllipse(200, 100, 150, 100);
       
        // Rectangle for bottom left Quadrant
        big.setPenColor(Draw.BLACK);
        big.filledSquare(300, 300, 100);
       
        // Big Name on Graphics Screen
        Font bigFnt = new Font("Arial", Font.PLAIN, 40); // create variable bigFnt 
        big.setFont(bigFnt);
        big.setPenColor(Draw.RED);
        big.text(200, 100, "Vincent Nguyen", 0);
        
        // Output 9 in graphics screen
        int xPos = 0, yPos = 210;
        Font smallFnt = new Font("Arial", Font.PLAIN, 20); 
        
        big.setFont(smallFnt);       // sets the font on variable big to smallFnt
        big.setPenColor(Draw.BLACK); // sets pen color to BLACK
        
        // Display text print on graphics screen
        big.textLeft(xPos, yPos, "Output 9");
        big.textLeft(xPos, yPos + 15, "Miles Driven: " + milesDriven);
        big.textLeft(xPos, yPos + 30, "Gallons Used: " + gallonsUsed);
        big.textLeft(xPos, yPos + 45, "Miles Per Gallon: " + milesPerGallon);
        
    }
    
    public static void circuitBoard()
    {
        double retailPrice,SELL_PERCENT, profit;
        
        // Asks for user Input
        System.out.println("Problem 11");
        Scanner Keyboard = new Scanner(System.in);
        System.out.println("Retail price of circuit board or 0 to exit: ");
        retailPrice = Keyboard.nextDouble();
        
        // Exit Condtion: if retailPrice is less that 0, exit the program 
        if (retailPrice <= 0){
            System.out.println("Invalid purchase amount. Exiting program");
            System.exit(0); // exit program with status 0
        }
        
        // Constant of electronic company percentage profit
        SELL_PERCENT = 0.4;
        
        // Calculation
        profit = retailPrice * SELL_PERCENT;
        
        // Graphics Screen Setup 
        Draw big = new Draw( );         
        big.clear(Draw.LIGHT_GRAY); 
        big.setXscale(0, 400); 
        big.setYscale(400, 0);
        big.setTitle("Retail Circuit Board problems output by Vincent Nguyen"); 
           
        // Ellipse for Name
        big.setPenColor(Draw.PINK);
        big.filledEllipse(200, 100, 150, 100);
        
        // Rectangle for bottom left Quadrant
        big.setPenColor(Draw.BLACK);
        big.filledSquare(300, 300, 100);
        
        // Rectangle top left
        big.filledSquare(100, 100, 100);
       
        // Big Name on Graphics Screen
        Font bigFnt = new Font("Arial", Font.PLAIN, 40); // create variable bigFnt 
        big.setFont(bigFnt);
        big.setPenColor(Draw.WHITE);
        big.text(135, 100, "Vincent", 0);
        
        big.setPenColor(Draw.BLACK);
        big.text(255, 100, "Nguyen", 0);
        
        // Output 11 in graphics screen
        int xPos = 0, yPos = 210;
        Font smallFnt = new Font("Arial", Font.PLAIN, 20); 
        
        big.setFont(smallFnt);       // sets the font on variable big to smallFnt
        big.setPenColor(Draw.DARK_GRAY); // sets pen color to BLACK
        
        // Displays information to Graphics Screen
        big.textLeft(0, yPos, "Output 11");
        big.textLeft(0, yPos + 15, "Retail price: $" + retailPrice);
        big.textLeft(0, yPos + 30, "Percentage Profit: " + SELL_PERCENT);
        big.textLeft(0, yPos + 45, "Profit: $" + profit);
    }
    
    public static void restaurantBill()
    {
        double mealCharge, SALES_TAX, TIP, taxAmt, tipAmt, totalBill;
        
        // Asks User to input meal charge
        System.out.println("Problem 13");
        Scanner Input = new Scanner(System.in);
        System.out.println("Meal Charge:");
        mealCharge = Input.nextDouble();
        
        // Exit Condtion: if meal charge is less that 0, exit the program 
        if (mealCharge <= 0){
            System.out.println("Invalid purchase amount. Exiting program");
            System.exit(0); // exit program with status 0
        }
        
        SALES_TAX =.0675; // 6.75 percent Sales tax
        TIP = .2;         // 20 percent tip 
        
        // Calculation
        taxAmt = mealCharge * SALES_TAX;           // Tax multiplied by meal
        tipAmt = (mealCharge + taxAmt) * TIP;      // Tip multipled after meal and tax are added
        totalBill = (mealCharge + taxAmt + tipAmt);// Add all variables to get total bill
        
        // Displaying meal charge, tax amount, tip amount, and total bill on terminal screen
        System.out.println("Meal Charge: $" + mealCharge +
                           "\nTax Amount: $" + taxAmt +
                           "\nTip Amount: $" + tipAmt +
                           "\nTotal Bill: $" + totalBill + "\n");
                         
    
         // Graphics Screen Setup 
        Draw big = new Draw( );         
        big.clear(Draw.LIGHT_GRAY); 
        big.setXscale(0, 400); 
        big.setYscale(400, 0);
        big.setTitle("Restaurant Bill problems output by Vincent Nguyen"); 
           
        // Ellipse for Name
        big.setPenColor(Draw.YELLOW);
        big.filledEllipse(200, 100, 150, 100);
        
        // Square for bottom right Quadrant
        big.setPenColor(Draw.BLACK);
        big.filledSquare(300, 300, 100);
        
        // Square bottom left Quadrant
        big.setPenColor(Draw.DARK_GRAY);
        big.filledSquare(100, 300, 100);
       
        // Big Name on Graphics Screen
        Font bigFnt = new Font("Arial", Font.PLAIN, 40); // create variable bigFnt 
        big.setFont(bigFnt);
        big.setPenColor(Draw.LIGHT_GRAY);
        big.text(135, 100, "Vincent", 0);
        
        big.setPenColor(Draw.BLACK);
        big.text(255, 100, "Nguyen", 0);
        
        // Output 13 in graphics screen
        int xPos = 50, yPos = 300;
        Font smallFnt = new Font("Arial", Font.PLAIN, 20); 
        
        big.setFont(smallFnt);       // sets the font on variable big to smallFnt
        big.setPenColor(Draw.YELLOW); // sets pen color to BLACK
        
        // Output text on graphics screen
        big.text(xPos     , yPos, "Output 13", 90); // x , y, "text", angle
        big.text(xPos + 15, yPos, "Meal charged: $" + mealCharge, 90);
        big.text(xPos + 30, yPos, "Tax Amount: $" + taxAmt, 90);
        big.text(xPos + 45, yPos, "Tip Amount: $" + tipAmt, 90);
        big.text(xPos + 60, yPos, "Total Bill: $" + totalBill, 90);
    }
}
/**
   
    
 **/
