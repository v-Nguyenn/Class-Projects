
/**
 * Write a description of class CounterVN here.
 * Replace this later with CounterVN
 * @author (your name)
 * @version (a version number or a date)
 */
public class CounterVN
{
    // instance variables - replace the example below with your own
    private int count;
    
    public void reset()
    {
        count = 0;
    }
    
    public void click()
    {
        count = count + 1;
    }
    
    public int getCount()
    {
        int ans =count;
        return ans;
    }
}
