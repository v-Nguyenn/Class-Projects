//import java.util.Scanner;
/**
 * Circle class represents a circle with a specific radius.
 * It calculates the area, diameter, and circumference, 
 * and can draw itself on a graphical interface.
 * 
 * @author Vincent Nguyen
 * @version 11/03/24
 */
public class Circle 
{
    // fields
    private double radius;             // Radius of the circle
    private final double PI = 3.14159; // Value of PI
    private boolean isSolid = true;    // Is circle filled?

    // Constructor
    public Circle(double r) {
        radius = r;
    }

    // Mutators
    public void setRadius(double newValue) {
        radius = newValue;
    }

    // Accessor
    public double getRadius() {
        return radius; // Returns the radius
    }

    // Calculate area
    public double getArea() {
        return PI * radius * radius; // Area formula
    }

    // Calculate diameter
    public double getDiameter() {
        return radius * 2;  
    }

    // Calculate circumference
    public double getCircumference() {
        return 2 * PI * radius;      // Circumference formula
    }

    /**
     * Returns a string with the area, diameter, and circumference.
     *
     * @return Formatted string with circle details
     */
    public String toString() {
        return "Area: "     + String.format("%.2f", getArea()) + "\n" +
        "Diameter: " + String.format("%.2f", getDiameter()) + "\n" +
        "Circumference: " + String.format("%.2f", getCircumference()) + "\n";
    }

    /**
     * Draws the circle on the given screen.
     *
     * @param scr The drawing object to use
     */
    public void drawMe(Draw scr) {
        // Setup Graphics
        scr.setXscale(0, 400);
        scr.setYscale(400, 0);
        scr.clear(Draw.LIGHT_GRAY);
        scr.setTitle("Circle by Vincent Nguyen");
        int centerX = 200;
        int centerY = 200;

        if (isSolid) {
            scr.filledCircle(centerX, centerY, radius);
        } else {
            scr.circle(centerX, centerY, radius);
        }
    }
    
    // // I moved the main method to another file which calls the Circle class.
    // // Note to self - uncomment the imports as well
    // /**
     // * Program starts in main and does the following:
     // * It prompts the user for the radius of the circle, creates a Circle
     // * object, displays its properties, and draws it on the screen.
     // *
     // */
    // public static void main(String[] args) {
        // Scanner keyboard = new Scanner(System.in);

        // // Asks for user input
        // System.out.print("Enter radius of circle: ");
        // double newValue = keyboard.nextDouble(); // Use nextDouble to read double

        // // Create circle with radius from user
        // Circle circle = new Circle(newValue);

        // // Displays the circle
        // System.out.println(circle);

        // Draw scr = new Draw();
        // circle.drawMe(scr); // Call drawMe on the instance circle

        // keyboard.close(); // Correctly close the Scanner
    // }
}
