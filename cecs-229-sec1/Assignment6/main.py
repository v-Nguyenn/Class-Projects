import random, math
import pa6, your_tester

def print_points(pts_set, cols):
    for i in range(0, len(pts_set), cols):
        regex = "%-20s" * cols
        print(regex % tuple(list(pts_set)[i:i + cols]))
        if i % cols == 0:
            print()
        i += 1
    print()


def main():
    
    print("Welcome to the PA #6 Tester")
    
    while True:
        S = {
            2 + 2j, 3 + 2j, 1.75 + 1j, 2 + 1j, 2.25 + 1j, 2.5 + 1j, 2.75 + 1j,
            3 + 1j, 3.25 + 1j
        }
        user_in = input(
            "\n" + "-" * 50 +
            "\nWhich problem would you like to test?"
            "\n1.  Problem 1: translate(S, z0)"
            "\n2.  Problem 2: scale(S, k)"
            "\n3.  Problem 3: rotate(S, tau)"
            "\n4.  Run your own tester"
            "\n5.  Quit"
            "\n\nEnter your selection: "
        )
        if user_in == '1':
            print("\n" + "-" * 50 + "\n\nTesting Problem 1...\n")
            print("ORIGINAL VALUES:")
            print_points(S, 3)
    
            T1 = pa6.translate(S, -3 -2j)
            T2 = pa6.translate(S, 3 - 2j)
            T3 = pa6.translate(S, -3 + 2j)  
            T4 = pa6.translate(S, 3 + 2j)  
    
            expected1 = {
                0j, (-0.25 - 1j), (-1 + 0j), -1j, (-1 - 1j), (-1.25 - 1j),
                (-0.75 - 1j), (0.25 - 1j), (-0.5 - 1j)
            }
            expected2 = {(6 - 1j), (6.25 - 1j), (5 + 0j), (6 + 0j), (5 - 1j),
                         (5.75 - 1j), (5.5 - 1j), (4.75 - 1j), (5.25 - 1j)}
            expected3 = {(-1 + 3j), (-1.25 + 3j), (-0.75 + 3j), (-1 + 4j), (-0.5 + 3j),
                         4j, (-0.25 + 3j), 3j, (0.25 + 3j)}
            expected4 = {(4.75 + 3j), (5.5 + 3j), (5.25 + 3j), (5 + 3j), (5 + 4j),
                         (6 + 4j), (5.75 + 3j), (6 + 3j), (6.25 + 3j)}
    
            print(' ' * 10 + '-' * 30)
            print("\nSHIFT LEFT 3, DOWN 2:")
            print("Expected Set:")
            print_points(expected1, 3)
            print("Returned Set:")
            print_points(T1, 3)
    
            print(' ' * 10 + '-' * 30)
            print("\nSHIFT RIGHT 3, DOWN 2:")
            print("Expected Set:")
            print_points(expected2, 3)
            print("Returned Set:")
            print_points(T2, 3)
    
            print(' ' * 10 + '-' * 30)
            print("\nSHIFT LEFT 3, UP 2:")
            print("Expected Set:")
            print_points(expected3, 3)
            print("Returned Set:")
            print_points(T3, 3)
    
            print(' ' * 10 + '-' * 30)
            print("\nSHIFT RIGHT 3, UP 2:")
            print("Expected Set:")
            print_points(expected4, 3)
            print("Returned Set:")
            print_points(T4, 3)
    
            if T1 == expected1 and T2 == expected2 and T3 == expected3 and T4 == expected4:
                print("Test PASSED.")
            else:
                print("Test FAILED.")
    

        elif user_in == '2':
            print("\n" + "-" * 50 + "\n\nTesting Problem 2...\n\n")
    
            T1 = pa6.translate(S, -3 -2j)  
            T2 = pa6.translate(S, 3 - 2j)  
            T3 = pa6.translate(S, -3 + 2j) 
            T4 = pa6.translate(S, 3 + 2j)  
            sets = [S, T1, T2, T3, T4]
    
            scaled_sets = [pa6.scale(A, 2) for A in sets]
            expected1 = {(3.5 + 2j), (4.5 + 2j), (5 + 2j), (4 + 2j), (5.5 + 2j),
                         (6 + 2j), (6.5 + 2j), (4 + 4j), (6 + 4j)}
            expected2 = {
                0j, (-2.5 - 2j), (0.5 - 2j), (-2 + 0j), (-1 - 2j), (-2 - 2j),
                (-1.5 - 2j), (-0.5 - 2j), -2j
            }
            expected3 = {(9.5 - 2j), (10.5 - 2j), (11.5 - 2j), (12.5 - 2j), (12 - 2j),
                         (10 - 2j), (11 - 2j), (10 + 0j), (12 + 0j)}
            expected4 = {(-2 + 6j), (-1.5 + 6j), (-1 + 6j), (-2.5 + 6j), (-0.5 + 6j),
                         6j, (-2 + 8j), (0.5 + 6j), 8j}
            expected5 = {(10 + 8j), (12 + 6j), (12 + 8j), (12.5 + 6j), (10 + 6j),
                         (9.5 + 6j), (10.5 + 6j), (11 + 6j), (11.5 + 6j)}
            expected = [expected1, expected2, expected3, expected4, expected5]
            for i in range(len(scaled_sets)):
    
                print("Original Set:")
                print_points(sets[i], 3)
                print("Expected after Scaling by 2:")
                print_points(expected[i], 3)
                print("Returned:")
                print_points(scaled_sets[i], 3)
                if expected[i] == scaled_sets[i]:
                    print("Test PASSED!\n")
                else:
                    print("Test FAILED.\n")
                print(' ' * 10 + '-' * 30)
    
    
        elif user_in == '3':
            print("\n" + "-" * 50 + "\n\nTesting Problem 3...\n\n")
            T1 = pa6.translate(S, -3 -2j) 
            T2 = pa6.translate(S, 3 - 2j)  
            T3 = pa6.translate(S, -3 + 2j)  
            T4 = pa6.translate(S, 3 + 2j) 
            sets = [S, T1, T2, T3, T4]
    
            r = int(input("Select the angle to rotate by:\n1. pi/2\n2. -pi/2:\nYour selection: "))
            if r == 1:
                rotated_sets = [pa6.rotate(A, math.pi / 2) for A in sets]
                
                new_sets = []
                for A in rotated_sets:
                    new_set = set()
                    for c in A:
                        new_set.add(complex(round(c.real, 2), round(c.imag, 2)))
                    new_sets.append(new_set)
                rotated_sets = new_sets
                expected = [{(-1 + 1.75j), (-2 + 2j), (-1 + 2.25j),
                             (-1 + 2j), (-1 + 2.5j), (-2 + 3j), (-1 + 2.75j), (-1 + 3j),
                             (-1 + 3.25j)},
                            {
                                0j, (1 - 0.25j), (1 + 0j), (1 - 0.75j), (1 + 0.25j),
                                (1 - 0.5j), (-0 - 1j), (1 - 1j), (1 - 1.25j)
                            },
                            {(1 + 4.75j), 5j, (1 + 5.25j), (1 + 5.75j), 6j, (1 + 6j),
                             (1 + 6.25j), (1 + 5j), (1 + 5.5j)},
                            {(-3 - 0.75j), (-3 - 0.25j), (-3 + 0j), (-3 + 0.25j),
                             (-4 - 1j), (-3 - 1j), (-3 - 1.25j), (-4 + 0j), (-3 - 0.5j)},
                            {(-3 + 4.75j),
                             (-4 + 5j), (-3 + 5j), (-3 + 5.25j), (-3 + 5.5j), (-4 + 6j),
                             (-3 + 5.75j), (-3 + 6j), (-3 + 6.25j)}]
                for i in range(len(rotated_sets)):
                    print("Original Set:")
                    print_points(sets[i], 3)
                    print("Expected after rotating by pi/2:")
                    print_points(expected[i], 3)
                    print("Returned:")
                    print_points(rotated_sets[i], 3)
                    print(' ' * 10 + '-' * 30)
                    if expected[i] == rotated_sets[i]:
                        print("Test PASSED.")
                    else:
                        print("Test FAILED.")
            elif r == 2:
                expected2 = [{(1 - 3.25j), (1 - 2.25j), (1 - 2j), (1 - 2.75j), (1 - 3j),
                              (2 - 3j), (1 - 2.5j), (2 - 2j), (1 - 1.75j)},
                             {
                                 0j, (-1 + 1j), (-1 + 1.25j), 1j, (-1 - 0j),
                                 (-1 + 0.75j), (-1 - 0.25j), (-1 + 0.5j), (-1 + 0.25j)
                             },
                             {(-1 - 6.25j), (-1 - 6j), -6j, (-1 - 5.25j), (-1 - 5.75j),
                              -5j, (-1 - 5j), (-1 - 4.75j), (-1 - 5.5j)},
                             {(3 + 0.5j), (3 + 0.75j), (4 + 0j), (3 + 1.25j), (3 + 1j),
                              (4 + 1j), (3 + 0.25j), (3 + 0j), (3 - 0.25j)},
                             {(3 - 4.75j), (3 - 6j), (4 - 6j), (3 - 6.25j), (3 - 5.25j),
                              (3 - 5.5j), (3 - 5j), (4 - 5j), (3 - 5.75j)}]
                rotated_sets2 = [pa6.rotate(A, -1 * math.pi / 2) for A in sets]
                new_sets = []
                for A in rotated_sets2:
                    new_set = set()
                    for c in A:
                        new_set.add(complex(round(c.real, 2), round(c.imag, 2)))
                    new_sets.append(new_set)
                rotated_sets2 = new_sets
                for i in range(len(rotated_sets2)):
                    print("Original Set:")
                    print_points(sets[i], 3)
                    print("Expected after rotating by -pi/2:")
                    print_points(expected2[i], 3)
                    print("Returned:")
                    print_points(rotated_sets2[i], 3)
                    print(' ' * 10 + '-' * 30)
                    if expected2[i] == rotated_sets2[i]:
                        print("Test PASSED.")
                    else:
                        print("Test FAILED.")
                    
                
            else:
                print("Invalid selection. Returning to main menu...\n\n")

        elif user_in == '4':
            print("\n" + "-" * 50 + "\n\nRunning your own tester...\n\n")
            your_tester.test()
    
        elif user_in == '5' or user_in.upper() == 'Q':
            break
    
        else:
            print("Invalid selection.  Please try again.")
main()