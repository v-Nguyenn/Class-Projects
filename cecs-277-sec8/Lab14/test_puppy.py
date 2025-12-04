"""
Test file for Puppy class - shows you how to think about testing. Made from AI

HOW TO THINK ABOUT TESTS:
1. What should happen when I create an object? → Test __init__
2. What should properties return? → Test each @property
3. What should methods do? → Test each method
4. What happens with edge cases? → Test boundaries (0, negative, etc.)
"""

import unittest
from puppy_state import PuppyState

# Mock state for testing
class MockState(PuppyState):
    """Fake state just for testing - implements required abstract methods"""
    def feed(self, puppy):
        return "Mock fed"
    
    def play(self, puppy):
        return "Mock played"


class TestPuppyState(unittest.TestCase):
    """Test the PuppyState interface"""
    
    def test_cannot_instantiate_abstract_class(self):
        """PuppyState is abstract - you can't create it directly"""
        with self.assertRaises(TypeError):
            state = PuppyState()  # Should fail!
    
    def test_mock_state_works(self):
        """MockState implements abstract methods - should work"""
        state = MockState()
        self.assertIsNotNone(state)


# Uncomment when you create state_asleep.py:
"""
from puppy import Puppy
from state_asleep import StateAsleep

class TestPuppy(unittest.TestCase):
    
    def setUp(self):
        # Runs before each test - creates fresh puppy
        self.puppy = Puppy()
    
    # TEST 1: Does __init__ work correctly?
    def test_initial_state_is_asleep(self):
        # What you're testing: Puppy starts in asleep state
        self.assertIsInstance(self.puppy._state, StateAsleep)
    
    def test_initial_feeds_is_zero(self):
        # What you're testing: Feed counter starts at 0
        self.assertEqual(self.puppy.feeds, 0)
    
    def test_initial_plays_is_zero(self):
        # What you're testing: Play counter starts at 0
        self.assertEqual(self.puppy.plays, 0)
    
    # TEST 2: Do properties work?
    def test_feeds_property_returns_feeds(self):
        # What you're testing: feeds property returns the counter
        self.puppy._feeds = 5
        self.assertEqual(self.puppy.feeds, 5)
    
    def test_plays_property_returns_plays(self):
        # What you're testing: plays property returns the counter
        self.puppy._plays = 3
        self.assertEqual(self.puppy.plays, 3)
    
    # TEST 3: Do increment methods work?
    def test_inc_feeds_increments_counter(self):
        # What you're testing: inc_feeds adds 1 to counter
        self.puppy.inc_feeds()
        self.assertEqual(self.puppy.feeds, 1)
        self.puppy.inc_feeds()
        self.assertEqual(self.puppy.feeds, 2)
    
    def test_inc_plays_increments_counter(self):
        # What you're testing: inc_plays adds 1 to counter
        self.puppy.inc_plays()
        self.assertEqual(self.puppy.plays, 1)
        self.puppy.inc_plays()
        self.assertEqual(self.puppy.plays, 2)
    
    # TEST 4: Does reset work?
    def test_reset_clears_both_counters(self):
        # What you're testing: reset sets both to 0
        self.puppy._feeds = 5
        self.puppy._plays = 3
        self.puppy.reset()
        self.assertEqual(self.puppy.feeds, 0)
        self.assertEqual(self.puppy.plays, 0)
    
    # TEST 5: Does change_state work?
    def test_change_state_updates_state(self):
        # What you're testing: change_state actually changes _state
        new_state = MockState()
        self.puppy.change_state(new_state)
        self.assertEqual(self.puppy._state, new_state)
    
    # TEST 6: Do delegation methods work?
    def test_throw_ball_calls_state_play(self):
        # What you're testing: throw_ball delegates to state.play()
        mock = MockState()
        self.puppy.change_state(mock)
        result = self.puppy.throw_ball()
        self.assertEqual(result, "Mock played")
    
    def test_give_food_calls_state_feed(self):
        # What you're testing: give_food delegates to state.feed()
        mock = MockState()
        self.puppy.change_state(mock)
        result = self.puppy.give_food()
        self.assertEqual(result, "Mock fed")
"""

if __name__ == '__main__':
    unittest.main()
