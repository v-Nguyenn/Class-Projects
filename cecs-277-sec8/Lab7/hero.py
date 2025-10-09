"""
Brian Gutierrez and Vincent Nguyen
CECS 277 - Sec 8
Lab 7 - hero.py
Inherits from entity.py and sets how much damage the hero can do
with a sword attack and a bow attack.
"""

import random
from entity import Entity

class Hero(Entity):
   """
   Represents a hero character in the game, inheriting from Entity.
   """


   def sword_attack(self, dragon):
      """
      Inflicts sword damage on the given dragon by rolling two six-sided dice.
      Returns a string describing the attack and the damage dealt.
      """
      roll1 = random.randint(1, 6)  # First die roll
      roll2 = random.randint(1, 6)  # Second die roll
      sword_dmg = roll1 + roll2     # Damage is the sum of both rolls
      dragon.take_damage(sword_dmg) # Apply damage to dragon
      return f"You slash the {dragon._name} with your sword for {sword_dmg} damage."


   def bow_attack(self, dragon):
      """
      Returns the damage inflicted by a bow attack on the given dragon by
      rolling one 12-sided die.
      Returns a string describing the attack and the damage dealt.
      """
      bow_dmg = random.randint(1, 12) # Roll a 12-sided die for damage
      dragon.take_damage(bow_dmg)     # Apply damage to dragon
      return f"You hit the {dragon._name} with an arrow for {bow_dmg} damage."