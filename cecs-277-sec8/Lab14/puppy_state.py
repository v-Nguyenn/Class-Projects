"""
Brian Gutierrez and Vincent Nguyen
Lab 14
CECS 277 Section 8
Fall 2025
December 3, 2025

puppy_state is the interface that provides the abstract for feed and play
"""

from abc import ABC, abstractmethod
#    ^^^       ^^^  ^^^^^^^^^^^^^^
#  module    class    decorator
#  (package) (thing   (function)
#           to inherit)

class PuppyState(ABC):
   @abstractmethod
   def feed(self, puppy):
      """Method should implement the reaction to feed."""
      pass

   @abstractmethod
   def play(self, puppy):
      """Method should implement the puppy's reaction to playing."""
      pass