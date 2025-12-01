
/**
 * CheckeredBoard - Fundamentals Homework
 * 
 * Creates a 400x400 checkered board pattern using black and white squares.
 * Bonus Program: Displays the French flag with a flag pole on a separate screen.
 * 
 * Learned: Draw library basics, coordinate systems, layering shapes, colors
 * Topics: filledSquare(), filledRectangle(), filledCircle(), setPenColor(), coordinate scaling
 *
 * @author Vincent Nguyen
 * @date Originally written: August 29, 2024
 * @date Updated: December 1, 2025
 */
public class CheckeredBoard
{
    public static void main (String[] args)
    {
        /**
         * Approach: Draw white screen, make two black squares bottom right and top left
         * Overlap top left half with two small white squares
         * Add two small black squares on the bottom left
         * 
         */
        // Set new screen 
        bonusProgram();
        Draw scr = new Draw();
        
        // Set the whole screen to white
        scr.clear(Draw.WHITE);
        
        // Set the parameters of the screen size
        scr.setXscale(0, 400); 
        scr.setYscale(400, 0);
        
        // Big Black Square top left
        scr.setPenColor(Draw.BLACK);
        scr.filledSquare(325, 325, 125);
        
        // Big Black Square middle
        scr.filledSquare(100, 100, 100);
        
        // Small White Squares top left (Overlaps top left square)
        scr.setPenColor(Draw.WHITE);
        scr.filledSquare(50, 50, 50);
        scr.filledSquare(50, 150, 50);
        
        // Small Black Squares bottom left
        scr.setPenColor(Draw.BLACK);
        scr.filledSquare(50, 250, 50);
        scr.filledSquare(50, 350, 50);
    }
    
    public static void bonusProgram()
    {
        // Set new Screen and Title
        Draw scr = new Draw();
        scr.setTitle("The Flag of France by Vincent");
        scr.clear(Draw.GRAY);
        // Set size of Screen
        scr.setXscale(0, 400); 
        scr.setYscale(400, 0);
        
        // Set name on left Side
        String myName = "Vincent";
        scr.text(25, 200, myName); 
        
        // Flag Pole
        scr.setPenColor(Draw.BLACK);
        scr.setPenRadius(.025);
        scr.line(100, 100, 100, 400);
        
        // Top of Pole
        scr.setPenColor(Draw.BLACK);
        scr.filledCircle(100, 85, 25);
        
        // Flag of France
        scr.setPenColor(Draw.BLUE);
        scr.filledRectangle(140, 175, 35, 65);
        scr.setPenColor(Draw.WHITE);
        scr.filledRectangle(210, 175, 35, 65);
        scr.setPenColor(Draw.RED);
        scr.filledRectangle(280,175, 35, 65);
        
    }
}
