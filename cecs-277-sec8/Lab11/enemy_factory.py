"""
Brian Gutierrez and Vincent Nguyen
Lab 11
CECS 277 Section 8
Fall 2025
November 4, 2025
"""

from abc import ABC, abstractmethod

class EnemyFactory(ABC):
   """ Template for all enemy factories """
   @abstractmethod
   def create_random_enemy(self):
      """ 
      Creates and returns randomly generated Enemy instance 
      Subclasses must override and return an enemy or (None)
      """
      raise NotImplementedError("create_random_enemy must be implemented by subclasses")