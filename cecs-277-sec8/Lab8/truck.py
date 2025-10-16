"""
Brian Gutierrez and Vincent Nguyen
CECS 277 - Sec 8
Lab 8
10/15/2025
truck.py
"""

from vehicle import Vehicle

class Truck(Vehicle):
   """
   Class Truck that inherits from Vehicle Class
   """
   def __init__(self, name):
      """
      Constructor for Truck class sets name.
      Returns: None
      """
      super().__init__(name, 'T', 5)  # Pass name, initial='T', speed=5

      
   def special_move(self, obs_loc):
      """
      Special move for the truck, deducts energy, moves with 2x speed
      , goes through obstacles and moves one space forward if no energy. 
      Returns: a string describing the event that occurred with the name 
               of the truck and the distance traveled (if applicable)
      """      

      # Checks if there is enough energy to perform the special move
      if self.energy >= 15:
         self.energy -= 15
         distance = self._speed * 2
         self.position += distance

         # Checks if there is an obstacle
         if obs_loc != -1 and self.position >= obs_loc:
            return (f"{self._name} rams through an obstacle moves {distance} units!")
         else:
            return (f"{self._name} rams forward moves {distance} units!")
      else:
         self.position += 1
         return (f"{self._name} tries to ram forward, but is out of energy and moves 1 unit!")