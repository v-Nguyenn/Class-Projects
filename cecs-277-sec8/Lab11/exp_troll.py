"""
Brian Gutierrez and Vincent Nguyen
Lab 11
CECS 277 Section 8
Fall 2025
November 4, 2025
"""

from random import randint
from entity import Entity

class ExpTroll(Entity):
   """ Creates and Expert Troll with name, random hp, and random attack values """
   def __init__(self):
      """ Constructs the objects name and random hp from 15 - 18. """
      super().__init__("Raging Troll", randint(15, 18))

   def melee_attack(self, enemy):
      """
      Randomizes the attack value from 8 - 12 

      Returns:
         str: A description of the attack 
      """
      damage_amount = randint(8, 12)
      enemy.take_damage(damage_amount)
      return f"{self.name} swings at {enemy.name} for {damage_amount} damage."