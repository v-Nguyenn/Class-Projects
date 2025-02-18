/**
 * personalInfoVN class stores and manages personal information like name, 
 * address, age, and phone number. It allows you to set and get these details.
 * 
 * @author Vincent Nguyen
 * @version 11/10/24
 */
public class personalInfoVN
{
    // Fields to store the personal information
    private String name;         // Person's name
    private String address;      // Person's address
    private int age;             // Person's age
    private String phoneNum;     // Person's phone number

    /**
     * Default constructor that initializes the fields to default values.
     * Name, address, and phone number are set to empty strings, and age is set to 0.
     */
    public personalInfoVN()      // No argument constructor
    {
        name = "";
        address = "";
        age = 0;
        phoneNum = "";
    }

    /**
     * Constructor with parameters to initialize the fields with inputted values.
     * 
     * @param inputName     The person's name
     * @param inputAddress  The person's address
     * @param inputAge      The person's age
     * @param inputPhoneNum The person's phone number
     */
    public personalInfoVN(String inputName, String inputAddress, int inputAge,
                           String inputPhoneNum)
    {
        name = inputName;
        address = inputAddress;
        age = inputAge;
        phoneNum = inputPhoneNum;
    }

    // Mutator methods (used to set the values of the fields)

    /**
     * Sets the name of the person.
     * 
     * @param inputName The name to be set
     */
    public void setName(String inputName)
    {
        name = inputName;
    }

    /**
     * Sets the address of the person.
     * 
     * @param inputAddress The address to be set
     */
    public void setAddress(String inputAddress)
    {
        address = inputAddress;
    }

    /**
     * Sets the age of the person.
     * 
     * @param inputAge The age to be set
     */
    public void setAge(int inputAge)
    {
        age = inputAge;
    }

    /**
     * Sets the phone number of the person.
     * 
     * @param inputPhoneNum The phone number to be set
     */
    public void setPhoneNum(String inputPhoneNum)
    {
        phoneNum = inputPhoneNum;
    }

    // Accessor methods (used to get the values of the fields)

    /**
     * Returns the name of the person.
     * 
     * @return The person's name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the address of the person.
     * 
     * @return The person's address
     */
    public String getAddress() 
    {
        return address;
    }

    /**
     * Returns the age of the person.
     * 
     * @return The person's age
     */
    public int getAge()
    {
        return age;
    }

    /**
     * Returns the phone number of the person.
     * 
     * @return The person's phone number
     */
    public String getPhoneNum()
    {
        return phoneNum;
    }
}
