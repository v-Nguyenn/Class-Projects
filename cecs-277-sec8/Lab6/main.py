# Brian Gutierrez and Vincent Nguyen
# Lab 6 - CECS 227 Section 8 - Fall 2024
# October 15, 2024
# Dice Game that awards the user points for a pair,
# three of a kind, or a series. 

import check_input
from player import Player
from die import Die
from operator import __str__


def take_turn(player):
   """ Passes in a Player object, rolls the player's dice, 
       displays the dice, check for pairs, and display any
       win types(pairs, series, three of a kind), and 
       displays the updated score.
       
   Args:
      player (Player): the Player object whose turn it is
   """
   player.roll_dice() # Roll the player's dice
   dice = str(player) # Get the string value of the player's dice
   print(f" {dice}")  # Display then player's dice
   
   if player.has_three_of_a_kind(): # Check if the player has three of a kind
      print("You got a three of a kind! +3 points")
      player.points += 3
   elif player.has_pair(): # Check if the player has a pair
      print("You got a pair! +2 points")
      player.points += 2
   elif player.has_series():
      print("You got a series of 3! +4 points")
      player.points += 4
   else:
      print("Aww. Too Bad.")
   print(f"Score = {player.points}") # Display the player's score  


def main(): 
   """ Main function to run the dice game.
   """
   user = Player()  # Create player once
   print("-Yahtzee-")
   is_running = True

   while is_running: # Loops until the user enters 'n' to quit
      take_turn(user) # Takes turn for the player
      # Checks if the user wants to play again
      play_again = check_input.get_yes_no("Play again? (y/n): \n")
      if not play_again:
         print("Game Over.")
         print(f"Final Score = {user.points}")
         is_running = False

if __name__ == "__main__":
   main()