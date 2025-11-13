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
from plate_decorator import Plate_decorator

def examine_plate(p):
   """ Examines the plate that is put in. 
   
   Returns:
      str: A description of the plate with the remaining area and weight 
   """
   # Bending Weight, 1 - 6
   if p.weight() > 13:
      plate_weight = "Strong"
   if p.weight() > 7:
      plate_weight = "Weak"
   if p.weight() 
   

def main():
   """ main program to run """
