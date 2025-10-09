# AI Coding Agent Instructions

## Project Overview
This is a multi-language academic coursework repository containing completed assignments and labs from computer science courses: Python (CECS 277, CS-10), Java (CS-38), C++ (CS-41). The primary active work is in **CECS 277 Python OOP labs**.

## Repository Structure
- **`cecs-277-sec8/`** - Active Python OOP course (CECS 277, Section 8, Fall 2024)
  - Each `Lab#/` folder is a self-contained assignment with its own copy of `check_input.py`
  - `utils/` contains the canonical version of shared utilities
- **`cs-10-intro-to-python/`** - Intro Python homework assignments
- **`cs-38-java/`** - Java course files with chapter-based exercises
- **`cs-41-data-structures/`** - C++ data structures sample code and homework

## Code Conventions - Python (CECS 277)

### File Headers
**Always include** a module docstring with:
```python
"""
[Author names]
CECS 277 - Sec 8
Lab [#] - [filename]
[Brief description of file purpose]
"""
```

### Class Documentation Pattern
Follow this structure for ALL classes and methods:
```python
class ClassName:
   """
   Brief class description.
   """

   def method_name(self, param):
      """
      Method description.

      Args:
         self (ClassName): the current object
         param (type): parameter description

      Returns:
         type: description of return value

      Raises:
         ExceptionType: when this exception occurs
      """
```

### OOP Patterns in Use

**1. Inheritance Hierarchy** (Lab 7 - Game Entities)
- Base class: `Entity` with `name`, `_hp`, `_max_hp`
- Derived classes: `Hero`, `Dragon` with specialized attack methods
- Use `from entity import Entity` then inherit with `class Hero(Entity):`
- Call parent `__init__` implicitly via super() pattern or direct attribute assignment

**2. Composition** (Lab 6 - Dice Game)
- `Player` class **contains** list of `Die` objects: `self._dice = [Die(), Die(), Die()]`
- Use private attributes with `@property` decorators for getters/setters
- Example: `@property` for `points` attribute with corresponding `@points.setter`

**3. Operator Overloading**
- `__lt__` for sorting: Compare objects in custom order (e.g., `Contact` by last name, then first name)
- `__eq__` for equality checks
- `__str__` for display representation
- `__repr__` for file serialization format

**4. File I/O Pattern** (Lab 5)
```python
def read_file():
   contacts = []
   try:
      with open("filename.txt", "r") as file:
         for line in file:
            # Parse line, create objects, append to list
      return contacts
   except FileNotFoundError:
      print("File not found.")
      return contacts
```

### Input Validation
**Always use** `check_input` module functions instead of raw `input()`:
- `check_input.get_int(prompt)` - any integer
- `check_input.get_positive_int(prompt)` - non-negative
- `check_input.get_int_range(prompt, low, high)` - range validation
- `check_input.get_yes_no(prompt)` - returns True/False

Import as: `import check_input` (Lab 6/7) or `import utils.check_input as check_input` (Lab 5)

### Random Values
Use `random.randint(min, max)` for dice rolls and damage calculations (inclusive on both ends).

## Running Python Programs
- Execute with: `python Lab#/main.py` or `python Lab#/lab#.py`
- Labs may use text files (e.g., `maze.txt`, `addresses.txt`) - ensure they exist in the lab directory
- No virtual environment setup documented; runs directly with system Python

## Java Conventions (CS-38)
- Chapter-based organization: `Ch01/`, `Ch02/`, etc.
- Uses `Draw` library for graphics assignments (located in `Libs/`)
- Build with: `build.bat` in root of Java Course Files
- Javadoc HTML documentation in `Ch#/doc/` folders

## Testing
- Lab 6 includes `test_die.py` - pytest-style unit tests
- No global test suite; testing is assignment-specific

## Key Patterns NOT in Use
- No type hints (except occasional annotations in Lab 7: `self._name: str`)
- No virtual environments or `requirements.txt`
- No CI/CD or automated testing infrastructure
- No package management beyond standard library + occasional imports

## Current Work Focus
Lab 7 (Inheritance) is **in progress** - `fire.py` and `flying.py` are empty placeholder files, suggesting upcoming mixin or multi-inheritance implementation for dragon variants.
