"""
Brian Gutierrez and Vincent Nguyen
CECS 277 - Sec 8
Lab 8
10/15/2025
motorcycle.py
"""

import random
from vehicle import Vehicle

class Motorcycle(Vehicle):
   """
   Class Motorcycle that inherits from Vehicle class
   """
   def __init__(self, name):
      """
      Constructor for Motorcycle class sets name.
      Returns: None
      """
      super().__init__(name, 'M', 8)  # Pass name, initial='M', speed=8

   def slow(self, obs_loc): 
      """
      Overridden method that passes in the obstacle 
      if there is one. The motorcycle will move at 
      75% speed +/- 1 if obstacle move around.
      Return: a string describing the event that 
              occurred with the name of the motorcycle
              and the distance traveled (if applicable)
      """
      reduced_speed = int(self._speed * (0.75))
      distance = random.randint(reduced_speed - 1, reduced_speed + 1)
   
      # Checks if there is an obstacle, if there is go around
      if obs_loc == -1:
         self.position += obs_loc + 1
         return f"{self._name} slowly moves {distance} units!"
      else:
         self.position += distance
         return f"{self._name} slows down for an obstacle and moves 1 unit!"

   
   def special_move(self, obs_loc):
      """
      Special move for the motorcycle, deducts energy, moves with 2x 
      speed but has a 75 percent chance to fail and move one space
      forward. 
      Returns: a string describing the event that occurred with the name 
               of the motorcycle and the distance traveled (if applicable)
      """      
      # Checks if there is enough energy to perform the special move
      if self.energy >= 15:
         self.energy -= 15

         # 25 percent chance to fail the special move
         if random.randint(1, 4) == 4:
            self.position += 1
            return (f"{self._name} tried to pop a wheelie and falls over moves 1 unit")
         
         # Calulate the distance traveled
         distance = random.randint((self._speed * 2) - 1, (self._speed * 2) + 1)

         # Checks if there is an obstacle in the way and crashes if there is
         if obs_loc != -1 and self.position + distance >= obs_loc: 
            self.position = obs_loc
            return (f"{self._name} tried to pop a wheelie but CRASHED into an obstacle")

         # Performs the special move successfully
         self.position += distance
         return (f"{self._name} pops a wheelie and moves {distance} units!")
      else:
         # Not enough energy to move, moves only 1 space
         self.position += 1
         return (f"{self._name} tries to pop a wheelie, but is all out of energy and moves 1 unit!")