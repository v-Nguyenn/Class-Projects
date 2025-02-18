
/**
 * Description: Contains the main logic to play the game.
 * Rolls the dice and evaluates the game rules (win, lose, or continue).
 * 
 * @author Dylan Prutsok
 * @version 11/27/24
 */
public class DiceDemo1
{
    public static void main(String[] args)
    {
        System.out.println("Dice Game by Dylan");

        // Initialize dice and score array
        ThreeDiceDP dice = new ThreeDiceDP();
        int[] score = new int[20];
        for (int i = 0; i < score.length; i++) 
        {
            score[i] = 0;
        }

        // Play the game
        play(dice, score);
    }

    // Play the game based on the given rules
    public static void play(ThreeDiceDP dice, int[] score) 
    {
        dice.roll(); // First roll
        int firstTotal = dice.getDice(0);
        score[0] = firstTotal;

        // Check win/lose conditions for the first roll
        if (firstTotal == 10 || firstTotal == 11) 
        {
            printArray(score, "You win:");
            return;
        }
        else if (firstTotal >= 3 && firstTotal <= 8) 
        {
            printArray(score, "You lose:");
            return;
        }

        // Continue playing if the first roll is neither win nor lose
        int goal = firstTotal;
        for (int i = 1; i < score.length; i++)
        {
            dice.roll();
            int total = dice.getDice(0);
            score[i] = total;

            if (total == goal)
            {
                printArray(score, "You win:");
                return;
            }
            else if (total == 10 || total == 11)
            {
                printArray(score, "You lose:");
                return;
            }
        }

        // If the array is full, print the results and exit
        printArray(score, "Array is full:");
    }

    // Print the score array with formatting
    public static void printArray(int[] score, String message) 
    {
        System.out.println(message);
        for (int i = 0; i < score.length; i++)
        {
            if (i > 0 && i % 5 == 0) 
            {
                System.out.print(" - "); // Add separator every 5 scores
            }
            System.out.print(score[i] + " ");
        }
        System.out.println();
    }
}
