/**
 * This class validates if a number exists in a predefined
 * list of valid account numbers.
 *
 * Author: Vincent Nguyen
 * Date: 12/08/25
 */
public class ChargeAccValVN
{
    // array with list of valid account numbers
    private int[] validNums = {5658845, 4520125, 7895122, 8777541,
                               8451277, 1302850, 8080152, 4562555,
                               5552012, 5050552, 7825877, 1250255,
                               1005231, 6545231, 3852085, 7576651,
                               7881200, 4581002
                              };

    /**
     * Checks if a given number is valid (exists in the validNums array).
     *
     * @param number The number to validate.
     * @return true if the number is found, false otherwise.
     */
    public boolean isValid(int number) 
    {
        boolean found = false; // Tracks if the number is found
        int index = 0;         // Index to iterate through the array
        while(!found && index < validNums.length)
        {
            if (validNums[index] == number)
            {    
                found = true; // set flag to true if found
            }
            else
            {
                index++; // Move to the next index
            }
        }
        return found; // Return true if found, false otherwise
    }
}
