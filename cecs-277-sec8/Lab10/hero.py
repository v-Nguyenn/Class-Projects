"""
Brian Gutierrez and Vincent Nguyen
Lab 9
CECS 277 Section 8
Fall 2025
October 27, 2025
"""

import random
from entity import Entity

class Hero(Entity):
   """ The user's character """
   def __init__(self, name):
      """ Initializes name, max_hp=25, and location at (0,0)"""
      super().__init__(name, 25) # name, max_hp = 25
      self._row = 0 # starting position
      self._col = 0 
   
   @property
   def location(self):
      """ Returns the hero's location """
      return (self._row, self._col)
   
   def attack(self, entity):
      """ 
      Hero attacks the enemy with damage between 2 - 5
      
      Args: 
         entity: The entity to attack
      
      Returns: 
         str: Description of the attack
      """
      damage = random.randint(2, 5)
      entity.take_damage(damage)
      return f"{self.name} attacks {entity.name} for {damage} damage."
   
   def go_north(self, map):
      """ Checks and updates the user going North """
      if self._row - 1 >= 0: # Checks if user is not at the top edge
         self._row -= 1 # Move up
         return map[self._row][self._col] # Returns location
      else:
         return 'o' # Returns 'o' for out of bounds
      
   def go_south(self, map):
      """ Checks and updates the user going South """
      if self._row + 1 < len(map): # Checks if user is at bottom edger
         self._row += 1 # Move down
         return map[self._row][self._col] 
      else:
         return 'o' 
      
   def go_east(self, map):
      """ Checks and updates the hero's location going east """
      if self._col + 1 < len(map[0]): # Checks if the user is not at the right edge
         self._col += 1 # Moves right
         return map[self._row][self._col]
      else:
         return 'o' 

   def go_west(self, map):
      """ Checks and updates the hero's location going west """
      if self._col - 1 >= 0: # Checks if the user is not at the left edge
         self._col -= 1 # Moves left
         return map[self._row][self._col]
      else:
         return 'o'
      
   
   
   