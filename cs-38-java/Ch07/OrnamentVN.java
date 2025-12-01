import java.util.Random;

/**
 * Description
 * Ornament class used in the Lab Project.
 * @author Vincent Nguyen  
 * @version 11/27/24
 */
public class OrnamentVN
{
    // fields
    private int xPos;
    private int yPos;
    private int radius;

    // Constructors and Overloaded Constructors

    /**
     * Constructor to draw an ornament in position x, y with a desired radius on the graphics screen.
     * The color is randomized.
     *
     * @param scr is the graphics screen used
     * @param x the ornament position (x-coordinate)
     * @param y the ornament position (y-coordinate)
     * @param newRadius is the radius for the ornament
     */
    public OrnamentVN(Draw scr, int x, int y, int newRadius)
    {
        xPos = x;
        yPos = y;
        radius = newRadius;
        randomColor(scr);
    }

    // Randomly sets the pen color for the ornament
    public void randomColor(Draw win)
    {
        Random ran = new Random();
        int red = ran.nextInt(134);
        int grn = ran.nextInt(200);
        int blu = ran.nextInt(145);
        win.setPenColor(red, grn, blu);
    }

    // Draws the ornament at its stored position
    public void drawMe(Draw scr)
    {
        scr.filledCircle(xPos, yPos, radius);
    }

    // Set new x and y coordinates for the ornament
    public void setXY(int newX, int newY)
    {
        xPos = newX;
        yPos = newY;
    }

    // Set a new radius for the ornament
    public void setRadius(int newRadius)
    {
        radius = newRadius;
    }
}
