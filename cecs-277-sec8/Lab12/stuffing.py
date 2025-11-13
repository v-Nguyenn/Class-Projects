"""
Brian Gutierrez and Vincent Nguyen
Lab 12
CECS 277 Section 8
Fall 2025
November 12, 2025

stuffing.py puts stuffing on the plate 
"""

from plate_decorator import Plate_Decorator

class Stuffing(Plate_Decorator):
   """Returns the description, area, weight, and count"""
   def description(self):
      "Returns the superclass description with stuffing."
      return super().description() + " and Stuffing"
   
   def area(self):
      "Returns superclass's result minus the food item's area."
      return super().area() - 18
   
   def weight(self):
      """Returns the superclass's result minus the food item's weight."""
      return super().weight() - 7
   
   def count(self):
      """Returns the superclass's result plus 1 to increment counter."""
      return super().count() + 1