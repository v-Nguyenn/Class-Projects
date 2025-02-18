import java.util.Scanner;   // Needed for Scanner class

/**
This program shows an array being processed with loops.
 */

public class ArrayDemo3VNguyen  
{
    public static void main(String[] args) {
        // Declare, create, initialize arrays
        int[] room = { 101, 106, 209, 203, 213 };
        int[] classSize = { 5, 12, 15, 8, 14 };
        int[] boys = { 2, 9, 6, 4, 3 };
        String[] names = { "J.Ali", "K.Johnson", "K.Tran", "C.Gonzalez", "S.Anderson" };

        // Title
        System.out.println("Alton Elementary ======");
        // Q1 - Print the teachers and room numbers
        System.out.print("Teacher\tRoom\tClass Size\tBoys\tGirls\tRatio\t");
        printArray(names);
        printArray(room);

        // Q2 - How many rooms are upstairs?
        int upstairs = 123;
        int i = 0;
        while (i < room.length) 
        {
            //qqq
            i++;
        }
        System.out.println("There are " + upstairs + " rooms upstairs");

        // Q3 - Which teacher has the most students?
        int max = 123;
        for (int k = 0; k < classSize.length; k++) 
        {
            //QQQ
        }
        System.out.println(names[max] + " has the most students");

        // Q4 - Which teacher has the most boys?
        teacherMostBoys(names, boys);

        // Q5 - Which teacher has the most girls?
        teacherMostGirls(names, classSize, boys);
    }
    
    // Method Overload allows you to use the SAME method name with
    // different argument types. This saves a lot of effort. Python 
    // doesn't have an easy way to "overload" (as of last year).
    public static void printArray(double[] ary) 
    {
        System.out.println();
    }

    public static void printArray(int[] ary) 
    {
        System.out.println();
        for(int index = 0; index < ary.length; index++)
        {
            // Print all on one line with a comma, seperating each
            if(index == 0)
            {
                System.out.print(ary[0]);
            }
            else
            {
                System.out.print(", " + ary[index]);
            }
        }
        System.out.println();
    }

    public static void printArray(String[] ary) 
    {
        System.out.println();
        for(int index = 0; index < ary.length; index++)
        {
            // Print all on one line with a comma, seperating each
            if(index == 0)
            {
                System.out.print(ary[0]);
            }
            else
            {
                System.out.print(", " + ary[index]);
            }
        }
        System.out.println();
    }

    public static void teacherMostGirls(String[] names, int[] classSize, int[] boys) {
        int maxGirls = 0;
        for (int k = 0; k < boys.length; k++) 
        {

        }

        System.out.println(names[maxGirls] + " has most girls");
    }

    public static void teacherMostBoys(String[] names, int[] boys) {
        int maxBoys = 0;
        for (int k = 0; k < boys.length; k++) 
        {

        }
        System.out.println(names[maxBoys] + " has most boys");
    } 
}     
