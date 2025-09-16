import java.util.Scanner;   // Needed for Scanner class

/**
This program shows values being stored in an array's
elements and displayed.
 */

public class ArrayDemoVNguyen
{
    public static void main(String[] args)
    {
        final int EMPLOYEES = 3;           // Number of employees
        int[] hours = new int[EMPLOYEES];  // Array of hours

        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in); 

        System.out.println("Enter the hours worked by 3 employees. ");

        // Get the hours worked by employee 1.
        System.out.print("Employee 1: ");
        hours[0] = keyboard.nextInt();

        // Get the hours worked by employee 2.
        System.out.print("Employee 2: ");
        hours[1] = keyboard.nextInt();

        // Get the hours worked by employee 3.
        System.out.print("Employee 3: ");
        hours[2] = keyboard.nextInt();

        // Display the values entered.
        System.out.println("The hours you entered are:");
        System.out.println(hours[0]);
        System.out.println(hours[1]);
        System.out.println(hours[2]);
    }

    public static void demoArrayA()
    {
        // lets associate gpa, age, and name
        double[] gpa = {2.2, 2.8, 3.2, 3.8, 4.0};
        // similar to gpa0 = 2.2, gpa1 = 2.8 ect

        int[] age = {33, 55, 22, 11, 77, 33};
        // can also do int age[] = {};

        String[] name  = {"Ed", "Jill", "Mark", "Bo", "Kyle", "Dan"};
        // similar to below, an array of names. This is easier than
        // doing the following below.

        String bro = "Ed";
        String sis = "Jill";
        String dad = "Mark";
        String uncle = "Bo";
        String pal = "Kyle";

        // How old is the first person?
        System.out.println(name[0] + " is " + age[0]);

        // What is the last person's gpa? How old is this person?
        System.out.println(name[5] + " is " + age[5] + " years olds");

        // What is the total age?
        // Adding all the indexes hard code
        int totalAge = age[0] + age[1] + age[2] + age[3] + age[4] + age[5];

        // Adding the total age together through A for loop
        int sumAge = 0; // add the age starting from the last index
        for(int i = 5; i >= 0; i--)
        {
            sumAge += age[i];
        }

        // Adding the total age through a while loop
        int ageSum = 0;
        int pos = 0;
        while(pos <= 5) //also works is while(pos < age.length)
        {
            ageSum = ageSum + age[pos];
            pos++;
        }

        // This should print the same values for all three
        System.out.println("The total age solved 3 ways: " + 
            totalAge + " , " + sumAge + " , " + ageSum);

        // What is the average age? It's the total divided by length
        // Note: ageSum/age.length won't give you an accurate value
        // we add by 0.0 so that age Sum becomes a double
        double averageAge  = (0.0 + ageSum)/age.length;
        System.out.println("Average age = " + averageAge);
    }

    public static void demoArrayB()
    {
        // Step 1: Array of 10 individual dice is declared
        DiceVN[] pieces = new DiceVN[5]; // how big it is

        // Step 2: is to put th objects in the array
        pieces[0] = new DiceVN();
        pieces[1] = new DiceVN();
        pieces[2] = new DiceVN();
        pieces[3] = new DiceVN();
        pieces[4] = new DiceVN();

        // Show what the 5 dice values are inside the array.
        for(int i = 0; i < pieces.length; i++)
        {
            // We are asking a specific dice "what is your value?"
            System.out.println("Dice #" + i + 1 + ": "
                + pieces[i].getFaceValue());
        }
    }
    
    public static void demoArrayC()
    {
        // Step 1: Array of 5 counters is declared
        CounterVN[] showCounter = new CounterVN[5];
        
    }
}     
