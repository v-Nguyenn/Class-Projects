# Brian Gutierrez and Vincent Nguyen
# Wednesday, September 24, 2025
# The Main.py that runs Rolodex which allows the user to view, search, and modify a contact list 
# made up of contact objects. The contact is imported from a contact class which has the 
# name, phone number, address, city, and zip code from 'addresses.txt'

import check_input
from contact import Contact

def read_file():
   """
   Opens and reads one line creating an object and then stores it in a list.
   
   Args:
      None
   
   Returns:
      list: list of objects from the Contact class

   Raises:
      FileNotFoundError: if the file does not exist
   """
   contacts = []
   try:
      with open("addresses.txt", "r") as file:
         # Iterates through each line in the file
         for line in file:
            line = line.strip()      # Gets rid of white space in the front and back of the line
            fields = line.split(",") # Splits the line into a list of fields based on commas

            if len(fields) != 6:     # checks if the line has exactly 6 fields
               print("Invalid format:", line)
               continue              # skips to the next line

            # Assigns each field to a variable after stripping whitespace
            for i in range(len(fields)):
               fields[i] = fields[i].strip()
               first_name_str = fields[0]
               last_name_str = fields[1]
               phone_str = fields[2]
               address_str = fields[3]
               city_str = fields[4]
               zip_code_str = fields[5]
            # Calls Contact constructor from the import and appends it to the list
            contacts.append(Contact(first_name_str, last_name_str, phone_str,
                                     address_str, city_str, zip_code_str))
            # uses __lt__ method from contact.py to sort. This is because the list
            # contains objects from the Contact class
            contacts.sort()
      return contacts
   
   except FileNotFoundError:
      print("File not found.")
      return contacts


def write_file(contacts):
   """
   Passes in the list of contacts and opens the file for writing, loop through the list
   and writes each contact to the file using the __repr__ method from contact.py

   Args:
      contacts (list): list of objects to write to the file

   Returns:
      None
   
   Raises:
      FileNotFoundError: if the file does not exist
   """
   # Checks if we can open the file
   try:
      with open("addresses.txt", "w") as file:
         # Iterates through the list 
         for contact in contacts:
            file.write(repr(contact) + "\n") 
   except FileNotFoundError:
            print("File not found.")
            return
   

def get_menu_choice():
   """
   Displays the main menu to the user and then takes user input
 
   Args:
      None

   Returns:
      int: user input from 1-5
   
   Raises:
      None 
   """
   print("Rolodex Menu:")
   print("1. Display Contacts")
   print("2. Add Contact")
   print("3. Search Contacts")
   print("4. Modify Contact")
   print("5. Save and Quit Program")
   user_input = check_input.get_int_range(">  ", 1, 5)
   return user_input


def modify_contact(contact):
   """
   Displays the modify menu and takes user input to change the contact information
   
   Args:
      contact (Contact): object to be modified

   Returns:
      Contact: the modified contact
   
   Raises:
      None
   """
   print("Modify Menu")
   print("1. First Name")
   print("2. Last Name")
   print("3. Phone")
   print("4. Address")
   print("5. City")
   print("6. Zip Code")
   print("7. Save and Exit Modify Menu\n") 

   # Loops until user chooses to exit the modify menu
   while True:
      print("Select field to modify or exit:")
      user_input = check_input.get_int_range(">  ", 1, 7)
      match user_input:
         case 1:
            new_first_name = input("Enter new first name: ")
            contact.first_name = new_first_name
         case 2:
            new_last_name = input("Enter new last name: ")
            contact.last_name = new_last_name
         case 3:
            new_phone_number = input("Enter new phone number: ")
            contact.phone = new_phone_number
         case 4:
            new_address = input("Enter new address: ")
            contact.address = new_address
         case 5:
            new_city = input("Enter new city: ")
            contact.city = new_city
         case 6:
            new_zip_code = input("Enter new zip code: ")
            contact.zip_code = new_zip_code
         case 7:
            break
   return contact


