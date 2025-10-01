# Brian Gutierrez and Vincent Nguyen
# Lab 6 - CECS 227 Section 8 - Fall 2024
# October 15, 2024
# player.py - Player class that keeps track of the player's name and score.

from operator import __eq__
from operator import __lt__  
from die import Die

class Player:
   """ A class representing a player with a score and 3 Die objects.
   """

   def __init__(self):
      """ Constructs and sorts the list of three Die objects and the
          player's points and then initializes the player's points to 0.

      Args:
         self (Player): the current object
         
      Returns:
         None
      """
      self._dice = [Die(), Die(), Die()] # List of 3 Die objects
      self._dice.sort()                  # Sort the list of Die objects
      self._points = 0                   # Player's points initialized to 0


   @property # turns it into a getter to access the private attribute
   def points(self): 
      """ Gets the player's points.

      Args:
         self (Player): the current object

      Returns:
         int: the player's points
      """
      return self._points 
   
   @points.setter
   def points(self, value):
      """ Sets the player's points.

      Args:
         self (Player): the current object
         value (int): the new points value
      """
      self._points = value 
   

   def roll_dice(self):
      """ Rolls each of the Die objects in the list and then sorts
          the list of Die objects.
          
      Args:
         self (Player): the current object
      
      Returns:
         None
            """
      for die in self._dice:
         die.roll()
      self._dice.sort()

   
   def has_pair(self):
      """ Checks if the player has a two dice with the same values.
      
      Args:
         self (Player): the current object
         
      Returns:
         bool: true if the player has a pair, false otherwise
      """
      if __eq__(self._dice[0], self._dice[1]) or __eq__(self._dice[1], self._dice[2]) \
      or __eq__(self._dice[0], self._dice[2]):
         return True
      return False


   def has_three_of_a_kind(self):
      """ Checks if the player has three dice with the same values
      
      Args:
         self (Player): the current object
      
      Returns:
         bool: true if the player has three of a kind, false otherwise
      """
      # Is the first die equal to the second die and the second die equal to the third die
      if self._dice[0] == self._dice[1] and self._dice[1] == self._dice[2]:
         return True
      return False
 
   
   def has_series(self):
      """ Checks if player has values in a specific order (e.g. 1, 2, 3 or 2,3,4
          or 3,4,5 or 4,5,6).
          
      Args:
         self (Player): the current object
         
      Returns:
         bool: true if the player has a series, false otherwise
      """
      # Is the third die equal to the second die + 1 and the second die equal to the first die + 1
      if (self._dice[1] - self._dice[0]) == 1 and (self._dice[2] - self._dice[1]) == 1:
         return True
      return False
   
   
   def __str__(self):
      """ Returns a string in the the format: "D1=2, D2=4, D3=6"

      Args:
         self (Player): the current object  
      
      Returns:
         str: the string value of the player's dice values
      """
      # I had an error here because I used 'str' as a variable name which
      # conflicts with the built-in str() function. Changed it to 'result'.
      result = "D1=" + str(self._dice[0]) + ", D2=" + str(self._dice[1]) + \
          ", D3=" + str(self._dice[2])
      return result