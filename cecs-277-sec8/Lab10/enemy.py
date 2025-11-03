"""
Brian Gutierrez and Vincent Nguyen
Lab 10
CECS 277 Section 8
Fall 2025
October 29, 2025
"""

import random
from entity import Entity

class Enemy(Entity):
   """ Monster character that the hero encounters in the maze """

   def __init__(self):
      """ Initializes monster health between 4 - 8 and random name """
      name = random.choice(["Goblin", "Vampire", "Ghoul", "Skeleton", "Zombie"])
      max_hp = random.randint(4, 8) # Random hp 4 - 8
      super().__init__(name, max_hp)
   

   def attack(self, entity):
      """ 
      Attacks the enemy hero (hero or another enemy)

      Returns:
         str: Description of the attack
      """
      damage = random.randint(1, 4) # damage 1 - 4
      entity.take_damage(damage) # call take damage on entity
      return f"{self.name} attacks {entity.name} for {damage} damage."