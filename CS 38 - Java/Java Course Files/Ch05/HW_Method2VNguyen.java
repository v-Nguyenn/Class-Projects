import java.util.Scanner;
import java.util.Random;
import java.awt.Font;

/**
 * Write a description of class HW_Method2VNguyen here.
 * The following programming challenges and graphics challenge
 * are completed here.
 * 
 * Programming Challenge #2 - retailPriceVNguyen
 * Retail Price Calculator
 * Asks the user to enter a whole sale price and mark up percentage
 * then calculate it and return the retail price of the item.
 * 
 * Programming Challenge #4 - paintJobVNguyen
 * Paint Job Estimator
 * Given the amount of rooms the user entered, the price of paint, 
 * and the square feet of wall space  , this will return the number 
 * of gallons of paint, hours of labor, cost of paint, the labor charges,
 * and the total cost of the job.
 * 
 * Programming Challenge #6 - celsiusTableVNguyen
 * Celsius Temperature table
 * Converts Fahreinheit temperatures from 0 to 20 to Celsius and displays 
 * them in a graphics screen.
 * 
 * Programming Challenge #7 - testAvgGradeVNguyen
 * Test Average and Grade Calculator
 * Program to calculate the average of five test scores and determine each 
 * score's grade. Displays the results in a graphics screen.
 *  
 * Graphics Challenge - testOlympicsVNguyen() 
 * Generates the 5 olympic rings in the bottom right of the corner.
 * Order is random when the enter key is hit.
 * 
 * @author Vincent Nguyen
 * @version 10/27/24
 */
public class HW_Method2VNguyen
{
     // ---------------------------- Programming Challenge #2 Below -------------------------------- // 
    
    /**
     * Programming Challenge #2 - Retail Price Calculator
     * This is the main method to ask for user input and 
     * the helper method calculateRetail
     */
    public static void RetailPriceVNguyen()
    {
        // Take user input
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the item's wholesale price. ");
        Double wholesalePrice =  keyboard.nextDouble();

        System.out.print("Enter the item's markup percentage. ");
        Double markupPercent =  keyboard.nextDouble();

        keyboard.close();

        // Calculate the retail price and print the result
        double retailPrice = calculateRetail(wholesalePrice, markupPercent);
        System.out.printf("The item's retail price is: $%.2f%n", retailPrice);

        // Displays Result to graphics screen
        Draw scr = new Draw(); 
        displayOutput(scr, wholesalePrice, markupPercent );
    }
    /**
     * Helper method to calculate retail price based on wholesale price
     * and markup percentage
     * 
     * @param wholesalePrice the item's original wholesale price
     * @param markupPercent wholeSalePrice the item's wholesale cost
     * @return the calculated retail price after markup
     */
    public static double calculateRetail(double wholesalePrice, double markupPercent)
    {
        return wholesalePrice * (1 + markupPercent/100);
    }
    /**
     * Method setups up the graphics screen and displays the output
     * @param scr the graphics screen where output will be displayed
     * @param wholesalePrice item's wholesale cost
     * @param markupPercent the markup percentage to be applied
     */ 
    public static void displayOutput(Draw scr, double wholesalePrice, double markupPercent)
    {
        scr.setTitle("Retail Price calculator by VNguyen");
        scr.setXscale(0, 400);
        scr.setYscale(400, 0);

        // Set the font
        Font fnt = new Font("Arial", Font.PLAIN, 24);
        scr.setFont(fnt);

        scr.text(100, 200, "Wholesale price: $" + wholesalePrice);
        scr.text(100, 220, "Markup percentage: " + markupPercent + "%");
        scr.text(100, 240, "Retail price: $" + calculateRetail(wholesalePrice, markupPercent));

    }   

    
     // ---------------------------- Programming Challenge #4 Below -------------------------------- //
    
    
    /**
     * Programming Challenge #4 - Paint job Calculator
     * Main method that gathers user input and calls helper methods to calculate
     * and display the paint job requirements.
     * 
     */
    public static void paintJobVNguyen() 
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the number of rooms to be painted: ");
        int rooms = keyboard.nextInt();

