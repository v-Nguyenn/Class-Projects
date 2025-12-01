------------------------------------------------------------------------
CHAPTER 01 - Java Fundamentals and Graphics
------------------------------------------------------------------------

PROJECT TITLE: Chapter 01 Programming Exercises
PURPOSE OF PROJECT: Learn Java fundamentals and the Draw graphics library
VERSION: Originally September 2024, Updated December 2025
AUTHOR: Vincent Nguyen

------------------------------------------------------------------------
PROGRAMS IN THIS FOLDER:
------------------------------------------------------------------------

1. CheckeredBoard.java
   - Creates a 400x400 checkered board pattern with black and white squares
   - Bonus: Displays the French flag with a flag pole
   - Main homework assignment for fundamentals
   - Topics: Coordinate scaling, layering shapes, colors

2. MyDrawing.java
   - First drawing exercise: Creates a black circle with a red rectangle in the center
   - Simple introduction to Draw graphics and default coordinate system
   - Topics: filledCircle(), filledRectangle(), basic shapes

3. BasicArithmetic.java (formerly Pg106_VincentN.java)
   - Practice exercises from page 106 of the textbook
   - Demonstrates basic arithmetic operations and text output to graphics screen
   - Multiple methods: main(), partB(), partCwGraphics()
   - Topics: Integer arithmetic, print statements, Draw library text output

4. CircleSizes.java (formerly VincentExercise1.java)
   - Exercise creating multiple colored circles of different sizes on a yellow background
   - Practice with Draw graphics, positioning, and color changes
   - Methods: main(), printExample()
   - Topics: Multiple shape positioning, setPenColor(), text() method

------------------------------------------------------------------------
HOW TO RUN THESE PROGRAMS:
------------------------------------------------------------------------

IMPORTANT: These programs use the Draw.jar library, so you MUST include
it in the classpath when compiling and running.

METHOD 1 - Using the play button in VS Code (configured):
   Simply open any .java file and click the play button (▶️) in the top right

METHOD 2 - Using the provided script (from project root):
   ./run_example.sh Ch01/CheckeredBoard
   ./run_example.sh Ch01/MyDrawing
   ./run_example.sh Ch01/BasicArithmetic
   ./run_example.sh Ch01/CircleSizes

METHOD 3 - Manual compilation and execution:
   cd Ch01
   javac -cp ".:../Libs/draw.jar" CheckeredBoard.java
   java -cp ".:../Libs/draw.jar" CheckeredBoard

   Replace "CheckeredBoard" with any other program name to run it.

METHOD 4 - Compile all at once:
   From the project root:
   ./compile_with_draw.sh
   
   Then run individual programs:
   cd Ch01
   java -cp ".:../Libs/draw.jar" CheckeredBoard

------------------------------------------------------------------------
NOTES:
------------------------------------------------------------------------
- The Draw library (draw.jar) is located in the Libs folder
- All graphics programs will open a new window
- If you get "cannot find symbol Draw" errors, you forgot to include
  the -cp flag with the draw.jar path
- VS Code is configured with .vscode/settings.json to automatically
  include the Draw library when using the play button
