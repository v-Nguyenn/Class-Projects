
/**
 * BasicArithmeticAndGraphics - Page 106 Exercises
 * 
 * The program does Basic variable declaration, arithmetic operations, and outputs to graphics screens
 * Topics: Integer arithmetic, print statements, Draw library basics
 *
 * @author Vincent Nguyen
 * @date Originally written: September 1, 2024
 * @date Updated: December 1, 2025
 */
public class BasicArithmetic
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
        System.out.println("part a: " + result);
        
        // Call the other methods
        partB();
        partCwGraphics();
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
        System.out.println("part c: " + result);
        
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
