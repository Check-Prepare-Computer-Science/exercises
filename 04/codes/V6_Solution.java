/**
 * Creates an integer by appending the elements of the array after each other
 *
 * @param a the array to form a single integer
 * @return the appended integers
 */
static int appendIntegers(int[] a) {
  // If array is empty
  if (a.length == 0) {
    return 0;
  }
  // Starting value
  int result = a[0];
  // Appends each integer to the previous one
  for (int i = 1; i < a.length; i++) {
    result = append(result, a[i]);
  }
  return result;
}

/**
 * Creates an integer by appending the value y to the value x
 *
 * @param x the source value to be appended by another value
 * @param y the value that should be appended to the other value
 * @return the appended integer
 */
static int append(int x, int y) {
  // Offset
  int d = 10;
  // Determine shifting
  while (y / d != 0) {
    d *= 10;
  }
  return x * d + y;
}
