"""
Brian Gutierrez and Vincent Nguyen
CECS 277 - Sec 8
Lab 7 - dragon.py
Inherits from entity.py and sets how much damage the dragon can do
"""

import random
from entity import Entity


class Dragon(Entity):
   """
   Represents a dragon inheriting from Entity and has a basic attack
   and a special attack.
   """


   def basic_attack(self, hero):
      """
      Tail attack that inflicts damage to the hero ranging from a 
      random amount of damage in the range of 2 - 5
      Returns a string describing the attack and damage
      """
      tail_dmg = random.randint(2, 5) # Random damage between 2 and 5
      hero.take_damage(tail_dmg)      # Apply damage to hero
      return f"{self._name} smashes you with its tail for {tail_dmg} damage."
   

   def special_attack(self, hero):
      """
      Claw attack that inflicts the hero a random amount of damage in the
      range of 3 - 7
      Returns a string describing the attack and damage
      """
      claw_dmg = random.randint(3, 7) # Random damage between 3 and 7   
      hero.take_damage(claw_dmg)      # Apply damage to hero
      return f"{self._name} slashes you with its claws for {claw_dmg} damage."