"""
Brian Gutierrez and Vincent Nguyen 
Lab 12
CECS 277 Section 8
Fall 2025
November 11, 2025

small_plate.py which returns a description, area, weight, and count of the small plate
inheritiing from plate.py
"""

from plate import Plate
# from plate_decorator import Plate_decorator

class Small_Plate(Plate):
   """ Returns the description of a small plate, smaller area, weight, and count """
   def description(self):
      """ Returns the string description of the small plate and what is on it. """
      return f"Sturdy 10 inch plate with"
   
   def area(self):
      """ Returns an integer, the small area of the plate which is 78. """
      return 72
   
   def weight(self):
      """ Returns an integer, the small weight capacity of the plate which is 32. """
      return 32

   def count(self):
      """ Returns 0 (no items on plate yet. )"""
      return 0


