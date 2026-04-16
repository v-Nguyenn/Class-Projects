import pa8
import pa9
import your_tester
import math
from copy import deepcopy
import random


def main():
    print("Welcome to the PA #9 Tester")
    while True:
        matrix0 = pa8.Matrix([[0, 2, 3, 1],[2, 4, 7, 3],[1, 1, 2, 2]])
        matrix1 = pa8.Matrix([[2, -1, -10], [2, 0, -4], [-7, 3, 2]])
        matrix2 = pa8.Matrix([[-10, 7, 7, -3, 2], [6, -9, 7, -5, 0], [-2, 7, -3, -6, 2]])
        matrix3 = pa8.Matrix([[-7, -9, 4, -9], [2, -9, -3, 3]])
        matrices = [matrix0, matrix1, matrix2, matrix3]
        rand_val = random.randint(0,3)
        rand_matrix = matrices[rand_val]

        user_in = input(
            "\n" + "-" * 50 +
            "\nWhat would you like to test?" +
            "\n1.  Matrix.copy()" +
            "\n2.  Matrix.swap_rows(i, j)" +
            "\n3.  Matrix.scale_row(i, c)" +
            "\n4.  Matrix.add_row_multiple(source, target, c)" +
            "\n5.  pivot_index(i, j, A)" +
            "\n6.  ref(A)" +
            "\n7.  Run your own tests"
            "\nQ.  Quit\n\nEnter your selection: "
        )
        if user_in == '1':
            c = rand_matrix.copy()
            print("Original matrix:")
            print(rand_matrix)
            print("Copied matrix:")
            print(c)
            if rand_matrix == c:
                print("Test Passed")
            else:
                print("Test Failed")
                
        elif user_in == '2':
            result0 = pa8.Matrix([[2, 4, 7, 3],[0, 2, 3, 1],[1, 1, 2, 2]])
            result1 = pa8.Matrix([[2, 0, -4], [2, -1, -10], [-7, 3, 2]])
            result2 = pa8.Matrix([[6, -9, 7, -5, 0], [-10, 7, 7, -3, 2], [-2, 7, -3, -6, 2]])
            result3 = pa8.Matrix([[2, -9, -3, 3], [-7, -9, 4, -9]])
            results = [result0, result1, result2, result3]
            print("Original matrix:")
            print(rand_matrix)
            rand_matrix.swap_rows(1, 2)            
            print("Swapped matrix i=1, j=2:")
            print(rand_matrix)
            print("Expected matrix:")
            print(results[rand_val])
            if rand_matrix == results[rand_val]:
                print("Test Passed")
            else:
                print("Test Failed")
    
        elif user_in == '3':
            result0 = pa8.Matrix([[0, 4, 6, 2],[2, 4, 7, 3],[1, 1, 2, 2]])
            result1 = pa8.Matrix([[4, -2, -20], [2, 0, -4], [-7, 3, 2]])
            result2 = pa8.Matrix([[-20, 14, 14, -6, 4], [6, -9, 7, -5, 0], [-2, 7, -3, -6, 2]])
            result3 = pa8.Matrix([[-14, -18, 8, -18], [2, -9, -3, 3]])
            results = [result0, result1, result2, result3]
            print("Original matrix:")
            print(rand_matrix)
            rand_matrix.scale_row(1, 2)            
            print("Matrix updated with scaled row where i=1, scalar=2:")
            print(rand_matrix)
            print("Expected matrix:")
            print(results[rand_val])
            if rand_matrix == results[rand_val]:
                print("Test Passed")
            else:
                print("Test Failed")
                
        elif user_in == '4':
            result0 = pa8.Matrix([[4, 10, 17, 7],[2, 4, 7, 3],[1, 1, 2, 2]])
            result1 = pa8.Matrix([[6, -1, -18], [2, 0, -4], [-7, 3, 2]])
            result2 = pa8.Matrix([[2, -11, 21, -13, 2], [6, -9, 7, -5, 0], [-2, 7, -3, -6, 2]])
            result3 = pa8.Matrix([[-3, -27, -2, -3], [2, -9, -3, 3]])
            results = [result0, result1, result2, result3]
            print("Original matrix:")
            print(rand_matrix)
            rand_matrix.add_row_multiple(2, 1, 2)            
            print("Matrix updated where source=2, target=1, c=2:")
            print(rand_matrix)
            print("Expected matrix:")
            print(results[rand_val])
            if rand_matrix == results[rand_val]:
                print("Test Passed")
            else:
                print("Test Failed")
    
        elif user_in == '5':
            result0 = (2, 1)
            result1 = (1, 1)
            result2 = (1, 1)
            result3 = (1, 1)
            results = [result0, result1, result2, result3]

            print("Original matrix:")
            print(rand_matrix)
            pivot_loc = pa9.pivot_index(1, 1, rand_matrix)
            print("Pivot starting at (1,1):", pivot_loc)
            print("Expected location: ", results[rand_val])
            if pivot_loc == results[rand_val]:
                print("Test Passed")
            else:
                print("Test Failed")
            
            
            new = pa8.Matrix([[0, 4, 7, 3],[0, 2, 3, 1],[0, 1, 2, 2]])
            print("Additional matrix:")
            print(new)
            pivot_loc = pa9.pivot_index(1, 1, new)
            print("Pivot starting at (1,1):", pivot_loc)
            result = (1,2)
            print("Expected location: ", result)
            if pivot_loc == result:
                print("Test Passed")
            else:
                print("Test Failed")
                
        elif user_in == '6':
            result0 = pa8.Matrix([[1.0, 2.0, 3.5, 1.5],[0.0, 1.0, 1.5, 0.5],[0.0, 0.0, 0.0, 1.0]])
            result1 = pa8.Matrix([[1.0, -0.5, -5.0], [0.0, 1.0, 6.0], [-0.0, -0.0, 1.0]])
            result2 = pa8.Matrix([[1.0, -0.7, -0.7, 0.3, -0.2], [-0.0, 1.0, -2.33, 1.42, -0.25],
                                [0.0, 0.0, 1.0, -1.54, 0.35]])
            result3 = pa8.Matrix([[1.0, 1.29, -0.57, 1.29],
                                [-0.0, 1.0, 0.16, -0.04]])
            results = [result0, result1, result2, result3]
            
            m, n = rand_matrix.dim()
            print(f"\nTesting ref(A) for {m}x{n} matrix A:")
            print(rand_matrix)
            returned = pa9.ref(rand_matrix)
            for r in range(1, m+1):
                for c in range(1, n+1):
                    returned.set_entry(r, c, round(returned.get_element(r, c), 2))
            print("\nReturned:\n", returned)
            print("\nExpected:\n", results[rand_val])
            if returned == results[rand_val]:
                print("Test Passed!")
            else:
                print("Test Failed!")
        elif user_in == '7':
            print("\n" + "-" * 50 + "\n\nRunning your own tester...\n\n")
            your_tester.test()
        elif user_in.upper() == 'Q':
            break
        else:
            print("Invalid selection.  Please try again.\n")



main()