# Vincent Nguyen, Brian Gutierrez
# Monday, August 25, 2025
# CECS 277 Lab 1, 
# Guessing game which generates a random number between 1 and 100 and then 
# asks the user to guess a number between 1 and 100

import random
import Lab1.check_input as check_input

def main():
   random_number = random.randint(1, 100)
   attempt_counter = 0

   print(" - Guessing Game - ")
   guess = -1

   # Loops until the user guesses the correct number
   print("I'm thinking of a number.", end= "")

   while guess != random_number:
       # guess variable uses the imported file check_input to check any inputs out of bounds
       guess = check_input.get_int_range(" Make a guess (1-100): ", 1, 100)
       attempt_counter += 1 # adds 1 to the counter when the user makes a guess
       if guess < random_number:
          print("Too Low! Guess again (1-100): ")
       else:
          print("Too High! Guess again (1-100): ")


   print("Correct! You got it in", attempt_counter + 1, "tries.")

if __name__ == "__main__":
   main()