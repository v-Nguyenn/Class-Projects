import java.util.Scanner;
/**
 * HWOOP1VNguyen has all the programming challenges.
 * It gets the radius from the user, creates a Circle,
 * shows its details, and draws it.
 * 
 * @author Vincent Nguyen
 * @version 11/03/24
 */
public class HWOOP1VNguyen {
    /**
     * Main method to run the program.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        // Ask for radius input
        System.out.print("Enter radius of circle: ");
        double newValue = keyboard.nextDouble(); // Get radius from user

        // Create Circle with user input
        Circle circle = new Circle(newValue);
        
        // Show circle details
        System.out.println(circle);

        Draw scr = new Draw();
        circle.drawMe(scr); // Draw the circle

        keyboard.close(); // Close the Scanner
    }
}
