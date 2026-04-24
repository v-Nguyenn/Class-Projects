import pa8
import pa10
import your_tester
import math
from copy import deepcopy
import random

def main():
    print("Welcome to the PA #10 Tester")
    while True:
        matrix0 = pa8.Matrix([[1, -3, 0], [-2, 4, 1], [5, -2, 2]])
        matrix1 = pa8.Matrix([[2, -1, -10], [2, 0, -4], [-7, 3, 2]])
        matrix2 = pa8.Matrix([[3, 5, 0], [-1, 2, 1], [3, -6, 4]])
        matrix3 = pa8.Matrix([[0, 2, 3, 1],[2, 4, 7, 3],[1, 1, 2, 2], [3, 1, -2, 5]])
        matrix4 = pa8.Matrix([[1, 0, 5, 2],[-1, 4, 1, 0],[3, 0, 4, 1], [-2, 1, 1, 3]])
        matrices = [matrix0, matrix1, matrix2, matrix3, matrix4]
        rand_val = random.randint(0, 4)
        rand_matrix = matrices[rand_val]

        user_in = input(
            "\n" + "-" * 50 +
            "\nWhat would you like to test?" +
            "\n1.  submatrix(A, i, j)" +
            "\n2.  determinant(A)" +
            "\n3.  Run your own tests"
            "\nQ.  Quit\n\nEnter your selection: "
        )
        if user_in == '1':
            result0 = pa8.Matrix([[1, 0], [5, 2]])
            result1 = pa8.Matrix([[2, -10], [-7, 2]])
            result2 = pa8.Matrix([[3, 0], [3, 4]])
            result3 = pa8.Matrix([[0, 3, 1], [1, 2, 2], [3, -2, 5]])
            result4 = pa8.Matrix([[1, 5, 2], [3, 4, 1], [-2, 1, 3]])
            results = [result0, result1, result2, result3, result4]
            print("Matrix:")
            print(rand_matrix)
            result = pa10.submatrix(rand_matrix, 2, 2)
            print("Submatrix (2, 2):")
            print(result)
            print("Expected Submatrix (2, 2):")
            print(results[rand_val])
            if result == results[rand_val]:
                print("Test1 Passed")
            else:
                print("Test1 Failed")
                
            
            result0 = pa8.Matrix([[-2, 4], [5, -2]])
            result1 = pa8.Matrix([[2, 0], [-7, 3]])
            result2 = pa8.Matrix([[-1, 2], [3, -6]])
            result3 = pa8.Matrix([[2, 4, 3], [1, 1, 2], [3, 1, 5]])
            result4 = pa8.Matrix([[-1, 4, 0], [3, 0, 1], [-2, 1, 3]])
            results = [result0, result1, result2, result3, result4]
            print("Matrix:")
            print(rand_matrix)
            result = pa10.submatrix(rand_matrix, 1, 3)
            print("Submatrix (1, 3):")
            print(result)
            print("Expected Submatrix (1, 3):")
            print(results[rand_val])
            if result == results[rand_val]:
                print("Test2 Passed")
            else:
                print("Test2 Failed")
                
        elif user_in == '2':
            result0 = -17
            result1 = -60
            result2 = 77
            result3 = -20
            result4 = -96
            results = [result0, result1, result2, result3, result4]
            print("Matrix:")
            print(rand_matrix)
            result = pa10.determinant(rand_matrix)
            print("Result Determinant: ")
            print(result)
            print("Expected determinant:")
            print(results[rand_val])
            if result == results[rand_val]:
                print("Test Passed")
            else:
                print("Test Failed")
    
        elif user_in == '3':
            print("\n" + "-" * 50 + "\n\nRunning your own tester...\n\n")
            your_tester.test()
        elif user_in.upper() == 'Q':
            break
        else:
            print("Invalid selection.  Please try again.\n")

main()