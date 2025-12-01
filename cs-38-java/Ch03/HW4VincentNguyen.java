import java.util.Scanner;
import java.awt.Font;
/**
 * Description
 * ______________________
 * Program Challenge 3. pg 193
 * Write a program that calculates and displays a person's body
 * mass index (BMI). The BMI is often used to determine whether a 
 * person is overweight for his or her height. A person's BMI is 
 * calculated.
 * BMI = Weight x 703/Height^2
 * Optimal weight: 18.5 - 25
 * Underweight: < 18.5
 * Overweight: > 25
 * 
 * Program Challenge 5. Mass and Weight
 * Scientists measure an object's  mass in kilograms and its weight
 * in Newtons. If you know the amount of mass that an object has, 
 * you can calculate its weight, in Newtons with the following 
 * formula:
 * Weight = Mass x 9.8
 * Write a program that asks the user to enter an object's mass, 
 * and then calculate its weight. If the object weights more than 
 * 1,000 Newtons, display a message indicating that it is too heavy.
 * If the object weights less than 10 Newtons, display a message
 * indicating that the object is too light.
 *
 * 
 * ______________________
 * @author Vincent Nguyen
 * @version 09/22/2024
 */
//Template we will start with
public class HW4VincentNguyen
{
    public static void main(String[] args)
    {
       }

    public static void bodyMassIndex()
    {
        double weight, height, BMI;
        String message = "";
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("\n****** Body Mass Index ******");
        System.out.print("\nEnter weight (Pounds)\n");
        weight = input.nextDouble();                                                                                                    
        
        System.out.print("Enter height (Inches)\n");
        height = input.nextDouble();
        
        // Calculation
        BMI = weight * 703/(height * height);
        // Format BMI to have two decimal places
        // Multiplying by ten shifts the decimal to the right
        // Dividing by ten shifts the decimal back to its og pos
        double roundedBMI = (double) Math.ceil(BMI * 10) / 10;
        
        // Checks the most specific case first            
        if(BMI > 18.5 && BMI < 25)
        {
            message = "You are considered optimal weight by BMI";
        }
        else if(BMI < 18.5) // checks if it is lower than 18.5
        {
            message = "You are considered underweight by BMI";
        }
        else // otherwise it has to be greater than 25
        {
            message = "You are considered overweight by BMI";
        }
        System.out.printf("%,.2f", BMI);
        System.out.print("\n*****************************");
        
        // Graphics Output setup
        Draw scr = new Draw();
        scr.clear(Draw.LIGHT_GRAY);
        scr.setTitle("Body Mass Index Calculator by Vincent Nguyen");
        scr.setXscale(0, 400);
        scr.setYscale(400, 0);
        
        // Shapes
        // Big Boned
        scr.setPenColor(Draw.ORANGE);
        scr.filledCircle(40, 242, 20);
        scr.filledSquare(40, 300, 40);
        scr.filledRectangle(20, 340, 10, 30);
        scr.filledRectangle(60,340, 10, 30);
        
        // Optimal
        scr.setPenColor(Draw.GREEN);
        scr.filledCircle(130, 242, 20); // Head
        scr.filledEllipse(130,300, 30, 40); // Body
        scr.filledRectangle(110,340, 10, 30); // Left Leg
        scr.filledRectangle(150,340, 10, 30);
        
        // Underweight scale
        scr.setPenColor(Draw.BLUE);
        scr.filledCircle(220, 242, 20); // Head
        scr.filledRectangle(220, 300, 10, 40); // Body
        scr.filledEllipse(210, 340, 5, 30); // Left Leg
        scr.filledEllipse(230, 340, 5, 30); // Right Leg 
        
        // Big Name on Graphics Screen
        scr.setPenColor(Draw.BLACK);
        Font bigNameFnt = new Font("TimesNewRoman", Font.BOLD, 60);
        scr.setFont(bigNameFnt);
        String name = "Vincent Nguyen";
        scr.text(340, 200, "" + name , 270);
        
        // Displays the result 
        int xPos = 10, yPos = 50;
        scr.setPenColor(Draw.RED);
        Font resultsFnt = new Font("Seriff", Font.PLAIN, 20);
        Font boldFnt = new Font("Seriff", Font.BOLD, 20);
        scr.setFont(resultsFnt);
        scr.textLeft(xPos, yPos, "Weight: " + weight);
        scr.textLeft(xPos, yPos + 20, "Height: " + height);
        scr.textLeft(xPos, yPos + 40, "BMI: " + roundedBMI);
        
        // Changes pen color to match the BMI index of overweight
        if(BMI > 18.5 && BMI < 25)
        {
            scr.setPenColor(Draw.GREEN);
        }
        else if(BMI < 18.5)
        {
            scr.setPenColor(Draw.BLUE);
        }
        else
        {
            scr.setPenColor(Draw.ORANGE);
        }
        scr.setFont(boldFnt);
        scr.textLeft(xPos, yPos + 60, message);
    }

    public static void massAndWeight()
    {   
        double mass, weight;
        String msg = "";
        System.out.print("\nEnter object's mass (kilograms) \n");
        Scanner keyboard = new Scanner(System.in);
        mass = keyboard.nextDouble();
        
        // Calculation
        weight = mass * 9.8;
        // Round up 
        double roundedWeight = Math.ceil(weight * 10) / 10;
        
        if(weight > 1000)
        {
            msg = "Object is too heavy.";
            if(weight < 10)
            {
                msg = "Object is too light.";
            }
        }
        else
        {
           msg = "You're object weights: "; 
        }
        
        System.out.println(msg);
        
        // Graphics screen  
        Draw graphics = new Draw(); 
        graphics.clear(Draw.GREEN);
        graphics.setTitle("Mass and Weight by Vincent Nguyen");
        Font nameFnt = new Font("Arial", Font.BOLD, 60);
        graphics.setFont(nameFnt);
        
        // Results display
        int xPos = 10, yPos = 50;
        graphics.textLeft(xPos, yPos, "Mass: " + mass);
        graphics.textLeft(xPos, yPos + 20, "Weight: " + weight); 
    }
}
