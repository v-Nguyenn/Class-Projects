"""
Brian Gutierrez and Vincent Nguyen
Lab 12
CECS 277 Section 8
Fall 2025
November 12, 2025

green_beans.py adds the food item green beans to the plate
"""

from plate_decorator import Plate_Decorator

class Green_Beans(Plate_Decorator):
   """ Returns the decription, area, weight, and count of green beans to the superclass."""
   def description(self):
      """ Returns the superclass's description and adds the green beans."""
      return super().description() + "Green Beans"

   def area(self):
      """ Returns the superclass's area minus the area of Green Beans."""
      return super().area() - 20
   
   def weight(self):
      """ Returns the superclass's area minus the weight of Green Beans."""
      return super().weight() - 3
   
   def count(self):
      """ Returns the superclass's result plus 1 to increment the counter."""
      return super().count() + 1