# Author: Vincent Nguyen

def pivot_index(i, j, A):
  """Finds the pivot position of Matrix A at or after location (i, j).
  Returns a tuple (row, col) using 1-based indexing.
  If no pivot exists, returns None.
  """
  m, n = A.dim()
  
  # TODO: Iterate through columns starting at j, then rows starting at i
  # For earch column starting at j
  for col in range(j, n + 1):
    # For each row starting at i 
    for row in range(i, m + 1):
      # If we find a nonzero entry, thats a pivot
      if A.get_element(row, col) != 0:
        return (row, col)
  # returns nonce since a pivot is not found.
  return None
  
  
def ref(matrixA):
  """ Returns the Row Echelon Form of matrix A as a new Matrix.
  Does not modify the original matrix.
  """
  RowEF = matrixA.copy()
  m, n = RowEF.dim()

  # Loop through columns while placing pivots in successive rows
  pivot_row = 1
  for col in range(1, n + 1):
    if pivot_row > m:
      break

    # Find the first pivot at or below the current pivot_row in this column or later.
    loc = pivot_index(pivot_row, col, RowEF)
    if loc is None:
      break

    row, pivot_col = loc

    # If pivot is in a later column, skip current column and continue
    if pivot_col != col:
      continue

    # Move pivot row into position
    if row != pivot_row:
      RowEF.swap_rows(pivot_row, row)

    # Scale pivot row so pivot entry becomes 1
    pivot_val = RowEF.get_element(pivot_row, col)
    if pivot_val != 1:
      RowEF.scale_row(pivot_row, 1 / pivot_val)

    # Eliminate entries below the pivot
    for r in range(pivot_row + 1, m + 1):
      entry = RowEF.get_element(r, col)
      if entry != 0:
        RowEF.add_row_multiple(pivot_row, r, -entry)

    pivot_row += 1

  return RowEF