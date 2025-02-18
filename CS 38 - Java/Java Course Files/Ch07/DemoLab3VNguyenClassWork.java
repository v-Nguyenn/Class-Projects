import java.util.Random;
import java.awt.Font;

// method showGrid()
/**
 * Description 
 * ____________
 * ____________
 * @author Vincent Nguyen
 * @version 11/27/24
 */
public class DemoLab3VNguyenClassWork
{
    public static void main(String[] args)
    {
        Draw scr = new Draw();
        demoBackground(scr);
        demo1(scr);

    }

    public static void demo1(Draw scr)
    {
        Random ran = new Random();
        int size = 50;
        //STEP 1-Create the array of OrnamentYI
        OrnamentVN[] circ = new OrnamentVN[size];

        for(int i=0; i<size; i++)
        {
            //STEP 2-Put an ornament into the array
            circ[i] = new OrnamentVN(scr);

            //Now show the ornaments 123
        }

        //animate
        boolean keepRunning = true;
        while(keepRunning)
        {
            int index = ran.nextInt(size);
            circ[index].randomColor( scr );

            scr.pause(1234);
            //QQQ check mouse press and take action if needed
            if( scr.isMousePressed() )
            {
                double x = scr.mouseX();
                double y = scr.mouseY();
                if(x>350 && y<50)
                {
                    keepRunning=false;
                }
                else if(x==123)
                {

                }
                else if(x==123)
                {

                }
                else if(x==123)
                {

                }
            }
        }
        scr.setPenColor(Draw.GRAY);
        scr.filledRectangle(200,100,200,100);
        scr.setPenColor(Draw.WHITE);
        scr.text(200,100,"Fall 2024 Project by VNguyen");
    }

    /**
     * Demo how to place ornaments in specific x,y
     *
     */
    public static void demo2( )
    {
        Draw scr = new Draw();
        setup( scr );
        Random ran = new Random();
        int size = 9;
        OrnamentVN[] circ = new OrnamentVN[size];

        int newRadius = ran.nextInt(5,20);
        int xOrn,yOrn;
        // line 87 - 100 locations of ornaments
        xOrn=25; yOrn=25; // change this for the location
        // could also use an overload constructor
        circ[0] = new OrnamentVN(scr);
        circ[0].setXY(scr,xOrn,yOrn);
        circ[0].randomColor( scr );

        xOrn=50; yOrn=25;
        circ[1] = new OrnamentVN(scr);
        circ[1].setXY(scr,xOrn,yOrn);
        circ[1].randomColor( scr );
        xOrn=75; yOrn=25;
        circ[2] = new OrnamentVN(scr);
        circ[2].setXY(scr,xOrn,yOrn);
        circ[2].randomColor( scr );

        xOrn=25; yOrn=75;
        circ[3] = new OrnamentVN(scr);
        circ[3].setXY(scr,xOrn,yOrn);
        circ[3].randomColor( scr );
        xOrn=50; yOrn=75;
        circ[4] = new OrnamentVN(scr);
        circ[4].setXY(scr,xOrn,yOrn);
        circ[4].randomColor( scr );
        xOrn=75; yOrn=75;
        circ[5] = new OrnamentVN(scr);
        circ[5].setXY(scr,xOrn,yOrn);
        circ[5].randomColor( scr );

        xOrn=25; yOrn=125;
        circ[6] = new OrnamentVN(scr);
        circ[6].setXY(scr,xOrn,yOrn);
        circ[6].randomColor( scr );
        xOrn=50; yOrn=125;
        circ[7] = new OrnamentVN(scr);
        circ[7].setXY(scr,xOrn,yOrn);
        circ[7].randomColor( scr );
        xOrn=75; yOrn=125;
        circ[8] = new OrnamentVN(scr);
        circ[8].setXY(scr,xOrn,yOrn);
        circ[8].randomColor( scr );

        //Above, all the ornaments are placed. Now show the ornaments
        for(int i=0; i<circ.length; i++)
        {
            circ[i].drawMe(scr);
        }

        //animate
        int waitTime = 500; // 1/2 sec
        boolean keepRunning = true;
        while(keepRunning)
        {
            int index = ran.nextInt(size);
            circ[index].randomColor(scr);
            circ[index].drawMe(scr);

            scr.pause(waitTime);
            if( scr.isMousePressed())
            {
                double x = scr.mouseX();
                double y = scr.mouseY();
                if(x>370 && y < 30) //top right
                {
                    keepRunning=false;
                }
            }
            scr.setPenColor(Draw.GRAY);
            scr.filledRectangle(200,123,200,123);
            scr.setPenColor(Draw.WHITE);

            scr.text(200,100,"Fall 2024 Demo2 Project by YName");
        }
    }

