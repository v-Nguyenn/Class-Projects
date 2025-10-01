#test_die.py

from die import Die

def test_die_roll():
   die = Die()
   for _ in range (1): # _ is a throwaway variable since we don't use it
      die.roll() 
      val = die.roll() # Roll the die and get the value
      print(f"Rolled value: {val}")


def test_die_sides():
   die = Die()                       # Create a Die object with default sides (6)
   print(f"Die sides: {die._sides}") # Accessing the private attribute for testing purposes

def test_str_():
   die = Die()
   die.roll()
   str_value = str(die)  # This will call the __str__ method
   print(f"String representation of die: {str_value}")

if __name__ == "__main__":
   test_die_init = Die(20)
   test_die_sides()
   test_die_roll()
   test_str_()