        System.out.print("Enter the price of paint per gallon: ");
        double pricePerGallon = keyboard.nextDouble();

        double totalSquareFeet = 0;
        for (int i = 1; i <= rooms; i++) {
            System.out.printf("Enter square feet of wall space for room %d: ", i);
            totalSquareFeet += keyboard.nextDouble();
        }

        // Perform calculations
        double gallons = numOfGal(totalSquareFeet);
        double hours = laborHours(gallons);
        double paintCost = costOfPaint(gallons, pricePerGallon);
        double laborCost = laborCharges(hours);
        double totalCost = totalCostOfPaintJob(paintCost, laborCost);

        // Display results in graphics
        Draw scr = new Draw();
        displayOutput(scr, gallons, hours, paintCost, laborCost, totalCost);

        keyboard.close();
    }
    /**
     * Method to calculate the number of gallons of paint required.
     * 
     * @param totalSquareFeet the total square feet of wall space
     * @return the number of gallons required
     */
    public static double numOfGal(double totalSquareFeet) {
        return totalSquareFeet / 115;
    }
    /**
     * Method to calculate the hours of labor required based on gallons of paint.
     * 
     * @param gallons the number of gallons required
     * @return the number of hours of labor required
     */
    public static double laborHours(double gallons) {
        return gallons * 8;
    }
    /**
     * Method to calculate the cost of paint based on gallons and price per gallon.
     * 
     * @param gallons the number of gallons required
     * @param pricePerGallon the price of one gallon of paint
     * @return the total cost of the paint
     */
    public static double costOfPaint(double gallons, double pricePerGallon) {
        return gallons * pricePerGallon;
    }
    /**
     * Method to calculate labor charges based on hours of labor.
     * 
     * @param hours the number of hours required for labor
     * @return the total labor charges
     */
    public static double laborCharges(double hours) {
        return hours * 18;
    }
    /**
     * Method to calculate the total cost of the paint job.
     * 
     * @param paintCost the total cost of the paint
     * @param laborCost the total labor charges
     * @return the total cost of the paint job
     */
    public static double totalCostOfPaintJob(double paintCost, double laborCost) {
        return paintCost + laborCost;
    }
    /**
     * Displays the paint job details on the graphics screen.
     * 
     * @param scr the Draw object used for displaying the results
     * @param gallons the number of gallons required
     * @param hours the number of hours required for labor
     * @param paintCost the cost of the paint
     * @param laborCost the labor charges
     * @param totalCost the total cost of the paint job
     */
    public static void displayOutput(Draw scr, double gallons, double hours,
    double paintCost, double laborCost, double totalCost) 
    {
        scr.setTitle("Paint Job Summary by VNguyen");
        scr.setXscale(0, 400);
        scr.setYscale(400, 0);

        Font fnt = new Font("Arial", Font.PLAIN, 14);
        scr.setFont(fnt);

        // Display each piece of data
        scr.text(200, 50, "Paint Job Summary");
        scr.text(200, 100, "Gallons of paint required: " + String.format("%.2f", gallons));
        scr.text(200, 130, "Hours of labor required: " + String.format("%.2f", hours));
        scr.text(200, 160, "Cost of the paint: $" + String.format("%.2f", paintCost));
        scr.text(200, 190, "Labor charges: $" + String.format("%.2f", laborCost));
        scr.text(200, 220, "Total cost of the paint job: $" + String.format("%.2f", totalCost));
    }
    
    
     // ---------------------------- Programming Challenge #6 Below -------------------------------- //
    
    
    /**
     * Programming Challenge #6 - Celsius Temperature Table
     * Main method that sets up the graphical display for the Celsius table.
     */
    public static void celsiusTableVNguyen()
    {
        Draw scr = new Draw();
        graphics(scr);

        Font fnt = new Font("Serif", Font.PLAIN, 24);
        scr.setFont(fnt);

        // Display the temperature table from 0 to 20 Fahrenheit
        for (int fahrenheit = 0; fahrenheit <= 20; fahrenheit++) {
            scr.textLeft(100, 50 + fahrenheit * 15, fahrenheit + " F = " 
                                 + String.format("%.2f", celsius(fahrenheit)) + " C");
        }
    }
    /**
     * Sets up the graphical display properties.
     * 
     * @param scrn the Draw object for graphical output
     * @param title the title of the display window
     */
    public static void graphics(Draw scr)
    {
        scr.setTitle("Celsius Temperature Table by VNguyen");
        scr.setXscale(0, 400);
        scr.setYscale(400, 0);
        scr.clear(Draw.LIGHT_GRAY);

        Font fnt = new Font("Serif", Font.BOLD, 24);
        scr.setFont(fnt);
        scr.text(200, 20, "Celsius Temperature Table by VNguyen");
    }
    /**
     * Converts Fahrenheit to Celsius.
     * 
     * @param fahrenheit the temperature in Fahrenheit
     * @return the converted temperature in Celsius
     */
    public static double celsius(double fahrenheit)
    {
        return (5 * (fahrenheit - 32) / 9);
    }
    
    
    // ---------------------------- Programming Challenge #7 Below -------------------------------- // 

    
    public static void testAvgGradeVNguyen()
    {
        Scanner input = new Scanner(System.in);
        
        // Gather scores from the user
        double s1 = getScore(input, 1);
        double s2 = getScore(input, 2);
        double s3 = getScore(input, 3);
        double s4 = getScore(input, 4);
        double s5 = getScore(input, 5);
        
        // Calculate average score
        double avg = calcAvg(s1, s2, s3, s4, s5);

        // Set up graphics for display
        Draw scr = new Draw();
        displayResults(scr, s1, s2, s3, s4, s5, avg);

        input.close();
    }
    /**
     * Collects an individual score from the user.
     * 
     * @param input Scanner for user input
     * @param num the test score number
     * @return the score entered by the user
     */
    public static double getScore(Scanner input, int num)
    {
        System.out.printf("Enter test score %d: ", num);
        return input.nextDouble();
    }
    /**
     * Calculates the average of five scores.
     * 
     * @param scores an array of scores
     * @return the calculated average
     */
    public static double calcAvg(double... scores)
    {
        double total = 0;
        for (double score : scores)
            total += score;
        return total / scores.length;
    }
    /**
     * Determines the letter grade based on the score.
     * 
     * @param score the score to evaluate
     * @return the letter grade (A, B, C, D, or F)
     */
    public static char grade(double score)
    {
        if (score >= 90)
            return 'A';
        else if (score >= 80)
            return 'B';
        else if (score >= 70)
            return 'C';
        else if (score >= 60)
            return 'D';
        else
            return 'F';
    }
    /**
     * Sets up and displays the test scores, average, and grades on the graphics screen.
     * 
     * @param scr Draw object used for displaying the results
     * @param s1-s5 the individual test scores
     * @param avg the calculated average score
     */
    public static void displayResults(Draw scr, double s1, double s2, double s3, 
                                                double s4, double s5, double avg)
    {
        scr.setTitle("Test Average and Grades by VNguyen");
        scr.setXscale(0, 400);
        scr.setYscale(400, 0);
        scr.clear(Draw.LIGHT_GRAY);

        Font fnt = new Font("Serif", Font.PLAIN, 24);
        scr.setFont(fnt);

        // Display each score with corresponding grade
        scr.text(200, 50, "Test Scores and Grades");
        scr.text(200, 100, String.format("Score 1: %.2f%% - Grade: %c", s1, grade(s1)));
        scr.text(200, 130, String.format("Score 2: %.2f%% - Grade: %c", s2, grade(s2)));
        scr.text(200, 160, String.format("Score 3: %.2f%% - Grade: %c", s3, grade(s3)));
        scr.text(200, 190, String.format("Score 4: %.2f%% - Grade: %c", s4, grade(s4)));
        scr.text(200, 220, String.format("Score 5: %.2f%% - Grade: %c", s5, grade(s5)));
        
        // Display average score
        scr.text(200, 280, String.format("Average Score: %.2f%%", avg));
    }
    
    
    // ---------------------------- Graphics Challenge Below -------------------------------- // 
    
    
    /**
     * Graphics challenge - Olympic Rings Program. 
     * Main method to start the Olympics ring Drawing program.
     * Sets up the graphics screen, handles user input to draw rings, and
     * allows exiting the program.
     */
    public static void testOlympicsVNguyen()
    {   
        // Setup Grapphics screen
        Draw myScr = new Draw();
        myScr.setXscale(0, 400);
        myScr.setYscale(400, 0);

        // Light Gray Background
        myScr.setPenColor(Draw.LIGHT_GRAY);
        myScr.filledSquare(300, 300, 100);        

        int color; // colorNum is a number that is randomly picked when 
        // when the user hits the enter key

        int radius = 25; // radius for the ring 
        int x, y;          

        // Prints the title and Name/date
        x = 300; // x - coordinate for the main title
        y = 215; // y - coordinate for the main title
        title(myScr, x, y); 

        // boolean statement to check if user wants to continue
        boolean keepRunning = true;
        Scanner keyboard = new Scanner(System.in); 
        Random randomNum = new Random();

        // Loop so user must either hit enter or q to quit
        while (keepRunning) 
        {
            System.out.print("Press Enter to draw a ring or type 'q' quit: ");
            String input = keyboard.nextLine();

            // Convert input to lowercase for comparison
            if (input.toLowerCase().equals("q")) 
            {
                keepRunning = false;
                System.out.println("Exiting program.");
            } else {

                // Draws a random ring. Same ring can be picked
                color = randomNum.nextInt(5) + 1;
                switch (color) 
                {
                    case 1: myScr.setPenColor(Draw.BLUE);  // Draws blue ring 
                        x = 250;
                        y = 285;
                        ring(myScr, x, y, radius);
                        System.out.println("Blue ring is Drawn");      
                        break;
                    case 2: myScr.setPenColor(Draw.BLACK);   // Draws black ring
                        x = 305;
                        y = 285; 
                        ring(myScr, x, y, radius);
                        System.out.println("Black ring is Drawn");      
                        break;
                    case 3: myScr.setPenColor(Draw.RED); // Draws red ring
                        x = 360; 
                        y = 285;
                        ring(myScr, x, y, radius);
                        System.out.println("Red ring is Drawn");      
                        break;
                    case 4: myScr.setPenColor(Draw.GREEN);  // Draws green ring
                        x = 335;
                        y = 310;
                        ring(myScr, x, y, radius);
                        System.out.println("Green ring is Drawn");
                        break;
                    case 5: myScr.setPenColor(Draw.YELLOW);    // Draws yellow ring
                        x = 275;
                        y = 310;
                        ring(myScr, x, y, radius);
                        System.out.println("Yellow ring is Drawn");
                        break;
                }
            }
        }
        keyboard.close(); 
    }
    /**
     * Draws two lines: "Paris Olympics and "by VNguyen date"
     * in LARGE FONTS at the specified location
     * 
     *  @param myScr the Draw object used for rendering
     *  @param x the x - coordinate for the text
     *  @param y the y - coordinate for the main title text and the name below
     */
    public static void title(Draw myScr, double x, double y)
    {
        // Set the font color and font size
        myScr.setPenColor(86, 97, 99);
        Font titleFont = new Font("Serif", Font.BOLD, 20);
        myScr.setFont(titleFont);

        // Set main title
        myScr.text(x, y, "Paris Olympics");

        // Name and date titlezs
        y += 20; // adjust this value for spacing for line
        myScr.text(x, y, "By VNguyen 10/27/24");
    }
    /**
     * Draws ONE ring with current color. at the specified coordinates
     * 
     * @param myScr the Draw object used for rendering
     * @param x the x - coordinate for the center of the ring
     * @param y the y - coordinate for the center of the ring
     * @param radius the radius othe ring being drawn
     */
    public static void ring(Draw myScr, double x, double y, double radius)
    {
        myScr.setPenRadius(0.015); // circle radius 
        myScr.circle(x, y, radius);       // Draws the circle
    }
}
