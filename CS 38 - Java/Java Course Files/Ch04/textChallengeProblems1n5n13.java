import java.util.Scanner;
import java.io.*;
/**
 * Description
 * 
 * Programming Challenge #1
 * write a program that asks the user for a number then adds 
 * those numbers
 * 1. sumOfNumbers()
 * 
 * Programming Challenge #5
 * write a program that enters a string, then a character, checks
 * how many time that character shows up in the string
 * 2. letterCounter()
 * 
 * Programming Challenge #13
 * Asks the user for a name of a file then displays the first 
 * five lines, it should display the file's entire content
 * 3. fileHeadDisplay()
 *
 * @author (Vincent Nguyen)
 * @version (10/13/24)
 */
public class textChallengeProblems1n5n13
{
    public static void main(String[] args){

    }

    // Programming Challenge #1
    public static void sumOfNumbers()
    {
        // Declare variables
        int count = 0, userInput, sumTotal = 1;

        // Asks for users input
        System.out.println("----------------------------------------");
        System.out.print("Enter a positive nonzero integer value: ");
        Scanner keyboard = new Scanner(System.in);
        userInput = keyboard.nextInt();
        System.out.println("----------------------------------------");
        keyboard.nextLine(); // remove white space from enter

        for(count = 2; count <= userInput; count++){
            // System.out.println("value of count: " + count);
            // System.out.println("value of total: " + sumTotal);
            // System.out.println("Count added to Total");

            sumTotal += count;
            // System.out.println("Final Total sum: " + sumTotal + "\n");            
        }
        System.out.println("Final Total sum: " + sumTotal + "\n");            
    }

    // Programming Challenge #5
    public static void letterCounter()
    {
        String stringInput = "";
        char charInput;
        int count = 0;
        Scanner keyboard = new Scanner(System.in);

        // Asks user for a string
        System.out.print("Enter a string: ");
        stringInput = keyboard.nextLine();
        stringInput = stringInput.toLowerCase();

        // Asks user for a character
        System.out.print("Enter a character you want to count: ");
        charInput = keyboard.next().charAt(0);
        charInput = Character.toLowerCase(charInput); 

        // Iterate through string to find the amount letters
        // add to count if letter is found
        for(int i = 0; i < stringInput.length(); i++)
        {
            if(stringInput.charAt(i) == charInput){
                count++;
            }
        }
        // Show results in terminal
        System.out.println("Word: " + stringInput);
        System.out.println("The amount of " + charInput +
            "'s is " + count); 
    }

    // Programming Challenge #13
    public static void fileHeadDisplay() throws IOException
    {
        String userInput = "";
        Scanner keyboard = new Scanner(System.in); 

        // Ask user for which file
        userInput = keyboard.nextLine(); 

        File userFile = new File(userInput);
        Scanner readFile = new Scanner(userFile);

        int lineNumber = 1;

        while(readFile.hasNext() && lineNumber < 5)
        {
            String oneLine = readFile.nextLine();
            System.out.println(lineNumber + ": " + oneLine);
            lineNumber++;
        }
        readFile.close();
    }
}
