import java.util.Random;

/**
 * Description
 * Ref: Module02 Fundamentals, 
 *      Java Templates & BlueJ Intro
 * Class name:
 * Fields:
 * Methods: 
 * @author Vincent Nguyen
 * @version 11/27/24
 */
public class ThreeDiceVN {
    // fields: array to hold dice values
    private int[] faceValues;

    // Default Constructor: sets random values 1 - 6 for each dice
    public ThreeDiceVN() {
        faceValues = new int[3];
        roll();
    }

    // Constructor with parameters: checks sets initial face values
    public ThreeDiceVN(int k, int m, int n) {
        faceValues = new int[3];
        if (checkDice(k) && checkDice(m) && checkDice(n)) {
            faceValues[0] = k;
            faceValues[1] = m;
            faceValues[2] = n;
        } else {
            System.out.println("Not a dice value. Random dice values used.");
            roll();
        }
    }

    // Mutators
    public void setDice(int n, int newValue) {
        if (n >= 1 && n <= 3 && checkDice(newValue)) {
            faceValues[n - 1] = newValue;
        } else {
            System.out.println("Wrong input for setDice, nothing changed.");
        }
    }

    public void roll() {
        Random rndNum = new Random();
        for (int i = 0; i < faceValues.length; i++) {
            faceValues[i] = rndNum.nextInt(6) + 1;
        }
    }

    // Accessors
    public int getDice(int n) {
        if (n >= 1 && n <= 3) {
            return faceValues[n - 1];
        } else if (n == 0) {
            return faceValues[0] + faceValues[1] + faceValues[2];
        } else {
            System.out.println("Wrong input for setDice, nothing changed.");
            return 0;
        }
    }

    public String toString() {
        return "" + faceValues[0] + faceValues[1] + faceValues[2];
    }

    public void printMe() {
        System.out.println(toString());
    }

    // Helper method to validate dice values
    private boolean checkDice(int value) {
        return value >= 1 && value <= 6;
    }
}
