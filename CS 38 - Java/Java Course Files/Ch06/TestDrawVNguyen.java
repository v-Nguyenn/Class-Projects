
/**
 * Description 
 * ____________
 * ____________
 * @author Vincent Nguyen   
 * @version 10/31/24
 */
public class TestDrawVNguyen

{ //"Instantiate two Draw Objects, scrn1 and scrn2"
    public static void main(String[] args)
    {
        Draw    scrn1 = new Draw( );
        Draw    scrn2 = new Draw( );
        
        //Draw method examples. 
        //scrn2 has yellow background, wait 10secs
        scrn2.clear(Draw.YELLOW);
        scrn2.pause(10000);
        
        //scrn1 has green background, draw a ring near at (100,100)
        scrn1.clear(Draw.GREEN);
        scrn1.setPenColor(Draw.BLACK);
        scrn1.circle(100, 100, 25);
    }
}



