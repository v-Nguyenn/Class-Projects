"""
Brian Gutierrez and Vincent Nguyen
Lab 9 
CECS 277 Section 8 
Fall 2025
October 27, 2025
"""

from abc import ABC, abstractmethod

class Entity(ABC):
   """ Describes a character in the game."""

   def __init__(self, name, max_hp):
      """ Initializes the instance variables """
      self._name = name
      self._hp = max_hp
      self._max_hp = max_hp

   @property
   def name(self):
      """ Returns entity's name """
      return self._name
   
   @property
   def hp(self):
      """ Returns entity's hp """
      return self._hp
   
   def take_damage(self, dmg):
      """ Subtracts the damage value from the hp """
      # Max returns the highest value and this ensures hp
      # is not negative
      # self._hp = max(0, self._hp - dmg) 
      self._hp = self._hp - dmg
      if self._hp < 0:
         self._hp = 0
   
   def heal(self):
