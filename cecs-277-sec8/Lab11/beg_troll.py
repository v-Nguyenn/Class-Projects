"""
Brian Gutierrez and Vincent Nguyen
Lab 11
CECS 277 Section 8
Fall 2025
November 4, 2025
"""
from random import randint
from entity import Entity

class BegTroll(Entity):
   """ The easy version of the monster Troll """
   def __init__(self):
      """ Defaults the monsters name and random hp from 8 - 10 """
      super().__init__("Troll", randint(8, 10)) 

   def melee_attack(self, enemy):
      """ 
      Randomizes attack damage from 5 - 9 

      Returns:
         str: Describes the attack of the troll 
      """
      damage_amount = randint(5, 9)
      enemy.take_damage(damage_amount) # Attack to hero
      return f"{self.name} smacks {enemy.name} for {damage_amount} damage."
