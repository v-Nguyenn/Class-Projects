import random
import math
import pa4
import your_tester


def main():
    print("Welcome to the PA #4 Tester")

    while True:
        user_in = input("\n" + "-" * 50 + "\nWhich problem would you like to test?\n1.  Problem 1: mod_inv(a, m)\n2.  Problem 2: solve_linear_congruence(a, b, m, low, high)\n3.  Run your own tester.\nQ.  Quit\n\nEnter your selection: ")
        if user_in == '1':
            print("\n" + "-" * 50 + "\n\nTesting Problem 1...\n\n")
            a = random.randint(2, 10)
            m = random.randint(2, 50)
            while math.gcd(a, m) != 1:
                a = random.randint(2, 10)
                m = random.randint(2, 50)
            received = pa4.mod_inv(a, m)
            print(f"Testing mod_inv({a}, {m})....\nReceived: {received}")

            if (received * a - 1) % m == 0:
                if 0 < received < m:
                    print(f"{received} * {a} is EQUIVALENT to 1 under modulus {m}.\n\nTest PASSED.")
                else:
                    print(f"{received} * {a} equivalent to 1 under modulus {m} is correct, but {received} is not the "
                          f"range [{low}, {high}].")
            else:
                print(f"{received} * {a} is NOT EQUIVALENT to 1 under modulus {m}.\n\nTest FAILED.")

        elif user_in == '2':
            print("\n" + "-" * 50 + "\n\nTesting Problem 2...\n\n")
            a = random.randint(2, 20)
            m = random.randint(2, 50)
            b = random.randint(-10, 10)
            while math.gcd(a, m) != 1:
                a = random.randint(-10, 10)
                m = random.randint(2, 50)

            low = random.randint(-2 * m, 0)
            high = low + random.randint(m, 2 * m)
            received = pa4.solve_linear_congruence(a, b, m, low, high)
            print(f"Testing solve_linear_congruence({a}, {b}, {m}, {low}, {high})....\n")
            print("Received:", received)
            for x in received:
                if (a * x - b) % m == 0:
                    if low <= x <= high:
                        print(f"\tx = {x}: {a}*{x} is EQUIVALENT to {b} modulus {m} ==> CORRECT.")
                    else:
                        print(f"\tx = {x}: {a}*{x} is EQUIVALENT to {b} modulus {m} BUT x is NOT IN CORRECT "
                              f"RANGE [{low}, {high}].")
                else:
                    print(f"\tx = {x}: {a}*{x} is NOT EQUIVALENT to {b} modulus {m} ==> INCORRECT.")

        elif user_in == '3':
            print("\n" + "-" * 50 + "\n\nRunning your own tester...\n\n")
            your_tester.test()

        elif user_in.upper() == 'Q':
            break
        else:
            print("Invalid selection.  Please try again.")
    return


if __name__ == "__main__":
    main()
