import java.util.Random;
import java.awt.Font;
/**
 * Description
 * This program creates a 3x3 board with a randomly rotated 
 * name in the center of each square.
 * ______________________
 * Programming Challenge A
 * Last name is N so I am doing a 3x3 board with a name
 * in the middle of each square with two alternating colors. 
 * ______________________
 * @author Vincent Nguyen 
 * @version 11/03/24
 */
public class nXnBoardVNguyen
{
    // fields
    int size = 9; // Num of Rectangles
    /**
     * Main method to start and display board.
     * Calls the method to setup the graphics screen,
     * draw rectangles, display the name in eac
     * square, and adds a title.
     * 
     * @param args not used
     */
    public static void main(String[] args)
    {
        Random rndNum = new Random();
        Draw scr = new Draw();
        
        setUp(scr);               // setups up graphics
        drawRectangles(scr);      // Draws the 3x3 rectangles
        centerNames(scr, rndNum); // Displays the name in each Square
        title(scr, 25);           // Adds a title to the screen
    }

    // method to setup graphics screen
    /**
     * Sets up the graphics screen with dimensions, background color, 
     * and title.
     * 
     * @param scr The Draw object to setup
    */
    public static void setUp(Draw scr)
    {
        scr.setXscale(0, 400);
        scr.setYscale(400, 0);
        scr.setTitle("3x3 Board5b by Vincent Nguyen");
        scr.clear(Draw.LIGHT_GRAY);
    }
    
    /**
     * Displays a title text in the center of the screen.
     * 
     * @param scr The Draw object used to display text
     * @param num The font size for the title text
     */
    public static void title(Draw scr, int num)
    {
        Font titleFont = new Font("Consolas", Font.BOLD, num);
        scr.setFont(titleFont);

        scr.setPenColor(Draw.YELLOW);
        scr.text(200, 200, "3x3 Board5b by VincentNguyen", 45);
    }

    /**
     * Draws a 3x3 grid of rectangles on the graphics screen
     * Each rectangle represents a cell on the 3x3 board
     * 
     * @param scr The Draw object to setup
     */
    public static void drawRectangles(Draw scr)
    {
        scr.setPenColor(Draw.BLUE); 
        int x, y;                   // Coordinates for the rectangles
        int length = 60;            // Width of the rectangle
        int width = 60;             // Height of the rectangle
        int count = 3;              // Number of rectangles per row/column
        int spacing = 130;          // Spacing between rectangle

        // Loop through rows
        for (int row = 0; row < count; row++) 
        {
            y = 70 + (row * spacing);       // Adjust y for each row 
            x = 70;                         // Reset x for each row
            // Loop through columns
            for (int col = 0; col < count; col++) 
            {
                scr.rectangle(x, y, length, width); 
                x += spacing;                   // Increment x for the next column 
            }
        }
    }

     /**
     * Displays the name in each rectangle with random rotation and alternating colors.
     * Colors alternate between Yoda Green and Ocean Blue.
     * 
     * @param scr The Draw object to display text
     * @param rndNum Random object for generating random rotation angles
     */
    public static void centerNames(Draw scr, Random rndNum)
    {
        scr.setPenColor(Draw.BLUE); 
        String name = "VNguyen";             
        int count = 3;              // Number of names per row/column
        int spacing = 130;          // Spacing between names

        // Loop through rows
        for (int row = 0; row < count; row++) {
            int y = 70 + (row * spacing);       // Adjust y for each row 
            int x = 70;                         // Reset x for each row
            // Loop through columns
            for (int col = 0; col < count; col++) {
                double rndAngle = rndNum.nextDouble() * 360; // Random angle each time

                // alternating colors
                if((row + col)% 2 == 0){
                  scr.setPenColor(91, 222, 19); // yoda green
                } else {
                  scr.setPenColor(0, 112, 161); // ocean blue
                }
                scr.text(x, y, name, rndAngle); 
                x += spacing;                   // Increment x for the next column
            }
        }
    }
}