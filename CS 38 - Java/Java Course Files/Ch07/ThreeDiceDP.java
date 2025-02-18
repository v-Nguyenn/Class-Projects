
import java.util.Random;
/**
 * Description: 
 * Represents the three dice using a three-element array.
 * @author Dylan
 * @version 243110
 */
public class ThreeDiceDP
 {
    // Instance variables
    private int[] face; // Array to store values of the dice

    // Default constructor: Initializes each dice with a random value between 1 and 6
    public ThreeDiceDP() 
    {
        face = new int[3];
        roll(); // Randomize the dice
    }

    // Constructor with parameters to initialize the dice values
    public ThreeDiceDP(int k, int m, int n) 
    {
        face = new int[3];
        if (isValidValue(k) && isValidValue(m) && isValidValue(n)) 
        {
            face[0] = k;
            face[1] = m;
            face[2] = n;
        } 
        else
        {
            roll(); // Default to random values if validation fails
        }
    }

    // Accessor to get a specific dice value or the total
    public int getDice(int n)
    {
        if (n >= 1 && n <= 3)
        {
            return face[n - 1];
        } 
        else if (n == 0) 
        {
            return face[0] + face[1] + face[2]; // Return the total
        } 
        else 
        {
            return -1; // Invalid input
        }
    }

    // Mutator to set a specific dice value
    public void setDice(int n, int newValue)
    {
        if (n >= 1 && n <= 3 && isValidValue(newValue))
        {
            face[n - 1] = newValue;
        }
    }

    // Mutator to randomize the dice values
    public void roll() 
    {
        Random random = new Random();
        for (int i = 0; i < 3; i++) 
        {
            face[i] = random.nextInt(6) + 1; // Random values between 1 and 6
        }
    }

    // Converts the dice values to a string
    public String toString()
    {
        return face[0] + "" + face[1] + "" + face[2];
    }

    // Debug method to print the dice values
    public void printMe() 
    {
        System.out.println(toString());
    }

    // Helper method to validate dice values
    private boolean isValidValue(int value) 
    {
        return value >= 1 && value <= 6;
    }
}

