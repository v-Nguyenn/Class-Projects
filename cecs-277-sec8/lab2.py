# Brian Gutierrez and Vincent Nguyen
# September 03, 2025
# Three Card Monte

# Player guesses the location of the queen from a set of three
# cards. Player starts with 100$ and doubles each win. This 
# continues until the player loses their money or quit.

import random
import check_input

def get_users_bet(money):
   print(f"You have ${money}.")

   # Asks the user for a valid input to bet how much money they have
   bet = check_input.get_int_range("How much you wanna bet? ", 1, money)
   return bet

# Displays cards and gets user input
def get_users_choice():
   print("+-----+ +-----+ +-----+")
   print("|     | |     | |     |")
   print("|  1  | |  2  | |  3  |")
   print("|     | |     | |     |")
   print("+-----+ +-----+ +-----+")

   # Asks the user for their choice between the range 1 and 3
   user_choice = check_input.get_int_range("Find the queen: ", 1, 3)
   return user_choice

# Displays the face cards and reveals where the queen is
def display_queen_loc(queen_loc):
   faces = ["K", "K", "K"]
   faces [queen_loc - 1] = "Q" # Because Index is from 0 - 2
   print("+-----+ +-----+ +-----+")
   print("|     | |     | |     |")
   print(f"|  {faces[0]}  | |  {faces[1]}  | |  {faces[2]}  |") 
   print("|     | |     | |     |")
   print("+-----+ +-----+ +-----+")

def main():
   print("-Three Card Monte-")
   print("Find the queen to double your bet!")

   money = 100
   while money > 0:
      # Gets a valid bet that returns the value 
      bet = get_users_bet(money)

      # Randomizes the queen's location
      queen_loc = random.randint(1, 3)
      
      # Show cards as 1 - 3 and get the users guess
      user_choice = get_users_choice() 

      display_queen_loc(queen_loc)

      # Checks if user wins or loses: Double money or lose bet
      if user_choice == queen_loc:
         money += 2 * bet # Get double the bet
         print("You got lucky this time...")
      else:
         money -= bet
         print("Sorry... you lose.")
      
      if money == 0:
         print("You're out of money. Beat it loser!")
         break
      
      # Checks if user wants to play again and safely checks user input
      # by taking away extra spaces and making the letter lowercase
      another_round = input("Play again? (Y/N): ").strip().lower()

      # Checks for N first before any other input, exits if found
      if another_round == "n":
         break

      # If yes then program continues, otherwise any other input is not accepted
      while another_round != "y":
         print("Invalid input - should be Y/N: ")
         another_round = input("Play again? (Y/N): ").strip().lower()
   

if __name__ == "__main__":
   main()



# Notes for myself
# The most trouble I had in this lab was in the main function.
# I could not order the functions properly and when I did, 
# I had scope issues this was from line 45 to 59
# I did not store the values from the functions into variables
# The second hardest thing was actually figuring out the play again feature
# We do have check.input file but the function imported had either Yes/No
# It was the not the same as Y/N so I tried to write my own.
# Initially it worked. When you input Y, the program continues as intended. 
# I had trouble from line 72 to 79 when I put a different input 
# from Y such as t or N which errored initially
# or when a user entereed in Y with spaces like "   Y " I found that we could
# remove the spaces and make it lowercase to make input more consistent.
