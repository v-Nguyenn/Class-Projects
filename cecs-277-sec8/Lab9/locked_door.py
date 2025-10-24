"""
Brian Gutierrez and Vincent Nguyen
Lab 9 
CECS 225 Section 8
Fall 2024
October 22, 2025
"""

import random
from door import Door

class LockedDoor(Door):
   """
   A locked door that has the user look for a key between
   three options
   """
   def __init__(self):
      """
      Randomizes the location of the key
      """
      self._action = random.randint(1,3)
      self._is_locked = True

   def examine_door(self):
      """
      A description of the door

      Returns:
         str: a string about the door
      """
      return ("A locked door. The key is hidden nearby.\n"
              "Look around for the key")
   
   def menu_options(self):
      """
      The menu options that user can choose from.

      Returns:
         str: options for the user to pick
      """
      return ("1. Look under the mat.\n"
              "2. Look under the flower pot.\n"
              "3. Look under the fake rock.")
   
   def get_menu_max(self):
      """
      The number of options the menu above has.

      Return:
         (int): total number of options
      """
      return 3
   
   def attempt(self, option):
      """
      Passes in the user's selection from the menu. Either 1, 2, 3

      Args:
         int: The number which the user is prompted and allowed to pick 

      Returns:
         str: describing what user attempted 
      """
      # Map the menu options to the locations
      locations = {
         1: "under the mat.",
         2: "under the flower pot.",
         3: "under the fake rock"
      }

      # Get location description
      location = locations.get(option, "invalid option")

      # Checks if the option chosen is the same as the randomly generated choice
      if option == self._action:
         self._is_locked = False # Unlocks the lock
         return f"You look {location} and find the key!\n {self.success()}"
      else:
         return f"You look {location} and find nothing \n {self.clue()}"

   def is_unlocked(self):
      """
      Checks to see if the door is was unlocked

      Returns:
         bool: true if unlocked and false locked
      """
      return not self._is_locked
   
   def clue(self):
      """
      Returns a hint that is returned if the user was unsuccessful checking location
      
      Returns:
         str: A hint for the player to look at another location
      """
      return "Look somewhere else"
   
   def success(self):
      """
      Congratulatory message if the user found the correct location

      Returns:
         str: Message that telling the user if they succeeded.
      """
      return "You found the key and unlocked the door!"