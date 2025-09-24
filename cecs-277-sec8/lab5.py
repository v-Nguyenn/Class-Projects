# Brian Gutierrez and Vincent Nguyen
# Contact class to store contact information from address.txt
# Each contact has a first name, last name, phone number, address, city, and zip code

import check_input
from contact import Contact

# Opens and reads one line creating a contact object and then stores it in a list.
# Sorts and then returns the list.
def read_file():
   contacts = []
   try:
      with open("addresses.txt", "r") as file:
         for line in file:
            line = file.readline().strip()
            fields = line.split(",") # Splits the line into a list of fields
            if len(fields) != 6:
               print("Invalid line format:", line)
               continue  # skips to the next line
            for i in range(len(fields)):
               fields[i] = fields[i].strip() # Removes xtra whitespace
               firstName = fields[0]
               lastName = fields[1]
               phone = fields[2]
               address = fields[3]
               city = fields[4]
               zipCode = fields[5]
            # Calls Contact constructor from our import and appends it to the list
            contacts.append(Contact(firstName, lastName, phone,
                                     address, city, zipCode))
            # uses __lt__ method from contact.py to sort. This is because the list 
            # contains Contact objects
            contacts.sort()
      return contacts
   
   except FileNotFoundError:
      print("File not found.")
      return contacts

def main():
   # Test for read_file function
   contacts = read_file()
   for contact in contacts:
      print(contact)


if __name__ == "__main__":
   main() 