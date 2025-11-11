"""
Brian Gutierrez and Vincent Nguyen
Lab 12
CECS 277 Section 8
Fall 2025
11/10/2025

This is the interface for plate which extends to small_plate and Big plate 
"""

from abc import ABC, abstractmethod

class Plate():
   """ Plate which has a description area, weight, and count """
   @abstractmethod
   def description(self):
      """ Returns a string description of the plate and what is on it """
      pass

   @abstractmethod
   def area(self):
      """ Returns the remaining square inches of the plate can hold """
      pass

   @abstractmethod
   def weight(self):
      """ Returns the remaining number of ounces the plate can hold. """
      pass

   @abstractmethod
   def count(self):
      """ Returns the number of food items the plate is currently holding. """
      pass      