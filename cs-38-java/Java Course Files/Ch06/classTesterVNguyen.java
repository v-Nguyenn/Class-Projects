
/**
 * Write a description of class TesterVNguyen here.
 *
 * @author Vincent Nguyen
 * @version 10/31/24
 */
public class classTesterVNguyen
{
    public static void main(String[]args) 
    {
        
    }
    
    public static void testDice()
    { // "Instantiate two friends dice ofr a game"
        DiceVN joey = new DiceVN();
        DiceVN bob = new DiceVN();
        // you can roll the dice metods
        
        for(int count = 1; count <=10; count++)
        {
            joey.rollDice();
            bob.rollDice();
            System.out.println(count + ": " + joey.getFaceValue() + ", "
                                     + bob.getFaceValue());
            
        }
    }
    
    public static void testClock()
    {
        // instantiate a clock 
        ClockVN myWatch = new ClockVN();
        
        // Now we can call ClockVn methods
        myWatch.setHour(9);
        myWatch.setMinute(45);
        myWatch.setAmPm("pm");
        
        // Now we can call another method to check if correct
        String msg = myWatch.getTime();
        System.out.println(msg);
        
        for(int count = 1; count < 5; count++)
        {
            myWatch.advanceTime(5);
            msg = myWatch.getTime();
            System.out.println(msg);
        }
    }
    
    
}
