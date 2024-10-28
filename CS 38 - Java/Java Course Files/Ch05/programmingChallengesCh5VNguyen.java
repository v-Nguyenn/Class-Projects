import java.util.Scanner;
import java.util.Random;
import java.awt.Font;
/**
 * Write a description of class programmingChallengesCh5 here.
 * 
 * Programming Challenge #1
 * showChar Method accepts two arguments, a reference to a String
 * object and an integer. the integer arugment is a character 
 * position within the String, with the first character at index
 * 0. When the method executes, it should display the character at
 * that position.
 * 
 * Programming Challenge #3
 * Asks the user for width and length of a rectangle, and then 
 * display the rectangle's area. The program calls the following
 * methods getLength, getWidth, getArea, displayData
 * 
 * Programming Challenge #5
 * This takes a method name fallingDistance and accepts an object's 
 * falling time (in seconds) as an argument. The method returns the 
 * distance, in meter, that the object has fallen during that time 
 * interval.
 * 
 * biteCookieVNguyen
 * This draws a cookie to the bottom right of the screen and takes
 * a "bite" out when the enter key is pressed.
 *
 * @author (Vincent Nguyen)
 * @version (10/20/24)
 */

public class programmingChallengesCh5VNguyen
{   
    // This is so other methods can use Scanner without being 
    // declared 
    private static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args)
    {
        showChar("New York", 2); // Challenge #1
        areaRectangle();         // Challenge #3
                                 // Challenge #5
        for(int seconds = 1; seconds <= 10; seconds++)
        {
            double distance = fallingDistance(seconds);
            System.out.printf("Falling Time: %d seconds," +
                              "Falling distance: %.2f meters.%n",seconds, distance);
        }
    }
    /**,
     * Programming Challenge #1
     * showChar Method. Accepts a string and integer with the
     * integer as a character position of string inputted.
     * Displays the character at the integer entered.
     */
    public static void showChar(String input, int num)
    {
        System.out.println("Programming Challenge #1");
        char charPosition = input.charAt(num);
        System.out.println("Word: " + input);
        System.out.println("Character at index " + num + ": "
        + charPosition + "\n");
    }
    
    /**
     * Programming Challenge #3
     * Rectangle Area - Complete the Program
     * Takes user input from getLength(); method and getWidth()
     * method. Then the program calculates the area in the 
     * getArea() method and displayData() displays the results
     * in the terminal.
     */ 
    public static void areaRectangle( )
    {
        System.out.println("Programming Challenge #3");
        double length, // The rectangle's length
        width,         // The rectangle's width
        area;          // The rectangle's area
        
        // Get the rectangle's length from the user
        length = getLength();
        
        // Get the rectangle's width fromt he user
        width = getWidth();
        
        // Get the rectangle's width from the user.
        area = getArea(length, width);
        
        // Display the rectangle area.
        displayData(length, width, area);  
    }
    // Asks user for the length
    // returns double value
    public static double getLength(){
        System.out.print("Enter length of rectangle: ");
        return keyboard.nextDouble(); 
    }
    // Asks user for the width
    // returns double value
    public static double getWidth(){
        System.out.print("Enter Width of rectangle: ");
        return keyboard.nextDouble();
    }
    // Calculates the area
    // Takes in the values, length, width, and area
    // returns area
    public static double getArea(double length, double width){
        double area = length * width;
        return area;
    }
    //  Displays the data 
    // Takes in values of length, width, and area
    public static void displayData(double length, double width,
    double area)
    {
        System.out.println("Rectangle length: " + length);
        System.out.println("Rectangle width: " + width);
        System.out.println("Total rectangle area: " + area + "\n");
    }
    
    /**
     *  Programming Challenge #5
     *  Takes in the argument fallingTime 
     *  Calculates the falling distance and returns distance.
     */
    public static double fallingDistance(double fallingTime)
    {
        double GRAVITY = 9.8;
        double distance = (1.0/2.0) * (GRAVITY) * fallingTime 
                                                * fallingTime;
        return distance; // returns calculated distance
    }
    
    /**
     * biteCookieVNguyen
     * This program draws a cookie to the bottom right of the screen
     * Pressing Enter takes a bite from the cookie and entering q stops 
     * the program
     * 
     */
    public static void biteCookieVNguyen()
    {
        // Set up Graphics Screen
        Draw scr = new Draw();
        scr.clear(Draw.LIGHT_GRAY);
        scr.setXscale(0, 400);
        scr.setYscale(400, 0);
        scr.setTitle("Bite Chocolate Chip Cookie by Vincent Nguyen");
        
        // Light Blue backgroud
        scr.setPenColor(176, 196, 222);
        scr.filledRectangle(300, 300, 100, 100);
        
        // Name on Screen
        scr.setPenColor(Draw.BLACK);
        Font bigName = new Font("SansSerif", Font.ITALIC, 15);
        scr.setFont(bigName);
        scr.text(300, 210, "VincentNguyen 10/20/24");
        
        // Dark background of cookie
        scr.setPenColor(90, 35, 15);
        scr.filledCircle(300, 300, 75);
        
        // Light background of cookie
        scr.setPenColor(205, 133, 63);
        scr.filledCircle(298, 297, 73);
        
        //chips
        scr.setPenColor(90,35,15);
        scr.filledCircle(287,360,5);
        scr.filledCircle(350,283,5);  
        scr.filledCircle(337,290,5);
        scr.filledCircle(277,292,5);
        scr.filledCircle(267,290,5);
        scr.filledCircle(345,252,5);
        scr.filledCircle(282,271,5);
        scr.filledCircle(283,232,5);
        scr.filledCircle(293,333,5);
        scr.filledCircle(260,350,5);
        scr.filledCircle(345,342,5);
        
        boolean keepRunning = true;
        Scanner keyboard = new Scanner(System.in);
        Random random = new Random(); // Create a Random object

        while (keepRunning) {
            System.out.print("Press Enter to take a random bite or type 'q' to quit: ");
            String input = keyboard.nextLine();

            // Convert input to lowercase for comparison
            if (input.toLowerCase().equals("q")) {
                keepRunning = false;
                System.out.println("No more bites.");
            } else {
                // Generate random coordinates for the bite within the cookie
                int biteX = random.nextInt(151) + 225; // Random x: the range (225, 375)
                int biteY = random.nextInt(151) + 225; // Random y: the range (225, 375)

                // Check if the generated point is within the cookie's area
                if (biteX >= 225 && biteX <= 375 && biteY >= 225 && biteY <= 375) {
                    scr.setPenColor(176, 196, 222);     // Background color
                    scr.filledCircle(biteX, biteY, 20); // Size of the bite
                }
            }
        }
    }
}