# Brian Gutierrez and Vincent Nguyen
# Lab 6 - CECS 227 Section 8 - Fall 2024
# October 15, 2024
# Dice class

import random

class Die:
   """ A class representing a die with a specified number of sides.
   """

   def __init__(self, sides=6):
      """ Initializes a Die object and assigns the number of sides.
      Set the value to either 0 or the returned value of roll()

      Args:
         sides (int): The number of sides on the die. Set to 6
      
      Returns:
         None
      """
      self.sides = sides # Assign sides to the sides parameter
      self.value = 0 # Initialize value to 0
      self.value = self.roll() # Roll the die to get an initial value

   def roll(self):
      """ Simulates rolling die between 1 and the number of sides.

      Args:
         self (Die): the current object

      Returns:
         int: A random integer between 1 and the number of sides.
      """
      value = random.randint(1, self.sides)
      return value 

   def __str__(self):
      """ Returns the Die's value as a string.

      Args:
         self (Die): the current object

      Returns:
         str: The Die's value as a string.
      """
      return(str(self.value))
   
   def __lt__(self, other):
      """ Compares two Die objects based on their values.
      
      Args:
         self (Die): the current object
         other (Die): another Die object to compare to

      Returns:
         """