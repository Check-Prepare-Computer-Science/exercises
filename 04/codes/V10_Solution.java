/**
 * Creates an array by removing every third element from the parameter.
 *
 * @param a the array, where every third element should be removed
 * @return the array, where every third element is removed
   */
public int[] foo(int[] a) {
  // Determine length
  int length = (int) (a.length - Math.round(a.length / 3.0));
  int[] b = new int[length];
  
  // Copy elements
  for (int i = 0, j = 0; i < a.length; i++) {
    // Skip every third element
    if (i % 3 == 0) {
      continue;
    } else {
      b[j] = a[i];
      j++;
    }
  }
  return b;
}