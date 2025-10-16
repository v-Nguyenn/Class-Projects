"""
Brian Gutierrez and Vincent Nguyen
CECS 277 - Sec 8
Lab 8
10/15/2025
main.py
"""

import check_input
from car import Car
from motorcycle import Motorcycle
from truck import Truck
import random


def main():
   """
   Main function that runs the vehicle game
   """
   print("Rad Racer!")
   print("Choose a vehicle and race it down the track (player - 'P') Slow down for obstacles ('O') or else you'll crash!")
   
   # List of vehicles
   print("1. Lightning Car - a fast car. Speed: 7. Special: Nitro Boost (1.5x speed)")
   print("2. Swift Bike - a speedy motorcycle. Speed: 8. Special: Wheelie (2x speed, but there's a chance you'll wipe out)")
   print("3. Behemoth Truck - a heavy truck. Speed: 6. Special: Ram (2x speed, goes through obstacles)")
   
   # Get user input for vehicle choice
   vehicle_choice = check_input.get_int_range("Choose your vehicle (1-3): ", 1, 3)

   # Create all the vehicles in a list
   all_vehicles = [Car("Lightning Car"),
                   Motorcycle("Swift Bike"),
                   Truck("Behemoth Truck")]

   # Assign based on user choice (1-3)
   vehicles = []
   if vehicle_choice == 1:
      # Car, Motorcycle, Truck
      vehicles = [all_vehicles[0], all_vehicles[1], all_vehicles[2]]
   elif vehicle_choice == 2:
      # Motorcycle, Car, Truck
      vehicles = [all_vehicles[1], all_vehicles[0], all_vehicles[2]]
   elif vehicle_choice == 3:
      # Truck, Car, Motorcycle
      vehicles = [all_vehicles[2], all_vehicles[0], all_vehicles[1]]
   
   # Iterates through the vehicles list and sets the initials
   for i, vehicle in enumerate(vehicles):
      # Player is always the first vehicle in the list
      if i == 0:
         vehicle.initial = 'P'  # Player's vehicle
      else:
         # Sets the initials based on the vehicle type
         if isinstance(vehicle, Car):
            vehicle.initial = 'C'
         elif isinstance(vehicle, Motorcycle):
            vehicle.initial = 'M'
         else:
            vehicle.initial = 'T'
   
   # Print vehicle stats
   for vehicle in vehicles:
      print(vehicle)

   # Construct 2D track: 3 lanes (rows), 100 units (columns)
   track = [['-' for _ in range(100)] for _ in range(3)]
   
   # Randomly place 2 obstacles ('O') in each lane, not at start (0) or finish (99)
   for lane in range(3):
       obstacles_placed = 0
       while obstacles_placed < 2:
           pos = random.randint(1, 98)  # Avoid start/finish
           if track[lane][pos] == '-':
               track[lane][pos] = 'O'
               obstacles_placed += 1
   
   # Initialize positions: one per vehicle/lane
   positions = [0, 0, 0]
   previous_positions = [0, 0, 0]  # To track last positions for marking stars
   
   # Track finishing
   finished = [False, False, False]
   finish_order = []
   
   # Game loop: repeat until all vehicles finish
   while not all(finished):
       # Display the track
       print()  # Blank line before track
       for lane in range(3):
           row = ""
           for col in range(100):
               if col == positions[lane] and not finished[lane]:
                   row += vehicles[lane].initial
               else:
                   row += track[lane][col]
           print(row)  
       
       # Check if player has finished
       if positions[0] >= 100 and not finished[0]:
           finished[0] = True
           finish_order.append(vehicles[0]._name)
       
       # If player hasn't finished, get move
       if not finished[0]:
           move_choice = check_input.get_int_range("Choose action (1. Fast, 2. Slow, 3. Special Move): ", 1, 3)
           print()
           
           # Find next obstacle in player's lane
           obs_loc = -1
           try:
               obs_loc = track[0].index('O', positions[0] + 1)
           except ValueError:
               pass  # No obstacle ahead
           
           # Perform move
           if move_choice == 1:
               result = vehicles[0].fast(obs_loc)
           elif move_choice == 2:
               result = vehicles[0].slow(obs_loc)
           else:
               result = vehicles[0].special_move(obs_loc)
           print(result)
           
           # Mark previous position with star on track (if not obstacle)
           if track[0][positions[0]] != 'O':
               track[0][positions[0]] = '*'
           
           # Update position
           positions[0] = vehicles[0].position

           # Check if player finished
           if positions[0] >= 100 and not finished[0]:
               finished[0] = True
               finish_order.append(vehicles[0]._name)
       
       # Move opponents
       for i in range(1, 3):
           if finished[i]:
               continue
           
           # Random choice: 40% slow, 30% fast, 30% special (if energy > 0)
           if vehicles[i].energy <= 0:
               choice = 2  # Slow
           else:
               rand = random.randint(1, 10)
               if rand <= 4:
                   choice = 2  # 40% slow
               elif rand <= 7:
                   choice = 1  # 30% fast
               else:
                   choice = 3  # 30% special
           
           # Find obstacle
           obs_loc = -1
           try:
               obs_loc = track[i].index('O', positions[i] + 1)
           except ValueError:
               pass
           
           # Perform move
           if choice == 1:
               result = vehicles[i].fast(obs_loc)
           elif choice == 2:
               result = vehicles[i].slow(obs_loc)
           else:
               result = vehicles[i].special_move(obs_loc)
           print(result)
           
           # Mark previous position with star on track (if not obstacle)
           if track[i][positions[i]] != 'O':
               track[i][positions[i]] = '*'
           
           # Update position
           positions[i] = vehicles[i].position
           
           if positions[i] >= 100 and not finished[i]:
               finished[i] = True
               finish_order.append(vehicles[i]._name)  
   
   # Display final results
   print("\nRace Results:")
   place_labels = ["1st place", "2nd place", "3rd place"]
   for i, name in enumerate(finish_order):
       # Find the vehicle object by name
       for vehicle in vehicles:
           if vehicle._name == name:
               print(f"{place_labels[i]}: {vehicle}")
               break

if __name__ == "__main__":
   main()