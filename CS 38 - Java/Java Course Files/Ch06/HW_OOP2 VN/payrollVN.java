/**
 * Programming Challenge #5: Payroll Class
 * The payrollVN class represents an employee's payroll information.
 * It contains fields for the employee's name, ID number, hourly pay rate, 
 * hours worked, and gross pay. The class provides methods to set and get 
 * these values, as well as a method to calculate the employee's gross pay.
 * 
 * @author Vincent Nguyen
 * @version 11/10/24
 */
public class payrollVN
{
    // Instance variables
    private String name;               // Employee's name
    private int idNum;                 // Employee's ID number
    private double hourlyPayRate;      // Employee's hourly pay rate
    private int hoursWorked;           // Number of hours worked by the employee
    private double grossPay;           // The employee's calculated gross pay

    /**
     * Default constructor for objects of class payrollVN.
     * Starts these at the following default values:
     * name to an empty string, idNum to 0, hourlyPayRate and hoursWorked 
     * to 0, and grossPay to 0.
     */
    public payrollVN()
    {
        name = "";
        idNum = 0;
        hourlyPayRate = 0;
        hoursWorked = 0;
        grossPay = 0;
    }

    /**
     * Constructor for objects of class payrollVN which
     * comes from specific values given by the user.
     * 
     * @param inputName          The name of the employee
     * @param inputIdNum         The ID number of the employee
     * @param inputHourlyPayRate The hourly pay rate of the employee
     * @param inputHoursWorked   The number of hours the employee worked
     * @param inputGrossPay      The gross pay of the employee 
     *                           (calculated as hourlyPayRate * hoursWorked)
     */
    public payrollVN(String inputName, int inputIdNum, 
                     double inputHourlyPayRate, int inputHoursWorked, double inputGrossPay)
    {
        name = inputName;
        idNum = inputIdNum;
        hourlyPayRate = inputHourlyPayRate;
        hoursWorked = inputHoursWorked;
        grossPay = inputHourlyPayRate * inputHoursWorked;  // Calculate gross pay
    }

    // Mutators (*note to self - mutator, to mutate, (to change or set, setters))

    /**
     * Sets the name of the employee.
     * 
     * @param inputName The employee's name
     */
    public void setName(String inputName)
    {
        name = inputName;
    }
    
    /**
     * Sets the ID number of the employee.
     * 
     * @param inputIdNum The employee's ID number
     */
    public void setIdNum(int inputIdNum)
    {
        idNum = inputIdNum;
    }

    /**
     * Sets the hourly pay rate of the employee.
     * 
     * @param inputHourlyPayRate The employee's hourly pay rate
     */
    public void setHourlyPayRate(double inputHourlyPayRate)
    {
        hourlyPayRate = inputHourlyPayRate;
    }

    /**
     * Sets the number of hours worked by the employee.
     * 
     * @param inputHoursWorked The number of hours worked
     */
    public void setHoursWorked(int inputHoursWorked)
    {
        hoursWorked = inputHoursWorked;
    }

    /**
     * Sets the gross pay of the employee.
     * This is calculated based on hourlyPayRate * hoursWorked.
     * 
     * @param inputHourlyPayRate The employee's hourly pay rate
     * @param inputHoursWorked The number of hours worked by the employee
     */
    public void setGrossPay(double inputHourlyPayRate, int inputHoursWorked)
    {
        grossPay = inputHourlyPayRate * inputHoursWorked;
    }

    // Accessor (*note for self - accessor, to access data (to get data, getter))

    /**
     * Gets the name of the employee.
     * 
     * @return The employee's name
     */
    public String getName()
    {
        return name; 
    }

    /**
     * Gets the ID number of the employee.
     * 
     * @return The employee's ID number
     */
    public int getIdNum()
    {
        return idNum;
    }

    /**
     * Gets the hourly pay rate of the employee.
     * 
     * @return The employee's hourly pay rate
     */
    public double hourlyPayRate()
    {
        return hourlyPayRate;
    }

    /**
     * Gets the number of hours worked by the employee.
     * 
     * @return The number of hours worked
     */
    public int hoursWorked()
    {
        return hoursWorked;
    }

    /**
     * Gets the gross pay of the employee.
     * 
     * @return The gross pay of the employee
     */
    public double getGrossPay()
    {
        return grossPay;
    }

}


