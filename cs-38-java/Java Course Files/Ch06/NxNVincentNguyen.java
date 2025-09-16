
/**
 * Class name: NxNVincentNguyen
 * Fields: 
 * Methods:   
 * Description:
 * This is a practice problem to prepare for Lab #2
 * using integers instead of arrays.
 * @author _____
 * @version _____
 */
import java.util.Random;

public class NxNVincentNguyen 
{
    // instance variables
    //private int[] ary;
    //private int[][] ary;
    //private ArrayList<Integer> ary;
    private int a,b,c;
    private int d,e,f;
    private int g,h,i;

    // constructor
    public NxNVincentNguyen( )
    {
        randomize(); 
    }

    /**
     * Method randomize
     *
     */
    public void randomize( )
    {
        Random ran = new Random();
        a = ran.nextInt(9)+1;
        b = ran.nextInt(9)+1;
        c = ran.nextInt(9)+1;
        
        d = ran.nextInt(9)+1;
        e = ran.nextInt(9)+1;
        f = ran.nextInt(9)+1;
        
        g = ran.nextInt(9)+1;
        h = ran.nextInt(9)+1;
        i = ran.nextInt(9)+1;
    }
    
    /**
     * Method toString
     *
     * @return The return value
     */
    public String toString()
    {
        // use toString method to return the NxN as a table
        String msg = a+" "+b+" "+c+"\n"
                    +d+" "+e+" "+f+"\n"
                    +g+" "+h+" "+i+"\n";

        return msg;
    }

    /**
     * Method printMe
     *
     */
    public void printMe()
    {
        System.out.println(toString());
        System.out.println("RowSum: "+totalRow1()+" "+totalRow2()+" "+totalRow3());
        System.out.println("ColSum: "+totalCol1()+" "+totalCol2()+" "+totalCol3());
    }
    
    public int totalRow1( )
    {
        int sum = a+b+c;
        return sum;
    }

    public int totalRow2( )
    {
        int sum = d+e+f;
        return sum;
    }

    public int totalRow3( )
    {
        int sum = g+h+i;
        return sum;
    }

    public int totalCol1( )
    {
        int sum = 123;
        return sum;
    }

    public int totalCol2( )
    {
        int sum = 123;
        return sum;
    }

    public int totalCol3( )
    {
        int sum = 123;
        return sum;
    }

    public int addCol(int cc)
    {
        // add the values in each of the columns
        int sum = 123;
        return sum;
    }
}
