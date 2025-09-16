import java.util.Random;
/**
 * Write a description of class mousePositionVNguyen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class mousePositionVNguyen
{
    public static void mousePositionVNguyen()
    {
        Draw scr = new Draw();
        scr.setXscale(0, 400);
        scr.setYscale(400, 0);
        scr.setTitle("mousePosition() by VNguyen");

        double x, y;

        // for(int count = 0; count < 200; count++)
        // {
        // scr.pause(500);
        // x = scr.mouseX();
        // y = scr.mouseY();

        // // Replace 
        // System.out.println(count + ": " + x + " , " + y);
        // }

        int count = 0;
        boolean keepRunning = true;
        while(keepRunning)
        {
            scr.pause(500);
            x = scr.mouseX();
            y = scr.mouseY();

            // ref 3.10: Display formatted out
            // System.out.println(count + ": " + x + " , " + y);
            System.out.printf("%d %.1f %.0f %n", count, x, y);
            count++;
            
            // stops the loops when mouse is at the top right 
            // of the program
            if(x > 390 && y <= 2)
            {
                keepRunning = false;
            }
        }
    }
    
    public static void mousePosition3VNguyen()
    {
        Draw scr = new Draw();
        scr.setXscale(0, 400);
        scr.setYscale(400, 0);
        scr.setTitle("mousePosition3() by VNguyen");
        scr.clear(Draw.LIGHT_GRAY);

        double x, y;
        
        int count = 0;
        boolean keepRunning = true;
        while(keepRunning)
        {
            scr.pause(500);
            x = scr.mouseX();
            y = scr.mouseY();

            // ref 3.10: Display formatted out
            // System.out.println(count + ": " + x + " , " + y);
            System.out.printf("%d %.1f %.0f %n", count, x, y);
            count++;
            
            // Using a switch and random generator to pick 1 of 4 colors
            Random ran = new Random();
            int n = 2 * ran.nextInt(4); // random number between 1 and 4
            switch (n)
            {
                case 0: scr.setPenColor(Draw.YELLOW);
                        break;
                case 2: scr.setPenColor(Draw.PINK);
                        break;
                case 4: scr.setPenColor(Draw.WHITE);
                        break;
                case 6: scr.setPenColor(123, 123, 123);
                        break;
                default:scr.setPenColor(Draw.RED);
            }
            
            // a number between 1 - 9
            // Switch case generates a number
            n = ran.nextInt(9) + 1;
            switch(n)
            {
                case 1,4,7: scr.rectangle(x + 12.3, y, 12.3, 12.3);
                            break;
                case 2,5,8: scr.circle(x - 12.3, y, 12.3);
                            break;
                case 3,6,9: scr.ellipse(x + 4.2, y +3, 12.3, 3);
            }
            
            // Cursor top right exits the program
            if(x > 390 && y < 5)
            {
                keepRunning = false;
            }
        }
    }
}
