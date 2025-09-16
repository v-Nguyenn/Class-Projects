import java.util.Scanner;
//import java.awt.Color;
import java.awt.Font;
/**
 * Description
 * ______________________
 * ______________________
 * @author _____
 * @version ______
 */
public class BiteCookie_VNguyen
{
    public static void main(String[] args)
    {
    }

    //Original Student Code
    public static void bite()
    {
        Scanner keyboard = new Scanner(System.in);
        Draw scrn = new Draw();
        scrn.setTitle("Bite a Cookie By VNguyen");
        scrn.setXscale(0,400);
        scrn.setYscale(400,0);
        scrn.setPenColor(176, 195, 221);
        scrn.filledRectangle(200,200,200,200);
        scrn.setPenColor(Draw.BLACK);
        Font fnt = new Font("Arial", Font.BOLD, 14);
        scrn.setFont(fnt);
        scrn.text(100,216,"VNguyen 10/20/2024");
        scrn.rectangle(100,300,100,100);
        scrn.setPenColor(139,69,19);
        scrn.filledCircle(100,300,75);
        scrn.setPenColor(205,133,63);
        scrn.filledCircle(97,297,73);
        scrn.setPenColor(90,35,15);
        scrn.filledCircle(69,244,5);
        scrn.filledCircle(136,250,5);
        scrn.filledCircle(106,275,5);
        scrn.filledCircle(59,277,5);
        scrn.filledCircle(94,300,5);
        scrn.filledCircle(156,300,5);
        scrn.filledCircle(40,310,5);
        scrn.filledCircle(74,322,5);
        scrn.filledCircle(114,320,5);
        scrn.filledCircle(133,350,5);
        scrn.filledCircle(74,357,5);
        double x,y;
        boolean keepRunning = true;
        while(keepRunning)
        {
            System.out.print("Type 'b' <Enter> to bite OR 'q' <Enter> to quit.");
            String input = keyboard.nextLine();

            if (input.equals("b"))
            {           
                x = scrn.mouseX();
                y = scrn.mouseY();
                if(x <= 200 && y >=200)
                {
                    scrn.setPenColor(176, 195, 221);
                    scrn.filledCircle(x, y, 20);
                }
            }

            if(input.equals("q"))
            {
                keepRunning = false;
            }
        }
        System.out.println("Program finished.");
    }
    
    // We will revise and improve this code by putting the code into
    // smaller methods.
    
    public static void bite2()
    {
        Scanner keyboard = new Scanner(System.in);
        
        Draw scrn = new Draw();
        //Set xy, scale, background color
        setUpGraphics(scrn);
        
        // show the  title and date
        displayName(scrn);
        
        // show the cookie with chocolate chips
        displayCookie(scrn);

        double x,y;
        boolean keepRunning = true;
        while(keepRunning)
        {
            System.out.print("Type 'b' <Enter> to bite OR 'q' <Enter> to quit.");
            String input = keyboard.nextLine();

            if (input.equals("b"))
            {           
                x = scrn.mouseX();
                y = scrn.mouseY();
                if(x <= 200 && y >=200)
                {
                    scrn.setPenColor(176, 195, 221);
                    scrn.filledCircle(x, y, 20);
                }
            }

            if(input.equals("q"))
            {
                keepRunning = false;
            }
        }
        System.out.println("Program finished.");
    }
    
    public static void setUpGraphics(Draw scrn)
    {
        scrn.setTitle("Bite a Cookie By VNguyen");
        scrn.setXscale(0, 400);
        scrn.setYscale(400, 0); 
        // sets the background for the cookie
        scrn.setPenColor(176, 195, 221);
        scrn.filledRectangle(200,200,200,200);
    }
    
    public static void displayName(Draw scrn) //
    {
        scrn.setTitle("Bite a Cookie By YName");
        scrn.setXscale(0, 400);
        scrn.setYscale(400, 0); 
        // sets the background for the cookie
        scrn.setPenColor(176, 195, 221);
        scrn.filledRectangle(200,200,200,200);
    }
    
    public static void displayCookie(Draw scrn)
    {
         scrn.rectangle(100,300,100,100);
        scrn.setPenColor(139,69,19);
        scrn.filledCircle(100,300,75);
        scrn.setPenColor(205,133,63);
        scrn.filledCircle(97,297,73);

        scrn.setPenColor(90,35,15);
        scrn.filledCircle(69,244,5);
        scrn.filledCircle(136,250,5);
        scrn.filledCircle(106,275,5);
        scrn.filledCircle(59,277,5);
        scrn.filledCircle(94,300,5);
        scrn.filledCircle(156,300,5);
        scrn.filledCircle(40,310,5);
        scrn.filledCircle(74,322,5);
        scrn.filledCircle(114,320,5);
        scrn.filledCircle(133,350,5);
        scrn.filledCircle(74,357,5);
    }

    
    
    
    //Label & Comment Each Section for Possible Methods
    public static void biteMethods1()
    {
        Scanner keyboard = new Scanner(System.in);
        Draw scrn = new Draw();
        scrn.setTitle("Bite a Cookie By YName");
        scrn.setXscale(0,400);
        scrn.setYscale(400,0);
        scrn.setPenColor(176, 195, 221);
        scrn.filledRectangle(200,200,200,200);
        scrn.setPenColor(Draw.BLACK);
        Font fnt = new Font("Arial", Font.BOLD, 14);
        scrn.setFont(fnt);
        scrn.text(100,216,"YName 10/20/2024");
        scrn.rectangle(100,300,100,100);
        scrn.setPenColor(139,69,19);
        scrn.filledCircle(100,300,75);
        scrn.setPenColor(205,133,63);
        scrn.filledCircle(97,297,73);
        scrn.setPenColor(90,35,15);
        scrn.filledCircle(69,244,5);
        scrn.filledCircle(136,250,5);
        scrn.filledCircle(106,275,5);
        scrn.filledCircle(59,277,5);
        scrn.filledCircle(94,300,5);
        scrn.filledCircle(156,300,5);
        scrn.filledCircle(40,310,5);
        scrn.filledCircle(74,322,5);
        scrn.filledCircle(114,320,5);
        scrn.filledCircle(133,350,5);
        scrn.filledCircle(74,357,5);
        double x,y;
        boolean keepRunning = true;
        while(keepRunning)
        {
            System.out.print("Type 'b' <Enter> to bite OR 'q' <Enter> to quit.");
            String input = keyboard.nextLine();

            if (input.equals("b"))
            {           
                x = scrn.mouseX();
                y = scrn.mouseY();
                if(x <= 200 && y >=200)
                {
                    scrn.setPenColor(176, 195, 221);
                    scrn.filledCircle(x, y, 20);
                }
            }

            if(input.equals("q"))
            {
                keepRunning = false;
            }
        }
        System.out.println("Program finished.");
    }

    public static void setup(Draw scrn)
    {

    }

    public static void showTitle(Draw scrn)
    {

    }

}