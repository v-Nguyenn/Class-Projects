"""
Unit tests for BasicDoor class
"""
import unittest
from basic_door import BasicDoor


class TestBasicDoor(unittest.TestCase):
    """Test cases for BasicDoor class."""
    
    def setUp(self):
        """Create a fresh BasicDoor before each test."""
        self.door = BasicDoor()
    
    # Test __init__
    def test_init_creates_action(self):
        """Test that door is initialized with push or pull."""
        self.assertIn(self.door._action, ["push", "pull"])
    
    def test_init_door_starts_locked(self):
        """Test that door starts in locked state."""
        self.assertTrue(self.door._is_locked)
        self.assertFalse(self.door.is_unlocked())
    
    # Test examine_door
    def test_examine_door_returns_string(self):
        """Test that examine_door returns a string."""
        result = self.door.examine_door()
        self.assertIsInstance(result, str)
        self.assertGreater(len(result), 0)
    
    def test_examine_door_contains_description(self):
        """Test that examine_door contains expected text."""
        result = self.door.examine_door()
        self.assertIn("door", result.lower())
    
    # Test menu_options
    def test_menu_options_returns_string(self):
        """Test that menu_options returns a string."""
        result = self.door.menu_options()
        self.assertIsInstance(result, str)
    
    def test_menu_options_has_push_and_pull(self):
        """Test that menu contains Push and Pull options."""
        result = self.door.menu_options()
        self.assertIn("Push", result)
        self.assertIn("Pull", result)
    
    def test_menu_options_has_numbers(self):
        """Test that menu has numbered options."""
        result = self.door.menu_options()
        self.assertIn("1", result)
        self.assertIn("2", result)
    
    # Test get_menu_max
    def test_get_menu_max_returns_int(self):
        """Test that get_menu_max returns an integer."""
        result = self.door.get_menu_max()
        self.assertIsInstance(result, int)
    
    def test_get_menu_max_returns_two(self):
        """Test that get_menu_max returns 2 (push and pull)."""
        result = self.door.get_menu_max()
        self.assertEqual(result, 2)
    
    # Test attempt - correct action
    def test_attempt_correct_action_unlocks_door(self):
        """Test that correct action unlocks the door."""
        # Figure out which option is correct
        if self.door._action == "push":
            correct_option = 1
        else:
            correct_option = 2
        
        # Attempt with correct option
        result = self.door.attempt(correct_option)
        
        # Check door is unlocked
        self.assertTrue(self.door.is_unlocked())
        self.assertFalse(self.door._is_locked)
    
    def test_attempt_correct_action_returns_success(self):
        """Test that correct action returns success message."""
        # Figure out correct option
        if self.door._action == "push":
            correct_option = 1
        else:
            correct_option = 2
        
        result = self.door.attempt(correct_option)
        
        # Check success message
        self.assertIsInstance(result, str)
        self.assertIn(self.door._action, result.lower())
    
    # Test attempt - wrong action
    def test_attempt_wrong_action_keeps_door_locked(self):
        """Test that wrong action keeps door locked."""
        # Figure out which option is WRONG
        if self.door._action == "push":
            wrong_option = 2
        else:
            wrong_option = 1
        
        # Attempt with wrong option
        result = self.door.attempt(wrong_option)
        
        # Check door is still locked
        self.assertFalse(self.door.is_unlocked())
        self.assertTrue(self.door._is_locked)
    
    def test_attempt_wrong_action_returns_clue(self):
        """Test that wrong action returns clue."""
        # Figure out wrong option
        if self.door._action == "push":
            wrong_option = 2
        else:
            wrong_option = 1
        
        result = self.door.attempt(wrong_option)
        expected_clue = self.door.clue()
        
        self.assertEqual(result, expected_clue)
    
    # Test attempt - invalid option
    def test_attempt_invalid_option(self):
        """Test that invalid option returns error message."""
        result = self.door.attempt(999)
        self.assertIn("Invalid", result)
    
    def test_attempt_invalid_option_keeps_locked(self):
        """Test that invalid option doesn't unlock door."""
        self.door.attempt(0)
        self.assertFalse(self.door.is_unlocked())
    
    # Test is_unlocked
    def test_is_unlocked_returns_bool(self):
        """Test that is_unlocked returns a boolean."""
        result = self.door.is_unlocked()
        self.assertIsInstance(result, bool)
    
    def test_is_unlocked_starts_false(self):
        """Test that door starts locked (is_unlocked returns False)."""
        self.assertFalse(self.door.is_unlocked())
    
    def test_is_unlocked_true_after_success(self):
        """Test that is_unlocked returns True after successful attempt."""
        # Unlock the door
        if self.door._action == "push":
            self.door.attempt(1)
        else:
            self.door.attempt(2)
        
        self.assertTrue(self.door.is_unlocked())
    
    # Test clue
    def test_clue_returns_string(self):
        """Test that clue returns a string."""
        result = self.door.clue()
        self.assertIsInstance(result, str)
        self.assertGreater(len(result), 0)
    
    def test_clue_contains_hint(self):
        """Test that clue contains helpful hint."""
        result = self.door.clue()
        self.assertIn("other", result.lower())
    
    # Test success
    def test_success_returns_string(self):
        """Test that success returns a string."""
        result = self.door.success()
        self.assertIsInstance(result, str)
        self.assertGreater(len(result), 0)
    
    def test_success_contains_action(self):
        """Test that success message mentions the action."""
        result = self.door.success()
        self.assertIn(self.door._action, result.lower())
    
    def test_success_contains_congratulations(self):
        """Test that success message is congratulatory."""
        result = self.door.success()
        # Check for positive words
        positive_words = ["congratulations", "success", "opened", "perfect"]
        has_positive = any(word in result.lower() for word in positive_words)
        self.assertTrue(has_positive)
    
    # Integration test
    def test_full_unlock_sequence(self):
        """Test complete sequence: check locked, wrong attempt, correct attempt."""
        # Start locked
        self.assertFalse(self.door.is_unlocked())
        
        # Try wrong action
        wrong = 2 if self.door._action == "push" else 1
        result1 = self.door.attempt(wrong)
        self.assertFalse(self.door.is_unlocked())
        self.assertEqual(result1, self.door.clue())
        
        # Try correct action
        correct = 1 if self.door._action == "push" else 2
        result2 = self.door.attempt(correct)
        self.assertTrue(self.door.is_unlocked())
        self.assertIn(self.door._action, result2.lower())


if __name__ == '__main__':
    unittest.main()