"""
Brian Gutierrez and Vincent Nguyen
Lab 9
CECS 277 Section 8
Fall 2025
October 23, 2025
"""

import random
from door import Door

class DeadboltDoor(Door):
   """
   A door with two deadbolts that need to be unlocked to open the door.
   """

   def __init__(self):
      """
      Initializes the state of the two bolts.
      """
      self._deadbolt_one = random.choice(["unlocked", "locked"])
      self._deadbolt_two = random.choice(["unlocked", "locked"])
      self._is_locked = True

   def examine_door(self):
      """
      Returns a string with two deadbolts, and both need to be unlocked

      Returns:
         str: Description of the deadbolt door.
      """   
      return ("You encounter a double deadbolt door, both deadbolts must be unlocked to open it, "
              "but you can't tell from looking at them whether they're locked or unlocked.")

   def menu_options(self):
      """
      Returns a string of the two menu options for the deadbolt door.

      Returns:
         str: Returns a string with two options, 1 to toggle bolt, 2 to toggle bolt
      """
      return ("1. Toggle Bolt 1\n"
              "2. Toggle Bolt 2")
   
   def get_menu_max(self):
      """
      Returns the the number of options in the deadbolt menu above

      Returns:
         int: the number of options
      """
      return 2
   
   def attempt(self, option):
      """
      Uses the value option to determine if the door gets unlocked

      Args:
         option (int): The deadbolt to toggle (1 or 2)

      Returns:
         str: A string describing what the user did
      """
      if option == 1:
         # Toggle deadbolt one
         if self._deadbolt_one == "locked":
            self._deadbolt_one = "unlocked"
         else:
            self._deadbolt_one = "locked"
         message = "You toggle the first bolt."
      elif option == 2:
         # Toggle deadbolt two
         if self._deadbolt_two == "locked":
            self._deadbolt_two = "unlocked"
         else:
            self._deadbolt_two = "locked"
         message = "You toggle the second bolt."
      else:
         return "Invalid option."
      
      # Check if both deadbolts are unlocked
      if self._deadbolt_one == "unlocked" and self._deadbolt_two == "unlocked":
         self._is_locked = False
         return f"{message}\n{self.success()}"
      else:
         return f"{message}\n{self.clue()}"
   
   def is_unlocked(self):
      """
      Checks to see if the door is unlocked

      Returns:
         bool: True if unlocked and False if locked
      """
      return not self._is_locked
   
   def clue(self):
      """
      Returns a hint if the user hasn't unlocked the door yet

      Returns:
         str: A hint for the player
      """
      # Check how many bolts are unlocked
      unlocked_count = 0
      if self._deadbolt_one == "unlocked":
         unlocked_count += 1
      if self._deadbolt_two == "unlocked":
         unlocked_count += 1
      
      # Return appropriate clue based on state
      if unlocked_count == 1:
         return "You jiggle the door...it seems like one of the bolts is unlocked."
      else:  # both locked
         return "You jiggle the door...it's completely locked."
   
   def success(self):
      """
      Congratulatory message if the user unlocked both deadbolts

      Returns:
         str: Message telling the user they succeeded
      """
      return "You unlocked both deadbolts and opened the door."