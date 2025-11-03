"""
Brian Gutierrez and Vincent Nguyen
Lab 10
CECS 277 Section 8
Fall 2025
October 25, 2025
"""

class Map:
   """ The map of the dungeon maze """
   _instance = None # Store the single instance
   _initialized = False # Tracks if it is initialized

   def __new__(cls):
      """ Creates or returns the single instance """
      if cls._instance is None: # If no instance exists yet
         cls._instance = super().__new__(cls) # Create new instance
      return cls._instance # Returns the same instance
   
   def __init__(self):
      """ Initialize the map once """
      if not Map._initialized:

         # Load map from file
         file = open('map.txt', 'r')
         
         # Iterates through each line removing whitespace
         self._map = [list(line.strip()) for line in file]
         file.close()

         rows = len(self._map)
         cols = len(self._map[0]) # Number of columns
         self._revealed = [[False] * cols for _ in range(rows)]
         Map._initialized = True 

   def __getitem__(self, row):
      """ Returns the specified row from the map. """
      return self._map[row]
   
   def __len__(self):
      """ Returns the number of rows in the map list. """
      return len(self._map)
   
   def show_map(self, loc):
      """ 
      Returns the map as a string in the format of a 5 x 5 matrix 

      Reveals the locations of the characters from map, unrevealed
      locations are x's, and hero's location is a '*'.

      Returns:
         str: 5 x 5 map 
      """
      result = ""
      # If location is a tuple like (x, y)
      hero_row, hero_col = loc

      # Build the 5x5 map string hero starts at (0,0)
      for r in range(len(self._map)):
         for c in range(len(self._map[0])):
            if (r, c) == loc: # Hero's location
               result += '*'
            elif self._revealed[r][c]: # Revealed location
               result += self._map[r][c]
            else: # Unrevealed location
               result += 'x' # Marks the spots as unknown
            result += ' ' # for readablity
         result += '\n'

      return result
   
   def reveal(self, loc):
      """ 
      Sets the value in the 2D revealed list at the
      specified location to True 
      """
      row, col = loc
      self._revealed[row][col] = True
   
   def remove_at_loc(self, loc):
      """ 
      Overwrites the character in the map list at the specified
      location with an 'n' 
      """
      row, col = loc
      self._map[row][col] = 'n'
