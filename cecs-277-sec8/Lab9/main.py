"""
Brian Gutierrez and Vincent Nguyen
Lab 9
CECS 227 Section 8
Fall 2024
October 23, 2025
"""


import random
from check_input import get_int_range
from door import Door
from basic_door import BasicDoor
from locked_door import LockedDoor
from deadbolt_door import DeadboltDoor
from combo_door import ComboDoor
from code_door import CodeDoor

def main():
   """
   The main program for the Escape game.
   """
   print("Welcome to the Escape Room \n"
         "You must unlock 3 doors to escape...")

   # Create a list 
   all_door_types = [
      BasicDoor,
      LockedDoor,
      DeadboltDoor,
      ComboDoor,
      CodeDoor,
   ]

   # Uses .sample to randomly pick items from a list with no
   # duplicates
   selected_door = random.sample(all_door_types, 3)

   # Create the instances of those selected door
   doors = [door_type() for door_type in selected_door]

   # Go through the doors
   for i, door in enumerate(doors, 1):
      print(f"\n --- Door {i} ---")
      print(door.examine_door()) # Any door type
      
      # Door is locked so it will iterate through
      while not door.is_unlocked():
         print(door.menu_options())
         choice = get_int_range("", 1, door.get_menu_max())
         result = door.attempt(choice)
         print(result)
   
if __name__ == "__main__":
   main()