def main():
   """
   Main to run the contact management program
   Displays the menu and takes user input to call the right function
   to manage the contacts
   """
   contacts = read_file() # Load contacts from file at start
   while True:
      user_choice = get_menu_choice()
      # Matches user input to the appropriate Rolodex menu option 1-5
      match user_choice:
         # 1. Display Contacts, reads the file and displays an enumerated list of contacts
         # of each of the contacts dusing the __str__ method from contact.py
         case 1:
            contacts = read_file()
            num_of_contacts = check_input.get_int_range("Number of contacts: ", 0, len(contacts))
            contact = contacts[num_of_contacts - 1]  # num_of_contacts is 1 based index
            # Displays the contact information using __str__ method from contact.py
            if num_of_contacts > 0 and len(contacts) > 0: 
               display_num = 1
               # Iterates through the list contacts and displays only the number of contacts requested
               for contact in contacts[:num_of_contacts]:  
                  print(f"{display_num}: {contact.first_name} {contact.last_name} ")
                  print(f"   {contact.phone}")
                  print(f"   {contact.address}")
                  print(f"   {contact.city}")
                  print(f"   {contact.zip}")
                  print()
                  display_num += 1
            pass

         # 2. Add Contact - prompts user to enter each piece of data for a contact,
         # constructing the contact object and adding it to the list of contacts and then sorting 
         case 2:
            # Get user input for the new contact information
            print("Enter new contact:")
            first_name = input("First name: ")
            last_name = input("Last name: ")
            phone = input("Phone #: ")
            address = input("Address: ")
            city = input("City: ")
            zip_code = input("Zip code: ")
            print()
            # Checks for any repeated people    
            for contact in contacts:
               if (contact.first_name.lower().strip() == first_name.lower().strip() and 
                   contact.last_name.lower().strip() == last_name.lower().strip()):
                   print("Contact already exists.")
                   break
            else:
               contacts.append(Contact(first_name, last_name, phone, address, city, zip_code))
               contacts.sort()
               write_file(contacts)
               print("Contact added.\n")
            pass
         
         # 3. Search Contacts - prompts user to enter the type of search, by last name 
         # or zip code, then prompts for search and then loops through the list and prints
         # Displays all contacts that match the search requirements
         case 3:
            print("Search:")
            print("1. Search by last name")
            print("2. Search by zip code")

            # Loops until user chooses to exit the search menu
            # Checks if user wants to search by last name or zip code
            search_choice = check_input.get_int_range("> ", 1, 2)
            # Checks if user wants to exit search menu

            if search_choice == 1:
               search_last_name = input("1. Search by last name: ")
               found = False # Set a flag to see if we found a match
               # Finds and prints the contacts that match the last name
               for contact in contacts:
                  if contact.last_name.lower().strip() == search_last_name.lower().strip():
                     print(contact)
                     found = True
               if not found:
                  print("No contact found with that last name.\n")
           
            # Checks if user wants to search by zip code
            elif search_choice == 2:
               search_zip_code = input("2. Search by zip code: ")
               found = False 
               # Iterates through the list and prints the contacts with the matching zip code 
               for contact in contacts:
                  if contact.zip.strip() == search_zip_code.strip():
                     print(contact)
                     found = True
               if not found:
                  print("No contact found with that zip code.\n")
            # If user enters invalid choice
            else:
               print("Invalid choice.")
         
         # 4. Modify Contact -  prompts user to enter the first and last name of the contact to modify
         # if found, calls the modify_contact function to display the modify menu and take user input
         case 4:
            first_name = input("Enter first name: ")
            last_name = input("Enter last name: ")
            found = False
            # Iterates through the list to find the matching first and last name
            for contact in contacts:
               if (contact.first_name.lower().strip() == first_name.lower().strip() and
                  contact.last_name.lower().strip() == last_name.lower().strip()):
                  found = True
                  print(contact)
                  modify_contact(contact)
                  write_file(contacts)  # saves the changes
                  print("Contact has been modified.\n")
                  break
            if not found:
               print("ERROR: Person could not be found")

         # 5. Save and Quit Program - writes the list of contacts to the file and exits the program
         case 5:
            print("Saving...")
            write_file(contacts)
            print("Ending Program")
            break


if __name__ == "__main__":
   main() 