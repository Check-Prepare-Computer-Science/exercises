/**
 * Constructs a nxm (rows x columns) matrix.
 *
 * @param rows       the number of rows of the matrix
 * @param columns    the number of columns of the matrix
 * @param arithmetic allows arithmetic operations on the elements in the
 * matrix
 */
public Matrix(int rows, int columns, Arithmetic<T> arithmetic) {
  this.arithmetic = arithmetic;
  this.rows = rows;
  this.columns = columns;
  data = new LinkedList<LinkedList<T>>();
  // Fill matrix with zero
  T zero = arithmetic.zero();
  // Initialize rows by creating a new LinkedList of T
  for (int i = 0; i < rows; i++) {
    data.add(new LinkedList<T>());
    // Initialize each column in the current row with zero
    for (int j = 0; j < columns; j++) {
      data.get(i).add(zero);
    }
  }
}

/**
 * Returns the number of rows of this matrix.
 *
 * @return the number of rows of this matrix
 */
public int getRows() {
  return rows;
}

/**
 * Returns the number of columns of this matrix.
 *
 * @return the number of columns of this matrix
 */
public int getColumns() {
  return columns;
}

/**
 * Returns the element at the specified row and column.
 *
 * @param row    the row of the element to be returned
 * @param column the column of the element to be returned
 * @return the element at the specified row and column
 */
public T getCell(int row, int column) {
  return data.get(row).get(column);
}

/**
 * Puts the value at the specified row and column.
 *
 * @param row    the row of the element to be set
 * @param column the column of the element to be set
 * @param value  the new value of the cell
 */
public void setCell(int row, int column, T value) {
  data.get(row).set(column, value);
}