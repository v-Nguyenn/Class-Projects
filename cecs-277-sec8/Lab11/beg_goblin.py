"""
Brian Gutierrez and Vincent Nguyen
Lab 11
CECS 277 Section 8
Fall 2025
November 4, 2025
"""
from random import randint
from entity import Entity

class BegGoblin(Entity):
   """ The easy monster of a goblin that is constructed """
   def __init__(self):
      """ Constructs the goblin assigning name and random hp """
      super().__init__("Goblin", randint(7, 9))

   def melee_attack(self, enemy):
      """ 
      Randomizes the damage between 4 - 6 
      
      Returns:
         str: Description of the attack
      """
      damage_amount = randint(4, 6)
      enemy.take_damage(damage_amount) # enemy is hero
      return f"{self.name} bites {enemy.name} for {damage_amount} damage."
   