import java.util.Scanner;   // Needed for Scanner class
import java.io.*;           // Needed for File I/O classes

/**
   This program writes data to a file.
   
   author: Vincent Nguyen
   version: 10/08/24
*/

public class FileWriteDemoVincentNguyen
{
   public static void main(String[] args) throws IOException
   {
      String filename;      // File name
      String friendName;    // Friend's name
      int numFriends;       // Number of friends

      // Create a Scanner object for keyboard input.
      Scanner keyboard = new Scanner(System.in);
      
      // Get the number of friends.
      System.out.print("How many friends do you have? ");
      numFriends = keyboard.nextInt();

      // Consume the remaining newline character.
      keyboard.nextLine();
      
      // Get the filename.
      System.out.print("Enter the filename: ");
      filename = keyboard.nextLine();

      // Open the file.
      PrintWriter outputFile = new PrintWriter(filename);

      // Get data and write it to the file.
      for (int i = 1; i <= numFriends; i++)
      {
         // Get the name of a friend.
         System.out.print("Enter the name of friend " +
                          "number " + i + ": ");
         friendName = keyboard.nextLine();

         // Write the name to the file.
         outputFile.println(friendName);
      }

      // Close the file.
      outputFile.close();
      System.out.println("Data written to the file.");
   }
   
   public static void fileWriteDemo1() throws IOException
   {
       // Open a file to write to
       PrintWriter myNote = new PrintWriter("Vincent.txt");
       
       // Wrtie something into the file 
       myNote.println("I attend IVC and enjoy the library");
       
       // Close the File. 
       myNote.close();
   }
   
   public static void fileReadDemo1() throws IOException
   {
       // Open the file
       File myFile       = new File ("Vincent.txt");
       Scanner inputFile = new Scanner(myFile);
       
       // Read ONE LINE at a time until nothing is left to read
       while(inputFile.hasNext()) // checks if there is anything left
       {
           String oneLine = inputFile.nextLine(); // reads one line
           System.out.println(oneLine); // then print the line in 
           // the terminal
       }
       
       // close the file
       inputFile.close();
   }
   
   public static void fileReadStudents() throws IOException
   {
       // ref: sec 4.6 running totals
       // Open the file
       File myFile = new File ("studentsByVincentNguyen.txt");
       Scanner inputFile = new Scanner(myFile);
       
       int count = 0;
       
       while(inputFile.hasNext())
       {
           String oneLine = inputFile.nextLine(); // reads one line
           System.out.println(oneLine); // prints the line
                                        // in the terminal 
           count++;
       }
       
       // close file to save memory
       inputFile.close();
       
       System.out.println(count); // This is accumulator
   }
   
   public static void addLineNumbers() throws IOException{
       // open the file
       File myFile = new File("studentsByVincentNguyen.txt");
       Scanner inputFile = new Scanner(myFile);
       
       int count = 0;
       
       while(inputFile.hasNext()){
           count ++;
           String oneLine = inputFile.nextLine();
           // adding line numbers to text file
           System.out.println(count + ": " + oneLine);   
       }
       
       inputFile.close(); // close to save memory
       
       System.out.println(count);
   }
   
   public static void count9thGraders() throws IOException{
       // Open file
       File myFile = new File("studentsByVincentNguyen.txt");
       Scanner inputFile = new Scanner(myFile);
       
       int count = 0; 
       int ninthGraders = 0;
       
       while(inputFile.hasNext()){
           count++;
           String oneLine = inputFile.nextLine();
           
           // Line 134 works as well as 135
           // if(oneLine.indexOf("9th") >= 0)){ 
           if(oneLine.indexOf("9th") != -1){
           ninthGraders++;
           System.out.println(count + ": " + oneLine);
           } 
       }
       
       inputFile.close();
       
       System.out.println(ninthGraders + " students are freshmen\n");
   }
   
   // 13 - List all students name only with line numbers
   public static void printStudentName() throws IOException { 
       // open the file.
       File myFile = new File("studentsByVincentNguyen.txt");
       Scanner inputFile = new Scanner(myFile);
       
       int count = 0;
       
       while( inputFile.hasNext()){
           count++;
           // Reads each line in the file
           String oneLine = inputFile.nextLine();
           
           // Where is the students name ?
           int posOfName = oneLine.indexOf("Name: ");
           
           // System.out.println(count + ": " + 
           //   + oneLine.substring(posOfName);
           
           System.out.println(count + ": " 
                + oneLine.substring(oneLine.indexOf("Name:")));
       }
       
       System.out.println(count);
       inputFile.close(); // close file after to save memory       
   }
}

