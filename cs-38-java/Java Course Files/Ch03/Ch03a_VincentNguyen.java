import java.awt.Font;
import java.util.Scanner;
import java.util.Random;

/**
 * Description 
 * ____________
 * ____________
 * @author Vincent Nguyen
 * @version 09/12/24
 */
public class Ch03a_VincentNguyen
{
    public static void main(String[] args)
    {

    }
    // Explain: This code is trying to get mom's and dad's age from
    // the keyboard, but is hardcoded in so we have to change that
    
    // The code wants to print who is older and each of their ages
    // but prints blank because they are the same right now
    public static void ifMomDad()
    {
        Scanner keyboard = new Scanner(System.in);
        int momAge, dadAge;
        System.out.print("Mom's age: ");
        momAge = keyboard.nextInt();
        
        System.out.print("Dad's age: ");
        dadAge = keyboard.nextInt();

        if( momAge > dadAge )
        {
            System.out.println("Mom is older");
        }
        if( dadAge > momAge )
        {
            System.out.println("Dad is older");
        }
        // What if they are same age?
        if( dadAge == momAge)
        {
            System.out.println("They are the same age");
        }
    }
    // Explain we want to set an if statement to check if dad's age
    // is equal to mom's age
    
    // Explain: This code takes input from the keyboard to generate
    // a random number of males and lets the computer to determine
    // a random number of females of (50) Then the number is 
    // compared and prints the number of males and females as well 
    // who has more on a graphics screen.
    
    public static void ex03()
    {
        Scanner keyboard = new Scanner(System.in); 
        Random rand = new Random();

        System.out.print("Enter number of males, ex 24: ");
        int numMale = keyboard.nextInt();

        int numFemale = rand.nextInt(50); //let computer pick it
        System.out.println("Number of females: "+numFemale);

        if(numMale > numFemale)
        {
            System.out.println("More males");
        }
        else
            System.out.println("More females");

        Draw win = new Draw();
        win.clear(Draw.LIGHT_GRAY);
        Font fnt = new Font("Arial", Font.BOLD, 64);
        win.setFont( fnt );
        win.setXscale(400,0);
        win.setYscale(0,400);
        if(numMale > numFemale)
        {
            win.clear(Draw.BLUE);
            fnt = new Font("Georgia", Font.BOLD, 64);
            win.setPenColor(Draw.WHITE);
            win.setFont(fnt);
            win.text(200, 200, "More Males", 0);
        }
        else
        {
            win.clear(Draw.PINK);
            fnt = new Font("Georgia", Font.BOLD, 64);
            win.setPenColor(Draw.WHITE);
            win.setFont(fnt);
            win.text(200, 200 ," More Females", 0);   
        }
    }  

    //ref pg220 count-control loop, four examples ====
    //Explain:
    //
    public static void if05()
    {
        //Use this to repeat instructions
        for(int count=1; count<=10; count=count+1)
        {
            //123 print your name
        }
    }

    //Explain:
    //
    public static void if06()
    {
        //Use this to repeat instructions
        for(int count=1; count<=10; count=count+1)
        {
            //123 print count all on ONE LINE
        }
    }

    //Explain:
    //
    public static void if07()
    {
        Draw yi = new Draw( );
        //Use this to repeat instructions
        for(int count=1; count<=10; count=count+1)
        {
            System.out.print(count + " ");
            yi.pause(1000);
        }
    }

    //Explain:
    //
    public static void if12( )
    {
        //ref if-else if-else
        Draw yi=new Draw( );
        yi.clear(Draw.WHITE);
        yi.setXscale(0,400);
        yi.setYscale(400,0);
        yi.setTitle("Top half is ___, else ___ by YName");

        Scanner keyboard = new Scanner(System.in);
        int x, y;
        for(int count=5; count>0; count=count-1)
        { 
            String msg = count + ") enter x and y, ex 50 140: "; 
            System.out.print( msg );
            x = keyboard.nextInt( );
            y = keyboard.nextInt( );

            //Draw cyan circle on left, red rectangle on right
            if( 123<123 )
            {
                //123 draw a solid cyan circle                
            }
            else
            {
                //123 draw solid red rectangle                
            }
        }
    }

   
   
