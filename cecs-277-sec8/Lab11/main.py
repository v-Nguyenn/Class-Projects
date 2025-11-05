"""
Brian Gutierrez and Vincent Nguyen
Lab 11
CECS 277 Section 8
Fall 2025
November 4, 2025

Main file of Monster trials which is a game where the user 
must defeat three monsters to pass the trial. Uses Factory Method
"""
from check_input import get_int_range
from hero import Hero
from beg_factory import BeginnerFactory
from exp_factory import ExpertFactory

def main():
   """ 
   Main program to run the Monster Trials game.

   Main that prompts the user for their name, constructs the 
   hero objects, and the factories. The factories then generate
   a list of three monsters, two beginners, and an expert that
   the user fights.  
   """

   # Creates an initial menu and asks for user name.
   print("Monster Trials")
   name = input("What is your name?: ").strip().lower().capitalize()
   # Construct the hero after getting name.
   hero = Hero(name)
   finished = False
   print(f"You will face a series of 3 monsters, {hero.name}.")
   # Creates the factory object to be called
   beginner_factory = BeginnerFactory()
   expert_factory = ExpertFactory()
   # Stores two easy monsters and one expert monster
   monsters = [
      beginner_factory.create_random_enemy(),
      beginner_factory.create_random_enemy(),
      expert_factory.create_random_enemy()
   ]

   while not finished:
      # build menu from monsters list (last option = Quit)
      menu_lines = []
      for i, monster in enumerate(monsters):
         menu_lines.append(f"{i + 1}. {monster.name} HP: {monster.hp}")
      # Adds the quit since the list is only 3
      menu_lines.append(f"{len(monsters) + 1}. Quit\n")
      # Makes it print on multiple lines as desired
      prompt = "\n".join(menu_lines) + "Enter choice"
      choice = get_int_range(prompt, 1, len(menu_lines))
      # Checks if user quit first
      if choice == len(menu_lines):
         finished = True
         break 
      # Select the chosen monster. Since the index is 0 over we must subtract 1
      selected_monster = monsters[choice - 1]
      # Combat loop
      while selected_monster.hp > 0 and hero.hp > 0:
         combat_menu = "1. Sword Attack\n2. Arrow Attack\nEnter choice:"
         action = get_int_range(combat_menu, 1, 2)
         if action == 1:
            # The hero attacks with melee attack
            print(hero.melee_attack(selected_monster))
         else:
            # The hero attacks with ranged attack
            print(hero.range_attack(selected_monster))

         # Monster attacks back only if alive
         if selected_monster.hp > 0:
            print(selected_monster.melee_attack(hero))
      
      # Should exit loop if less so goes here to remove monster or end game if hero died
      if selected_monster.hp <= 0:
         print(f"You have slain the {selected_monster.name}")
         monsters.remove(selected_monster)
      # Ends the game if the hero dies
      if hero.hp <= 0:
         print(f"You have died.")
         finished = True
      
if __name__ == "__main__":
   main()