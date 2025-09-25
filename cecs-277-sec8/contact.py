# Brian Gutierrez and Vincent Nguyen
# Wednesday, September 24, 2025
# Contact class to store contact information from address.txt
# Each contact has a first name, last name, phone number, address, city, and zip code

class Contact:
   def __init__(self, fn, ln, ph, addr, city, zip):
      """ 
      Constructor for the contact class. Passes in and assigns the parameters to the class variables

      Args: 
         fn (str): first name
         ln (str): last name
         ph (str): phone number
         addr (str): address
         city (str): city
         zip (str): zip code

      Returns: 
         None  
      
      Raises:
         None
      """
      self.first_name = fn
      self.last_name = ln
      self.phone = ph
      self.address = addr
      self.city = city
      self.zip = zip

  
   def __lt__(self, other):
      """
      Passes in two contact objects and compares their last names for sorting

      Args:
         other (Contact): another object to compare to
         self (Contact): the current object
         
      Returns:
         bool: True if self is less than other, False otherwise

      Raises: 
         None
      """
      if self.last_name != other.last_name:
         # returns True if self's last name before other's last name
         return self.last_name < other.last_name 
      else:
         # returns True if self's first name before other's first name
         return self.first_name < other.first_name


   def __str__(self):
      """
      Passes in the object to be displayed in the console
      
      Args:
         self (Contact): the current object

      Returns:
         str: formatted string with contact details

      Raises:
         None
      """
      return (
         f"{self.first_name}\n"
         f"{self.last_name}\n"
         f"{self.phone}\n"
         f"{self.address}\n"
         f"{self.city}\n"
         f"{self.zip}\n"
      )
   
   
   def __repr__(self):
      """
      Passes in the object to be written to a file 

      Args:
        self (Contact): the current object

      Returns:
         str: formatted string for file writing 
         
      Raises:
         None
      """
      return (
         f"{self.first_name},{self.last_name},{self.phone},"
         f"{self.address},{self.city},{self.zip}"
       )

# Testing class functionality
def main():
   # Test for class __lt__ method
   print("---------------\n", "Line 18")
   c1 = Contact("Alia", "Smith", "714-2123", "Address1", "Long Beach 1", "11111")
   c2 = Contact("Beck", "Jones", "714-3456", "Address2", "San Clemente 2", "22222")
   c3 = Contact("Carol","Smith", "714-3789", "Address3", "Los Angeles 3", "33333")
   print(c1.first_name)  # testing "Alia"
   print(c1 < c2)        # False
   print(c1 < c3, "\n")  # True

   # Test for class __str__ method
   print("Line 28")
   print(c1)  # print all details of c1 - c3
   print(c2) 
   print(c3,"\n") 

   # Test for class __repr__ method
   print("Line 55")
   contacts = [c1, c2, c3]
   print(contacts,"\n")  # print list of contacts  

if __name__ == "__main__":
    main()

#  # Previous version of __lt__ method
   #  if self.last_name == other.last_name:
   #          return True
   #       elif self.first_name == other.first_name:
   #          return True
   #       else:
   #          return False