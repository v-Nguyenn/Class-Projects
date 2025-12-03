"""
Brian Gutierrez and Vincent Nguyen
Lab 14
CECS 277 Section 8
Fall 2025
December 3, 2025

puppy.py is the object that the user interacts with
"""

from state_asleep import StateAsleep

class Puppy:
   def __init__(self):
      """Initializes the state to asleep, and the number for plays and feeds."""
      self._state = StateAsleep()
      self._feeds = 0
      self._plays = 0

   @property 
   def feeds(self):
      """Returns the number of times puppy is fed"""
      return self._feeds
   
   @property
   def plays(self):
      """Returns the number of times puppy plays"""
      return self._plays
   
   def change_state(self, new_state):
      """Updates the puppy's state to the new state."""
      self._state = new_state
   
   def throw_ball(self):
      """Calls the play method depending on the state of the puppy."""
      return self._state.play(self) 

   def give_food(self):
      """Calls the feed method depending on the state the puppy."""
      return self._state.feed(self)
   
   def inc_feeds(self):
      """Increments the number of times the puppy has been fed in a row."""
      self._feeds += 1

   def inc_plays(self):
      """Increments the number of times the puppy has played in a row."""
      self._plays += 1
   
   def reset(self):
      """Reinitializes the feeds and plays attributes."""
      self._feeds = 0
      self._plays = 0