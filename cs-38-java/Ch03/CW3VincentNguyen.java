import java.awt.Font;
/**
 * Description
 * We made a logo
 * 
 * @author Vincent Nguyen
 * @version 09/10/24
 */
//Template we will start with
public class CW3VincentNguyen
{
    public static void main(String[] args)
    {
    }

    public static void companyLogo()
    {
        // Setting the Screen
        Draw scr = new Draw();
        scr.setXscale (0, 400);
        scr.setYscale (400, 0);
        scr.clear(Draw.LIGHT_GRAY);
        
        scr.setTitle("Company Logo from class work");
        
        // Set the lines 
        // scr.line(200, 0, 200, 400); // vertical line
        // scr.line(0, 200, 400, 200); // horizontal line
        
        scr.line(400, 400, 0, 0); // Diagonal line "\" 
        scr.line(0, 400, 400, 0); // Diagonal line "/"
        
        // Target picture 200,60)
        scr.setPenColor(Draw.RED);
        scr.filledCircle(200, 60, 60);
        scr.setPenColor(Draw.WHITE);
        scr.filledCircle(200, 60, 40);
        scr.setPenColor(Draw.RED);
        scr.filledCircle(200,60, 20);
        
        // Target Words
        Font fnt = new Font("Arial", Font.PLAIN, 24);
        scr.setFont(fnt);
        scr.setPenColor(Draw.RED);
        scr.text(200,140,"TARGET", 0);
    }
    
    public static void panda()
   {
       // Set Screen
       Draw scr = new Draw();
       scr.setXscale(0, 400);
       scr.setYscale(400, 0);
       scr.clear(Draw.LIGHT_GRAY);
       
       // Draw body
       scr.setPenColor(Draw.BLACK);
       scr.filledCircle(200, 375, 175);
       
       // Draw Ears
       scr.filledCircle(100, 100, 50); // Left ear
       scr.filledCircle(300, 100, 50); // Right ear
       
       // Draw Face
       // Circle ( x, y, size);
       scr.setPenColor(Draw.WHITE);
       scr.filledCircle(200, 200, 125);
       
       // Draw Eyes
       // Ellipse ( x, y, width, length)
       scr.setPenColor(Draw.BLACK);
       scr.filledEllipse(160, 160, 30, 40); // Left eye
       scr.filledEllipse(240, 160, 30, 40); // Right eye
       
       // Draw pupils 
       scr.setPenColor(Draw.WHITE);
       scr.filledCircle(160, 160, 20);
       scr.filledCircle(240, 160, 20);
       
       scr.setPenColor(Draw.BLACK);
       scr.filledCircle(160, 160, 5);
       scr.filledCircle(240, 160, 5);
       
       // Draw Nose 200 200
       scr.setPenColor(Draw.BLACK);
       scr.filledEllipse(200, 220, 40, 20);
       
       // Draw Mouth
       scr.setPenColor(Draw.PINK);
       scr.filledEllipse(200, 275, 30, 20);
       scr.setPenColor(Draw.WHITE);
       scr.filledRectangle(200, 260, 40, 10);
   }
}
