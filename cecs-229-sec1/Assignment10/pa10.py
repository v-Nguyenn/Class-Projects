import pa8

def submatrix(A, i, j):
    """Returns the submatrix of A with row i and column j removed, where i and j are 1-based.
    Raises an IndexError if i or j are not within the dimentions of A.
    """
    m, n = A.dim()
    if #TODO: check to see if i and j are within the dimensions of A.
        raise IndexError(
            f"Submatrix omitting row {i} and column {j} can not be created for Matrix with dimension {m}x{n} ")
    rows = []
    #TODO: build and return the submatrix of A with row i and column j removed.

    return pa8.Matrix(rows)


def determinant(A):
    """Returns the determinant of matrix A.
    Raises a ValueError if the matrix is not square.
    """
    m, n = A.dim()
    if #TODO: check to see if matrix A is a square matrix
        raise ValueError(f"Determinant is not defined for Matrix with dimension {m}x{n}.  Matrix must be square.")

    if n == 1:
        return #TODO: return the determinant if n = 1
    elif n == 2:
        return #TODO: calculate and return the determinant if n = 2
    else: 
        #TODO: calculate and return the determinant if n >= 3
        d = 0

        return d

