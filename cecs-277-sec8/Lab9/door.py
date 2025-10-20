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
      """