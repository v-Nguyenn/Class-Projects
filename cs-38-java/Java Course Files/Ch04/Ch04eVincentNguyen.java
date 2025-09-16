import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.awt.Font;

/**
 * Description 
 * ____________
 * ____________
 * @author Vincent Nguyen
 * @version 10/03/2024
 */
public class Ch04eVincentNguyen
{
    public static void main(String[] args)
    {

    }

    //New Topics: while loop 
    //Code Listing 4-3
    public static void whileLoop( )
    {
        int number = 1;

        while (number <= 5)
        {
            System.out.println("Hello");
            number++;
        }

        System.out.println("That's all!");

        //Graphics
        Draw   scr = new Draw( );
        Random rnd = new Random( );
        double x,y,width,height;
        number = 1;
        while (number <=15 )
        {
        x = rnd.nextDouble( ) * 123;
        y = rnd.nextDouble( ) * 123;
        width  = 0.050;
        height = 0.025;
        //QQQ draw solid Red rectangles
        //on left half of the screen and
        //Green not solid rectangles on right half
        scr.rectangle(x,y,width,height);

        scr.pause(1000);
        number++;
        }
        
    }

    //Code Listing 4-4
    public static void checkTemperature( )
    {
        final double MAX_TEMP = 102.5;  // Maximum temperature
        double temperature;             // To hold the temperature

        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);

        // Get the current temperature.
        System.out.print("Enter the substance's Celsius temperature: ");
        temperature = keyboard.nextDouble();

        // As long as necessary, instruct the technician
        // to adjust the temperature.
        while (temperature > MAX_TEMP)
        {
            String msg = new String("The temperature is too high. Turn the\n");
            msg += new String("thermostat down and wait 5 minutes.\n");
            msg += "Then, take the Celsius temperature again\n"
            + "and enter it here: ";

            System.out.print(msg);
            temperature = keyboard.nextDouble();
        }

