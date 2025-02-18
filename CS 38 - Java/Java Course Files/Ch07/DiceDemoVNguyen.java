import java.util.Scanner;

/**
 * Description
 * Dice Game that rolls three dice and determines win/loss conditions based on the total.
 * @author Vincent Nguyen
 * @version 11/27/24
 */
public class DiceDemoVNguyen
{
    public static void main(String[] args)
    {
        System.out.println("Dice Game by Vincent Nguyen");

        // Get the number of games from user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of games to play: ");
        int numOfGames = scanner.nextInt();

        // Run games based on user input
        for (int game = 1; game <= numOfGames; game++)
        {
            // Initialize dice and score array
            ThreeDiceVN dice = new ThreeDiceVN();
            int[] scores = new int[20];

            // Set each element in scores to 0
            for (int i = 0; i < scores.length; i++)
            {
                scores[i] = 0;
            }

            // Play the game and get the number of rolls
            int rolls = play(dice, scores);

            // Print the result (win or lose)
            if (scores[0] == 10 || scores[0] == 11)
            {
                System.out.print("You win:   ");
            }
            else
            {
                System.out.print("You lose:  ");
            }

            // Print scores (with zeroes for unused spots)
            printArray(scores);
        }

        // Close scanner after use
        scanner.close();
    }

    // Play the game and return the number of rolls it took to win/lose
    public static int play(ThreeDiceVN dice, int[] scores)
    {
        dice.roll();
        int total = dice.getDice(0); // Sum of all three dice
        int goal = 0;

        // Check win/loss conditions on the first roll
        if (total == 10 || total == 11)
        {
            scores[0] = total; // Win if first roll is 10 or 11
            return 1;
        }
        else if (total >= 3 && total <= 8)
        {
            scores[0] = total; // Lose if first roll is between 3-8
            return 1;
        }
        else
        {
            goal = total; // Otherwise, set goal
            scores[0] = total;
        }

        // Keep rolling until we match goal, roll 10/11, or fill array
        for (int i = 1; i < scores.length; i++)
        {
            dice.roll();
            total = dice.getDice(0);
            scores[i] = total;

            if (total == goal)
            {
                return i + 1; // Win if we match goal
            }
            else if (total == 10 || total == 11)
            {
                return i + 1; // Lose if roll is 10 or 11
            }
        }

        // If array is full, return length (game ends without win/lose)
        return scores.length;
    }

    // Print the scores array, formatting the output
    public static void printArray(int[] scores)
    {
        for (int i = 0; i < scores.length; i++)
        {
            System.out.printf("%3d", scores[i]); // Print each score with width 3 for alignment

            if ((i + 1) % 5 == 0 && i != scores.length - 1)
            {
                System.out.print(" - "); // Print dash after every 5 numbers
            }
        }
        System.out.println(); // Move to the next line after printing the array
    }
}
