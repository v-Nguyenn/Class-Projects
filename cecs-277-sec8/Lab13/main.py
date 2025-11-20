"""
Brian Gutierrez and Vincent Nguyen
Lab 13
CECS 277 Section 8
Fall 2025
November 19, 2025

main.py for the user task list program
"""

from tasklist import Tasklist
from check_input import get_int_range

def main_menu(tasklist):
   """Displays the main menu and returns the user's valid input."""
   print("\n-- Tasklist --")
   print(f"[] Tasks to complete: {len(tasklist)}")
   print("1. Display current task")
   print("2. Display all tasks")
   print("3. Mark current task complete")
   print("4. Add new task")
   print("5. Search by date")
   print("6. Save and quit")
   choice = get_int_range("Enter choice: ", 1, 6)
   return choice

def get_date():
   """Prompts the user to enter the month, day, and year."""
   month = get_int_range("Enter month: ", 1, 12)
   day = get_int_range("Enter day: ", 1, 31)
   year = get_int_range("Enter year: ", 2000, 2100)
   return f"{month:02d}/{day:02d}/{year}" # 02d means 2 digits with leading zero

def get_time():
   """Prompts the user to enter the time."""
   print("-- Enter time --")
   hour = get_int_range("Enter hour: ", 0, 23)
   minute = get_int_range("Enter minute: ", 0, 59)
   return f"{hour:02d}:{minute:02d}"

def main():
   """Main program that runs the user task list program."""
   tasklist = Tasklist()
   choice = 0
   while choice != 6:
      choice = main_menu(tasklist)
      if choice == 1:
         # Checks if there are no tasks and displays the string
         if len(tasklist) > 0:
            print("-- Current Task --")
            print(f"[] {tasklist.get_current_task()}")
         else:
            print("All tasks complete!\n")

      elif choice == 2:
         # Displays All Tasks
         print("-- All Tasks --")
         for i, task in enumerate(tasklist, 1):
            print(f"{i}. [ ] {task}")

      elif choice == 3:
         # Mark Current Task Complete
         if len(tasklist) > 0:
            completed = tasklist.mark_complete()
            print(f"[X] {completed}")
            # Show new current task
            if len(tasklist) > 0:
               print("-- Updated Current Tasks --")
               print(f"[ ] {tasklist.get_current_task()}")
            else:
               print("All tasks complete!\n")
         else:
            print("No tasks to complete!\n")

      elif choice == 4:
         # Add New Task
         desc = input("-- Enter a task description --").strip().replace('\n',' ')
         print("-- Enter due date --")
         date = get_date()
         time = get_time() 
         tasklist.add_task(desc, date, time)

      elif choice == 5:
         # Search by Date
         print("-- Enter date to search --")
         date = get_date()
         found = False
         matches = []
         # Find all matching tasks
         for task in tasklist:
            if task.date == date:
               matches.append(task)
               found = True

         if found:
            print(f"Tasks due on {date}: ")
            for i, task in enumerate(matches, 1):
               print(f"{i}. [ ] {task}")
         else:
            print(f"No tasks found for {date}")

      elif choice == 6:
         # Save and Quit
         print("Saving List...")
         tasklist.save_file()
         

if __name__ == "__main__":
   main()