"""
Brian Gutierrez and Vincent Nguyen
Lab 9 
CECS 277 Section 8
Fall 2025
October 23, 2025
"""

import random
from door import Door

class CodeDoor(Door):
   """
   A door with a coded keypad that has three characters. Each key toggles
   between 'X' and 'O'.
   """

   def __init__(self):
      """
      Initializes the door by randomizing the secret code (3 characters)
      and setting the player's current code to a different starting state.
      """
      # Generate random secret code
      self._secret_code = [random.choice(['X', 'O']) for _ in range(3)]
      
      # Initialize player's current code (start with random values)
      self._player_code = [random.choice(['X', 'O']) for _ in range(3)]
      
      self._is_locked = True

   def examine_door(self):
      """
      Returns a description of the door.

      Returns:
         str: Description of the coded keypad door.
      """
      return ("A door with a coded keypad with three characters. "
              "Each key toggles a value with an 'X' or an 'O'.")

   def menu_options(self):
      """
      Returns the menu options for pressing keys.

      Returns:
         str: Menu showing the three keys to press.
      """
      return ("1. Press Key 1\n"
              "2. Press Key 2\n"
              "3. Press Key 3")

   def get_menu_max(self):
      """
      Returns the number of options in the menu.

      Returns:
         int: The number of keys (3).
      """
      return 3

   def attempt(self, option):
      """
      Toggles the selected key and checks if the code is correct.

      Args:
         option (int): The key to press (1, 2, or 3).

      Returns:
         str: A string describing what happened.
      """
      # Convert option to index (1-3 → 0-2)
      index = option - 1
      
      # Toggle the selected key
      if self._player_code[index] == 'X':
         self._player_code[index] = 'O'
      else:
         self._player_code[index] = 'X'
      
      message = f"You press key {option}."
      
      # Check if code is correct
      if self._player_code == self._secret_code:
         self._is_locked = False
         return f"{message}\n{self.success()}"
      else:
         return f"{message}\n{self.clue()}"

   def is_unlocked(self):
      """
      Checks if the door is unlocked.

      Returns:
         bool: True if unlocked, False if locked.
      """
      return not self._is_locked

   def clue(self):
      """
      Gives a clue about how many characters are correct.

      Returns:
         str: A message showing the number of correct characters.
      """
      # Count how many characters match
      correct_count = 0
      for i in range(3):
         if self._player_code[i] == self._secret_code[i]:
            correct_count += 1
      
      return f"{correct_count} character(s) are correct."

   def success(self):
      """
      Returns the success message.

      Returns:
         str: Congratulatory message.
      """
      return "You cracked the code and opened the door!"
