from pa4 import mod_inv, solve_linear_congruence


def test():
    print("Testing Problem 1...")
    # Write your test cases for Problem 1 here
    result = mod_inv(3, 11)
    print("Should return 4: \n")
    print("Modulus inverse (3, 11): ", result)
    print()

    result = mod_inv(10, 17)
    print("Should return 12 \n")
    print("Modulus inverse (10, 17): ", result)
    print()

    result = mod_inv(2, 4)
    print("Should raise ValueError (Since gcd(2, 4) != 1 \n")
    print("Modulus inverse (2, 4): ", result)

    print("Testing Problem 2...")
    # Write your test cases for Problem 2 here



