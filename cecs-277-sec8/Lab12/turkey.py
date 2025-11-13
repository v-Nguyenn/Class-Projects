"""
Brian Gutierrez and Vincent Nguyen
Lab 12
CECS 277 Section 8
Fall 2025
November 11, 2025

turkey.py returns the superclass with a description 
"""

from plate_decorator import Plate_Decorator 

class Turkey(Plate_Decorator):
   """ A description of turkey, the area minus the food item, weight of the turkey and count"""
   def description(self):
      return super().description() + " with Turkey"
   
   def area(self):
      """ Returns remaining area after subtracting Turkey"""
      return super().area() - 15

   def weight(self):
      """ Returns the remaining weight after subtracting Turkey"""
      return super().weight() - 4
   
   def count(self):
      """ Returns the result plus 1 to increment the counter"""
      return super().count() + 1