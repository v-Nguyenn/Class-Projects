import java.util.Random;

public class DemoLab3VNguyen
{
    // Array to hold the ornaments for each tree
    static OrnamentVN[][] ornaments;

    public static void main(String[] args)
    {
        // Set up the screen and draw the background
        Draw scr = new Draw();
        demoBackground(scr);

        // Draw the snowman
        drawSnowman(scr, 80, 325, 40);

        // Animate the ornaments
        animateOrnaments(scr);
    }

    // Draw the snowman - includes body, eyes, buttons, etc.
    public static void drawSnowman(Draw scr, int x, int y, int radius)
    {
        scr.setPenColor(Draw.WHITE);

        // Draw body parts (3 circles)
        int bottomY = y;
        int middleY = bottomY - (radius + 10);
        int headY = middleY - (radius + 10);

        scr.filledCircle(x, bottomY, radius);       // Bottom
        scr.filledCircle(x, middleY, radius - 5);   // Middle
        scr.filledCircle(x, headY, radius - 10);    // Head

        // Draw eyes
        scr.setPenColor(Draw.BLACK);
        int eyeOffsetX = 10;
        int eyeOffsetY = 10;
        int eyeRadius = 4;

        scr.filledCircle(x - eyeOffsetX, headY - eyeOffsetY, eyeRadius); // Left eye
        scr.filledCircle(x + eyeOffsetX, headY - eyeOffsetY, eyeRadius); // Right eye

        // Draw buttons
        int buttonRadius = 3;
        int buttonSpacingY = 15;

        scr.filledCircle(x, middleY - buttonSpacingY, buttonRadius); // Top button
        scr.filledCircle(x, bottomY - buttonSpacingY, buttonRadius); // Middle button
        scr.filledCircle(x, bottomY + radius - 10, buttonRadius);    // Bottom button

        // Draw carrot nose (simple triangle)
        scr.setPenColor(Draw.ORANGE);
        double[] xNose = {x, x + 15, x};
        double[] yNose = {headY, headY - 5, headY + 5};
        scr.filledPolygon(xNose, yNose);

        // Draw arms
        scr.setPenColor(165, 42, 42); // Brown arms
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

    // Set up the background scene with trees, sky, ground, etc.
    public static void demoBackground(Draw scr)
    {
        setup(scr);

        // Sky (midnight purple)
        scr.setPenColor(25, 20, 50);
        scr.filledRectangle(200, 100, 200, 100);
        title(scr);

        // Ground (green)
        scr.setPenColor(96, 143, 91);
        scr.filledRectangle(200, 300, 200, 100);

        // Gridlines (for positioning - optional)
        showGrid(scr, 50, 50);

        // Tree positions
        int[] xPositions = {180, 250, 350};
        int[] yPositions = {225, 360, 340};

        ornaments = new OrnamentVN[xPositions.length][4]; // Array for all ornaments

        // Draw each tree
        for (int i = 0; i < xPositions.length; i++)
        {
            drawTree(scr, xPositions[i], yPositions[i], i);
        }
    }

    // Draw a tree with its trunk, leaves, cap, and ornaments
    public static void drawTree(Draw scr, int xCenter, int yBase, int treeIndex)
    {
        // Trunk
        scr.setPenColor(165, 42, 42); // Brown trunk
        scr.filledRectangle(xCenter, yBase, 10, 20);

        // Leaves (green)
        scr.setPenColor(44, 69, 50);
        double[] xPoints = {xCenter - 50, xCenter, xCenter + 50};
        double[] yPoints = {yBase, yBase - 150, yBase};
        scr.filledPolygon(xPoints, yPoints);

        // Snow cap on top
        scr.setPenColor(Draw.WHITE);
        scr.filledCircle(xCenter, yBase - 155, 10);

        // Ornaments (4 per tree)
        Random rand = new Random();
        for (int i = 0; i < 4; i++)
        {
            int xOrn = xCenter - 30 + rand.nextInt(60); // Random x around tree center
            int yOrn = yBase - 50 - rand.nextInt(100);  // Random y up the tree
            ornaments[treeIndex][i] = new OrnamentVN(scr, xOrn, yOrn, 15);
            ornaments[treeIndex][i].drawMe(scr);
        }
    }

    // Animate the ornaments to change color
    public static void animateOrnaments(Draw scr)
    {
        int pauseSetting = 100;
        scr.setPenColor(Draw.WHITE);
        scr.text(200, 380, "Click top left to speed up, bottom to adjust speed, top right to stop.");
        boolean keepRunning = true;

        while (keepRunning)
        {
            // Change the color of the ornaments
            for (int treeIndex = 0; treeIndex < ornaments.length; treeIndex++)
            {
                for (int i = 0; i < ornaments[treeIndex].length; i++)
                {
                    ornaments[treeIndex][i].randomColor(scr);
                    ornaments[treeIndex][i].drawMe(scr); // Redraw with new color
                }
            }

            scr.pause(pauseSetting);

            // Handle user clicks for control
            if (scr.isMousePressed())
            {
                double x = scr.mouseX();
                double y = scr.mouseY();

                if (x > 350 && y < 50)
                {
                    // Stop animation if clicked in the top right
                    scr.setPenColor(Draw.GRAY);
                    scr.filledRectangle(200, 100, 200, 100);
                    scr.setPenColor(Draw.WHITE);
                    scr.text(200, 100, "Fall 2024 Project by VNguyen");
                    keepRunning = false;
                    break;
                }
                else if (x < 50 && y < 50)
                {
                    // Speed up if clicked in top left
                    pauseSetting = Math.max(10, pauseSetting - 10);
                }
                else if (y > 350)
                {
                    // Toggle speed if clicked at bottom
                    pauseSetting = (pauseSetting == 100) ? 50 : 100;
                }
                else
                {
                    // Draw a snowflake if clicked anywhere else
                    drawSnowflake(scr, (int) x, (int) y, 20);
                }
            }
        }
    }

    // Draw a snowflake at given coordinates
    public static void drawSnowflake(Draw scr, int x, int y, int length)
    {
        scr.setPenColor(Draw.WHITE);
        scr.line(x, y - length, x, y + length);             // Vertical
        scr.line(x - length, y, x + length, y);             // Horizontal
        scr.line(x - length, y - length, x + length, y + length);
        scr.line(x + length, y - length, x - length, y + length); 
    }

    // Setup for drawing screen
    public static void setup(Draw scrn)
    {
        scrn.setTitle("Lab Project Task #3 by VNguyen");
        scrn.setXscale(0, 400);
        scrn.setYscale(400, 0);
    }

    // Draw title text
    public static void title(Draw canvas)
    {
        canvas.setPenColor(Draw.WHITE);
        canvas.text(200, 50, "To Mom and Dad, a merry Christmas");
    }

    // Optional: Show a grid (for easier positioning)
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
