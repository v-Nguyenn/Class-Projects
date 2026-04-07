import math

class Matrix:
  def __init__(self, rows=[]):
    """Initializes a Matrix with given rows (1 based indexing)
    :param rows: the list of rows for this Matrix object.
    """
    self.rows = rows

  def set_row(self, i, v):
    """Sets the i-th row to be the list v"""
    if :  # TODO check if row length is correct 
      raise ValueError("ERROR: Incompatible row length.")
    else:
      # TODO: assign the vector to the row

  def set_col(self, j, u):
    """Sets the j-th column to be the list u."""
    if :  # TODO check if column length is correct 
      raise ValueError("ERROR: Incompatible column space.")
    else:
      # TODO: assign the vector to the column

  def set_entry(self, i, j, a):
    """Sets the ij-th entry to be a."""
    # TODO: assign the element to the specified location

  def get_row(self, i):
    """Gets the ith row.
    :return: list of elements in the ith row of the matrix.
    """
    return # TODO: return the specified row

  def get_col(self, j):
    """Gets the jth column.
    :return: list of elements in the jth column of the matrix.
    """
    col = []
        # TODO: populate list with correct elements 
    return col 

  def get_element(self, i, j):
    """Gets the ijth element.
    :return: element at location ij in the matrix.
    """
    return # TODO: return the specified element

  def get_columns(self):
    """Gets the list of columns.
    :return: list of columns in the matrix.
    """
    cols = []
        # TODO: populate list with column vectors
    return cols

  def get_rows(self):
    """Gets the list of rows.
    :return: list of rows in the matrix.
    """
    return # TODO: return the list of row vectors

  def dim(self):
    """Gets the dimensions of the mxn matrix where m = number of rows, n = number of columns.
    :return: integer tuple - the dimensions of the matrix (m, n).
    """
    m = # TODO: find the number of rows
    n = # TODO: find the number of cols
    return (m, n)

  def get_diag(self):
    """Gets the main diagonal. 
    :return: list of elements in the main diagonal of the matrix.
    """
    d = []
    
    # TODO: populate the list with the elements in the main diagonal starting from 1,1
    
    return d


  def __add__(self, other):
    """Overloads the + operator to support Matrix + Matrix
    :param other: the other Matrix object
    :raises: ValueError if the Matrix objects have mismatching dimensions
    :raises: TypeError if other is not of Matrix type
    :return: Matrix type; the Matrix object resulting from the Matrix + Matrix operation
    """
    if :  # TODO: check other type
      raise TypeError(f"Matrix + {type(other)} is not supported.")

    
    if :  # TODO: check the matrix dimensions
      raise ValueError("Matrix dimension mismatch. Can not add matrices of different dimensions.")
    
    #  TODO: create a new matrix using matrix addition
    
    return # TODO: return the resulting matrix

  def __sub__(self, other):
    """Overloads the - operator to support Matrix - Matrix
    :param other: the other Matrix object
    :raises: ValueError if the Matrix objects have mismatching dimensions
    :raises: TypeError if other is not of Matrix type
    :return: Matrix type; the Matrix object resulting from Matrix - Matrix operation
    """
    if :  # TODO: check other type
      raise TypeError(f"Matrix - {type(other)} is not supported.")
      
    if : # TODO: check the matrix dimensions
      raise ValueError("Matrix dimension mismatch. Can not subtract matrices of different dimensions.")
      
    #  TODO: create a new matrix using matrix subtraction
    
    return  # TODO: return the resulting matrix

  def __mul__(self, other):
    """Overloads the * operator to support Matrix * Matrix and Matrix * Scalar
    :param other: the other Matrix object or a Scalar
    :raises: ValueError if the Matrix objects have mismatching dimensions in M * M multiplication.
    :raises: TypeError if other is not of Matrix type
    :return: Matrix type; the Matrix object resulting from Matrix * Matrix or Matrix * Scalar operation
    """
    if  :# TODO: check if other is a scalar
      #  TODO: create a new matrix using scalar multiplication 
      return # TODO: return the resulting matrix
    elif : # TODO: check if other is a matrix
      if :# TODO: check the matrix dimensions
        #  TODO: create a new matrix using matrix multiplication
        return # TODO: return the resulting matrix
      else:
        raise ValueError("Incompatible dimensions")
    else:
      raise TypeError(f"Matrix * {type(other)} is not supported")
    return

  def __rmul__(self, other):
    """Overloads the * operator to support Scalar * Matrix
    :param other: the Scalar value
    :raises: TypeError if other is not a scalar 
    :return: Matrix type; the Matrix object resulting from Scalar * Matrix operation
    """
    if : # TODO: check if other is a scalar
      #  TODO: create a new matrix using scalar multiplication 
      return # TODO: return the resulting matrix
    else:
      raise TypeError(f" {type(other)} * Matrix is not supported")
    return

  def __eq__(self, other):
    """Overloads the == operator to return True if
    two Matrix objects have the same elements in the same orientation
    """
    if :# TODO: check if other is not a matrix
      return False
    return # TODO: return true if the matrices are the same
    
  def __str__(self):
    """String representation of a Matrix."""
    mat_str = ""
    for row in self.rows:
      mat_str += str(row) + "\n"
    return mat_str

