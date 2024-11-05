import java.util.Random;

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
public class DiceVN
{
    // fields. "What data do dice have?
    private int faceValue;

    // constructor
    public DiceVN()
    {
        
    }

    // mutators "What things can I do with dice?"
    public void setFaceValue(int newValue )
    {
        faceValue = newValue;
    }
    
    public void rollDice()
    {
        Random rnd = new Random( );
        faceValue  = rnd.nextInt(6) + 1;
    }

    // accessor
    public int getFaceValue()
    {
        int value = faceValue;
        return value;
    }

    public String toString()
    {
        String msg = "QQQ";
        return msg;
    }
}
