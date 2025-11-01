"""
Brian Gutierrez and Vincent Nguyen
Lab 9 
CECS 277 Section 8 
Fall 2025
October 25, 2025
"""

from map import Map
from hero import Hero
from check_input import get_int_range
from enemy import Enemy
import random

def main():
   """ The main program of the dungeon game. """
   # Initialize name, flag, hero object, map object, and location
   name = input("What is your name, traveler? ").strip().lower().capitalize()
   game_over = False
   hero = Hero(name)
   map = Map()
   map.reveal(hero.location)

   while not game_over:
      # Display Hero, HP, and current map location
      print(hero) # Also displays HP
      print(map.show_map(hero.location))

      # Get User input for direction
      num = get_int_range(
         "1. Go North\n"
         "2. Go South\n"
         "3. Go East\n"
         "4. Go West\n"
         "5. Quit\n"
         "Enter choice: ", 1, 5)
      
      # Menu logic based on user choice
      if num == 1:
         char = hero.go_north(map)
      elif num == 2:
         char = hero.go_south(map)
      elif num == 3:
         char = hero.go_east(map)
      elif num == 4:
         char = hero.go_west(map)
      elif num == 5:
         game_over = True
         char = None # No encounter 
         print("Thank you for playing!")
   
      # Reveals the map
      if char!= 'o' and char is not None:
         map.reveal(hero.location)

      # Check what scenario is the encounter
      # 'm' == monster
      if char == 'm':
         # Constructs enemy and displays health
         monster = Enemy()
         print(f"You encounter a {monster.name}")
         print(f"HP: {monster.hp}/{monster._max_hp}")
         # Checks if the monster hp is alive and hero is alive
         while monster.hp > 0 and hero.hp > 0:
            # Prompts user to either attack or run
            option = get_int_range("1. Attack\n"
                                 "2. Run Away\n"
                                 "Enter choice: ", 1, 2)
            # Attacks monster if hero chooses 1
            if option == 1:
               print(hero.attack(monster))
               # If monster still has hp then it attacks
               if monster.hp > 0:
                  print(monster.attack(hero))
               # If monster goes to less that 0 then we remove the m and put n
               else:
                  print(f"You have slain a {monster.name}.\n")
                  map.remove_at_loc(hero.location)
            # If hero runs away from choice 2
            elif option == 2:
               # Make hero go in random direction
               moved = False
               while not moved:
                  direction = random.choice(['n', 's', 'e', 'w'])
                  if direction == 'n':
                     result = hero.go_north(map)
                     print("You ran in a random direction going North!\n")
                  elif direction == 's':
                     result = hero.go_south(map)
                     print("You ran in a random direction going South!\n")
                  elif direction == 'e':
                     result = hero.go_east(map)
                     print("You ran in a random direction going East!\n")
                  elif direction == 'w':
                     result = hero.go_west(map)
                     print("You ran in a random direction going West!\n")

                  if result != 'o':
                     moved = True
               # Real hero
               map.reveal(hero.location)
               if result == 's':
                  print("You wound up back at the beginning!")
               break # Exit combat loop to go to main loop
                  
      # 'o' == invalid direction 
      elif char == 'o':
         print("You cannot go that way...\n")
      # 'n' == nothing
      elif char == 'n':
         print("There is nothing here...\n")
      elif char == 's':
         print("You wound up back at the start of the dungeon!\n")
      # 'i' == item room 
      elif char == 'i':
         # If hero has full hp then does not heal.
         if hero.hp == hero._max_hp:
            print("You are already at full HP!\n")
         else:
            hero.heal()
            map.remove_at_loc(hero.location)
            print("You found a Health Potion! You drink it to restore your health.\n")
      # Player found the exit 
      elif char == 'f':
         print("Congratulations! You found the exit.\n"
               "Game Over.")
         game_over = True
      
      # Check if hero still has hp otherwise defeated
      if hero.hp <= 0:
         print("You have been obliterated...\n")
         game_over = True

         
if __name__ == "__main__":
   main()



