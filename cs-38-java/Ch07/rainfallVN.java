
/**
 * Programming Challenge #1
 * This class keeps track of the total rainfall for 12 months using an array. 
 * It has methods to calculate yearly total, average monthly rainfall, 
 * and find the month with the most or least rain.
 * 
 * @author Vincent Nguyen
 * @version 12/09/24
 */
public class rainfallVN 
{
    private double[] totalRainfall; // Stores rainfall for 12 months

    /**
     * Default constructor - sets all monthly rainfall to 0
     */
    public rainfallVN() 
    {
        totalRainfall = new double[12]; // 12 months initialized to 0.0
    }

    /**
     * Constructor with user-provided rainfall data
     * @param monthlyRainfall Array with 12 monthly rainfall values
     */
    public rainfallVN(double[] monthlyRainfall) 
    {
        if (monthlyRainfall.length != 12) // Checks if the array has 12 values
        { 
            System.out.println("Invalid Input: Starting with default values.");
            totalRainfall = new double[12];
        } 
        else 
        {
            for (double rainfall : monthlyRainfall) 

            { // Check for negative values
                if (rainfall < 0) 
                {
                    System.out.println("Invalid Input: No negatives allowed.");
                    totalRainfall = new double[12];
                    return; // Exits early if input is not correct
                }
            }
            totalRainfall = monthlyRainfall; // Save valid data
        }
    }

    /**
     * Calculates total rainfall for the year
     * @return Total yearly rainfall
     */
    public double yearlyRainfall() {
        double total = 0;
        for (double monthRainfall : totalRainfall) // iterate through loop
        { 
            total += monthRainfall; // Add all the month values to a total
        }
        return total; // Return total rainfall
    }

    /**
     * Finds the average monthly rainfall
     * @return Average rainfall
     */
    public double avgMonthlyRainfall() {
        return yearlyRainfall() / totalRainfall.length; // Total / 12
    }

    /**
     * Finds the month with the most rain
     * @return Index of the month with the most rain (0 = Jan)
     */
    public double mostMonthlyRainfall() 
    {
        int maxIndex = 0;
        for (int i = 1; i < totalRainfall.length; i++) 
        {
            // Start at first value, iterate through the array, and 
            // update maxIndex if a larger value is found 
            if (totalRainfall[i] > totalRainfall[maxIndex]) 
            {
                maxIndex = i;
            }
        }
        return maxIndex; // Return index of the max value
    }

    /**
     * Finds the month with the least rain
     * @return Index of the month with the least rain 
     */
    public double leastMonthlyRainfall() {
        int minIndex = 0;
        for (int i = 1; i < totalRainfall.length; i++) 
        {
            // Start at first value, we assume it is the lowest,
            // iterate through the array and update minIndex if lower value is found.
            if (totalRainfall[i] < totalRainfall[minIndex])
            {
                minIndex = i;
            }
        }
        return minIndex; // Return index of the min value
    }

    /**
     * Accessor for rainfall data
     * @return Array of monthly rainfall
     */
    public double[] getRainfall() 
    {
        return totalRainfall; // Return the array
    }
}
