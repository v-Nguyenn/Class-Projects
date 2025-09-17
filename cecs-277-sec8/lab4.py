# Lab 4 - Maze Solve
# CECS 277 Section 8 - Fall 2024
# Brian Gutierrez and Vincent Nguyen
# October 01, 2024

import check_input

 # Reads the maze from a text file and returns it as a list of lists
def read_maze():
   with open('maze-demo.txt', 'r') as file:
      maze_data = file.read().splitlines() #note splitlines() removes newline characters
      maze = []
      for line in maze_data:
         maze.append(list(line))
      return maze

# Finds the start position 'S' in the maze, takes a list of strings as input
def find_start(maze):
   for i in range(len(maze)):
      for j in range(len(maze[i])):

         # Find the start position 'S' or 's'
         if maze[i][j] == 'S' or maze[i][j] == 's':
            return (i, j) #returns(row, column)
         
   return None

# Displays the maze with the current location, takes a list of strings and loc(row, column)
def display_maze(maze,loc):
   for i in range(len(maze)):
      row = ""
      for j in range(len(maze[i])):
         # Mark the current location with 'X'
         if (i, j) == loc:
            row += 'X'  
         else:
            row += maze[i][j]
      print(row)
   
def main():
   # Initialize the maze and starting location
   print("-Maze Solver-")
   maze = read_maze()
   location = find_start(maze)
   at_end = False

   while not at_end:
      display_maze(maze, location)
      
      # Testing, print the location position with coordinates
      # if location:
      #    print(f"Position at: {location}")
      # else:
      #    print("Position 'S' not found in the maze.")

      # Display movement options and get user input
      print("1. Go North")
      print("2. Go South")
      print("3. Go East")
      print("4. Go West")
      print("5. Exit")
      user_input = check_input.get_int_range("Enter choice: ", 1, 5)
      print()

      new_loc = location  # Default to current location

      if user_input == 1:  # Go North
         new_loc = (location[0] - 1, location[1])
      elif user_input == 2: # Go South
         new_loc = (location[0] + 1, location[1])
      elif user_input == 3: # Go East
         new_loc = (location[0], location[1] + 1)
      elif user_input == 4: # Go West
         new_loc = (location[0], location[1] - 1)
      elif user_input == 5: # Exit
         print("Exiting the maze.")
         break

      # Check if new location is within bounds and not a wall
      if (0 <= new_loc[0] < len(maze)) and (0 <= new_loc[1] < len(maze[0])):
         if maze[new_loc[0]][new_loc[1]] == '*':
            print("You cannot move there.") # location stays the same
         else:
            location = new_loc  # Only updates if location is not a wall
      else:
         print("Out of the maze")

      # Check if the new location is the end 'F'
      if maze[location[0]][location[1]] == 'F' or maze[location[0]][location[1]] == 'f':
         at_end = True
         display_maze(maze, location)
         print("Congratulations! You solve the maze!")
   
   # print(f"New location: {location}") # For testing, print new location

if __name__ == "__main__":
   main()