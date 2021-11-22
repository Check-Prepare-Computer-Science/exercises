/**
 * Returns the result of the addition of this matrix with another matrix.
 *
 * @param other the matrix to be added with this matrix
 * @return the result of the addition of this matrix with another matrix
 */
public Matrix<T> add(Matrix<T> other) {
  if (columns != other.columns() || rows != other.rows()) {
    return null;
  }
  Matrix<T> result = new Matrix<T>(rows, columns, arithmetic);
  for (int row = 0; row < rows; row++) {
    for (int column = 0; column < columns; column++) {
      data.get(row).set(column, arithmetic.add(data.get(row).get(column),
          other.getCell(row, row)));
    }
  }
  return result;
}

/**
 * Returns the result of the multiplication of this matrix with another matrix.
 *
 * @param other the matrix to be multiplied with this matrix
 * @return the result of the multiplication of this matrix with another matrix
 */
public Matrix<T> mul(Matrix<T> other) {
  if (columns != other.rows()) {
    return null;
  }
  Matrix<T> result = new Matrix<T>(rows, other.columns, arithmetic);
  for (int row = 0; row < rows; row++) {
    for (int column = 0; column < other.columns; column++) {
      T value = arithmetic.zero();
      for (int k = 0; k < columns; k++) {
        value = arithmetic.add(value, arithmetic.mul(getCell(row, k),
            other.getCell(k, column)));
      }
      result.setCell(row, column, value);
    }
  }
  return result;
}