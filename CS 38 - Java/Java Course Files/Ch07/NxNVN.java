import java.util.Random;

public class NxNVN {
    // Instance variable: 2D array to store the 3x3 grid
    private int[][] array;

    // Constructor: Initializes the 3x3 array with random two-digit numbers, no duplicates
    public NxNVN() {
        array = new int[3][3];
        fillArrayWithUniqueRandoms();
    }

    // Fills the 3x3 array with random two-digit numbers without duplicates
    private void fillArrayWithUniqueRandoms() {
        Random rand = new Random();
        boolean[] usedNumbers = new boolean[90]; // Array to track used numbers (10-99)

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num;
                do {
                    num = rand.nextInt(90) + 10; // Generate a two-digit number (10-99)
                } while (usedNumbers[num - 10]);

                usedNumbers[num - 10] = true;
                array[i][j] = num;
            }
        }
    }

    // toString() method: Returns a string representation of the 3x3 array
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : array) {
            for (int num : row) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // printMe() method: Prints the 3x3 array with row sums and column sums
    public void printMe() {
        System.out.println("Array:");
        System.out.println(this.toString());

        System.out.print("Row Sums: ");
        for (int i = 0; i < 3; i++) {
            System.out.print(sumRow(i) + " ");
        }
        System.out.println();

        System.out.print("Column Sums: ");
        for (int i = 0; i < 3; i++) {
            System.out.print(sumCol(i) + " ");
        }
        System.out.println("\n");
    }

    // sumRow(int num): Returns the sum of elements in a specific row
    public int sumRow(int num) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += array[num][i];
        }
        return sum;
    }

    // sumCol(int num): Returns the sum of elements in a specific column
    public int sumCol(int num) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += array[i][num];
        }
        return sum;
    }

    // shuffle(): Randomly reloads the 3x3 table with new two-digit numbers
    public void shuffle() {
        fillArrayWithUniqueRandoms();
    }
}
