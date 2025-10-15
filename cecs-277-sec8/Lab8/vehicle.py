"""
Brian Gutierrez and Vincent Nguyen
CECS 277 - Sec 8
Lab 8
10/15/2025
vehicle.py
"""

import random
from abc import ABC, abstractmethod

class Vehicle(ABC):
   """
   An Abstract Class that creates a name, label, speed, position and
   current location on track and vehicle's power level.
   """

   def __init__(self, name, initial, speed):
      """
      Constructor for Vehicle class sets name, label, speed
      Returns: None
      """
      self.name = name
      self.initial = initial
      self.speed = speed
      self.position = 0
      self.energy = 100

   # Decorator for initial 
   @property 
   def initial(self):  
      return self._initial
   
   @initial.setter
   def initial(self, value):
      self._initialinitial = value

   # Decorator for position
   @property
   def position(self):
      return self._position

   @position.setter
   def position(self, value):
      self._position = value

   # Decorator for energy
   @property
   def energy(self):
      return self._energy
   
   @energy.setter
   def energy(self, value):
      self._energy = value


   def fast(self, obs_loc):
      """
      Passes in the location of the next obstacle if there is one
      then randomzies the distance traveled between +/- 1.
      Returns: a string that describes the event that occurred 
               with the name of the vehicle and distance traveled
      """   
      # Checks if you enough energy to move
      if self.energy >= 5:
         distance = random.randint(self.speed -1, self.speed + 1)
         self.position += distance
         self.energy -= 5
         
         # Checks if you hit an obstacle
         if obs_loc != -1 and self.position >= obs_loc:
            self.position = obs_loc
            return(f"{self.name} CRASHED into an obstacle! ")

         # Moves fast successfully
         return(f"{self.name} moved {distance} spaces forward.")
      else:
         # Not enough energy to move, moves only 1 space
         self.position += 1
         return(f"{self.name} tries to ram forward, but is all out \
                of energy! ")
      

   def slow(self, obs_loc):
      """
      Passes in the location of the next obstacle if there is one and
      move the vehicle at half speed. If there is no obstacle it will
      will go around it.
      Returns: a string that describes the event that occurred 
               with the name of the vehicle and distance traveled
      """
      half_speed = self.speed // 2 
      distance = random.randint(half_speed -1 , half_speed + 1)

      # Checks if there is an obstacle and moves around it
      # obs_loc = -1 means no obstacle
      # self.position < obs_loc <= self.position + distance checks if
      # the obstacle is within the distance traveled
      if obs_loc != -1 and self.position < obs_loc <= self.position + distance:
         # Moves around the obstacle
         self.position = obs_loc + 1 
         return(f"{self.name} slowly dodges the obstacle and \
                moves {distance} units!")
      else:
         # Moves normally
         self.position += distance
         return(f"{self.name} slowly moves {distance} units!")
      

   def __str__(self):
      """
      Returns: a string that displays the vehicle's name, position, and
      energy.
      """
      return(f"{self.name} [Position - {self.position}, Energy - {self.energy}]")


   @abstractmethod
   def special_move(self, obs_loc):
      """
      Abstract method overriden in the subclasses.
      """
      pass

