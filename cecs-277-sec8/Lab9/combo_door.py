"""
Brian Gutierrez and Vincent Nguyen
Lab 9 
CECS 277 Section 8
Fall 2025s
October 23, 2025
"""

import random 
from door import Door

class ComboDoor(Door):
   """
   A door that randomized a value to a number 1 - 10.
   """   
   
   def __init__(self):
      """
      Makes the initial state of the door locked and randomizes a value.
      """
      # Generates random number from 1 to 10
      self._random_number = random.randint(1, 10)
      self._is_locked = True

   def examine_door(self):
      """
      A description of the door

      Returns:
         str: A combination door.
      """ 
      return ("You encounter a door with a combination lock, "
              "you can spin the dial to a number 1-10.")

   def menu_options(self):
      """
      Returns a string of the menu options 
      
      Returns:
         str: a message prompting the user 1 - 10
      """
      return "Enter # 1-10:"
   
   def get_menu_max(self):
      """
      Returns then number of options
      
      Returns:
         int: the number of options which is a number 1 - 10
      """
      return 10
   
   def attempt(self, option):
      """
      Takes in what the user selected to determine if the value is close

      Args:
         option (int): The number the user guessed (1-10)

      Returns:
         str: A string describing what the user attempted.
      """
      # Create message about what user did
      message = f"You turn the dial to... {option}."
      
      # Checks if what the user did makes it unlocked
      if option == self._random_number:
         self._is_locked = False
         return f"{message}\n{self.success()}"
      else:
         # Give clue if wrong
         return f"{message}\n{self.clue(option)}"

   def is_unlocked(self):
      """
      Checks to see if what user did to return is unlocked

      Returns:
         bool: True if unlocked, False if locked
      """
      return not self._is_locked

   def clue(self, option):
      """
      Gives back the appropriate clue depending if the user was higher
      or lower

      Args:
         option (int): The number the user guessed

      Returns:
         str: Clue message ("Too high." or "Too low.")
      """
      # Checks if the guess is higher than then value
      if option > self._random_number:
         return "Too high."
      else:
         return "Too low."
   
   def success(self):
      """
      Returns a string with a message that shows they successfully guessed.
      """
      return "You found the correct value and opened the door."