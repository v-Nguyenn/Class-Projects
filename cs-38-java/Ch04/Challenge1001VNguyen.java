import java.util.Scanner; // Scanner class
import java.awt.Font;
import java.io.*;         // To read Files
/**
 * Description 
 * ____________
 * Instructions are above each method so I put something brief. I also 
 * initially had all programs including the book here, but I was worried
 * about file size so I seperated them into another class
 * 4. reverseMe()
 *    reverses the function the user inputted
 *    
 * 5. startToEnd()
 *    reads input from a keyboard and uses a loop to read and 
 *    validate the range
 * 
 * 6. fileWriteStartToEnd()
 *    writes numbers to a file
 * 
 * 7. fileCstudents()
 *    reads the file studentsByVNguyen.txt and prints only the 
 *    students from a 2.00 gpa to a 2.99 gpa
 * ____________
 * @author Vincent Nguyen
 * @version 10/11/24
 */
public class Challenge1001VNguyen
{
    //Read a string from the keyboard and print the characters in 
    //reversed order on a black graphics screen. For example entering 
    //"Irvine Valley College" displays "egelloC yellaV enivrI" in large
    //fonts. Choose an RGB color, not one of the default colors that 
    //can contrast well on the black background. You must have your name 
    //on the title bar and somewhere else on the screen.
    public static void reverseMe( )
    {
        // Initialize variables
        String userInput  = "";
        String reversedString = "";
        Scanner keyboard = new Scanner(System.in);
        
        // ask for user input
        System.out.println();
        System.out.print("Enter a word you want backwards: ");
        userInput = keyboard.nextLine();

        // For loop to iterate from the end the string to the 
        // beginning. That means 0 has to be the last value so
        // until i is = to 0. i needs to be decremented because
        // we are starting at the end of the string
        for(int i = userInput.length() - 1; i >= 0; i--){
            reversedString += userInput.charAt(i);
        }
        // For terminal testing
        System.out.println(reversedString);
        
        // Initialize Graphics
        Draw scr  = new Draw();
        scr.setXscale(0, 400);
        scr.setYscale(400, 0);
        scr.clear(Draw.BLACK);
        scr.setTitle("Reverse Me by Vincent Nguyen");
        
        // Set name on Screen
        Font bigNameFont = new Font("Consolas", Font.BOLD, 50);
        Font displayFont = new Font("Serif", Font.PLAIN, 25);
        
        // Name on Screen
        scr.setFont(bigNameFont);
        scr.setPenColor(120, 154, 179);
        scr.text(200, 350, "neyugN tnecniV");
        
        // Display word user inputted
        scr.setFont(displayFont);
        scr.setPenColor(242, 131, 129);
        scr.text(200, 150, "Word: " + userInput);
        
        // Display word backwards
        scr.text(200, 200, "Word backwards: " + reversedString);

    }

    //Read a start integer from the keyboard between 10 and 30. 
    //Read an end  integer from the keyboard between 45 and 55. 
    //Use a while loop to validate numbers are in the correct range
    //as described in your textbook.
    //Print on the terminal and graphics screen all integers between
    //start and end. Use a new font you haven't used before.
    public static void startToEnd( )
    {
        int startInt = 0;
        int endInt = 0; 
        Scanner keyboard = new Scanner(System.in);
        
        // Get user input
        System.out.println("--------------------");
        System.out.print("Enter a starting integer between 10 and 30: ");
        startInt = keyboard.nextInt();
        System.out.println("--------------------");
        keyboard.nextLine(); // consume whitespace
        // Checks if in range, if not again and again...
        while(startInt > 30 || startInt < 10)
        {
            System.out.println("You are not in the range! ");
            startInt = keyboard.nextInt();
        }
        
        System.out.print("Enter a ending integer between 45 and 55: ");
        endInt = keyboard.nextInt();
        System.out.println("--------------------");
        while(endInt > 55 || endInt < 45)
        {
            System.out.println("You are not in the range! ");
            endInt = keyboard.nextInt();
        }
        
        // Initialize Graphics and set title
        Draw scr = new Draw();
        scr.clear(Draw.LIGHT_GRAY); // background
        scr.setXscale(0, 400);
        scr.setYscale(400, 0);
        scr.setTitle("Start to End by Vincent Nguyen");
        
        // Set up fonts for name and results
        Font bigName = new Font("Serif", Font.BOLD, 55);
        Font displayResults = new Font("Consolas", Font.PLAIN, 30);
        
        // Large name on graphics
        scr.setPenColor(233, 233, 248);
        scr.setFont(bigName);
        scr.text(200, 50, "Vincent Nguyen");
        
        // Initialize values to keep track of printing
        int x = 20; 
        int y = 200;
        int maxWidth = 380; 
        int incrementX = 40;
        int incrementY = 20;
        scr.setFont(displayResults);
        scr.setPenColor(248, 233, 248); // light magenta
        
        // Loop prints from the starting integer
        // to the ending integer and increments by 1
        for(int i = startInt; i <= endInt; i++)
        {
            //System.out.print(i + ", "); // Checks in terminal to work
            scr.text(x, y, "" + i);       // prints at a set x, y
            x += incrementX;              // increments by x to print
            
            // if integer goes past a certain point on screen
            // move to next line and at the initial x
            if(x > maxWidth) 
            {
                x = 20;          // start back at initial x
                y += incrementY; // increment down to go next line
            }
        }
        
        
    }   
    //Same as above but write the numbers into a file "startToEndYName.txt"
    public static void fileWriteStartToEnd() throws IOException
    {
        int startInt = 0;
        int endInt = 0; 
        Scanner keyboard = new Scanner(System.in);
        
        // Get user input
        System.out.print("Enter a starting integer between 10 and 30: ");
        startInt = keyboard.nextInt();
        keyboard.nextLine(); // consume whitespace
        // Checks if in range, if not again and again...
        while(startInt > 30 || startInt < 10)
        {
            System.out.println("You are not in the range! ");
            startInt = keyboard.nextInt();
        }
        
        System.out.print("Enter a ending integer between 45 and 55: ");
        endInt = keyboard.nextInt();
        System.out.println("--------------------");
        while(endInt > 55 || endInt < 45)
        {
            System.out.println("You are not in the range! ");
            endInt = keyboard.nextInt();
        }
        
        // Open file for writing
        PrintWriter myFile = new PrintWriter("startToEndVNguyen.txt");
        
        // initialize values to keep track of printing
        int maxWidth = 380;
        int incrementX = 40;
        int currentLineWidth = 0;
        
        // read file 
        for(int i = startInt; i <= endInt; i++)
        {
             myFile.print(i + "  ");
             currentLineWidth += incrementX;
             
             if(currentLineWidth > maxWidth)
             {
                 myFile.println(); // move to next line
                 currentLineWidth = 0; // reset the line to its initial value
             }
        }
        myFile.close();
    }
    
    //Read the file studentByYName.txt and print only the name and
    //GPA of students who between 2.00 and 2.99 gpa
    public static void fileCstudents() throws IOException
    {
        {
        Scanner inFile = new Scanner(new File("studentsByVincentNguyen.txt"));
        
        while(inFile.hasNext()) {
            String fileLine = inFile.nextLine();
            
            int startInt = fileLine.indexOf("GPA") + 4;
            int endInt = fileLine.indexOf(",", startInt);
            double gpa = Double.valueOf(fileLine.substring(startInt, endInt));
            
            if(gpa >= 2.00 && gpa <= 2.99)
                System.out.println(gpa + " " + fileLine.substring(fileLine.indexOf("Name:") + 6));
        }
        inFile.close();
    }
    }
}
