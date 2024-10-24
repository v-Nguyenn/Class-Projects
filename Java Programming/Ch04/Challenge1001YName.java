import java.util.Scanner;
import java.awt.Font;
import java.io.*;
/**
 * Description 
 * 
 * @author YName
 * @version MM/DD/YYYY
 */
public class Challenge1001YName
{
    public static void main(String[] args)
    {
    }

    //Read a string from the keyboard and print the characters in 
    //reversed order on a black graphics screen. For example entering 
    //"Irvine Valley College" displays "egelloC yellaV enivrI" in large
    //fonts. Choose an RGB color, not one of the default colors that 
    //can contrast well on the black background. You must have your name 
    //on the title bar and somewhere else on the screen.
    public static void reverseMe()
    {
        Draw win = new Draw();
        win.setTitle("Reverse Me by YName");
        
        win.setXscale(0, 400);
        win.setYscale(400, 0);
        win.clear(Draw.BLACK);
        
        Font fnt = new Font("Arial", Font.PLAIN, 32);
        win.setFont(fnt);
        win.setPenColor(0, 0, 0);
        win.text(200, 20, "YName");
        
        String word, reverse = "";
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a word: ");
        word = input.nextLine();
        
        for(int i = word.length() - 1; i >= 0; --i)
            reverse += word.charAt(i);
        
        System.out.println(reverse);
        win.text(200, 200, reverse);
    }

    //Read a start integer from the keyboard between 10 and 30. 
    //Read an end  integer from the keyboard between 45 and 55. 
    //Use a while loop to validate numbers are in the correct range
    //as described in your textbook.
    //Print on the terminal and graphics screen all integers between
    //start and end. Use a new font you haven't used before.
    public static void startToEnd()
    {
        Draw win = new Draw();
        win.setTitle("Start To End by YName");
        
        win.setXscale(0, 400);
        win.setYscale(400, 0);
        
        Font fnt = new Font("Serif", Font.PLAIN, 32);
        win.setFont(fnt);
        win.text(200, 20, "YName");
        
        fnt = new Font("Serif", Font.PLAIN, 24);
        win.setFont(fnt);
        
        String numRange = "";
        int start = 0, end = 0, counter = 0, printLine = 10, newLine = 20;
        Scanner input = new Scanner(System.in);
        
        while(start < 10 || start > 30) {
            System.out.print("Enter start number between 10 and 30: ");
            start = input.nextInt();
            
            if(start < 10 || start > 30)
                System.out.println("Invalid number.\n");
        }
        
        while(end < 45 || end > 55) {
            System.out.print("Enter end number between 45 and 55: ");
            end = input.nextInt();
            
            if(end < 45 || end > 55)
                System.out.println("Invalid number.\n");
        }
        
        for(int i = start + 1; i < end; ++i) {
            if(counter++ == printLine) {
                System.out.println();
                win.textLeft(10, newLine += 40, numRange);
                printLine += 10;
                numRange = "";
            }
            System.out.print(i + " ");
            numRange += i + " ";
        }
        
        System.out.println();
        win.textLeft(10, newLine += 40, numRange);
    }

    //Same as above but write the numbers into a file "startToEndYName.txt"
    public static void fileWriteStartToEnd() throws IOException
    {
        int start = 0, end = 0, counter = 0, printLine = 10;
        Scanner input = new Scanner(System.in);
        PrintWriter outFile = new PrintWriter("startToEndYName.txt");
        
        while(start < 10 || start > 30) {
            System.out.print("Enter start number between 10 and 30: ");
            start = input.nextInt();
            
            if(start < 10 || start > 30)
                System.out.println("Invalid number.\n");
        }
        
        while(end < 45 || end > 55) {
            System.out.print("Enter end number between 45 and 55: ");
            end = input.nextInt();
            
            if(end < 45 || end > 55)
                System.out.println("Invalid number.\n");
        }
        
        for(int i = start + 1; i < end; ++i) {
            if(counter++ == printLine) {
                outFile.println();
                printLine += 10;
            }
            outFile.print(i + " ");
        }
        
        outFile.close();
    }
    
    //Read the file studentByYName.txt and print only the name and
    //GPA of students who between 2.00 and 2.99 gpa
    public static void fileCstudents() throws IOException
    {
        Scanner inFile = new Scanner(new File("studentsByYName.txt"));
        
        while(inFile.hasNext()) {
            String line = inFile.nextLine();
            
            int start = line.indexOf("GPA") + 4;
            int end = line.indexOf(",", start);
            double gpa = Double.valueOf(line.substring(start, end));
            
            if(gpa >= 2.00 && gpa <= 2.99)
                System.out.println(gpa + " " + line.substring(line.indexOf("Name:") + 6));
        }
        
        inFile.close();
    }
}