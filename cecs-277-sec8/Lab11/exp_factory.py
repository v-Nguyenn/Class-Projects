"""
Brian Gutierrez and Vincent Nguyen
Lab 11
CECS 277 Section 8
Fall 2025
November 4, 2025
"""

from random import choice
from enemy_factory import EnemyFactory
from exp_goblin import ExpGoblin
from exp_troll import ExpTroll

class ExpertFactory(EnemyFactory):
   """ Class creates difficult enemies.
   
   Functions:
      create_random_enemy(self) - creates a random hard difficulty monster

   Usage:
      ExpertFactory().create_random_enemy()
   """  
   def create_random_enemy(self):
      """ Returns an expert monster randomly. """
      return choice([ExpGoblin(), ExpTroll()])