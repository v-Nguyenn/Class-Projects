
public class MyDrawing {
    public static void main(String[] args) {
        // Create a Draw object
        Draw scr = new Draw();
        
        // Clear the screen with a white background
        scr.clear(Draw.WHITE);
        
        // Set the pen color to black and draw a filled circle
        scr.setPenColor(Draw.BLACK);
        scr.filledCircle(0.5, 0.5, 0.3);  // Center of screen with radius 0.3
        
        // Draw a red rectangle
        scr.setPenColor(Draw.RED);
        scr.filledRectangle(0.5, 0.5, 0.2, 0.1);  // Draws in the center
    }
}
