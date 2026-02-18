import random
import math
import pa3
import your_tester


def main():
    print("Welcome to the PA #3 Tester")

    while True:
        user_in = input(
            "\n" + "-" * 50 +
            "\nWhich problem would you like to test?\n1.  Problem 1: primes(a, b)\n2.  Problem 2: gcd(a, b)\n3.  Problem 3: bezout_coeffs(a, "
            "b)\n4.  Run your own tests.\nQ.  Quit\n\nEnter your selection: "
        )
        if user_in == '1':
            print("\n" + "-" * 50 + "\n\nTesting Problem 1...\n\n")
            a = random.randint(1, 60)
            b = random.randint(a + 15, 100)
            prime_vals = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109]
            expected = [x for x in prime_vals if x >= a and x<=b]
            received = pa3.primes(a, b)
            print(f"Testing primes({a}, {b})....\nExpected: {expected}\nReceived: {received}")

            if expected == received:
                print("\nTest PASSED!")
            else:
                print("\nTest FAILED.")

        elif user_in == '2':
            print("\n" + "-" * 50 + "\n\nTesting Problem 2...\n\n")
            
            # test when a = b
            a = random.randint(-100, 100)
            while a == 0:
                a = random.randint(-100, 100)
            expected = math.gcd(a, a)
            received = pa3.gcd(a, a)

            print(f"Testing gcd({a}, {a})....\n\tExpected: {expected}\n\tReceived: {received}")

            if expected == received:
                print("\tTest PASSED!\n")
            else:
                print("\tTest FAILED.\n")

            # negative test
            a = random.randint(50, 100)
            b = random.randint(-49, -2)
            expected = math.gcd(a, b)
            received = pa3.gcd(a, b)
            
            print(f"Testing gcd({a}, {b})....\n\tExpected: {expected}\n\tReceived: {received}")

            if expected == received:
                print("\tTest PASSED!\n")
            else:
                print("\tTest FAILED.\n")

            # positive test
            a = random.randint(50, 100)
            b = random.randint(2, 49)
            expected = math.gcd(a, b)
            received = pa3.gcd(a, b)
            
            print(f"Testing gcd({a}, {b})....\n\tExpected: {expected}\n\tReceived: {received}")

            if expected == received:
                print("\tTest PASSED!\n")
            else:
                print("\tTest FAILED.\n")
                        
        elif user_in == '3':
            print("\n" + "-" * 50 + "\n\nTesting Problem 3...\n\n")
            sols = {(30, 30):(0, 1), (30, 84):(3, -1), (3, 90):(1, 0), (17, 35):(-2, 1), (30, 50):(2, -1), (6, 81):(-13, 1), (13, 97):(15, -2)}
            item = random.choice(list(sols.keys()))
            expected = sols[item]
            received = pa3.bezout_coeffs(item[0], item[1])

            print(f"Testing bezout_coeffs({item[0]}, {item[1]})....\nExpected: {expected}\nReceived: {received}")

            if expected == received:
                print("\nTest PASSED!")
            else:
                print("\nTest FAILED.")

        elif user_in == '4':
            print("\n" + "-" * 50 + "\n\nRunning your own tester...\n\n")
            your_tester.test()

        elif user_in.upper() == 'Q':
            break
        else:
            print("Invalid selection.  Please try again.")
    return


if __name__ == "__main__":
    main()
