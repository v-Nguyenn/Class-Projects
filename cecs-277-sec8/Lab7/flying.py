"""
Brian Gutierrez and Vincent Nguyen
CECS 277 - Sec 8
Lab 7 - flying.py
Inherits from dragon.py and sets how much damage the flying enemy can do
with a swoop attack.
"""

import random
from dragon import Dragon

class FlyingDragon(Dragon):
   """
   A flying dragon that inherits the Dragon class and has a swoop attack.
   """

   def __init__(self, name, hp):
      """
      Calls super to set the name and hp and then assigns a default value to 
      swoop attacks
      Returns: None 
      """
      super().__init__(name, hp)
      self.swoop_attacks = 3


   def special_attack(self, hero):
      """
      Overridden swoop attack - if the dragon has swoop attacks left, it will
      apply a random amount of damage to the hero in the range of 5-8
      Returns a string describing the attack or if there are no swoop attacks left
      """
      if self.swoop_attacks > 0:
         swoop_dmg = random.randint(5, 8) # Random damage between 5 and 8
         hero.take_damage(swoop_dmg)      # Apply damage to hero
         self.swoop_attacks -= 1          # Decrease swoop attacks by 1
         return f"{self._name} swoops down and claws you for {swoop_dmg} damage!"
      else:
         # No swoop attacks left
         return f"{self._name} tries to swoop at you but is too tired to fly."
      
   
   def __str__(self):
      """
      Gets __str__ from Entity class then adds on the number of swoop_attacks
      Returns: string representation of flying dragon
      """
      return super().__str__() + f" \nSwoop Attacks remaining: {self.swoop_attacks}"