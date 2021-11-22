/**
 * Multiplies two matrices by doing matrix multiplication.
 *
 * @param mat1 the first matrix 
 * @param mat2 the second matrix
 * @return the first matrix multiplied with the second matrix
 */
int[][] matrixMul(int[][] mat1, int[][] mat2) {
  int rowsMat1 = mat1.length;
  int colsMat1 = mat1[0].length;
  int rowsMat2 = mat2.length;
  int colsMat2 = mat2[0].length;
  // Resulting matrix
  int[][] mat3 = new int[rowsMat1][colsMat2];
  // Check, if the dimension is correct
  if (colsMat1 != rowsMat2) {
    // Error output print on console
    System.err.println("Wrong Dimensions");
    return null;
  }
  // Matrix multiplication
  for (int i = 0; i < rowsMat1; i++) {
    for (int j = 0; j < colsMat1; j++) {
      for (int k = 0; k < colsMat2; k++) {
        mat3[i][k] += mat1[i][j] * mat2[j][k];
      }
    }
  }
  return mat3;
}