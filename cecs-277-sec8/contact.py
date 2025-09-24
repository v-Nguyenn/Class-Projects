# Brian Gutierrez and Vincent Nguyen
# Contact class to store contact information from address.txt
# Each contact has a first name, last name, phone number, address, city, and zip code

class Contact:
   # Constructor for the contact class
   # Passes in and assigns the parameters to the class variables
   def __init__(self, fn, ln, ph, addr, city, zip):
            self.first_name = fn
            self.last_name = ln
            self.phone = ph
            self.address = addr
            self.city = city
            self.zip = zip

   # Passes in two contact objects and compares their last names for sorting
   # Returns boolean value if the first contact's last name is the same as the second contact's last name
   def __lt__(self, other):
         if self.last_name != other.last_name:
            # returns True if self's last name before other's last name
            return self.last_name < other.last_name 
         else:
            # returns True if self's first name before other's first name
            return self.first_name < other.first_name

   # Passes in the object to be displayed in the console
   # Returns a string with all the contact's information
   def __str__(self):
      return (
         f"First Name: {self.first_name}\n"
         f"Last Name: {self.last_name}\n"
         f"Phone #: {self.phone}\n"
         f"Address: {self.address}\n"
         f"City: {self.city}\n"
         f"Zip: {self.zip}\n"
      )
   
   # Passes in the object to be written to a file
   # Returns a string that is used in the format 'f_name,l_name,phone,address,city,zip'
   def __repr__(self):
       return (
           f"{self.first_name},{self.last_name},{self.phone},"
           f"{self.address},{self.city},{self.zip}"
       )

# Testing class functionality
def main():
   # Test for class __lt__ method
   print("---------------\n", "Line 18")
   c1 = contact("Alia", "Smith", "714-2123", "Address1", "Long Beach 1", "11111")
   c2 = contact("Beck", "Jones", "714-3456", "Address2", "San Clemente 2", "22222")
   c3 = contact("Carol","Smith", "714-3789", "Address3", "Los Angeles 3", "33333")
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