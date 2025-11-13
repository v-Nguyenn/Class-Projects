"""
Brian Gutierrez and Vincent Nguyen
Lab 11
CECS 277 Section 8
Fall 2025
November 3, 2025
"""
from abc import ABC, abstractmethod

class Entity(ABC):
   """ Abstracts the monsters and hero which extend from. """
   def __init__(self, name, hp):
      """ Sets the name and hp attributes """
      self._name = name
      self._hp = hp

   @property
   def name(self):
      """ Decorator to get the values of _name """
      return self._name

   @property
   def hp(self):
      """ Decorator to get the values of _hp"""
      return self._hp

   def take_damage(self, dmg):
      """ Method deals the damage the entity, Subtracting the damage from the entity's HP value """
      self._hp = max(0, self._hp - dmg)

   def __str__(self):
      """ Returns a string with the entity's name and hp """
      return f"{self._name}, HP: {self._hp}"

   @abstractmethod # forgot the abstract method.
   def melee_attack(self, enemy):
      " The attack the entity does to another entity "
      pass