"""
Brian Gutierrez and Vincent Nguyen
Lab 9 
CECS 277 Section 8 
Fall 2024
October 22, 2025
"""
import random
from door import Door

class BasicDoor(Door):
   """
   A door that is either pushed to open, or pulled to open.
   """

   def __init__(self):
      """
      Initializes door by randomizing the initial state of the door
      (push or pull).
      """
      # Picks a random choice from the list
      self._action = random.choice(["push", "pull"])
      self._is_locked = True

   def examine_door(self):
      """
      A door that is either pushed to open, or pulled

      Returns: 
         str: A description of a door that can either be pushed or pulled
      """
      return f"A door that is either pushed to open, or pulled."

   def menu_options(self):
      """
      Returns a string of the menu options that user from
      
      Returns: 
         str: Message with the menu options
      """
      return f"1. Push \n2. Pull"
   
   def get_menu_max(self):
      """
      Returns the number of options in the above menu.

      Returns:
         int: 2 because you can either push or pull
      """
      # Count the number of lines in menu_options()
      menu = self.menu_options()
      return menu.count('\n') + 1
   
   def attempt(self, option):
      """
      Passes in the user's selection from the menu

      Args:
         option (int): The menu number the user selects

      Returns:
         str: What the user attempted
      """
      # Maps what the user picks
      if option == 1:
         chosen_action = "push"
      elif option == 2:
         chosen_action = "pull"
      else:
         return "Invalid option."
      
      # Matches the action to the random one (push or pull)
      if chosen_action == self._action:
         self._is_locked = False
         return self.success()
      else:
         return self.clue()
      
      
   def is_unlocked(self):
      """
      Checks to see if the door is unlocked

      Returns:
         bool: True if unlocked and False if locked
      """
      # Returns it unlocked.
      return not self._is_locked
   
   def clue(self):
      """
      Hint that is returned to the user if unsucessful

      Returns:
         str: Message with clue about their attempt.
      """
      return "Try the other way."
   
   def success(self):
      """
      Message that is returned if user is successful

      Returns: 
         str: Congratulatoy message if the user pushed or pulled
      """   
      return f"You {self._action} the door. \nCongratulations, you opened the door."