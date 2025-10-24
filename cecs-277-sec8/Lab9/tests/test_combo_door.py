"""
Unit tests for ComboDoor class
"""
import unittest
import sys
import os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))

from combo_door import ComboDoor


class TestComboDoor(unittest.TestCase):
    """Test cases for ComboDoor class"""
    
    def setUp(self):
        """Create a fresh ComboDoor instance for each test"""
        self.door = ComboDoor()
    
    # Test 1: Initialization
    def test_init_creates_random_number_between_1_and_10(self):
        """Test that __init__ creates random number between 1 and 10"""
        self.assertGreaterEqual(self.door._random_number, 1)
        self.assertLessEqual(self.door._random_number, 10)
    
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
        self.assertIn("combination lock", result.lower())
        self.assertIn("1-10", result)
    
    def test_examine_door_starts_with_you_encounter(self):
        """Test that examine_door starts with 'You encounter'"""
        result = self.door.examine_door()
        self.assertTrue(result.startswith("You encounter"))
    
    # Test 3: menu_options()
    def test_menu_options_returns_string(self):
        """Test that menu_options returns a string"""
        result = self.door.menu_options()
        self.assertIsInstance(result, str)
    
    def test_menu_options_contains_prompt(self):
        """Test that menu_options contains number prompt"""
        result = self.door.menu_options()
        self.assertIn("1-10", result)
    
    # Test 4: get_menu_max()
    def test_get_menu_max_returns_10(self):
        """Test that get_menu_max returns 10 (ten possible numbers)"""
        result = self.door.get_menu_max()
        self.assertEqual(result, 10)
    
    # Test 5: attempt() - correct guess
    def test_attempt_correct_guess_unlocks_door(self):
        """Test that guessing correct number unlocks door"""
        correct_number = self.door._random_number
        result = self.door.attempt(correct_number)
        self.assertFalse(self.door._is_locked)
    
    def test_attempt_correct_guess_returns_success_message(self):
        """Test that correct guess returns success message"""
        correct_number = self.door._random_number
        result = self.door.attempt(correct_number)
        self.assertIn("correct", result.lower())
        self.assertIn("opened", result.lower())
    
    def test_attempt_correct_guess_mentions_number(self):
        """Test that attempt message mentions the number guessed"""
        correct_number = self.door._random_number
        result = self.door.attempt(correct_number)
        self.assertIn(str(correct_number), result)
    
    # Test 6: attempt() - wrong guess (too high)
    def test_attempt_too_high_keeps_door_locked(self):
        """Test that guessing too high doesn't unlock door"""
        # Set specific number for testing
        self.door._random_number = 5
        result = self.door.attempt(8)
        self.assertTrue(self.door._is_locked)
    
    def test_attempt_too_high_returns_clue(self):
        """Test that too high guess returns 'Too high.' clue"""
        self.door._random_number = 5
        result = self.door.attempt(8)
        self.assertIn("too high", result.lower())
    
    # Test 7: attempt() - wrong guess (too low)
    def test_attempt_too_low_keeps_door_locked(self):
        """Test that guessing too low doesn't unlock door"""
        self.door._random_number = 8
        result = self.door.attempt(3)
        self.assertTrue(self.door._is_locked)
    
    def test_attempt_too_low_returns_clue(self):
        """Test that too low guess returns 'Too low.' clue"""
        self.door._random_number = 8
        result = self.door.attempt(3)
        self.assertIn("too low", result.lower())
    
    # Test 8: attempt() - message format
    def test_attempt_describes_what_user_did(self):
        """Test that attempt describes the action taken"""
        result = self.door.attempt(5)
        self.assertIn("turn", result.lower())
        self.assertIn("dial", result.lower())
        self.assertIn("5", result)
    
    # Test 9: is_unlocked()
    def test_is_unlocked_returns_false_initially(self):
        """Test that door starts locked"""
        self.assertFalse(self.door.is_unlocked())
    
    def test_is_unlocked_returns_true_after_correct_guess(self):
        """Test that is_unlocked returns True after correct guess"""
        correct_number = self.door._random_number
        self.door.attempt(correct_number)
        self.assertTrue(self.door.is_unlocked())
    
    def test_is_unlocked_returns_false_after_wrong_guess(self):
        """Test that is_unlocked stays False after wrong guess"""
        # Make sure we guess wrong
        wrong_number = 1 if self.door._random_number != 1 else 2
        self.door.attempt(wrong_number)
        self.assertFalse(self.door.is_unlocked())
    
    # Test 10: clue()
    def test_clue_returns_string(self):
        """Test that clue returns a string"""
        result = self.door.clue(5)
        self.assertIsInstance(result, str)
    
    def test_clue_says_too_high_when_guess_is_high(self):
        """Test that clue says 'Too high.' when guess is too high"""
        self.door._random_number = 3
        result = self.door.clue(7)
        self.assertEqual(result, "Too high.")
    
    def test_clue_says_too_low_when_guess_is_low(self):
        """Test that clue says 'Too low.' when guess is too low"""
        self.door._random_number = 8
        result = self.door.clue(2)
        self.assertEqual(result, "Too low.")
    
    def test_clue_boundary_high(self):
        """Test clue when guess is exactly one above correct"""
        self.door._random_number = 5
        result = self.door.clue(6)
        self.assertEqual(result, "Too high.")
    
    def test_clue_boundary_low(self):
        """Test clue when guess is exactly one below correct"""
        self.door._random_number = 5
        result = self.door.clue(4)
        self.assertEqual(result, "Too low.")
    
    # Test 11: success()
    def test_success_returns_string(self):
        """Test that success returns a string"""
        result = self.door.success()
        self.assertIsInstance(result, str)
    
    def test_success_contains_congratulatory_message(self):
        """Test that success contains positive message"""
        result = self.door.success()
        self.assertIn("correct", result.lower())
        self.assertIn("opened", result.lower())
    
    # Test 12: Multiple attempts scenario
    def test_multiple_wrong_guesses_then_correct(self):
        """Test making several wrong guesses before getting it right"""
        # Set specific number for predictable testing
        self.door._random_number = 7
        
        # Try too low
        self.door.attempt(3)
        self.assertTrue(self.door._is_locked)
        
        # Try still too low
        self.door.attempt(5)
        self.assertTrue(self.door._is_locked)
        
        # Try too high
        self.door.attempt(9)
        self.assertTrue(self.door._is_locked)
        
        # Finally correct
        self.door.attempt(7)
        self.assertFalse(self.door._is_locked)
    
    # Test 13: Edge cases
    def test_attempt_with_minimum_value(self):
        """Test attempting with minimum value (1)"""
        result = self.door.attempt(1)
        self.assertIsInstance(result, str)
        self.assertIn("1", result)
    
    def test_attempt_with_maximum_value(self):
        """Test attempting with maximum value (10)"""
        result = self.door.attempt(10)
        self.assertIsInstance(result, str)
        self.assertIn("10", result)
    
    def test_clue_when_answer_is_1_and_guess_is_higher(self):
        """Test clue when answer is 1 and all guesses are too high"""
        self.door._random_number = 1
        result = self.door.clue(2)
        self.assertEqual(result, "Too high.")
    
    def test_clue_when_answer_is_10_and_guess_is_lower(self):
        """Test clue when answer is 10 and all guesses are too low"""
        self.door._random_number = 10
        result = self.door.clue(9)
        self.assertEqual(result, "Too low.")
    
    # Test 14: Integration test
    def test_full_door_sequence(self):
        """Test complete door interaction from start to finish"""
        # 1. Door starts locked
        self.assertFalse(self.door.is_unlocked())
        
        # 2. Examine the door
        description = self.door.examine_door()
        self.assertIsInstance(description, str)
        
        # 3. Get menu options
        menu = self.door.menu_options()
        self.assertIn("1-10", menu)
        
        # 4. Set specific number for testing
        self.door._random_number = 6
        
        # 5. Try wrong guesses
        result1 = self.door.attempt(3)
        self.assertIn("too low", result1.lower())
        
        result2 = self.door.attempt(9)
        self.assertIn("too high", result2.lower())
        
        # 6. Guess correctly
        result3 = self.door.attempt(6)
        
        # 7. Door is now unlocked
        self.assertTrue(self.door.is_unlocked())
        self.assertIn("correct", result3.lower())


if __name__ == '__main__':
    unittest.main()
