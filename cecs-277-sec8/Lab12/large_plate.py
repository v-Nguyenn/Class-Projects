""" 
Brian Gutierrez and Vincent Nguyen
Lab 12
CECS 277 Section 8
Fall 2025 
November 11, 2025

large_plate.py which returns a description, area, weight, and count of the large plate
inheritiing from plate.py
"""

from plate import Plate

class Large_Plate(Plate):
   """ Returns the description, area, weight, and count of the large plate. """
   def description(self):
      """ Returns the description of the large plate. """
      return "Large Flimsy 12 inch paper plate with"

   def area(self):
      """ Returns the large area of the plate"""
      return 113
   
   def weight(self):
      """ Returns the weight capactity of the large plate"""
      return 24

   def count(self):
      """ Returns 0 (no items on plate yet)"""
      return 0
