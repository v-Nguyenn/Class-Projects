"""
Brian Gutierrez and Vincent Nguyen
Lab 12
CECS 277 Section 8
Fall 2025
November 12, 2025

pie.py adds pie to the plate 
"""

from plate_decorator import Plate_Decorator

class Pie(Plate_Decorator):
   """ Returns the Description, area, weight, and count of pie adding to the superclass"""
   def description(self):
      """ Returns the superclass's description with Pie."""
      return super().description() + "Pie"
   
   def area(self):
      """ Returns the superclass's area minus the area of the pie."""
      return super().area() - 19

   def weight(self):
      """ Returns the superclass's weight minus the weight of the pie."""
      return super().weight() - 8
   
   def count(self):
      """ Returns the superclass's result plus 1 to increment the counter."""
      return super().count() + 1