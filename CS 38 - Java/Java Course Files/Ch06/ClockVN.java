
/**
 * Description
 * Ref: Module02 Fundamentals, 
 *      Java Templates & BlueJ Intro
 * Class name:
 * Fields:
 * Methods: 
 * @author Vincent Nguyen
 * @version 10/31/24
 */
public class ClockVN
{
    // fields
    private int hour;
    private int minute;
    private String amPm;

    // constructor
    public ClockVN()
    {
        
    }

    // mutators 
    public void setHour(int newValue)
    {
        hour = newValue;
    }

    // accessor
    public void setMinute(int newValue)
    {
        minute = newValue;
    }

    public void setAmPm(String newValue)
    {
        amPm = newValue;
    }
    
    /**
     *  Method advanceTime
     *  Note: what happens if it goes over 59??
     *  @param update minute to an additional newMinutes
     */
    public void advanceTime(int newMinutes)
    {
        minute += newMinutes;
    }
    
    /**
     *  Method getTime
     *  
     *  @return The time in this format "8:32 am"
     */
    public String getTime()
    {
        String value = hour + ":" + minute + amPm;
        return value;
    }
}
