"""
Brian Gutierrez and Vincent Nguyen
CECS 277 - Sec 8
Lab 7 - entity.py
Sets the name, health, and damage attributes for the entity class.
"""

class Entity:
   """
   Represents a game entity with a name and health points and damage taken

   """


   def __init__(self, name, max_hp):
      """
      Initialize a new Entity with a name and maximum health points
      Returns: None
      """
      self._name: str = name    # specifed name of entity
      self._max_hp: int = max_hp
      self._hp: int = max_hp


   def take_damage(self, dmg):
      """
      Subtracts the damage value from the entity's health points
      Returns: None
      """
      self._hp -= dmg
      # If health drops below 0, set it to 0
      if self._hp < 0: 
         self._hp = 0


   def __str__(self):
      """
      String of the entity with its name and current/max health
      Returns: string representation hp points
      """
      return f"{self._name}: {self._hp}/{self._max_hp} HP"
   
 