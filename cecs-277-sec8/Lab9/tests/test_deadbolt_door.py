"""
Unit tests for DeadboltDoor class
"""
import unittest
import sys
import os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))

from deadbolt_door import DeadboltDoor


class TestDeadboltDoor(unittest.TestCase):
    """Test cases for DeadboltDoor class"""
    
    def setUp(self):
        """Create a fresh DeadboltDoor instance for each test"""
        self.door = DeadboltDoor()
    
    # Test 1: Initialization
    def test_init_creates_deadbolt_one_state(self):
        """Test that __init__ creates deadbolt_one with locked or unlocked state"""
        self.assertIn(self.door._deadbolt_one, ["locked", "unlocked"])
    
    def test_init_creates_deadbolt_two_state(self):
        """Test that __init__ creates deadbolt_two with locked or unlocked state"""
        self.assertIn(self.door._deadbolt_two, ["locked", "unlocked"])
    
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
        self.assertIn("double deadbolt door", result.lower())
        self.assertIn("both deadbolts must be unlocked", result.lower())
    
    # Test 3: menu_options()
    def test_menu_options_returns_string(self):
        """Test that menu_options returns a string"""
        result = self.door.menu_options()
        self.assertIsInstance(result, str)
    
    def test_menu_options_has_two_options(self):
        """Test that menu has both toggle options"""
        result = self.door.menu_options()
        self.assertIn("1. Toggle Bolt 1", result)
        self.assertIn("2. Toggle Bolt 2", result)
    
    # Test 4: get_menu_max()
    def test_get_menu_max_returns_2(self):
        """Test that get_menu_max returns 2 (two bolts to toggle)"""
        result = self.door.get_menu_max()
        self.assertEqual(result, 2)
    
    # Test 5: attempt() - toggling functionality
    def test_attempt_toggles_deadbolt_one_from_locked_to_unlocked(self):
        """Test that attempting option 1 toggles deadbolt one from locked to unlocked"""
        self.door._deadbolt_one = "locked"
        self.door.attempt(1)
        self.assertEqual(self.door._deadbolt_one, "unlocked")
    
    def test_attempt_toggles_deadbolt_one_from_unlocked_to_locked(self):
        """Test that attempting option 1 toggles deadbolt one from unlocked to locked"""
        self.door._deadbolt_one = "unlocked"
        self.door.attempt(1)
        self.assertEqual(self.door._deadbolt_one, "locked")
    
    def test_attempt_toggles_deadbolt_two_from_locked_to_unlocked(self):
        """Test that attempting option 2 toggles deadbolt two from locked to unlocked"""
        self.door._deadbolt_two = "locked"
        self.door.attempt(2)
        self.assertEqual(self.door._deadbolt_two, "unlocked")
    
    def test_attempt_toggles_deadbolt_two_from_unlocked_to_locked(self):
        """Test that attempting option 2 toggles deadbolt two from unlocked to locked"""
        self.door._deadbolt_two = "unlocked"
        self.door.attempt(2)
        self.assertEqual(self.door._deadbolt_two, "locked")
    
    # Test 6: attempt() - messages
    def test_attempt_option_1_returns_first_bolt_message(self):
        """Test that option 1 returns message about first bolt"""
        result = self.door.attempt(1)
        self.assertIn("first bolt", result.lower())
    
    def test_attempt_option_2_returns_second_bolt_message(self):
        """Test that option 2 returns message about second bolt"""
        result = self.door.attempt(2)
        self.assertIn("second bolt", result.lower())
    
    # Test 7: attempt() - unlocking behavior
    def test_attempt_unlocks_when_both_deadbolts_unlocked(self):
        """Test that door unlocks when both deadbolts are unlocked"""
        # Set both to locked first
        self.door._deadbolt_one = "locked"
        self.door._deadbolt_two = "locked"
        
        # Unlock both
        self.door.attempt(1)  # Toggle deadbolt one
        self.door.attempt(2)  # Toggle deadbolt two
        
        # Door should be unlocked
        self.assertFalse(self.door._is_locked)
    
    def test_attempt_keeps_locked_when_only_one_unlocked(self):
        """Test that door stays locked when only one deadbolt is unlocked"""
        # Set one locked, one unlocked
        self.door._deadbolt_one = "unlocked"
        self.door._deadbolt_two = "locked"
        self.door._is_locked = True
        
        # Try toggling (doesn't matter which, still not both unlocked)
        self.door.attempt(1)
        
        # Door should still be locked
        self.assertTrue(self.door._is_locked)
    
    def test_attempt_returns_success_when_both_unlocked(self):
        """Test that success message is returned when both deadbolts unlocked"""
        # Set one locked, one unlocked
        self.door._deadbolt_one = "unlocked"
        self.door._deadbolt_two = "locked"
        
        # Toggle the locked one
        result = self.door.attempt(2)
        
        # Should contain success message
        self.assertIn("unlocked both deadbolts", result.lower())
    
    # Test 8: is_unlocked()
    def test_is_unlocked_returns_false_initially(self):
        """Test that door starts locked"""
        self.assertFalse(self.door.is_unlocked())
    
    def test_is_unlocked_returns_true_after_both_unlocked(self):
        """Test that is_unlocked returns True after both deadbolts unlocked"""
        # Set both to locked
        self.door._deadbolt_one = "locked"
        self.door._deadbolt_two = "locked"
        
        # Unlock both
        self.door.attempt(1)
        self.door.attempt(2)
        
        self.assertTrue(self.door.is_unlocked())
    
    def test_is_unlocked_returns_false_when_only_one_unlocked(self):
        """Test that is_unlocked returns False when only one deadbolt unlocked"""
        # Set one unlocked, one locked
        self.door._deadbolt_one = "unlocked"
        self.door._deadbolt_two = "locked"
        
        self.assertFalse(self.door.is_unlocked())
    
    # Test 9: clue() - dynamic messages
    def test_clue_returns_string(self):
        """Test that clue returns a string"""
        result = self.door.clue()
        self.assertIsInstance(result, str)
    
    def test_clue_says_completely_locked_when_both_locked(self):
        """Test that clue says completely locked when both deadbolts locked"""
        self.door._deadbolt_one = "locked"
        self.door._deadbolt_two = "locked"
        
        result = self.door.clue()
        self.assertIn("completely locked", result.lower())
    
    def test_clue_says_one_unlocked_when_one_unlocked(self):
        """Test that clue mentions one bolt unlocked when exactly one is unlocked"""
        self.door._deadbolt_one = "unlocked"
        self.door._deadbolt_two = "locked"
        
        result = self.door.clue()
        self.assertIn("one of the bolts is unlocked", result.lower())
    
    def test_clue_says_one_unlocked_when_other_one_unlocked(self):
        """Test that clue mentions one bolt unlocked regardless of which one"""
        self.door._deadbolt_one = "locked"
        self.door._deadbolt_two = "unlocked"
        
        result = self.door.clue()
        self.assertIn("one of the bolts is unlocked", result.lower())
    
    # Test 10: success()
    def test_success_returns_string(self):
        """Test that success returns a string"""
        result = self.door.success()
        self.assertIsInstance(result, str)
    
    def test_success_contains_congratulatory_message(self):
        """Test that success contains positive message"""
        result = self.door.success()
        self.assertIn("unlocked both deadbolts", result.lower())
        self.assertIn("opened the door", result.lower())
    
    # Test 11: Complex scenarios
    def test_toggling_back_and_forth(self):
        """Test toggling the same bolt multiple times"""
        # Start with bolt locked
        self.door._deadbolt_one = "locked"
        
        # Toggle it 4 times
        self.door.attempt(1)  # unlocked
        self.assertEqual(self.door._deadbolt_one, "unlocked")
        
        self.door.attempt(1)  # locked
        self.assertEqual(self.door._deadbolt_one, "locked")
        
        self.door.attempt(1)  # unlocked
        self.assertEqual(self.door._deadbolt_one, "unlocked")
        
        self.door.attempt(1)  # locked
        self.assertEqual(self.door._deadbolt_one, "locked")
    
    def test_unlocking_sequence_from_both_locked(self):
        """Test complete unlocking sequence starting from both locked"""
        # Set both locked
        self.door._deadbolt_one = "locked"
        self.door._deadbolt_two = "locked"
        self.door._is_locked = True
        
        # Check initial state
        self.assertFalse(self.door.is_unlocked())
        clue1 = self.door.clue()
        self.assertIn("completely locked", clue1.lower())
        
        # Toggle first bolt
        self.door.attempt(1)
        self.assertFalse(self.door.is_unlocked())
        clue2 = self.door.clue()
        self.assertIn("one of the bolts is unlocked", clue2.lower())
        
        # Toggle second bolt
        result = self.door.attempt(2)
        self.assertTrue(self.door.is_unlocked())
        self.assertIn("unlocked both deadbolts", result.lower())
    
    # Test 12: Integration test
    def test_full_door_sequence(self):
        """Test complete door interaction from start to finish"""
        # 1. Door starts locked
        self.assertFalse(self.door.is_unlocked())
        
        # 2. Examine the door
        description = self.door.examine_door()
        self.assertIsInstance(description, str)
        
        # 3. Get menu options
        menu = self.door.menu_options()
        self.assertIn("1.", menu)
        self.assertIn("2.", menu)
        
        # 4. Set specific state for testing
        self.door._deadbolt_one = "locked"
        self.door._deadbolt_two = "locked"
        
        # 5. Toggle both bolts
        self.door.attempt(1)
        self.door.attempt(2)
        
        # 6. Door is now unlocked
        self.assertTrue(self.door.is_unlocked())


if __name__ == '__main__':
    unittest.main()
