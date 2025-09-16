import java.awt.Font;

/**
 * Description 
 * ____________
 * ____________
 * @author Vincent Nguyen
 * @version 11/12/24
 */
public class MouseDemoVNguyen
{
    //Experiment: 1-does it always draw when you click the mouse?
    //2-write method mouseClick2() that correct the code so it is 
    //  more "responsive" when clicked. Add comments to explain.
    //3-rewrite mouseClick2( ) using a do while loop to stop 
    //  when top right corner is clicked
    public static void mouseClick1()
    {
        Draw scrn = new Draw( );
        setup( scrn );
        scrn.setPenColor(Draw.YELLOW);
        for(int i=0; i<=123; i++)
        {
            scrn.pause(1234);
            if( scrn.isMousePressed() )
            {
                double x = scrn.mouseX();
                double y = scrn.mouseY();
                String msg = "YName at "+ x + ", " + y;
                System.out.println( msg );
                scrn.setTitle(msg);
                scrn.text(x,y,msg);
                scrn.ellipse(x,y,75,20);
            }
        }
    }

    public static void setup(Draw mouseClick)
    {
        mouseClick.setXscale(0,400);
        mouseClick.setYscale(400,0);
        mouseClick.clear(Draw.BLACK);
    }

    public static void mouseClickBetter()
    {
        Draw scrn = new Draw( );
        setup(scrn);
        scrn.setPenColor(Draw.GREEN);
        for(int i = 0; i <= 123; i++)
        {
            scrn.pause(100); // one tenth of a second
            if(scrn.isMousePressed() )
            {
                double x = scrn.mouseX();
                double y = scrn.mouseY();
                String msg = String.format("%.2f. ", x);
                msg = "VNguyen at " + msg + String.format("%.1f. ", y);
                System.out.println(msg);
                scrn.setTitle(msg);
                scrn.text(x,y,msg);
                scrn.ellipse(x,y,75,20);
            }
        }
    }
    
    // We will improve the above by using a do while loop
    public static void mouseClickMoreBetter()
    {
        Draw scrn = new Draw( );
        setup(scrn);
        scrn.setPenColor(Draw.MAGENTA);
        double x, y;
        x = -123;
        y = 123;
        do 
        {
            scrn.pause(50); // one tenth of a second
            if(scrn.isMousePressed() )
            {
                x = scrn.mouseX();
                y = scrn.mouseY();
                String msg = String.format("%.2f. ", x);
                msg = "VNguyen at " + msg + String.format("%.1f. ", y);
                System.out.println(msg);
                scrn.setTitle(msg);
                scrn.text(x,y,msg);
                scrn.ellipse(x,y,75,20);
            }
        } while(x < 390 && y > 10); // top right corner
        String msg1 = "Program Finished"; 
        Font fnt = new Font("Stencil", Font.BOLD, 40);
        scrn.setFont(fnt);
        scrn.text(200, 200, msg1); // prints message in the middle 
                                   // of the screen.
    }
    
    /**
     * demoClockAndMouse
     * This method takes the method above and uses mouse clicks 
     * to advance the clock 15 minutes.
     */
    public static void demoClockAndMouse()
    {
        // Instantiate objects to test the method
        ClockVN newYork = new ClockVN();
        ClockVN irvine = new ClockVN();
        
        // Demo code should call methods for the objects
        // In this case set newYork 11:50 am
        newYork.setHour(11);
        newYork.setMinute(50);
        newYork.setAmPm("am");
        // ClockVN.setMinute(50); // this is incorrect
        
        // Demo code now calls method for the second object
        // When you write objects for testing chapter 6,
        // always create two objects e.g moms bank info, sis info
        irvine.setHour(8);
        irvine.setMinute(50);
        irvine.setAmPm("am");
        
        Draw scrn = new Draw( );
        setup(scrn);
        scrn.setPenColor(Draw.MAGENTA);
        double x, y;
        x = -123;
        y = 123;
        do 
        {
            scrn.pause(50); // one tenth of a second
            // we clear everything under if statement to put advanceTime
            if(scrn.isMousePressed() )
            {
                x = scrn.mouseX();
                y = scrn.mouseY();
                // Advance 
                String msg = "Advance Clock 15 minutes";
            }
        } while(x < 390 && y > 10); // top right corner
        String msg1 = "Program Finished"; 
        Font fnt = new Font("Stencil", Font.BOLD, 40);
        scrn.setFont(fnt);
        scrn.text(200, 200, msg1); // prints message in the middle 
                                   // of the screen.
    }
}
