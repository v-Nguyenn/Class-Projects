
/**
 * Description:
 * ______________________
 * ______________________
 * @author Vincent Nguyen
 * @version _____
 */
public class NxNDemoVNguyen
{
    public static void solve3x3( )
    {
        int count = 1;
        NxNVincentNguyen nXn = new NxNVincentNguyen( );
        nXn.printMe();
        boolean keepTrying = true;
        int i=1;
        while(keepTrying) 
        {
            if(count>1000)
            {
                count=0;
                System.out.println("\ntry #"+i);
                nXn.printMe();
            }
            nXn.randomize();
            //QQQ if all 3 rows, all 3 columns,
            //sum to the same, print
            //the solution and #tries and exit loop
            if(nXn.totalRow1( ) == 123)
            {
                keepTrying=false;
            }
            
            count++;
            i++;
        }
        System.out.println("Loop is finished");
    }

}