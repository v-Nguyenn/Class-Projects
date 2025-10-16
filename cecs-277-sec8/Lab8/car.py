"""
Brian Gutierrez and Vincent Nguyen
CECS 277 - Sec 8
Lab 8
10/15/2025
car.py
"""

import random
from vehicle import Vehicle


class Car(Vehicle):
   """
   A class representing a car, inheriting from the Vehicle class.
   """
   def __init__(self, name):
      """
      Constructor for Car class sets name, label as 'C' and speed as 10.
      Returns: None
      """
      super().__init__(name, 'C', 7)  # Pass name, initial='C', speed=7


   def special_move(self, obs_loc):
      """
      Nitro boost moves the car 1.5 times its speed passing in the location
      of the next obstacle if there is one. Checks for enough energy >= 15
      and checks if their is an obstacle within the nitro range. Crashes if so.
      Returns: A string describing the event that happened with the name of 
               the car.
      """
      # Checks if car has enough energy to use nitro boost
      if self.energy >= 15:
         self.energy -= 15
         nitro_speed = int(self._speed * 1.5)
         nitro_distance = random.randint(nitro_speed - 1, nitro_speed + 1)

         # Checks if there is an obstacle within the nitro range 
         if obs_loc != -1 and self.position < obs_loc <= self.position + nitro_distance:
            self.position = obs_loc
            return f"{self._name} crashes into an obstacle using nitro boost at {obs_loc}!"
         else:
            # No obstacle in range moves forward normally
            self.position += nitro_distance
            return f"{self._name} uses nitro boost and moves {nitro_distance} units!"
      else:
         # Not enough energy to use nitro boost so move 1 unit forward
         self.position += 1
         return f"{self._name} tries to use nitro boost, but is all out of energy!"
