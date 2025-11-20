"""
Brian Gutierrez and Vincent Nguyen
Lab 13
CECS 277 Section 8
Fall 2025
November 19, 2025

tasklist.py manages a sorted list of tasks with files
"""

from task import Task

class Tasklist():
   """Manages a sorted list of tasks using file."""

   def __init__(self):
      """Initialization of tasks reading from the file and storing them in the tasklist."""
      self._tasklist = []
      # Tries to see if the file is available
      try: 
         with open("tasklist.txt","r") as file: 
            for line in file: 
               line = line.strip() # Remove\n and whitespace
               desc, date, time = line.split(',') # Separate after each comma
               task = Task(desc, date, time) # Set the desired format
               self._tasklist.append(task) # Add to the tasklist
      # If file is not found then initializes an empty list.
      except FileNotFoundError:
         pass
      except Exception as e:
         print(f"Error: {e}")
      self._tasklist.sort()

      self._tasklist.sort()
      print(f"Loaded {len(self._tasklist)} tasks from file")  # Debug line

   def add_task(self, desc, date, time):
      """Constructs a new task, adds it to the list, and then sorts it."""
      new_task = Task(desc, date, time)
      self._tasklist.append(new_task)
      self._tasklist.sort()

   def get_current_task(self):
      """Returns the task at the beginnning at the list."""
      return self._tasklist[0]

   def mark_complete(self):
      """Removes and returns the current task from the tasklist."""
      return self._tasklist.pop(0)

   def save_file(self):
         """Writes the contents of the tasklist back to the file using the Task's repr method"""
         with open("tasklist.txt", "w") as file:
            for task in self._tasklist:
               file.write(repr(task)+"\n")
   
   def __len__(self):
      """Returns the number of items in the tasklist."""
      return len(self._tasklist)
   
   def __iter__(self):
      """Intializes the counter and returns self."""
      self._n = 0
      return self # tells the program that it is the iterator

   def __next__(self):
      """
      Iterates the iterator one position at a time. 
      
      Raises a StopIteration when the iterator reaches the end of the tasklist, otherwise return
      the Task object at the iterator's current position.
      """
      # If the length of the iterator is less than the length of the list.
      if self._n < len(self._tasklist):
         # Still have tasks to return
         task = self._tasklist[self._n] # Get the current task
         self._n += 1 # Move to the next position
         return task
      else:
         raise StopIteration   