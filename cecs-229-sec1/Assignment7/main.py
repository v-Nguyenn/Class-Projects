# This code is provided by professor Shannon Cleary to run pa7
import random, math
import pa7, your_tester


def main():
    print("Welcome to the PA #7 Tester")
    
    while True:
        user_in = input(
            "\n" + "-" * 50 +
            "\nWhich problem would you like to test?"
            "\n1.  Problem 1: Vec class"
            "\n2.  Run your own tester"
            "\n3.  Quit"
            "\n\nEnter your selection: "
        )
        if user_in == '1':
            print("\n" + "-" * 50 + "\n\nTesting Problem 1...\n\n")
            u = pa7.Vec([1, 2, 3])
            w = pa7.Vec([0, 1, -1])
            v = pa7.Vec([0, -3])
    
            print("u = ", u)
            print("w = ", w)
            print("\nEuclidean norm of u:", abs(u))
            print("Expected:", math.sqrt(sum([ui ** 2 for ui in u.elements])))
            print("\nEuclidean norm of v:", abs(v))
            print("Expected: 3")
            print("\nu left scalar multiplication by 2:", 2 * u)
            print("Expected: [2, 4, 6]")
            print("\nw right scalar multiplication by -1:", w * -1)
            print("Expected: [0, -1, 1]")
            print("\nVector addition:", u + w)
            print("Expected: [1, 3, 2]")
            print("\nVector addition:", u - w)
            print("Expected: [1, 1, 4]")
            print("\nDot product:", w * u)
            print("Expected: -1")
    
            try:
                print("\nDot product:", v * u)
                print(
                    "If this line prints, you forgot to raise a ValueError for taking the dot product of vectors of different lengths"
                )
            except ValueError:
                print("If this line prints, a ValueError was correctly raised.")
    
        elif user_in == '2':
            print("\n" + "-" * 50 + "\n\nRunning your own tester...\n\n")
            your_tester.test()
    
        elif user_in == '3' or user_in.upper() == 'Q':
            break
        else:
            print("Invalid selection.  Please try again.")
main()