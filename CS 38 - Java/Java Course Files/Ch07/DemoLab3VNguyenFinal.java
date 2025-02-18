import java.util.Random;
import java.awt.Font;

/**
 * Description 
 *   Lab Project that includes a new snowman-drawing feature.
 * @author Vincent Nguyen
 * @version 11/27/24
 */
public class DemoLab3VNguyenFinal
{
    public static void main(String[] args)
    {
        // Setup screen and background
        Draw scr = new Draw();
        demoBackground(scr);

        // Draws snowman at x = 100, y = 300, body radius = 40
        drawSnowman(scr, 80, 325, 40); 
        demo1(scr);
    }

    public static void drawSnowman(Draw scr, int x, int y, int radius)
    {
        scr.setPenColor(Draw.WHITE);

        // Draw body parts: bottom, middle, and head
        int bottomY = y;
        int middleY = bottomY - (radius + 10);
        int headY = middleY - (radius + 10);

        scr.filledCircle(x, bottomY, radius);       // Bottom circle
        scr.filledCircle(x, middleY, radius - 5);   // Middle circle
        scr.filledCircle(x, headY, radius - 10);    // Head circle

        // Draw the eyes
        scr.setPenColor(Draw.BLACK);
        int eyeOffsetX = 10;
        int eyeOffsetY = 10;
        int eyeRadius = 4;

        scr.filledCircle(x - eyeOffsetX, headY - eyeOffsetY, eyeRadius); // Left eye
        scr.filledCircle(x + eyeOffsetX, headY - eyeOffsetY, eyeRadius); // Right eye

        // Draw the buttons
        int buttonRadius = 3;
        int buttonSpacingY = 15;

        scr.filledCircle(x, middleY - buttonSpacingY, buttonRadius); // Top button
        scr.filledCircle(x, bottomY - buttonSpacingY, buttonRadius); // Middle button
        scr.filledCircle(x, bottomY + radius - 10, buttonRadius);    // Bottom button

        // Draw the carrot nose
        scr.setPenColor(Draw.ORANGE);
        double[] xNose = {x, x + 15, x};
        double[] yNose = {headY, headY - 5, headY + 5};
        scr.filledPolygon(xNose, yNose);

        // Draw arms
        scr.setPenColor(165, 42, 42); // Brown color
        int armLength = 40;

        scr.line(x - radius, middleY, x - radius - armLength, middleY - 10); // Left arm
        scr.line(x + radius, middleY, x + radius + armLength, middleY - 10); // Right arm

        // Draw top hat
        scr.setPenColor(Draw.BLACK);
        int brimWidth = radius;
        int brimHeight = 5;
        int topHatWidth = radius - 10;
        int topHatHeight = 25;

        int brimY = headY - (radius - 10) + 10;
        int topHatY = brimY - topHatHeight;

        scr.filledRectangle(x, brimY, brimWidth, brimHeight);    // Draw brim
        scr.filledRectangle(x, topHatY, topHatWidth, topHatHeight); // Draw top of hat
    }

    public static void demo1(Draw scr) {
        Random ran = new Random();
        int size = 50;

        // STEP 1 - Create the array of OrnamentVN
        OrnamentVN[] circ = new OrnamentVN[size];

        for (int i = 0; i < size; i++) {
            // STEP 2 - Put an ornament into the array
            circ[i] = new OrnamentVN(scr);
        }

        // Animate snowflake on click
        boolean keepRunning = true;
        while (keepRunning) {
            int index = ran.nextInt(size);
            circ[index].randomColor(scr);
            scr.pause(100);

            // Check mouse press and add a snowflake at the clicked position
            if (scr.isMousePressed()) {
                double x = scr.mouseX();
                double y = scr.mouseY();

                // Stop animation if clicked in the upper-right corner
                if (x > 350 && y < 50) {
                    keepRunning = false;
                } else {
                    // Draw a snowflake at the clicked position
                    drawSnowflake(scr, (int) x, (int) y, 20);
                }
            }
        }

        scr.setPenColor(Draw.GRAY);
        scr.filledRectangle(200, 100, 200, 100);
        scr.setPenColor(Draw.WHITE);
        scr.text(200, 100, "Fall 2024 Project by VNguyen");
    }

