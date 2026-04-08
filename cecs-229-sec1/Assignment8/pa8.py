# Author: Vincent Nguyen
# Due: April 7, 2026s
# I filled out the TODO portions of the code.
# Function, doc string, and problem setup is done by professor Shannon Cleary 

import math

class Matrix:
  def __init__(self, rows=[]):
    """Initializes a Matrix with given rows (1 based indexing)
    :param rows: the list of rows for this Matrix object.
    """
    self.rows = rows

  def set_row(self, i, v):
    """Sets the i-th row to be the list v"""
    if len(v) != len(self.rows[0]):  # TODO check if row length is correct 
      raise ValueError("ERROR: Incompatible row length.")
    else:
      self.rows[i - 1] = v # TODO: assign the vector to the row

  def set_col(self, j, u):
    """Sets the j-th column to be the list u."""
    if len(u) != len(self.rows):  # TODO check if column length is correct 
      raise ValueError("ERROR: Incompatible column space.")
    else:
      for i in range(len(self.rows)):
        self.rows[i][j - 1] = u[i] # TODO: assign the vector to the column

  def set_entry(self, i, j, a):
    """Sets the ij-th entry to be a."""
    # TODO: assign the element to the specified location
    self.rows[i - 1][j - 1] = a

  def get_row(self, i):
    """Gets the ith row.
    :return: list of elements in the ith row of the matrix.
    """
    return self.rows[i - 1] # TODO: return the specified row

  def get_col(self, j):
    """Gets the jth column.
    :return: list of elements in the jth column of the matrix.
    """
    col = []
    for row in self.rows:
        col.append(row[j - 1]) # TODO: populate list with correct elements 
    return col 

  def get_element(self, i, j):
    """Gets the ijth element.
    :return: element at location ij in the matrix.
    """
    return self.rows[i - 1][j - 1]# TODO: return the specified element

  def get_columns(self):
    """Gets the list of columns.
    :return: list of columns in the matrix.
    """
    cols = []
    m, n = self.dim()
    for j in range(1, n + 1):
      cols.append(self.get_col(j))  # TODO: populate list with column vectors
    return cols

  def get_rows(self):
    """Gets the list of rows.
    :return: list of rows in the matrix.
    """
    return self.rows # TODO: return the list of row vectors

  def dim(self):
    """Gets the dimensions of the mxn matrix where m = number of rows, n = number of columns.
    :return: integer tuple - the dimensions of the matrix (m, n).
    """
    m = len(self.rows) # TODO: find the number of rows
    n = len(self.rows[0]) if m > 0 else 0 # TODO: find the number of cols
    return (m, n)

  def get_diag(self):
    """Gets the main diagonal. 
    :return: list of elements in the main diagonal of the matrix.
    """
    # TODO: populate the list with the elements in the main diagonal starting from 1,1
    d = []
    m, n = self.dim()
    for k in range(1, min(m, n) + 1):
      d.append(self.get_element(k, k))
    return d 


  def __add__(self, other):
    """Overloads the + operator to support Matrix + Matrix
    :param other: the other Matrix object
    :raises: ValueError if the Matrix objects have mismatching dimensions
    :raises: TypeError if other is not of Matrix type
    :return: Matrix type; the Matrix object resulting from the Matrix + Matrix operation
    """
    if not isinstance(other, Matrix):  # TODO: check other type
      raise TypeError(f"Matrix + {type(other)} is not supported.")

    
    if self.dim() != other.dim():  # TODO: check the matrix dimensions
      raise ValueError("Matrix dimension mismatch. Can not add matrices of different dimensions.")
    
    #  TODO: create a new matrix using matrix addition
    new_rows = []
    m, n = self.dim()
    for i in range(1, m + 1):
      new_row = []
      for j in range(1, n + 1):
        new_row.append(self.get_element(i, j) + other.get_element(i, j))
      new_rows.append(new_row)

    return Matrix(new_rows) # TODO: return the resulting matrix

  def __sub__(self, other):
    """Overloads the - operator to support Matrix - Matrix
    :param other: the other Matrix object
    :raises: ValueError if the Matrix objects have mismatching dimensions
    :raises: TypeError if other is not of Matrix type
    :return: Matrix type; the Matrix object resulting from Matrix - Matrix operation
    """
    if not isinstance(other, Matrix):  # TODO: check other type
      raise TypeError(f"Matrix - {type(other)} is not supported.")
      
    if self.dim() != other.dim(): # TODO: check the matrix dimensions
      raise ValueError("Matrix dimension mismatch. Can not subtract matrices of different dimensions.")
      
    #  TODO: create a new matrix using matrix subtraction
    new_rows = []
    m, n = self.dim()
    for i in range(1, m + 1):
      new_row = []
      for j in range(1, n + 1):
        new_row.append(self.get_element(i, j) - other.get_element(i, j))
      new_rows.append(new_row)
    
    return Matrix(new_rows) # TODO: return the resulting matrix

  def __mul__(self, other):
    """Overloads the * operator to support Matrix * Matrix and Matrix * Scalar
    :param other: the other Matrix object or a Scalar
    :raises: ValueError if the Matrix objects have mismatching dimensions in M * M multiplication.
    :raises: TypeError if other is not of Matrix type
    :return: Matrix type; the Matrix object resulting from Matrix * Matrix or Matrix * Scalar operation
    """
    if isinstance(other, (int, float)): # TODO: check if other is a scalar
      new_rows = [] #  TODO: create a new matrix using scalar multiplication 
      m, n = self.dim()
      for i in range(1, m + 1):
        new_row = []
        for j in range(1, n + 1):
          new_row.append(self.get_element(i, j) * other)
        new_rows.append(new_row)
      return Matrix(new_rows) # TODO: return the resulting matrix
    
    elif isinstance(other, Matrix): # TODO: check if other is a matrix
      if self.dim()[1] == other.dim()[0]: # TODO: check the matrix dimensions
        #  TODO: create a new matrix using matrix multiplication
        new_rows = []
        m, n = self.dim()
        p = other.dim()[1]

        for i in range(1, m + 1):
          new_row = []
          for j in range(1, p + 1):
            total = 0
            for k in range(1, n + 1):
              total += self.get_element(i, k) * other.get_element(k, j)
            new_row.append(total)
          new_rows.append(new_row)

        return Matrix(new_rows) # TODO: return the resulting matrix
      else:
        raise ValueError("Incompatible dimensions")
    else:
      raise TypeError(f"Matrix * {type(other)} is not supported")

  def __rmul__(self, other):
    """Overloads the * operator to support Scalar * Matrix
    :param other: the Scalar value
    :raises: TypeError if other is not a scalar 
    :return: Matrix type; the Matrix object resulting from Scalar * Matrix operation
    """
    if isinstance(other, (int, float)): # TODO: check if other is a scalar
      #  TODO: create a new matrix using scalar multiplication 
      return self * other # TODO: return the resulting matrix
    else:
      raise TypeError(f" {type(other)} * Matrix is not supported")
    return

  def __eq__(self, other):
    """Overloads the == operator to return True if
    two Matrix objects have the same elements in the same orientation
    """
    if not isinstance(other, Matrix): # TODO: check if other is not a matrix
      return False
    return self.dim() == other.dim() and self.rows == other.rows # TODO: return true if the matrices are the same
    
  def __str__(self):
    """String representation of a Matrix."""
    mat_str = ""
    for row in self.rows:
      mat_str += str(row) + "\n"
    return mat_str