        // Remind the technician to check the temperature
        // again in 15 minutes.
        System.out.println("The temperature is acceptable.");
        System.out.println("Check it again in 15 minutes.");
    }

    //New Topics: rgb colors, validation loop, 
    //set screen location
    public static void colorBalls1()   
    {
        Random ran = new Random( );
        Scanner keyboard = new Scanner(System.in);
        int red, grn, blu, x, y, wd=40, ht=40;

        //validation loop
        int count = -1;
        while( count<0 || count>=99 ) 
        {
            System.out.print("Enter an integer 0-100: ");
            count = keyboard.nextInt();
        }

        //now count is good and we can use it
        Draw rgb = new Draw( );
        //rgb.setLocationOnScreen(50,60);
        rgb.setXscale(0,400);
        rgb.setYscale(400,0);
        rgb.setTitle("RGB demo by YName");
        rgb.clear(Draw.BLACK);
        rgb.setPenColor(Draw.WHITE);
        Font fnt = new Font("Arial",Font.BOLD,32);
        rgb.setFont( fnt );        
        while( count>0 )
        {
            //Set a dark background
            rgb.clear(Draw.BLACK);

            //Set red, grn, blu to random integer 0-255            
            red = 123;
            grn = 123;
            blu = 123;
            String msg = "red="+red+", grn="+grn+", blu="+blu;
            rgb.setPenColor(red,grn,blu);
            //Draw a circle in the middle    
            rgb.filledCircle(123,123,12.3);

            //Display a message rotated 90 deg
            rgb.setPenColor(Draw.WHITE);
            rgb.text(50,200,msg,90);

            //String word = keyboard.nextLine( );
            rgb.pause(1000);
            count--;
        }
    }

    //New Topics: rgb colors, validation loop, 
    //set screen location, polygon
    public static void colorTies1()
    {
        Random ran = new Random( );
        Scanner keyboard = new Scanner(System.in);
        int red, grn, blu; 

        //New material for drawing polygons
        double x[] = {200, 250, 200, 150};
        double y[] = {0,   300, 400, 300};
        //validation loop
        int count = -1;
        while( count<0 || count>=99 ) 
        {
            System.out.print("Enter an integer 0-100: ");
            count = keyboard.nextInt();
        }

        //now count is good and we can use it
        //Graphics part

        Draw tie = new Draw( );
        //rgb.setLocationOnScreen(50,60);
        tie.clear(Draw.BLACK);
        tie.setTitle("Color ties by YName");
        tie.setXscale(0,400);
        tie.setYscale(400,0);

        Font fnt = new Font("Algerian",Font.PLAIN,24);
        tie.setFont( fnt );        
        while( count>0 )
        {
            //make a dark background
            tie.clear(Draw.BLACK);

            //select random colors
            red = 123;
            grn = 123;
            blu = 123;
            tie.setPenColor(red,grn,blu);

            //draw the polygon
            tie.filledPolygon(x,y);

            //display the red, green, blue values rotated 90 degs
            tie.setPenColor(Draw.WHITE); 
            tie.text(50,200,"red="+red+", grn="+grn+", blu="+blu);

            //String word = keyboard.nextLine( );
            tie.pause(1000);
            count--;
        }
    }

    //Copy nervousEyes method here and add a nose

    public static void simpleForLoop()
    {
        Random rand = new Random( );
        Scanner keyboard = new Scanner(System.in);
        int myDice, yourDice;
        int wins=0, loss=0, ties=0;
        System.out.print("How many plays, ex 100: ");
        int count = keyboard.nextInt( );
        for(int i = 1; i <= count; i++)
        {
            myDice = rand.nextInt((6) + 1); // only one to 6
            yourDice = rand.nextInt((6) + 1);
            if(myDice > yourDice) //count number of wins, loss, ties
            {
                wins++;
            }
            else if (yourDice > myDice)
            {
                loss++;
            }
            else
            {
                ties++;
            }
        }
        System.out.print("Wins: " + wins);
        System.out.print("\nLosses: " + loss);
        System.out.print("\nTies: " + ties + "\n");
    }

    public static void simpleWhileLoop()
    {
        Random rand = new Random( );
        Scanner keyboard = new Scanner(System.in);
        int myDice, yourDice;
        int wins=0, loss=0, ties=0;
        System.out.print("How many plays, ex 100: ");
        int count = keyboard.nextInt( );
        int i=1;
        while( i<=count )
        {
            myDice = rand.nextInt((6) + 1);
            yourDice = rand.nextInt((6) + 1);
            if(myDice < yourDice) //count number of wins, loss, ties
            {
                loss++;
            }
            else if(yourDice < myDice)
            {
                wins++;
            }
            else
            {
                ties++;
            }
            i++;
        }
        System.out.print("Wins: " + wins + "\n");
        System.out.print("Losses: " + loss + "\n");
        System.out.print("Ties: " + ties + "\n");
        
    }

    public static void simpleDoWhileLoop()
    {
        Random rand = new Random( );
        Scanner keyboard = new Scanner(System.in);
        int myDice, yourDice;
        int wins=0, loss=0, ties=0;
        System.out.print("How many plays, ex 100: ");
        int count = keyboard.nextInt( );
        int i=1;
        do
        {
            myDice = rand.nextInt((6) + 1);
            yourDice = rand.nextInt((6) + 1);
            if( 123==123 ) //count number of wins, loss, ties
            {
                
            }
            i++;
        } while( 123!=123 );
    }

    //Ref Code Listing 4-18, pg _____
    public static void readFirstLine( ) throws IOException
    {
        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);

        // Get the file name.
        System.out.print("Enter the name of a file: ");
        String filename = keyboard.nextLine();

        // Open the file.
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);

        // Read the first line from the file.
        String line = inputFile.nextLine();

        // Display the line.
        System.out.println("The first line in the file is:");
        System.out.println(line);

        // Close the file.
        inputFile.close();
    }

    //Ref Code Listing 4-18, pg _____
    public static void readFirstLines( ) throws IOException
    {
        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);

        // Get the file name.
        System.out.print("Enter the name of a file: ");
        String filename = keyboard.nextLine();

        // Open the file.
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);

        // Read the first line from the file.
        String line = inputFile.nextLine();

        // Display the line.
        System.out.println("The first line in the file is:");
        System.out.println(line);

        // Close the file.
        inputFile.close();
    }

    //Ref Code Listing 4-19, pg _____
    public static void fileReadDemo( ) throws IOException
    {
        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);

        // Get the filename.
        System.out.print("Enter the filename: ");
        String filename = keyboard.nextLine();

        // Open the file.
        Scanner inputFile = new Scanner(new File(filename));

        // Read lines from the file until no more are left.
        int lineNumber = 123;
        while (inputFile.hasNext())
        {
            // Read the next name.
            String friendName = inputFile.nextLine();

            // Display the last name read.
            System.out.println(friendName);
        }

        // Close the file.
        inputFile.close();
    }

    public static void method3( )
    {

    }
}
