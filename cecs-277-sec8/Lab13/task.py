"""
Brian Gutierrez and Vincent Nguyen
Lab 13
CECS 277 Section 8
Fall 2025
November 19, 2025

task.py defines the Task class for managing individual files.
"""

class Task():
   """A single task with a description, due date, and time."""
   def __init__(self, desc, date, time):
      """Initializes the task class."""
      self._description = desc
      self._date = date
      self._time = time

   @property
   def date(self):
      """Return the date of the task."""
      return self._date
   
   def __str__(self):
      """Returns the string used to display the task's information to the user."""
      return self._description + " - Due: " + self._date + " at " + self._time 
   
   def __repr__(self):
      """Returns a string used to write the task to the file."""
      return f"{self._description},{self._date},{self._time}"
      
   def __lt__(self, other):
      """
      Returns true if the self task is less than the other task.
      
      Compares by year, then month, then day, then hour, then minute, and then the 
      task description by alphabetical order.
      """
      if self._date < other._date:
         return True
      elif self._date > other._date:
         return False
      else:
         # Since Dates are equal, we compare the time
         if self._time < other._time:
            return True
         elif self._time > other._time:
            return False
         else:
            # Since Time is equal then we compare description
            return self._description < other._description