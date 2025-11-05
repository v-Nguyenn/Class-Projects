"""
Brian Gutierrez and Vincent Nguyen
Lab 11
CECS 277 Section 8
Fall 2025
November 4, 2025
"""

from random import randint
from entity import Entity

class ExpGoblin(Entity):
   """ Creates an expert goblin with random hp and attack """
   def __init__(self):
      """ Constructs the expert goblin with name and random hp. """
      super().__init__("Raging Goblin", randint(12, 15))

   def melee_attack(self, enemy):
      """ 
      Randomizes the attack to the hero from  5 - 8. 

      Returns:
         str: A description of the attack
      """
      damage_amount = randint(5, 8)
      enemy.take_damage(damage_amount) 
      return f"{self.name} slams {enemy.name} for {damage_amount} damage."