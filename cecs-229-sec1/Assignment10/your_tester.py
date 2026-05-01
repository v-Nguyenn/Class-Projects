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
    