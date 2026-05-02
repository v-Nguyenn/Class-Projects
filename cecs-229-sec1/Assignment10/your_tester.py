import pa8
import pa10

def test():
    print("Testing Problem 1...")
    # Write your test cases for Problem 1 here
    A = pa8.Matrix([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
    result = pa10.submatrix(A, 2, 2)
    expected = pa8.Matrix([[1, 3], [7, 9]])
    print("submatrix removes row 2, col 2:", "PASS" if result == expected else "FAIL")



    print("Testing Problem 2...")
    # Write your test cases for Problem 2 here
    A = pa8.Matrix([[1, 2], [3, 4]])
    result = pa10.determinant(A)
    expected = -2
    print("determinant 2x2:", "PASS" if result == expected else "FAIL")

    print("Testing Problem 3...")
    A = pa8.Matrix([[1, -3, 0], [-2, 4, 1], [5, -2, 2]])
    result = pa10.determinant(A)
    expected = -17
    print("determinant 3x3:", "PASS" if result == expected else "FAIL")
