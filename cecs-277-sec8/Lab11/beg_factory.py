"""
Brian Gutierrez and Vincent Nguyen
Lab 11
CECS 277 Section 8
Fall 2025
November 4, 2025
"""

from random import choice
from enemy_factory import EnemyFactory
from beg_goblin import BegGoblin
from beg_troll import BegTroll

class BeginnerFactory(EnemyFactory):
   """ Factory that creates easy enemies.

   Functions:
      create_random_enemy(self) - Creates a easy difficulty monster

   Usage:
      BeginnerFactory().create_random_enemy()
   """
   def create_random_enemy(self):
      """ Returns a random object choice. """
      return choice([BegTroll(), BegGoblin()])