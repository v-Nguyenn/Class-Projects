import java.awt.Font;
import java.awt.Color;
/**
 * Description
 * ______________________
 * The first program is a bunny and since my name starts with N,
 * The bunny is in the top right most quadrant
 * 
 * The second program is a building made out of rectangles
 * ______________________
 * @author Vincent Nguyen
 * @version 9/29/24
 */
//Template we will start with
public class programChallengeLoops1
{
    public static void main(String[] args)
    {
    }

    public static void bunnyByVincent()
    {
        // Setup Graphics screen
        Draw scr = new Draw();
        Color gween = new Color(0, 102, 0);
        scr.clear(gween); // background
        scr.setTitle("Bunny by Vincent Nguyen");
        Font fntName = new Font("Serif",Font.BOLD, 40);
        scr.setXscale(0, 400);
        scr.setYscale(400, 0);
        
        // Name in the middle
        scr.setFont(fntName);
        scr.setPenColor(Draw.RED);
        scr.text(200, 200, "Bunny by Vincent Nguyen", 90);
        
        // Bunny
        // Ears (looks like two ellipses)
        int xPos = 270, yPos = 60;
        Color lightPink = new Color(255, 209, 220);
        scr.setPenColor(lightPink); // Ear color
        scr.filledEllipse(xPos     , yPos, 15, 50); // Left Ear
        scr.filledEllipse(xPos + 60, yPos, 15, 50); // Right Ear
        scr.setPenColor(Draw.YELLOW);
        scr.filledEllipse(xPos     , yPos + 5, 10, 45); // Left inside
        scr.filledEllipse(xPos + 60, yPos + 5, 10, 45); // Right inside
        
        // Head and Cheeks
        xPos = 300; 
        yPos = 120;
        scr.setPenColor(Draw.WHITE);
        scr.filledEllipse(xPos, yPos, 56, 50); // forehead
        scr.filledCircle(xPos - 30, yPos + 35, 40); // Left Cheek
        scr.filledCircle(xPos + 30, yPos + 35, 40); // Right Cheek

        // Eyes, pink eye spot, and pupils
        xPos = 270;
        yPos = 140;
        Color pinkEye = new Color(255, 200, 200);
        scr.setPenColor(pinkEye); 
        scr.filledEllipse(xPos + 60, yPos, 15, 20); // Right Eye shadow
        scr.setPenColor(Draw.BLACK);
        scr.filledEllipse(xPos     , yPos, 6, 12); // Left Eye
        scr.filledEllipse(xPos + 60, yPos, 6, 12); // Right Eye
        // pupils
        scr.setPenColor(Draw.WHITE);
        scr.filledEllipse(xPos     , yPos - 5, 2, 5); // left pupil
        scr.filledEllipse(xPos + 60, yPos - 5, 2, 5); // right pupil
        
        // Mouth
        xPos = 300;
        yPos = 170;
        scr.setPenColor(Draw.BLACK);
        scr.filledRectangle(xPos, yPos, 10,5); // mouth
        
    }

    public static void building()
    {
        // Graphics screen setup
        Draw scr = new Draw();
        Color lightBlue = new Color(51, 204, 255);
        scr.clear(lightBlue);
        scr.setXscale(0,400);
        scr.setYscale(400,0);
        scr.setTitle("Building by Vincent Nguyen");
        
        // Large name for graphics screen
        Font bigName = new Font("Helvetica", Font.PLAIN, 45);
        scr.setFont(bigName);
        Color faveColor = new Color(0, 255, 51);
        scr.setPenColor(faveColor);
        scr.text(50, 200, "Vincent Nguyen", 90);
        
        // Sun
        int xPos = 320, yPos = 200;
        scr.setPenColor(Draw.YELLOW);
        scr.filledCircle(xPos, yPos, 50);
        
        // The building - I started from the bottom to the top
        // width part of base
        // + goes up - goes down
        xPos = 200; yPos = 360;
        Color turd = new Color(102, 51, 0);
        scr.setPenColor(turd);
        scr.filledRectangle(xPos, yPos + 5, 100, 35); 
        
        // big foundation of building
        //scr.setPenColor(Draw.ORANGE);
        scr.filledRectangle(xPos, yPos - 10, 90, 50);
        
        // Middle block of building 
        xPos = 200; yPos = 180;
        //scr.setPenColor(Draw.BLUE);
        scr.filledRectangle(xPos, yPos + 20, 50, 100);
        
        // 2nd block from top
        xPos = 200; yPos = 90;
        //scr.setPenColor(Draw.GREEN);
        scr.filledRectangle(xPos, yPos, 30, 10);
        
        // top block
        xPos = 200; yPos = 70;
        //scr.setPenColor(Draw.ORANGE);
        scr.filledSquare(xPos, yPos, 10);
    }

}
