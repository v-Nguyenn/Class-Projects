"""
Brian Gutierrez and Vincent Nguyen
Lab 9 
CECS 227 Section 8 
Fall 2024
October 20, 2025
"""

from abc import ABC, abstractmethod

class Door(ABC):
   """
   A class representing a door in an escape room game.
   """

   @abstractmethod
   def examine_door(self):
      """ 
      Returns a string description of the door.
      
      Returns:
         str: Description of the door.
      """
      pass

   @abstractmethod
   def menu_options(self):
      """
      Returns a string of the menu options that user
      can choose when attempting to unlock the door.

      Returns:
         str: Menu options for the door.
      """
      pass

   @abstractmethod
   def get_menu_max(self): 
      """
      Returns the number of options in the above menu.

      Returns:
         int: The number of options
      """
      pass

   @abstractmethod
   def attempt(self, option):
      """
      Determines whether what user selected unlocks the door.

      Returns:
         str: Message describing what the user attempted.
      """
      pass

   @abstractmethod
   def is_unlocked(self):
      """
      Checks to see if the the door was unlocked.

      REturns:
         bool: True if unlocked, false if locked.
      """
      pass

   @abstractmethod
   def clue(self):
      """
      A hint to help the user if user was unsuccessful 

      Returns:
         str: Message to assist user
      """
      pass
      

   @abstractmethod
   def success(self):
      """
      Message that is returned if the user is successful.

      Returns: 
         str: Message congratulating the user
      """
      pass