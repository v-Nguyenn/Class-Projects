"""
Brian Gutierrez and Vincent Nguyen
CECS 277 - Sec 8
Lab 7 - fire.py
Inherits from dragon.py and sets how much damage the fire dragon can do
"""

import random
from dragon import Dragon

class FireDragon(Dragon):
   """
   A fire dragon that inherits the Dragon class and has a fire shot attack
   """


   def __init__(self, name, hp):
      """
      Calls super to inherit from Entity and then sets fire shots to 2
      """
      super().__init__(name, hp)
      self.fire_shots = 2


   def special_attack(self, hero):
      """
      Overridden fire attack - if the dragon has fire shots left, it will
      apply a random amount of damage to the hero in the range of 6-9
      Returns a string describing the attack or if there are no fire shots left
      """   
      if self.fire_shots > 0:
         fire_dmg = random.randint(6, 9)
         hero.take_damage(fire_dmg)  # Apply damage to hero
         self.fire_shots -= 1        # Decrease fire shots by 1
         return f"{self._name} engulfs you in flames for {fire_dmg} damage!"
      else:
         # No fire shots left
         return f"{self._name} tries to spit fire at you but is all out of fire shots."


   def __str__(self):
      """
      Uses super to get __str__ from Entity class then adds on the number of fire_shots
      Returns: string representation of fire dragon
      """
      return super().__str__() + f" \nFire Shots remaining: {self.fire_shots}"