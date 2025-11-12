"""
Brian Gutierrez and Vincent Nguyen
Lab 12
CECS 277 Section 8
Fall 2025
November 11, 2025

plate_decorator.py inherits from plate.y
"""

from plate import Plate

class Plate_Decorator(Plate):
   """ """
   def __init__(self, p): # plate p 
      """ Initializes a plate and assigns to the an attribute to call each plate method"""
      self._plate = p
      
   def description(self):
      """ Returns the description of the wrapped plate"""
      return self._plate.description()
   
   def area(self):
      """ Returns the area of the wrapped plate """
      return self._plate.area()
   
   def weight(self):
      """ Returns the weight of the wrapped plate"""
      return self._plate.weight()