    public static void demo2()
    {
        Draw scr = new Draw();
        setup(scr);
        Random ran = new Random();
        int size = 9;
        OrnamentVN[] circ = new OrnamentVN[size];

        int newRadius = ran.nextInt(5, 20);
        int xOrn, yOrn;

        // Set locations for ornaments
        xOrn = 25;
        yOrn = 25;
        circ[0] = new OrnamentVN(scr);
        circ[0].setXY(scr, xOrn, yOrn);
        circ[0].randomColor(scr);

        xOrn = 50;
        yOrn = 25;
        circ[1] = new OrnamentVN(scr);
        circ[1].setXY(scr, xOrn, yOrn);
        circ[1].randomColor(scr);

        xOrn = 75;
        yOrn = 25;
        circ[2] = new OrnamentVN(scr);
        circ[2].setXY(scr, xOrn, yOrn);
        circ[2].randomColor(scr);

        xOrn = 25;
        yOrn = 75;
        circ[3] = new OrnamentVN(scr);
        circ[3].setXY(scr, xOrn, yOrn);
        circ[3].randomColor(scr);

        xOrn = 50;
        yOrn = 75;
        circ[4] = new OrnamentVN(scr);
        circ[4].setXY(scr, xOrn, yOrn);
        circ[4].randomColor(scr);

        xOrn = 75;
        yOrn = 75;
        circ[5] = new OrnamentVN(scr);
        circ[5].setXY(scr, xOrn, yOrn);
        circ[5].randomColor(scr);

        xOrn = 25;
        yOrn = 125;
        circ[6] = new OrnamentVN(scr);
        circ[6].setXY(scr, xOrn, yOrn);
        circ[6].randomColor(scr);

        xOrn = 50;
        yOrn = 125;
        circ[7] = new OrnamentVN(scr);
        circ[7].setXY(scr, xOrn, yOrn);
        circ[7].randomColor(scr);

        xOrn = 75;
        yOrn = 125;
        circ[8] = new OrnamentVN(scr);
        circ[8].setXY(scr, xOrn, yOrn);
        circ[8].randomColor(scr);

        // Draw ornaments
        for (int i = 0; i < circ.length; i++)
        {
            circ[i].drawMe(scr);
        }

        // Animate
        int waitTime = 500;
        boolean keepRunning = true;

        while (keepRunning)
        {
            int index = ran.nextInt(size);
            circ[index].randomColor(scr);
            circ[index].drawMe(scr);

            scr.pause(waitTime);

            if (scr.isMousePressed())
            {
                double x = scr.mouseX();
                double y = scr.mouseY();

                if (x > 370 && y < 30)
                {
                    keepRunning = false;
                }
            }

            scr.setPenColor(Draw.GRAY);
            scr.filledRectangle(200, 123, 200, 123);
            scr.setPenColor(Draw.WHITE);
            scr.text(200, 100, "Fall 2024 Demo2 Project by VNguyen");
        }
    }

    public static void setup(Draw scrn)
    {
        scrn.setTitle("Lab Project Task #3 by VNguyen");
        scrn.setXscale(0, 400);
        scrn.setYscale(400, 0);
    }

    public static void title(Draw canvas)
    {
        canvas.setPenColor(Draw.WHITE);
        canvas.text(200, 50, "To Mom and Dad, a merry Christmas");
    }

    public static void demoBackground(Draw scr) {
        setup(scr);

        // Midnight Purple Sky
        scr.setPenColor(25, 20, 50);
        scr.filledRectangle(200, 100, 200, 100);
        title(scr);

        // Ground
        scr.setPenColor(96, 143, 91);
        scr.filledRectangle(200, 300, 200, 100);

        // Show gridline to help draw trees, remove later if not needed
        showGrid(scr, 50, 50);

        // Tree positions and heights
        int[] xPositions = {180, 250, 350};  // x-coordinates for each tree
        int[] yPositions = {225, 360, 340}; // y-coordinates for the base of each tree (different heights)

        // Draw multiple trees using a loop
        for (int i = 0; i < xPositions.length; i++) 
        {
            drawTree(scr, xPositions[i], yPositions[i]);
        }
    }
    
    public static void drawTree(Draw scr, int xCenter, int yBase)
    {
        // Draw trunk
        scr.setPenColor(165, 42, 42); // Brown trunk
        scr.filledRectangle(xCenter, yBase, 10, 20);
        
        // Draw leaves
        scr.setPenColor(44, 69, 50); // Green leaves
        double[] xPoints = {xCenter - 50, xCenter, xCenter + 50}; // Triangle shape
        double[] yPoints = {yBase, yBase - 150, yBase}; // Height of the tree
        scr.filledPolygon(xPoints, yPoints);

        // Draw cap
        scr.setPenColor(Draw.WHITE);  // Snow cap
        scr.filledCircle(xCenter, yBase - 155, 10);
    }

    // Method to draw a snowflake at given coordinates
    public static void drawSnowflake(Draw scr, int x, int y, int length) 
    {
        scr.setPenColor(Draw.WHITE); // Set the color for the snowflake

        // Draw six branches radiating from the center point (x, y)
        scr.line(x, y - length, x, y + length);             // Vertical line
        scr.line(x - length, y, x + length, y);             // Horizontal line
        scr.line(x - length, y - length, x + length, y + length); // Diagonal line (top-left to bottom-right)
        scr.line(x + length, y - length, x - length, y + length); // Diagonal line (top-right to bottom-left)
    }

    public static void showGrid(Draw scr, int xSize, int ySize)
    {
        scr.setPenColor(Draw.BLACK);

        for (int x = 0; x <= 400; x += xSize)
        {
            scr.line(x, 0, x, 400);
        }

        for (int y = 400; y >= 0; y -= ySize)
        {
            scr.line(0, y, 400, y);
        }
    }
}
