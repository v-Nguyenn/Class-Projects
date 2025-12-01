import java.util.Scanner;  import java.util.Random; import java.io.*;
/**
 * Description 
 * ____________
 * ____________
 * @author Vincent Nguyen
 * @version 10/31/24
 */
public class TestPrintWriterVNguyen
{
    public static void main(String[] args) throws IOException
    {
        // Instantiate Printer object and a Random object
        PrintWriter output = new PrintWriter("VNguyen.txt");
        Random ran = new Random();

        // PrintWriter method examples
        for(int row = 1; row <= 10; row++)  // for loop 10 times
        {
            int count = 1;
            while (count <= 10)              // while loop 10 times
            {
                int number = ran.nextInt(9) + 1; // random 1-9
                output.print(number + " ");
                count++;
            }
            output.println();                // writes a newline to the file
        }
        output.close();
    }
}

/*Sample Terminal output:
8 1 2 1 7 8 4 3 9 5 
3 7 1 8 7 1 4 6 9 2 
7 2 5 9 2 6 3 9 1 8 
8 6 9 6 1 7 6 3 9 1 
7 2 7 1 7 1 1 9 6 9 
6 4 9 9 9 4 3 3 4 4 
1 7 8 8 5 4 4 9 4 5 
4 6 2 1 2 7 7 7 1 3 
9 1 2 9 7 9 6 5 5 6 
2 2 2 7 9 3 4 8 5 1 
*/
