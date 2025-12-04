"""
Brian Gutierrez and Vincent Nguyen
Lab 14
CECS 277 Section 8
Fall 2025
December 3, 2025

state_asleep.py is the class which has the puppy asleep and wakes up when it is fed.
The puppy runs when it hears the food bowl being filled.
"""

from puppy_state import PuppyState

class StateAsleep(PuppyState):
   """"""
   def feed(self, puppy):
      """
      Puppy wakes up when it hears the food bowl being filled. Changes the state of the puppy because it transitions

      Returns a string describing the puppy waking up from hearing the food bowl.
      """
      from state_eat import StateEat
      puppy.change_state(StateEat())
      puppy.reset()
      puppy.inc_feeds()
      return f"The puppy wakes up and comes running to eat."

   def play(self, puppy):
      """
      Puppy cannot play while it is asleep so nothing changes.

      Returns a string describing the puppy is unable to play.
      """
      return f"The puppy is asleep. It does not want to play right now."
