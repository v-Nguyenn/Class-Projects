# Lab 4 - Maze Solver
# CECS 277 - Fall 2024
# Brian Gutierrez and Vincent Nguyen
# October 01, 2024

import check_input


def read_maze():
   with open('maze-demo.txt', 'r') as file:
      maze_data = file.readlines()
   
   maze = []
   for line in maze_data:
      maze.append(list(line.strip('\n')))
   
   return maze

#def find_start(maze):
      
#def display_maze(maze,loc):


def main():
   print("-Maze Solver-")
   maze = read_maze()
   for row in maze:
      print(''.join(row))
  # start_location = find_start(maze)

if __name__ == "__main__":
   main()