    /**
     * A tester to  draw an array of ornaments of
     * random size and position with a random colors.
     * NO ANIMATION.
     * Click top right exits program.
     */
    public static void demo3()
    {
        Draw scr = new Draw();
        setup( scr );
        Random ran = new Random();
        int size = 9;
        OrnamentVN[] circ = new OrnamentVN[size];
        for(int i=0; i<size; i++)
        {
            int newRadius = ran.nextInt(5,20);
            circ[i] = new OrnamentVN(scr);
            circ[i].setRadius( scr, newRadius );
        }

        //Above, all the ornaments are in the array. Now show the ornaments
        for(int i=0; i<123; i++)
        {

        }

        //animate
        int waitTime = 50;
        boolean keepRunning = true;
        while(keepRunning)
        {
            scr.pause(waitTime);
            if( scr.isMousePressed() )
            {
                double x = scr.mouseX();
                double y = scr.mouseY();
                if(x==123) //top right
                {
                    keepRunning=false;
                }
                else if(x==123)
                {// this is optional

                }
            }
        }
        scr.setPenColor(Draw.GRAY);
        scr.filledRectangle(200,100,200,100);
        scr.setPenColor(Draw.WHITE);

        scr.text(200,100,"Fall 2024 Project by VNguyen");
    }

    /**
     * A tester to draw an array of ornaments of
     * random size and position with a random colors.
     * HAS ANIMATION.
     * Click top right exits program.
     */
    public static void animateOrnaments()
    {

    }

    /**
     * A tester to draw an array of ornaments of
     * random size and position.
     * Click top right exits program.
     * Click along the bottom line to change animation rate
     */
    public static void randOrnaments( )
    {
    }

    public static void setup(Draw scrn)
    {
        scrn.setTitle("Lab Project Task #3 by VNguyen");
        scrn.setXscale(0,400);
        scrn.setYscale(400,0);
    }

    public static void title(Draw canvas)
    {
        canvas.setPenColor();
        canvas.text(200,50,"To Mom and Dad, a merry Christmas");
    }

    public static void demoBackground(Draw scr)
    {
        setup(scr);

        //sky
        scr.setPenColor(Draw.CYAN);
        scr.filledRectangle(200,100,200,100);
        title(scr);

        //ground
        scr.setPenColor(Draw.GREEN);
        scr.filledRectangle(200,300,200,100);

        //show gridline to help draw trees, remove later
        showGrid(scr,50,50);

        //tree
        scr.setPenColor(Draw.BLUE);   //leaves
        double[] x = {125, 175, 75};
        double[] y = {200, 350, 350};
        scr.filledPolygon( x,y );
        scr.setPenColor(Draw.RED);    //trunk
        scr.filledRectangle(125,365,  10,15);
        scr.setPenColor(Draw.WHITE);  //cap
        scr.filledCircle(125,195,10);
        //showTree(yName,50,225);
        //showTree(yName,200,200);
        //showTree(yName,300,300);

    }

    public static void showTree(Draw scr, int xCenter, int yCenter)
    {
        scr.setPenColor(Draw.YELLOW);
        double hWidth = 40;
        double hHeight= 75;

        double[] xTree = {123, 123, 123};
        double[] yTree = {123, 123, 123};
        scr.filledPolygon(xTree, yTree);

        //trunk
        scr.setPenColor(162, 45, 45);
        //scr.filledRectangle();

        //cap
        scr.setPenColor(Draw.WHITE);
        //scr.filledCircle();
    }

    public static void showGrid(Draw scr, int xSize, int ySize)
    {
        scr.setPenColor(Draw.BLACK);
        for(int x=0; x<=400; x+=xSize)
        {

        }
        for(int y=400; y>=0; y-=ySize)
        {

        }
    }
}
