
/**
 * CircleSizes - Circle Positioning Practice
 * 
 * Creates multiple colored circles on a yellow background to practice positioning
 * and color changes. Includes a separate printExample() method for text output.
 * 
 * Learned: Multiple shape positioning, color changes, text output to graphics and console
 * Topics: filledCircle() positioning, setPenColor(), text() method
 *
 * @author Vincent Nguyen
 * @date Originally written: September 2024
 * @date Updated: December 1, 2025
 */
public class CircleSizes
{
    public static void main(String[] args)
    {
        Draw scr1 = new Draw();
        // Sets the background of the screen to be yellow
        scr1.clear(Draw.YELLOW);
        // Sets a big circle
        scr1.filledCircle(0.5, 0.5, 0.1);
        // Sets two green circles at two different points
        scr1.setPenColor(Draw.GREEN);
        scr1.filledCircle(0.75, 0.25, 0.1);
        scr1.filledCircle(0.95, 0.65, 0.1);
        // Sets two blue circles at two different points
        scr1.setPenColor(Draw.BLUE);
        scr1.filledCircle(0.25, 0.75, 0.1);
        scr1.filledCircle(0.25, 0.75, 0.25);
    }
    
    public static void printExample()
    {
        Draw win = new Draw();
        win.clear( Draw.LIGHT_GRAY );
        win.text( 0.10, 0.25,"Programming is great fun! ");
        System.out.println("My program is great fun! ");
    }
}