    public static void nervousEyes( )
    {
    }
    
    public static void StringEx()
    {
        //                       0123456789101112)
        String abc = new String("unforgetable"); // u is at index 0
        // Words are for, get, forget, table, able, others
        String word = " ";
        
        // Explain why 2 to 5?
        // the first number (_,_) is the starting index
        // the second number goes to that point in the 
        // index and returns that value
        word = abc.substring(2,5); 
        System.out.print("\nword: " + word);
        
        word = abc.substring(5,8);
        System.out.print("\nword: " + word);  
        
        word = abc.substring(2,8);
        System.out.print("\nword: " + word);
        
        word = abc.substring(8,12);
        System.out.print("\nword: " + word);
        
        // new command
        // Explain: if you have a single number in 
        // in the substring, it means start from that index
        // and get everything to the end
        word = abc.substring(8);
        System.out.print("\nword: " + word);
    }
    
    // We decided to work on the word candidate
    // My partners are Dylan and Ivan
    public static void subStringWithDylanIvan()
    {
        // Word we chose was candidate and we did our own way
        // of breaking the work up
        
        // I decided to break the word up into can, did, date
        // ,candid, didate (single number)
        
        //                       012345678
        String abc = new String("candidate");
        String word = " ";
        System.out.print("\n" + abc);
        
        word = abc.substring(0,3);
        System.out.print("\nword: " + word);
        
        word = abc.substring(3,6);
        System.out.print("\nword: " + word);
        
        word = abc.substring(5,9);
        System.out.print("\nword: " + word);
        
        word = abc.substring(0,6);
        System.out.print("\nword: " + word);
        
        word = abc.substring(6);
        System.out.print("\nword: " + word);
    }
    
    public static void string2Ex()
    {
        String word = new String("candidate");
        // Words from group activity
        // can, did, date, candid
        int pos;
        pos = word.indexOf( "can");
        System.out.println("\npos of can: " + pos);
        
        pos = word.indexOf ("did");
        System.out.println("pos of did: " + pos);
        
        pos = word.indexOf ("date");
        System.out.println("pos of date: " + pos);
        
        pos = word.indexOf ("candid");
        System.out.println("pos of candid: " + pos);
        
        // Explain
        // This gives a negative one because it cannot find the 
        // word. That means this is case sensitive so Ate != ate
        pos = word.indexOf ("Ate" );
        System.out.println("pos of Ate: " + pos);
        
        /*
         * Results
        pos of can: 0
        pos of did: 3
        pos of date: 5
        pos of candid: 0
        pos of Ate: -1
         */   
    }
    
    public static void string3Ex()
    {
        String w1 = "unforget";
        String w2 = "Unforget";
        String w3 = "unforgotten";
        
        System.out.println("Is w1 same as w2: " 
        + w1.equalsIgnoreCase( w2) );
        boolean same;
        same  = w1.equals( w2 );
        System.out.println("Same if you don't ignore case? " 
        + same);
        
        same = w1.equals( w3); // should be false
        System.out.println("are w1 & w3 the same? " + same);
        
        
        // ans = w1.compareTo says this:
        // if negative num -> in alphebetical order
        // if 0 - > they are the same
        // if positive -> They are in reverse order
        int results;
        results = w1.compareTo( w2 );
        System.out.println("compare w1, w2: "+ results);
    }
    
    public static void simpleLoop()
    {
        Draw scr = new Draw();
        scr.setXscale(0,400);
        scr.setYscale(400,0);
        scr.clear(Draw.YELLOW);
        
        Random ran = new Random();
        scr.setPenColor(Draw.BLUE);
        for(int count =1; count<=123; count++)
        {
            System.out.println("Hello" + count);
            System.out.println("Everyone" ); 
            double x,y;
            x = ran.nextInt(400);
            y = ran.nextDouble() * 400; // random integer from 0 to 400
            scr.filledCircle(x,y, 10);
            scr.pause(500);
        }
    }
}
