import java.awt.Font;
/**
 * Description
 * ______________________
 * Programming Challenge B
 * Since my last name starts with N, I placed my minion 
 * in the bottom left of the screen. This program draws 
 * a minion face with eyes, goggles, and a mouth using 
 * simple shapes.
 * ______________________
 * @author Vincent Nguyen
 * @version 11/03/24
 */
public class minionVNguyen {
    
    /**
     * Main method calls the Draw object and calls methods
     * to set up the graphics window and draw the minion face.
     */
    public static void main(String[] args) {
        Draw scr = new Draw();
        setUp(scr);
        drawEye(scr, 140, 265); // Right eye
        drawEye(scr, 60, 265); // Left eye
        drawMouth(scr);
    }

    /**
     * Sets up the screen for the drawing, setting background color, 
     * scale, title, and drawing the goggles band on the minion’s head.
     * @param scr The Draw object used to setup the graphics.
     */
    public static void setUp(Draw scr) {
        scr.clear(Draw.YELLOW);       // Set background to yellow
        scr.setXscale(0, 400);        
        scr.setYscale(400, 0);        
        scr.setTitle("Minion by Vincent Nguyen");

        // Draw minion face background
        scr.setPenColor(255, 215, 0); // Gold color for minion background
        scr.filledSquare(100, 300, 100); // Centered square as minion's face

        // Draw goggles band
        scr.setPenColor(Draw.BLACK);   // Black band for goggles
        scr.filledRectangle(100, 260, 100, 15);
    }

    /**
     * Draws the minion’s mouth with a slight offset to reate a smiling effect.
     * @param scr The Draw object used for graphics.
     */
    public static void drawMouth(Draw scr) {
        int x = 100;
        int y = 350;
        int length = 55;
        int width = 25;

        scr.setPenColor(Draw.BLACK);         // Outer black for mouth
        scr.filledEllipse(x, y, length, width);

        scr.setPenColor(255, 215, 0);        // Yellow minion color
        y -= 15;                             // offset y for smile
        scr.filledEllipse(x, y, length, width);
    }

    /**
     * Draws a single eye of the minion at the (x, y) location.
     * The eye includes the outer goggle frame, the white part of the eye,
     * a brown iris, and a black pupil.
     * @param scr The Draw object used for setup.
     * @param x The x-coordinate for the eye center.
     * @param y The y-coordinate for the eye center.
     */
    public static void drawEye(Draw scr, double x, double y) {
        // Outer grey circle for goggles
        scr.setPenColor(105, 105, 105); // Grey
        scr.filledCircle(x, y, 35);

        // White part of the eye
        scr.setPenColor(Draw.WHITE);
        scr.filledCircle(x, y, 27);

        // Brown iris
        scr.setPenColor(139, 69, 19);   // Brown
        scr.filledCircle(x, y, 15);

        // Black pupil
        scr.setPenColor(Draw.BLACK);   
        scr.filledCircle(x, y, 9);
        
        // White highlight in the pupil
        scr.setPenColor(Draw.WHITE);
        scr.filledCircle(x - 10, y - 10, 3); // Slight offset for highlight effect
    }
}
