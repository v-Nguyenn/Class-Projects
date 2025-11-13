""" 
Brian Gutierrez and Vincent Nguyen
Lab 12
CECS 277 Section 8
Fall 2025
November 12, 2025

main.py runs the Thanksgiving Dinner program which has the user 
add food to their plate without going over the weight or area
limit of a paper plate.
"""

from check_input import get_int_range
from plate_decorator import Plate_Decorator
from small_plate import Small_Plate
from large_plate import Large_Plate
from turkey import Turkey
from stuffing import Stuffing
from potatoes import Potatoes
from green_beans import Green_Beans
from pie import Pie

def examine_plate(p):
   """Examines the plate and displays description with remaining hints.
   
   Returns:
      bool: True if plate failed (spilled), False otherwise
   """
   # Display plate description
   print(p.description())
   
   # Check for failure first (area or weight <= 0)
   if p.area() <= 0:
      print("Your plate isn't big enough for this much food! Your food spills over the edge.")
      return True
   
   if p.weight() <= 0:
      print("Your plate isn't strong enough for this much food! Your food spills over the edge.")
      return True
   
   # Display weight hint (1-6: bending, 7-12: weak, 13+: strong)
   if p.weight() >= 13:
      weight_hint = "strong"
   elif p.weight() >= 7:
      weight_hint = "weak"
   else:  # 1-6
      weight_hint = "bending"
   
   # Display area hint (1-20: tiny bit, 21-40: some, 41+: plenty)
   if p.area() >= 41:
      area_hint = "Plenty"
   elif p.area() >= 21:
      area_hint = "Some"
   else:  # 1-20
      area_hint = "A Tiny Bit"
   
   print(f"Sturdiness: {weight_hint}")
   print(f"Space available: {area_hint}")
   
   return False  # Plate is okay
   

def main():
   """ main program to run """
   print("\n- Thanksgiving Dinner -")
   print("Serve yourself as much food as you like from the buffet,")
   print("but make sure that your plate will hold without spilling everywhere!")

   # Choose the plate once, show plate menu
   print("Choose a plate:")
   print("1. Small Sturdy Plate")
   print("2. Large Flimsy Plate")
   plate_choice = get_int_range("", 1, 2)

   if plate_choice == 1:
      plate = Small_Plate()
   else:
      plate = Large_Plate()

   print(f"You have the {plate.description()} with nothing on it.")

   spilled = False 
   while not spilled:
      # Show Food menu 
      print("1. Turkey")
      print("2. Stuffing")
      print("3. Potatoes")
      print("4. Green Beans")
      print("5. Pie")
      print("6. Quit")

      # Get User Choice for foods
      food_choice = get_int_range("", 1, 6)

      if food_choice == 6:
         print(f"{plate.description()}")
         print(f"Good Job! You made it to the table with {plate.count()} items.")
         print(f"There was still {plate.area()} square inches left on your plate.")
         print(f"Your plate could have held {plate.weight()} more ounces.")
         print(f"Don't worry, you can always go big back for more. Happy Thanksgiving!\n")
         break # quits 

      # Decorate plate with the chosen food
      if food_choice == 1:
         plate = Turkey(plate) 
      elif food_choice == 2:
         plate = Stuffing(plate)
      elif food_choice == 3:
         plate = Potatoes(plate)
      elif food_choice == 4:
         plate = Green_Beans(plate)
      elif food_choice == 5:
         plate = Pie(plate)
      
      spilled = examine_plate(plate)

if __name__ == "__main__":
   main()