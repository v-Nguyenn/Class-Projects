"""
Brian Gutierrez and Vincent Nguyen
Lab 14
CECS 277 Section 8
Fall 2025
December 3, 2025

state_eat.py the puppy eats until it falls asleep.
"""

from puppy_state import PuppyState
from state_play import StatePlay

class StateEat(PuppyState):
   """Puppy eats until is full and it falls back asleep or gets distracted by a ball so it can play."""

   def feed(self, puppy):
      """Increments the puppy counter each time is fed until it falls asleep."""
      if puppy.feeds == 1:
         puppy.inc_feeds()
         return "The puppy continues to eat as you add another scoop of kibble to its bowl."
      # Changes the state of the puppy at 2
      elif puppy.feeds == 2:
         from state_asleep import StateAsleep
         puppy.change_state(StateAsleep())
         puppy.reset()
         return "The puppy continues to eat as you add another scoop of kibble to its bowl.\nThe puppy ate so much it fell asleep!"
      else:
         return "Error: unexpected feed count" # Just in case the count goes wrong.
      
   def play(self, puppy):
      """Distracts the puppy with the ball."""
      # Changes the state of the puppy when we play so we reset the puppy and increment the plays.
      puppy.change_state(StatePlay())
      puppy.reset()
      puppy.inc_plays()
      return "The puppy looks up from its food and chases the ball you threw."