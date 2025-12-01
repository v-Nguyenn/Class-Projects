import java.util.Scanner;
import java.util.Random;
import java.awt.Font;
import java.util.*;

/**
 * Description 
 * ____________
 *
 * ____________
 * @author Vincent Nguyen
 * @version 09/24/24
 */
public class Ch04cVincentNguyen
{
    public static void main(String[] args)
    {

    }

    //ref pg159 Code Listing 3-13
    // switch case is a "nice" way to organize if-else type
    // problems. Int, string, but Can't use logical operators 
    // can't use compare doubles
    public static void switchDemo()
    {
        int number;       // A number entered by the user

        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);

        // Get one of the numbers 1, 2, or 3 from the user.
        System.out.print("Enter 1, 2, or 3: ");
        number = keyboard.nextInt();

        // Determine the number entered.
        switch (number)
        {
            case 1:
                System.out.println("You entered 1.");
                break;
            case 2:
                System.out.println("You entered 2.");
                break;
            case 3:
                System.out.println("You entered 3.");
                break;
            default: // anything else
                System.out.println("That's not 1, 2, or 3!");
        }

    }

    //ref pg162 Code Listing 3-15
    public static void petFood( )
    {
        String input;     // To hold the user's input
        char foodGrade;   // Grade of pet food

        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);

        // Prompt the user for a grade of pet food.
        System.out.println("Our pet food is available in " +
            "three grades:");
        System.out.print("A, B, and C. Which do you want " +
            "pricing for? ");
        input = keyboard.nextLine();
        foodGrade = input.charAt(0);

        // Display pricing for the selected grade.
        switch(foodGrade)
        {
            case 'a', 'A': //ref: pg164 Multi Value case is same as case 'a', 'A':
                System.out.println("30 cents per lb.");
                break;
            case 'b', 'B':
                System.out.println("20 cents per lb.");
                break;
            case 'c', 'C':
                System.out.println("15 cents per lb.");
                break;
            default:
                System.out.println("Invalid choice.");
        }

    }

    //ref pg222 Code Listing 4-7
    public static void squares( )
    {
        int number; // Loop control variable

        System.out.println("Number   Number Squared");
        System.out.println("-----------------------");

        for (number = 1; number <= 10; number++)
        {
            System.out.println(number + "\t\t" +
                number * number);
        }

        // Graphics 
        Draw table = new Draw();
        table.clear(Draw.LIGHT_GRAY);
        table.setXscale(0,400);
        table.setYscale(400,0);
        double x0=200;
        var    y0=30;  //ref pg101 sect 2.15 Reading Keyboard Input
        var    y=y0;  //Explain var determines the variable type by looking 
        // at what value is assigned 
        table.text(x0,y0,"Number    Number Squared");
        //QQQ replace with command to draw a line

        for (number = 1; number <= 10; number++)
        {
            y+=20; //QQQ please correct. Ref pg 68 Combined Assignment Operators
            // if(number<=3)
                // table.setPenColor(Draw.BLACK);
            // else if (number<=6)
                // table.setPenColor(Draw.BLUE);
            // else if (number<=9)
                // table.setPenColor(Draw.RED);
            // else 
                // table.setPenColor(Draw.BLUE);
            switch(number)
            {
                case 1: 
                case 2: 
                case 3:
                    table.setPenColor(Draw.BLACK);
                    break;
                case 4: 
                case 5: 
                case 6:
                    table.setPenColor(Draw.BLUE);
                    break;
                case 7:
                case 8:
                case 9:
                    table.setPenColor(Draw.RED);
                    break;
                default:
                    table.setPenColor(Draw.BLUE);
            }
            table.textLeft(x0-75, y, (number + "     " + number * number));
            //QQQ New command. Write a description of how this works
            //table.textLeft(x0, y, (number + "     " + number * number));
        }
        table.setTitle("Table of Squares by YourName");

    }

    
    //ref pg225 Code Listing 4-8
    public static void userSquares( )
    {
        int number;    // Loop control variable
        int maxValue;  // Maximum value to display

        System.out.println("I will display a table of " +
            "numbers and their squares.");

        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);

        // Get the maximum value to display.
        System.out.print("How high should I go? ");
        maxValue = keyboard.nextInt();

        // Display the table.
        System.out.println("Number   Number Squared");
        System.out.println("-----------------------");
        for (number = 1; number <= maxValue; number++)
        {
            System.out.println(number + "\t\t" + 
                number * number);
        }
    }

    //ref pg227 Code Listing 4-9
    public static void speedConverter( )
    {
        // Constants
        final int STARTING_KPH = 60; // Starting speed
        final int MAX_KPH = 130;     // Maximum speed
        final int INCREMENT = 10;    // Speed increment

        // Variables
        int kph;       // To hold the speed in kph
        double mph;    // To hold the speed in mph

        // Display the table headings.
        System.out.println("KPH\t\tMPH");
        System.out.println("-------------------");

        // Display the speeds.
        for (kph = STARTING_KPH; kph <= MAX_KPH; kph += INCREMENT)
        {
            // Calculate the mph.
            mph = kph * 0.6214;

            // Display the speeds in kph and mph. ref section 3.10 Formatted Output
            System.out.printf("%d           %.2f\n", kph, mph);
            //System.out.println(kph+"         "+mph);
        }
    }
    //Generate a random 2 digit number both graphics and terminal
    public static void randomNumber()
    {
        Random rand = new Random();
        Draw   screen = new Draw();
        screen.setXscale(0,400);
        screen.setYscale(400,0);
        //Font fnt = new Font( );

        //screen.setFont( fnt );
        String message = "";
        for(int count=0; count<10; count++)
        {
            int num = 123; //random integer 10-99
            System.out.print(num+" ");
            message += num+" ";
            screen.clear(Draw.ORANGE);
            screen.textLeft(20,75,"Random numbers by YName");
            screen.textLeft(20,100,message);
            //123 wait for 1 second
        }
    }

    public static void spookyEyes()
    {
        Draw    quad         = new Draw();
        Random  randomNumber = new Random();
        Scanner keyboard     = new Scanner(System.in);
        var num = -1;  //is same as int num = -1;
        double x0,y0;
        var width=5;
        var height=15;
        quad.clear(Draw.DARK_GRAY);
        quad.setXscale(0,400);
        quad.setYscale(400,0);
        quad.setPenColor(Draw.WHITE);
        //get a number from the user
        while( num<0 ) //ref sect 4.3: input validation
        {
            System.out.print("Enter a positive number, ex 100: ");
            num = keyboard.nextInt( );
            if( num<0 )
                System.out.println("Error, please try again");
        }

        //Each quadrant has different color eyeballs
        for(int count=1; count<=num; count++)
        {
            x0 = randomNumber.nextInt(280);
            y0 = randomNumber.nextDouble() * 400;
            if(x0 <= 200 && y0 <= 200)
                quad.setPenColor(Draw.YELLOW); // Top Left 
            else if(x0 > 200 && y0 <= 200)
                quad.setPenColor(Draw.CYAN); // Top Right 
            else if(x0 <= 200 && y0 > 200)
                quad.setPenColor(Draw.GREEN); // Bottom Left
            else
                quad.setPenColor(Draw.PINK); // Bottom Right 

            //Draw pair of eyeballs. How do we keep the eyes inside the screen
            quad.filledCircle(x0,y0,  width);
            quad.filledCircle(x0+90,y0,  width);
            quad.setPenColor(Draw.BLACK);

            //draw both pupils
            quad.filledCircle(x0,y0, width / 2 );
            quad.filledCircle(x0+90, y0,width / 2 );
            //123 make it wait 1/4 sec
            try{
                Thread.sleep(250);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void purpleRain()
    {
        Draw    quad         = new Draw();
        Random  randomNumber = new Random();
        Scanner keyboard     = new Scanner(System.in);
        var num = -1;
        double x0,y0,x1,y1;
        quad.clear(Draw.LIGHT_GRAY);
        quad.setXscale(0,400);
        quad.setYscale(400,0);
        quad.setPenColor(Draw.BLUE);
        //get a number from the user
        while( num<0 ) //this is called input validation
        {
            System.out.print("Enter a positive number, ex 100: ");
            num = keyboard.nextInt( );
            if( num<0 )
                System.out.println("Error, please try again");
        }

        //
        for(int count=1; count<=num; count++)
        {
            x0 = randomNumber.nextInt(400);
            y0 = randomNumber.nextDouble() * 400;
            x1 = x0+12.3;
            y1 = y0+12.3;

            
            
            
            
            quad.rectangle(x0,y0,  x1,y1);                
        }

    }
    //Ref similar to Code Listing 4-12 Clock.java
    public static void clock()
    {
        Draw scr = new Draw( );
        scr.setXscale(0,400);
        scr.setYscale(400,0);
        scr.clear(Draw.DARK_GRAY); //qqq use a different color
        //scr.setPenColor(Draw.WHITE);
        Font fnt = new Font("Segoe Script", Font.PLAIN, 64);
        scr.setFont( fnt );
        String msg = "";
        boolean am = true;
        int hrs=0;
        for(int hours=1; hours<=48; hours++)
        {
            for(int minutes=0; minutes<=59; minutes++)
            {
                // 

                // 
                // 

                // 
                // 
                // 

                // 
                // 
                // 

                // 
                // 
                // 

                // 

                // 
                // 
                // 
                // 
                //
                //
                //

                
                //
            }
        }
    }
    //Modified from Code Listing 4-26 MathTutor.java
    //1-Changed from addition to multiplication
    //2-Changed from one time run to a loop 
    public static void mathTutor2()
    {
        int number1;      // A number
        int number2;      // Another number
        int product;      // The sum of the numbers
        int userAnswer;   // The user's answer

        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);

        // Create a Random class object.
        Random randomNumbers = new Random();

        for(int count=1; count<=10; count++)
        {
            // Get two random numbers.
            number1 = randomNumbers.nextInt(100);
            number2 = randomNumbers.nextInt(100);

            // Display an addition problem.
            System.out.println("What is the answer to the " +
                "following problem or -123 to quit?");
            System.out.print(number1 + " x " +
                number2 + " = ? ");

            // Calculate the answer.
            product = number1 * number2;

            // Get the user's answer.
            userAnswer = keyboard.nextInt();

            // Display the user's results.
            if(userAnswer == -123)
            {
                count=1000;    
            }
            else
            {
                if (userAnswer == product)
                    System.out.println("Correct!");
                // else
                // {
                // System.out.println("Sorry, wrong answer. " +
                // "The correct answer is " +
                // product);
                // }
                else if(userAnswer > product)
                {
                    System.out.println("Too high by "+(userAnswer-product) );
                }
                else 
                {
                    System.out.println("Too low by "+(product-userAnswer) );
                }
            }
        }
    }

}
