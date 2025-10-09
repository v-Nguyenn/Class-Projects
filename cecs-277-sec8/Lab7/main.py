"""
Brian Gutierrez and Vincent Nguyen
CECS 277 - Sec 8
Lab 7 - main.py
"""
import check_input
from hero import Hero
from dragon import Dragon
from fire import FireDragon
from flying import FlyingDragon
from entity import Entity
import random

def main():
   """
   Main function to run the game loop where the hero either defeats
   all the dragons or is defeated.
   """

   print("What is your name, challenger?")
   hero_name = input()
   print(f"Welcome to dragon training, {hero_name}")
   print("You must defeat 3 dragons")

   hero = Hero(hero_name, 50) # Create hero with 50 HP
   dragons = [
      Dragon("Deadly Nadder", 10),
      FireDragon("Gronkle", 15),
      FlyingDragon("Timberjack", 20)
   ]  # List of dragons to fight

   
   while len(dragons) > 0 and hero._hp > 0:
      # Display hero status
      print(f"\n{hero}")
      
      # Display dragon menu
      print("\nChoose a dragon to attack:")
      for i in range(len(dragons)):
         print(f"{i + 1}. {dragons[i]}")
      
      # Get user's dragon choice
      dragon_choice = check_input.get_int_range("Enter choice: ", 1, len(dragons))
      chosen_dragon = dragons[dragon_choice - 1]  # Convert to 0-based index
      
      # Display attack menu
      print("\nAttack with:")
      print("1. Sword")
      print("2. Bow")
      attack_choice = check_input.get_int_range("Enter choice: ", 1, 2)
      
      # Hero attacks
      if attack_choice == 1:
         print(hero.sword_attack(chosen_dragon))
      else:
         print(hero.bow_attack(chosen_dragon))
      
      # Check if dragon is defeated
      if chosen_dragon._hp <= 0:
         print(f"You have defeated {chosen_dragon._name}!")
         dragons.remove(chosen_dragon)
         
         # Check if all dragons defeated
         if len(dragons) == 0:
            print("\nCongratulations! You have defeated all three dragons! \n" \
            "you have passed the trials.")
            break
      
      # Dragon's turn - random dragon attacks
      attacking_dragon = random.choice(dragons)
      attack_type = random.randint(1, 2)
      
      if attack_type == 1:
         print(attacking_dragon.basic_attack(hero))
      else:
         print(attacking_dragon.special_attack(hero))
      
      # Check if hero is defeated
      if hero._hp <= 0:
         print("\nYou have been defeated!")
         break


if __name__ == "__main__":
   main()