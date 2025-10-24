"""
Unit tests for LockedDoor class
"""
import unittest
import sys
import os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))

from locked_door import LockedDoor


class TestLockedDoor(unittest.TestCase):
    """Test cases for LockedDoor class"""
    
    def setUp(self):
        """Create a fresh LockedDoor instance for each test"""
        self.door = LockedDoor()
    
    # Test 1: Initialization
    def test_init_creates_action_between_1_and_3(self):
        """Test that __init__ randomizes key location to 1, 2, or 3"""
        self.assertIn(self.door._action, [1, 2, 3])
    
    def test_init_sets_locked_to_true(self):
        """Test that door starts locked"""
        self.assertTrue(self.door._is_locked)
    
    # Test 2: examine_door()
    def test_examine_door_returns_string(self):
        """Test that examine_door returns a string"""
        result = self.door.examine_door()
        self.assertIsInstance(result, str)
    
    def test_examine_door_contains_description(self):
        """Test that examine_door contains key information"""
        result = self.door.examine_door()
        self.assertIn("locked", result.lower())
        self.assertIn("key", result.lower())
    
    # Test 3: menu_options()
    def test_menu_options_returns_string(self):
        """Test that menu_options returns a string"""
        result = self.door.menu_options()
        self.assertIsInstance(result, str)
    
    def test_menu_options_has_three_options(self):
        """Test that menu has all three location options"""
        result = self.door.menu_options()
        self.assertIn("mat", result.lower())
        self.assertIn("flower pot", result.lower())
        self.assertIn("rock", result.lower())
    
    # Test 4: get_menu_max()
    def test_get_menu_max_returns_3(self):
        """Test that get_menu_max returns 3 (three locations to check)"""
        result = self.door.get_menu_max()
        self.assertEqual(result, 3)
    
    # Test 5: attempt() - correct location
    def test_attempt_correct_location_unlocks_door(self):
        """Test that finding key at correct location unlocks door"""
        correct_location = self.door._action
        result = self.door.attempt(correct_location)
        self.assertFalse(self.door._is_locked)
    
    def test_attempt_correct_location_returns_success_message(self):
        """Test that correct attempt returns success message"""
        correct_location = self.door._action
        result = self.door.attempt(correct_location)
        self.assertIn("key", result.lower())
        self.assertIn("unlock", result.lower())
    
    # Test 6: attempt() - wrong location
    def test_attempt_wrong_location_keeps_door_locked(self):
        """Test that wrong location doesn't unlock door"""
        # Find a wrong location
        wrong_location = 1 if self.door._action != 1 else 2
        result = self.door.attempt(wrong_location)
        self.assertTrue(self.door._is_locked)
    
    def test_attempt_wrong_location_returns_clue(self):
        """Test that wrong location returns a clue"""
        wrong_location = 1 if self.door._action != 1 else 2
        result = self.door.attempt(wrong_location)
        clue = self.door.clue()
        self.assertIn(clue, result)
    
    # Test 7: attempt() - describes what user did
    def test_attempt_describes_location_checked(self):
        """Test that attempt describes which location was checked"""
        result = self.door.attempt(1)
        self.assertIn("mat", result.lower())
        
        result = self.door.attempt(2)
        self.assertIn("flower pot", result.lower())
        
        result = self.door.attempt(3)
        self.assertIn("rock", result.lower())
    
    # Test 8: is_unlocked()
    def test_is_unlocked_returns_false_initially(self):
        """Test that door starts locked"""
        self.assertFalse(self.door.is_unlocked())
    
    def test_is_unlocked_returns_true_after_correct_attempt(self):
        """Test that is_unlocked returns True after finding key"""
        correct_location = self.door._action
        self.door.attempt(correct_location)
        self.assertTrue(self.door.is_unlocked())
    
    def test_is_unlocked_returns_false_after_wrong_attempt(self):
        """Test that is_unlocked stays False after wrong location"""
        wrong_location = 1 if self.door._action != 1 else 2
        self.door.attempt(wrong_location)
        self.assertFalse(self.door.is_unlocked())
    
    # Test 9: clue()
    def test_clue_returns_string(self):
        """Test that clue returns a string"""
        result = self.door.clue()
        self.assertIsInstance(result, str)
    
    def test_clue_provides_helpful_hint(self):
        """Test that clue contains helpful information"""
        result = self.door.clue()
        self.assertTrue(len(result) > 0)
    
    # Test 10: success()
    def test_success_returns_string(self):
        """Test that success returns a string"""
        result = self.door.success()
        self.assertIsInstance(result, str)
    
    def test_success_contains_congratulatory_message(self):
        """Test that success contains positive message"""
        result = self.door.success()
        self.assertIn("key", result.lower())
        self.assertIn("unlock", result.lower())
    
    # Test 11: Multiple attempts
    def test_multiple_wrong_attempts_then_correct(self):
        """Test trying multiple wrong locations before finding key"""
        correct_location = self.door._action
        
        # Try wrong locations first
        for location in [1, 2, 3]:
            if location != correct_location:
                self.door.attempt(location)
                self.assertTrue(self.door._is_locked)
        
        # Finally try correct location
        self.door.attempt(correct_location)
        self.assertFalse(self.door._is_locked)
    
    # Test 12: Integration test
    def test_full_unlock_sequence(self):
        """Test complete door unlocking sequence"""
        # 1. Door starts locked
        self.assertFalse(self.door.is_unlocked())
        
        # 2. Examine the door
        description = self.door.examine_door()
        self.assertIsInstance(description, str)
        
        # 3. Get menu options
        menu = self.door.menu_options()
        self.assertIn("1.", menu)
        
        # 4. Try correct location
        correct_location = self.door._action
        result = self.door.attempt(correct_location)
        
        # 5. Door is now unlocked
        self.assertTrue(self.door.is_unlocked())
        self.assertIn("key", result.lower())


if __name__ == '__main__':
    unittest.main()
