from pa1 import congruent_to

def test():
    print("Testing Problem 1...")
    # Write your test cases for Problem 1 here

    # Test case 1 
    result = congruent_to(3, 5, -10, 15)
    expected = [-7, -2, 3, 8, 13]
    print(f"Test 1: congruent_to(3, 5, -10, 15)")
    print(f"Expected: {expected}")
    print(f"Got:      {result}\n")
    if(result != expected):
        print(f"[x] FAILED: Expected\n")

    print("Testing Problem 2 ...")
    
    print("Testing Problem 3 ...")