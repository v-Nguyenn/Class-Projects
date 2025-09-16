
/**
 * Write a description of class Pg106_VincentN here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pg106_VincentN
{
   public static void main(String[] args)
    {
        int result, w, y;
        int x;
        int z;
        
        w = 5;
        x = 4;
        y = 8; z = 2;
        
        result = x + y;
        System.out.println("part a: "+result);
    }
    
    public static void partB()
    {
        // double slash is a comment. A note
        // We will calculate result = z * 2;
        int result, x, y, w, z;
        w = 5; x = 4; y = 8; z = 2;
        result = z * 2;
        System.out.println("part b: " + result);
        
    }
    
    public static void partCwGraphics()
    {
        int result, w, x, y, z;
        w = 5; x = 4; y = 8; z = 2;
        result = y / x;
        System.out.println("part c; " + result);
        
        //Now we will output to a graphics screen
        Draw scr = new Draw( );
        scr.clear(Draw.GREEN);
        scr.setXscale( 0, 400 );
        scr.setYscale( 400, 0 );
        String msg = "Part c:" + result; // converts to string
        scr.text(200, 40, msg);
        scr.text(320, 360, msg);
        scr.setPenColor(Draw.BLUE);
        String message = "Hi mom: " + result;
        scr.text(300, 50, message);
        scr.text(50, 400, message);
    }
}
