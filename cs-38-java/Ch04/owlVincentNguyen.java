import java.awt.Font;
/**
 * Write a description of class owlVincentNguyen here.
 * 
 * This is a drawing of an owl
 * Draw the ears, nose, eye and your name. You can draw the rest
 * at home.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class owlVincentNguyen
{
    public static void owl()
    {
        Draw scr = new Draw();
        scr.clear(Draw.LIGHT_GRAY);
        scr.setXscale(0,400);
        scr.setYscale(400,0);
        
        scr.setTitle("Owl by Vincent Nguyen");
        Font fnt = new Font("Arial", Font.BOLD, 32);
        scr.setFont(fnt);
        scr.text(50, 200, "Owl by Vincent Nguyen", 90);
        
        scr.setPenColor(139, 69, 19);
        scr.filledEllipse(200, 160, 140, 90);
        
        double[] x = {60,  80, 120, 60};
        double[] y = {100, 20, 50, 100};
        scr.filledPolygon(x,y);
        
        scr.setPenColor(255, 165, 0);
        double[] x2 = {190, 210, 200, 190};
        double[] y2 = {170, 170, 210, 170};
        scr.filledPolygon(x2,y2);
        // face
        
        
        scr.pause(1000);
    }
}
