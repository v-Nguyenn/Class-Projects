
/**
 * This class provides a method to display numbers in an array 
 * that are greater than a given value n.
 *
 * Author: Vincent Nguyen
 * Date: 12/08/25
 */
public class largerThanNVN {

    /**
     * Prints all numbers in the array that are larger than n.
     *
     * @param array The array of integers to check.
     * @param n The value to compare against.
     */
    public static void displayNumLargerthanN(int[] array, int n) 
    {
        System.out.println("Numbers greater than " + n + ":");
        
        // Loop through the array
        for (int num : array) 
        {
            // Check if the number is larger than n
            if (num > n) 
            {
                System.out.println(num); // prin|
            }
        }
    }
}
