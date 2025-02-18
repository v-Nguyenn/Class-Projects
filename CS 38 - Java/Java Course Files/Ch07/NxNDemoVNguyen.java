import java.util.Random;
/**
 * Write a description of class NxNDemoVincentNguyen here.
 *
 * @author Vincent Nguyen
 * @version 11/27/24
 */
public class NxNDemoVNguyen {
    public static void main(String[] args) {
        Random rand = new Random();
        NxNVN grid = new NxNVN();
        int targetSum = -1;
        int tryCount = 0;

        while (true) {
            tryCount++;
            grid.shuffle();

            // Calculate row and column sums
            int rowSum0 = grid.sumRow(0);
            int rowSum1 = grid.sumRow(1);
            int rowSum2 = grid.sumRow(2);
            int colSum0 = grid.sumCol(0);
            int colSum1 = grid.sumCol(1);
            int colSum2 = grid.sumCol(2);

            // Check if all rows and columns have the same sum
            if (rowSum0 == rowSum1 && rowSum1 == rowSum2 &&
                rowSum0 == colSum0 && colSum0 == colSum1 && colSum1 == colSum2) {
                
                targetSum = rowSum0;
                System.out.println("try #" + tryCount + " Vincent Nguyen FOUND A SOLUTION =====");
                grid.printMe();
                System.out.println("All rows and columns sum to: " + targetSum);
                break;
            }

            // Print progress every million tries
            if (tryCount % 1000000 == 0) {
                System.out.println("Looking... Attempt #" + tryCount);
            }
        }
    }
}

