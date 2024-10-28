import java.util.Random;
import java.util.Scanner;
import java.awt.Font;
/**
 * Description 
 * ____________
 * 
 * ____________
 * @author Vincent Nguyen
 * @version 10/01/24
 */
public class Ch04dVincentNguyen
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
        scr.setXscale(0,400);
        scr.setYscale(400,0);
        scr.setTitle("while Loop by Vincent Nguyen");
        Random rnd = new Random( );
        double x,y,width,height;
        number = 1;
        while (number <=15 )
        {
        x = rnd.nextDouble( ) * 400; // range 0 to 400
        y = rnd.nextDouble( ) * 400; 
        //y = rnd.nextDouble ( ) * 410 + 10; // 10 - 410
        width  = 10;
        height = 30;
        //QQQ draw solid Red rectangles
        //on left half of the screen and
        //Green not solid rectangles on right half
        if(x <= 200) // Left Side 
        {
            scr.setPenColor(Draw.RED);
            scr.filledRectangle(x,y,width,height);
        }
        else         // Right side
        {
            scr.setPenColor(Draw.GREEN);
            scr.rectangle(x,y,width,height);
        }
        

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
        rgb.setTitle("RGB demo by Vincent Nguyen");
        rgb.clear(Draw.BLACK);
        rgb.setPenColor(Draw.WHITE);
        Font fnt = new Font("Arial",Font.BOLD,32);
        rgb.setFont( fnt );        
        while( count>0 )
        {
            //Set a dark background
            rgb.clear(Draw.BLACK);

            //Set red, grn, blu to random integer 0-255            
            red = 255;
            grn = 105;
            blu = 100;
            String msg = "red="+red+", grn="+grn+", blu="+blu;
            rgb.setPenColor(red,grn,blu);
            //Draw a circle in the middle    
            rgb.filledCircle(150, 200, 20);

            //Display a message rotated 90 deg
            rgb.setPenColor(Draw.WHITE);
            rgb.text(50,200,msg,90);

            //String word = keyboard.nextLine( );
            rgb.pause(1000);
            count--;
        }
    }
    
    public static void polygon()
    {
        Draw poly = new Draw();
        poly.setXscale(0,400);
        poly.setYscale(400,0);
        poly.setPenColor(210,106, 100);
        //new material
        double[] x = {200, 400, 200}; // this is an array
        double[] y = {  0, 200, 400};
        poly.filledPolygon(x,y);
    }
    
    public static void czechFlag()
    {
        Draw flag = new Draw();
        flag.setXscale(0,400);
        flag.setYscale(400,0);
        flag.setTitle("Czech Republic by Vincent Nguyen");
        flag.clear(Draw.LIGHT_GRAY);
        
        // Purple portion
        flag.setPenColor(160, 32, 240);
        double[] x = {0, 125, 0};
        double[] y = {200, 300, 400};
        flag.filledPolygon(x,y);
        
        // bottom portion of flag
        flag.setPenColor(Draw.RED);
        double[] xBot = {125, 250, 250, 125, 0  , 125};
        double[] yBot = {300, 300, 400, 400, 400, 300};
        flag.filledPolygon(xBot,yBot);
        
        // top portion of flag
        flag.setPenColor(Draw.WHITE);
        double[] xTop = {250, 0  , 125, 250, 250};
        double[] yTop = {200, 200, 300, 300, 200};
        flag.filledPolygon(xTop, yTop);
        
        Font name = new Font("Arial", Font.BOLD, 25);
        flag.setFont(name);
        flag.text(200, 100, "Czech Republic Flag by Vincent");
        
        
        
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
            red = 205;
            grn = 105;
            blu = 100;
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

}
