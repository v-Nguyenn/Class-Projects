import java.awt.Font;

/**
 * Description 
 * ____________
 * ____________
 * @author _____
 * @version _____
 */
public class MouseDemo2_VNguyen
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
                String msg = "YName at "+x +", "+y;
                System.out.println( msg );
                scrn.setTitle(msg);
                scrn.text(x,y,msg);
                scrn.ellipse(x,y,75,20);
            }
        }
    }

    public static void mouseClickBetter()
    {
        Draw scrn = new Draw( );
        setup( scrn );
        scrn.setPenColor(Draw.YELLOW);
        for(int i=0; i<=123; i++)
        {
            scrn.pause(100);   //one tenth of a second
            if( scrn.isMousePressed() )
            {
                double x = scrn.mouseX();
                double y = scrn.mouseY();
                String msg = String.format("%.0f, ",x);
                msg = "SJang at " + msg + String.format("%.1f", y);
                System.out.println( msg );
                scrn.setTitle(msg);
                scrn.text(x,y,msg);
                scrn.ellipse(x,y,75,20);
            }
        }
    }

    //We will improve the above by using a do while loop
    public static void mouseClickMoreBetter()
    {
        Draw scrn = new Draw( );
        setup( scrn );
        scrn.setPenColor(Draw.YELLOW);
        double x,y;
        x=-123;
        y=123;
        //for(int i=0; i<=123; i++)
        do
        {
            scrn.pause(100);   //one tenth of a second
            if( scrn.isMousePressed() )
            {
                x = scrn.mouseX();
                y = scrn.mouseY();
                String msg = String.format("%.0f, ",x);
                msg = "SJang at " + msg + String.format("%.1f", y);
                System.out.println( msg );
                scrn.setTitle(msg);
                scrn.text(x,y,msg);
                scrn.ellipse(x,y,75,20);
            }
        } while( x<390  &&  y>10  );
        scrn.clear(Draw.BLACK);
        String msg1 = "Program Finished";
        Font fnt = new Font("TimesRoman", Font.BOLD, 40);
        scrn.setFont( fnt );
        scrn.text(200,200, msg1);

    }

    /**
     * demoClockAndMouse
     * This method takes the method above and uses mouse clicks
     * to advance the clock 15 minutes.
     */
    public static void demoClockAndMouse()
    {
        //Demo code should instantiate objects to test
        ClockVN newYork = new ClockVN( );
        ClockVN irvine  = new ClockVN( );

        //Demo code should call methods for the objects 
        //In this case set newYork 11:50 am
        newYork.setHour( 11 );
        //ClockSJ.setHour( 11 ); //incorrect
        newYork.setMinute( 50 );
        newYork.setAmPm( "am" );

        //Demo code now calls methods for the second object
        //You do that

        Draw scrn = new Draw( );
        setup( scrn );
        scrn.setPenColor(Draw.YELLOW);
        scrn.setTitle("Mouse & Clocks by YName");
        double x,y;
        x=-123;
        y=123;
        //for(int i=0; i<=123; i++)
        do
        {
            scrn.pause(100);   //one tenth of a second
            if( scrn.isMousePressed() )
            {
                x = scrn.mouseX();
                y = scrn.mouseY();
                //Advance both clocks by 15 minutes
                newYork.advanceTime(15);
                irvine.advanceTime(15);
                String msg1 = "New York: "+newYork.getTime();
                String msg2 = "Irvine: "+irvine.getTime();
                //msg = "SJang at " + msg + String.format("%.1f", y);
                System.out.print( msg1 );
                scrn.text(x,y,msg1);

                System.out.println( msg2 );
                scrn.text(x,y+20,msg2);
                //scrn.ellipse(x,y,75,20);
            }
        } while( x<390  ||  y>10  );
        scrn.clear(Draw.BLACK);
        String msg1 = "Program Finished";
        Font fnt = new Font("TimesRoman", Font.BOLD, 40);
        scrn.setFont( fnt );
        scrn.text(200,200, msg1);

    }    

    /**
     * demoClock2AndMouse
     * This method takes the method above and uses mouse clicks
     * advance the clock 15 minutes
     * 1) if click in bottom left quadrant, advance 15 minutes.
     * 2) if click in bottom right quadrant, advance -15 minutes.
     * 3) if click in top left quadrant, advance 1 hour.
     * 4) if click in top right quadrant, advance -1 hour.
     */
    public static void demoClock2AndMouse()
    {
        //Demo code should instantiate objects to test
        ClockVN newYork = new ClockVN( );
        ClockVN irvine  = new ClockVN( );

        //Demo code should call methods for the objects 
        //In this case set newYork 11:50 am
        newYork.setHour(11);
        //ClockSJ.setHour( 11 ); //incorrect
        newYork.setMinute(50);
        newYork.setAmPm("am");

        //Demo code now calls methods for the second object
        //You do that

        Draw scrn = new Draw( );
        setup( scrn );
        scrn.setPenColor(Draw.YELLOW);
        scrn.setTitle("Mouse & Clocks by YName");
        double x,y;
        x= -123;
        y= 123;
        //for(int i=0; i<=123; i++)
        do
        {
            scrn.pause(100);   //one tenth of a second
            if( scrn.isMousePressed() )
            {
                x = scrn.mouseX();
                y = scrn.mouseY();

                //Check bottom left quadrant: +15 minutes
                if(x <= 200  && y >= 200)
                {
                    newYork.advanceTime(15);
                    irvine.advanceTime(15);
                }
                //Check bottom right quadrant: -15 minutes
                else if(x >= 200  && y >= 200)
                {
                    newYork.advanceTime(-15);
                    irvine.advanceTime(-15);
                }
                //Check top left quadrant: +60 minutes
                else if(x <= 200  && y <= 200)
                {
                    newYork.advanceTime(60);
                    irvine.advanceTime(60);
                }
                //Check top right quadrant: -60 minutes
                else if(x >= 200 && y <= 200 )
                {
                    newYork.advanceTime(-60);
                    irvine.advanceTime(-60);
                }

                //Advance both clocks by 15 minutes
                // newYork.advanceTime(15);
                // irvine.advanceTime(15);
                String msg1 = "New York: "+ newYork.getTime();
                String msg2 = "Irvine: "+ irvine.getTime();
                //msg = "VNguyen at " + msg + String.format("%.1f", y);
                
                scrn.clear(Draw.BLACK); // clear screen to see updated message.
                
                System.out.print(msg1); // prints to terminal
                // x, y here determines the place of the message
                x = 200; 
                y = 200;
                scrn.text(x, y, msg1);
                System.out.println(msg2);
                scrn.text(x, y + 20, msg2);
                //scrn.ellipse(x,y,75,20);
            }
        } while(x < 390  &&  y > 10);
        scrn.clear(Draw.BLACK);
        String msg1 = "Program Finished";
        Font fnt = new Font("TimesRoman", Font.BOLD, 40);
        scrn.setFont( fnt );
        scrn.text(200,200, msg1);

    }    

    /**
     * demoDiceAndMouse
     * Revise the methods above to simulate dice rows
     * takes the method above and uses mouse clicks
     * advance the clock 15 minutes
     * 1) if click in left half of screen, roll left dice.
     * 2) if click in right half of screen, roll right dice.
     * Use Math.abs( ) to check if mouse is near where you want
     */
    public static void demoDiceAndMouse()
    {
        //Demo code should instantiate objects to test
        DiceVN d1 = new DiceVN( );
        DiceVN d2 = new DiceVN( );

        //Demo code should call methods for the objects 
        d1.rollDice( );
        d2.rollDice( );

        //Demo code now calls methods for the second object
        Draw scrn = new Draw( );
        setup( scrn );
        scrn.setPenColor(Draw.YELLOW);
        scrn.setTitle("Mouse & Dice by YName");

        //Set x,y coordinates for two dice.
        double xLeft, yLeft, xRight, yRight;
        xLeft  = 100; yLeft  = 200;
        xRight = 300; yRight = 200;

        //Use large fonts
        //123
        

        double x,y;
        x=-123;
        y=123;
        //for(int i=0; i<=123; i++)
        do
        {
            scrn.pause(100);   //one tenth of a second
            if( scrn.isMousePressed() )
            {
                x = scrn.mouseX();
                y = scrn.mouseY();

                
                
                if(x <= Math.abs(200))
                {
                    d1.rollDice( );
                }

                if(x >= Math.abs(200))
                {
                    d2.rollDice( );
                }

                String msg1 = "Left:  "+ d1.getFaceValue();
                String msg2 = "Right: "+ d2.getFaceValue();
                //msg = "VNguyen at " + msg + String.format("%.1f", y);
                System.out.print( msg1 );
                scrn.clear(Draw.BLACK);
                x = 100;
                y = 200;
                scrn.text(x,y,msg1);

                System.out.println( msg2 );
                scrn.text(x + 200, y, msg2);
                //scrn.ellipse(x,y,75,20);
            }
        } while(x < 390  ||  y > 10  );
        scrn.clear(Draw.BLACK);
        String msg1 = "Program Finished";
        
        
        scrn.text(x,y, msg1);
    }    

    public static void setup(Draw mouseClick)
    {
        mouseClick.setXscale(0,400);
        mouseClick.setYscale(400,0);
        mouseClick.clear(Draw.BLACK);
    }
}
