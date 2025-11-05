"""
Brian Gutierrez and Vincent Nguyen
Lab 11
CECS 277 Section 8
Fall 2025
November 3, 2025
"""

from entity import Entity
import random 

class Hero(Entity):
   """ The User's character extending from entity """
   def __init__(self, name):
      """ Initialize Hero with name, max HP 25 """
      super().__init__(name, 25)

   def melee_attack(self, enemy):
      """ 
      Deals damage based on the sum of a 2, 6 sided dice to enemy.
      
      Returns:
         str: Description of the attack
      """
      die1 = random.randint(1, 6)
      die2 = random.randint(1, 6)
      dmg = die1 + die2
      enemy.take_damage(dmg)
      return f"{self.name} slashes a {enemy.name} with a sword for {dmg} damage."
   
   def range_attack(self, enemy):
      """ 
      Deals damage based on the 1, 12 sided die to the enemy

      Returns:
         str: Description of the attack
      """
      dmg = random.randint(1, 12)
      enemy.take_damage(dmg)
      return f"{self.name} pierces a {enemy.name} with an arrow for {dmg} damage."