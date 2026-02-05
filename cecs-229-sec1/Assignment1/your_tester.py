# Vincent Nguyen
# CECS 229
# Assignment 1

from pa1 import congruent_to

"""
def congruent_to(a, m, low, high):
    x_vals = []
    # Use high + 1 to include the upper bound endpoint
    for val in range(low, high + 1): 
        # Checks if val and a have the same remainder when divided by m
        if val % m == a % m:
            x_vals.append(val) 
            
    return x_vals
"""

def test():
    print()
    print("Testing Problem 1...")
    # Write your test cases for Problem 1 here

    # Test Case 1 
    result = congruent_to(3, 5, -10, 15)
    expected = [-7, -2, 3, 8, 13]
    print(f"Test 1: congruent_to{expected}")
    print(f"Expected: {expected}")
    print(f"Got:      {result}\n")
    # Test for failed case for best practice
    if(result != expected):
        print(f"[x] FAILED: Expected\n")

    # Test Case 2
    print("Testing Problem 2 ...")
    result = congruent_to(12, 15, -29, -11)
    expected = [-18]
    print(f"Test 2: congruent_to{expected}")
    print(f"Expected: {expected}")
    print(f"Got:      {result}\n")
    if(result != expected):
        print(f"[x] FAILED: Expected\n")

    # Test Case 3
    print("Testing Problem 3 ...")
    result = congruent_to(-20, 4, 3, 21)
    expected = [4, 8, 12, 16, 20]
    print(f"Test 3: congruent_to{expected}")
    print(f"Expected: {expected}")
    print(f"Got:      {result}\n")
    if(result != expected):
        print(f"[x] FAILED: Expected\n")
