import java.util.Scanner;
/**
 * Description
 * ______________________
 * This is the main function that tests the programming
 * challenges #3, #5, and A.
 * ______________________
 * @author Vincent Nguyen
 * @version 11/10/24
 */
public class testerVNguyen
{
    /**
     * Main method where the program starts.
     */
    public static void main(String[] args)
    {
        // Main is currently empty.
    }

    /**
     * Programming Challenge #3: Personal Information // refer to page 419
     * This method uses the personalInfoVN class, where personal information is
     * stored and displayed for three people (myself and two friends).
     */
    public static void programmingChallenge3VN()
    {
        // Creating instances of the personalInfoVN class to hold personal information
        // These objects can also be created using a constructor with parameters

        // personalInfoVN myself = new personalInfoVN("Vincent Nguyen", "12832 Washington Ave",
        //                                            23, "714-434-7232");
        // personalInfoVN friend1 = new personalInfoVN("Jonathan", "7123 Beach Blvd",
        //                                             24, "714-454-3892");
        // personalInfoVN friend2 = new personalInfoVN("Nathan", "3412 West Covina Ave",
        //                                             27,"823-429-2328");

        // Creating objects with the default constructor
        personalInfoVN myself = new personalInfoVN();
        personalInfoVN friend1 = new personalInfoVN();
        personalInfoVN friend2 = new personalInfoVN();

        // Setting my personal information (substitute with actual data)
        myself.setName("Vincent Nguyen");
        myself.setAddress("12832 Washington Ave");
        myself.setAge(23);
        myself.setPhoneNum("713-434-7232");

        // Setting first friend's information
        friend1.setName("Jonathan");
        friend1.setAddress("7123 Beach Blvd");
        friend1.setAge(24);
        friend1.setPhoneNum("714-454-3892");

        // Setting second friend's information
        friend2.setName("Nathan");
        friend2.setAddress("3412 West Covina Ave");
        friend2.setAge(27);
        friend2.setPhoneNum("823-429-2328");

        // Title in terminal 
        System.out.println("Programming Challenge #3: Personal Info Class");

        // Displaying my personal information
        System.out.println("-------My Information-------");
        System.out.println("Name: "         + myself.getName());
        System.out.println("Address: "      + myself.getAddress());
        System.out.println("Age: "          + myself.getAge());
        System.out.println("Phone Number: " + myself.getPhoneNum() + "\n");

        // Displaying Friend 1's information
        System.out.println("------Friend 1's Information------");
        System.out.println("Name: "         + friend1.getName());
        System.out.println("Address: "      + friend1.getAddress());
        System.out.println("Age: "          + friend1.getAge());
        System.out.println("Phone Number: " + friend1.getPhoneNum() + "\n");

        // Displaying Friend 2's information
        System.out.println("-------Friend 2's Information-------");
        System.out.println("Name: "         + friend2.getName());
        System.out.println("Address: "      + friend2.getAddress());
        System.out.println("Age: "          + friend2.getAge());
        System.out.println("Phone Number: " + friend2.getPhoneNum() + "\n");
    }

    /**
    * Programming Challenge #5: Payroll Class // refer to page 419
    * This method uses of the payroll class to calculate an employee's 
    * gross pay based on user input. It asks for the employee's name, ID number, hourly pay 
    * rate, and number of hours worked, then calculates the gross pay and displays it.
    * 
    * The method uses a payrollVN object to store employee data and calculates the gross 
    * pay using the provided hourly pay rate and hours worked.
    */
    public static void programmingChallenge5VN()
    {
        // Scanner object to read user input
        Scanner keyboard = new Scanner(System.in);

        // Title in terminal
        System.out.println("Programming Challenge #5: Payroll Class");

        // Ask user for employee name 
        System.out.print("Enter name of employee: ");
        String name = keyboard.nextLine();

        // Asks user for employee ID number
        System.out.print("Enter employee ID number: ");
        int idNum = keyboard.nextInt();

        // Asks user for employee hourly pay rate
        System.out.print("Enter hourly pay rate: ");
        double hourlyPayRate = keyboard.nextDouble();

        // Asks user for number of hours employee worked
        System.out.print("Enter number of hours worked: "); // newline to seperate
        int hoursWorked = keyboard.nextInt();
        
        
        // Create object using the class     
        payrollVN employee = new payrollVN();

        // Mutators set the value from user input
        employee.setName(name);                             // set the name
        employee.setIdNum(idNum);                           // set the ID Number
        employee.setHourlyPayRate(hourlyPayRate);           // set the pay rate
        employee.setHoursWorked(hoursWorked);               // set the hours worked

        // Calculate and display gross pay
        employee.setGrossPay(hourlyPayRate, hoursWorked);   // set employees pay
        double grossPay = employee.getGrossPay();           // store result

        System.out.print("Gross Pay: $");           // Keeps the output on the same line
        System.out.printf("%,.2f", grossPay);  // Prints the formatted gross pay
        System.out.println();                         // newline after the message
    }
}
