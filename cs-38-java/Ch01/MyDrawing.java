/**
 * MyDrawing - First Graphics Exercise
 * 
 * Creates a simple drawing with a black circle and red rectangle in the center.
 * First introduction to the Draw library and basic shapes.
 * 
 * Learned: Creating Draw objects, clearing screen, basic shapes and colors
 * Topics: filledCircle(), filledRectangle(), default coordinate system (0.0 to 1.0)
 *
 * @author Vincent Nguyen
 * @date Originally written: September 2024
 * @date Updated: December 1, 2025
 */
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
