"""
Brian Gutierrez and Vincent Nguyen
Lab 14
CECS 277 Section 8
Fall 2025
December 3, 2025

state_play.py defines the StatePlay class for the puppy's playing state behavior.
"""

from puppy_state import PuppyState
from state_asleep import StateAsleep

class StatePlay(PuppyState):
   """"""
   def feed(self, puppy):
      """
      The state of the puppy does not change when it we try to play with it.

      Returns a string describing that the puppy cannot be fed while it is playing
      """
      return "The puppy is too busy playing with the ball to eat right now."

   def play(self, puppy):
      """
      Changes the state of the puppy when playing until it is tired.

      Returns a string describing the puppy playing until it falls asleep again after incrementing 
      """ 
      if puppy.plays == 1:
         puppy.inc_plays()
         return "You throw the ball again and the puppy excitedly chases it."
      elif puppy.plays == 2:
         puppy.change_state(StateAsleep())
         puppy.reset()
         return "You throw the ball again and the puppy excitedly chases it.\nThe puppy played so much it fell asleep!"
      else:
         return "Error unexpected play count" # Just in case
