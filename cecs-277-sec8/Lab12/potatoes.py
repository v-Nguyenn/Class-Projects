"""
Brian Gutierrez and Vincent Nguyen
Lab 12
CECS 277 Section 8
Fall 2025
November 12, 2025

potatoes.py class that adds a potatoe to the plate when called
"""

from plate_decorator import Plate_Decorator

class Potatoes(Plate_Decorator):
   """ Returns a description, area, weight, and count."""
   def description(self):
      """ Returns the superclass's description along with potatoes."""
      return super().description() + "Potatoes" 

   def area(self):
      """ Returns the superclass's area minus the area of potatoes covers."""
      return super().area() - 18
   
   def weight(self):
      """ Returns the superclass's weight minus the weight potatoes has."""
      return super().weight() - 6
   
   def count(self):
      """ Returns the superclass's result plus 1 to increment counter."""
      return super().count() + 1