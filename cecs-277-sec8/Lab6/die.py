# Brian Gutierrez and Vincent Nguyen
# Lab 6 - CECS 227 Section 8 - Fall 2024
# October 15, 2024
# Die class - has two attribbutes: the number of sides of the die
# and the value of the rolled die.  The class has methods to roll

import random

class Die:
   """ A class representing a die with a specified number of sides.
   """

   def __init__(self, sides=6):
      """  Initializes a Die object and assigns the number of sides.

      Set the value to either 0 or the returned value of roll()

      Args:
         sides (int): The number of sides on the die. Set to 6
      
      Returns:
         None
      """
      self._sides = sides       # Assign sides to the sides parameter
      self._value = self.roll() # Roll the die to get an initial value


   def roll(self):
      """  Simulates rolling die between 1 and the number of sides.

      Args:
         self (Die): the current object

      Returns:
         int: A random integer between 1 and the number of sides.
      """
      value = random.randint(1, self.sides)
      return value 


   def __str__(self):
      """  Returns the Die's value as a string.

      Args:
         self (Die): the current object

      Returns:
         str: The Die's value as a string.
      """
      return(str(self.value))
   

   def __lt__(self, other):
      """ Compares two Die objects values if one is less than the other.

      Args:
         self (Die): the current object
         other (Die): another Die object to compare to

      Returns:
         bool: return true if the value of self is less than the value of other
      """
      if self.value < other.value:
         return True
      else:
         return False


   def __eq__(self, other):
      """
      Compares two Die objects values if they are equal

      Args:
         self (Die): the current object
         other (Die): another Die object to compare to

      Returns:
         bool: return true if the value of self is equal to the value of other
      """
      if self.value == other.value:
         return True
      else:
         return False
      

   def __sub__(self, other):
      """ Subtracts the value of one Die object from another.
      
      Args:
         self (Die): the current object
         other (Die): another Die object to compare to
         
      Returns:
         int: The difference between the value of self and the value of other.
      """
      return self.value - other.value
   
