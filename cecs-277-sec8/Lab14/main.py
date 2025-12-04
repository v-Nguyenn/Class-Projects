"""
Brian Gutierrez and Vincent Nguyen
Lab 14
CECS 277 Section 8
Fall 2025
December 3, 2025

main.py runs the puppy simulator. Puppy starts in asleep and wakes up being fed, goes until user quits.
"""

from check_input import get_int_range
from puppy import Puppy

def main():
   """Constructs a puppy object and then displays a menu that allows the user to play with the puppy or feed it.
   
   Displays the puppy's reaction to the user's choice and repeats until the user decides to quit.
   """
   puppy = Puppy()
   running = True
   print("Congratulations on your new puppy!")
   while running:
      print("What would you like to do?")
      print("1. Feed the puppy")
      print("2. Play with the puppy")
      print("3. Quit")
      choice = get_int_range("Enter choice: ", 1, 3)
      print()

      if choice == 1:
         print(puppy.give_food())
      if choice == 2:
         print(puppy.throw_ball())
      if choice == 3:
         print("Thank you for playing with doggo!")
         break

if __name__ == "__main__":
   main()
