import java.awt.Font;
import java.util.Random;

/**
 * Description
 * 
 * Program 1
 * draws a beach house with last name N-S using graphics
 * 
 * Program 2
 * A dice game that iterates 10 times and determins a winner, 
 * drew some sick graphics 
 * 
 * @author: Vincent Nguyen
 * @version: 10/6/24
 */
public class beachhouseVincentNguyen
{
    public static void main(String[] args)
    {
    }

    public static void  beachhouseVincentNguyen()
    {
        // Set up graphics
        Draw scr = new Draw(); 
        scr.setXscale(0,400);
        scr.setYscale(400,0);
        scr.setTitle("Beach House by Vincent Nguyen");

        // Sky or background
        scr.setPenColor(176,220,229); // Light blue
        scr.filledRectangle(200,200,200,200);

        // Name on Screen
        scr.setPenColor(Draw.BLACK);
        Font nameFnt = new Font("Consolas", Font.PLAIN, 25);
        scr.setFont(nameFnt);
        scr.text (200,80, "Beach House by Vincent Nguyen", -25);

        // ocean
        scr.setPenColor(3,135,137); // teal
        scr.filledRectangle(200,280,200,120);

        // shadows around rocks
        // ellipse under dark blue rock
        scr.setPenColor(169,215,231); // light blue
        scr.filledEllipse(200,220,190,20);

        // ellipse under cobalt blue rock
        scr.setPenColor(64,165,173);
        scr.filledEllipse(280,260,100,15);

        // ellipse under bright blue polygon
        scr.setPenColor(136,200,210);
        scr.filledEllipse(120,340,180,40);

        // rocks
        scr.setPenColor(25,25,111); // dark blue rock
        double x[] ={0,200,340,0};
        double y[] ={20,100,220,220};
        scr.filledPolygon(x,y);

        scr.setPenColor(66,105,224); // cobalt blue rock
        double x1[] ={140,240,360,340};
        double y1[] ={260,180,220,260};
        scr.filledPolygon(x1,y1);

        scr.setPenColor(1,190,255); // bright blue rock
        double x2[] = {0,140,280,0};
        double y2[] = {220,200,340,340};
        scr.filledPolygon(x2,y2);

        // House
        scr.setPenColor(252,125,108); // pinkish Roof
        double x3[] = {80,140,160,100};
        double y3[] = {100,100,120,120};
        scr.filledPolygon(x3,y3);

        // Walls
        scr.setPenColor(164,165,167); // Grayish left wall
        double x4[] = {80,100,100,80};
        double y4[] = {100,120,140,140}; 
        scr.filledPolygon(x4,y4);

        scr.setPenColor(223,220,221); // whitish front wall
        double x5[] = {100,160,160,100};
        double y5[] = {120,120,160,160};
        scr.filledPolygon(x5,y5);

        // Ground on which the house is on
        scr.setPenColor(12,131,139); // teal mound
        double x6[] = {80,120,180,60};
        double y6[] = {140,140,160,160};
        scr.filledPolygon(x6,y6);
    }

    public static void dice_game()
    {
        // Set up Graphics
        Draw scr = new Draw() ;
        scr.setXscale(0,400);
        scr.setYscale(400,0);
        scr.setTitle("Dice game by Vincent Nguyen");
        Random random = new Random();

        System.out.print("User VS Computer");
        int user = 0;
        int computer = 0;
        int userWins = 0;
        int cpuWins = 0;
        int draws = 0;

        for(int i = 1; i <= 10; i++)
        {
            user = random.nextInt(6) + 1;
            computer = random.nextInt(6) + 1;
            if (user > computer)
            {
                userWins += 1;
            }
            else if (user < computer)
            {
                cpuWins += 1; 
            }
            else
            {
                draws += 1; 
            }
        }

        Font winnerName = new Font("Roboto", Font.BOLD, 45);

        // Display Results of game
        scr.setPenColor(176,220,229); 
        scr.filledRectangle(200,200,200,200);

        scr.setPenColor(125, 125, 125);
        scr.text(80,  50,  "Player wins: " + userWins);
        scr.text(200, 50,  "Draws: " + draws);
        scr.text(320, 50,  "Computer wins: " + cpuWins);

        // Checks if the user won first 
        if  (userWins > cpuWins)
        {   
            scr.setPenColor(Draw.WHITE);

            // Display User winner
            scr.text(200, 100, "WINNER");
            scr.setFont(winnerName);
            scr.text(200, 150, "PLAYER");

            scr.setPenColor (240, 188, 133); // tan
            scr.filledCircle(200, 250, 50);  // head
            scr.filledSquare(200, 300, 10);  // neck

            scr.setPenColor(0, 179, 87);
            double x1[] = {190, 160, 160, 240, 240, 210};
            double y1[] = {310, 360, 400, 400, 360, 310};
            scr.filledPolygon(x1, y1);
        }
        // Checks if the user and cpu drawed
        else if(userWins == cpuWins) 
        {
            scr.setPenColor(Draw.WHITE);

            // Display Draw
            scr.setFont(winnerName);
            scr.text(200, 150, "DRAW");

        } 
        else // Computer had to win
        {
            scr.setPenColor(Draw.WHITE);

            // Display Computer Winner
            scr.text(200, 100, "WINNER");
            scr.setFont(winnerName);
            scr.text(200, 150, "COMPUTER");

            scr.setPenColor(128, 128, 128); // monitor
            scr.filledRectangle(150, 250, 80, 40); // monitor screen
            scr.setPenColor(16, 21, 36);
            scr.filledRectangle(150, 250, 75, 35); // inside screen
            
            scr.setPenColor(128, 128, 128);
            double x2[] = {230, 300, 140, 70}; // Keyboard
            double y2[] = {290, 350, 350, 290};
            scr.filledPolygon(x2, y2);
        

        }
    }
}