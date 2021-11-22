/**
 * Switches the elements at the given indices.
 *
 * @param a the array containing the elements
 * @param i the index of the first element 
 * @param j the index of the second element 
 * @throws IllegalArgumentException if the given array is null or one of indices are out of
 * bounds
 */
void switchElements(T[] a, int i, int j) throws IllegalArgumentException {
  if (a == null) {
    throw new IllegalArgumentException();
  }
  int length = a.length;
  if (i < 0 || j < 0 || i >= length || j >= length) {
    throw new IllegalArgumentException();
  }
  
  // Swap
  T tmp = a[i];
  a[i] = a[j];
  a[j] = tmp;
}