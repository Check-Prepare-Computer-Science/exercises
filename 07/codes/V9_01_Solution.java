 /**
 * Steps through the array and picks one element from the input data. Compares this element
 * to its adjacent element and moves through all element of the sorted array
 * until the picked element is at its correct position.
 *
 * @param array          the unsorted array which should be sorted
 * @param startInclusive the minimum (inclusive) index of the array 
 * @param endInclusive   the maximum (inclusive) index of the array 
 */
private void insertionSort(int[] array, int startInclusive, int endInclusive) {
  for (int j = startInclusive + 1; j <= endInclusive; j++) {
    int key = array[j];
    int i = j - 1;

    while (i >= startInclusive && array[i] > key) {
    array[i + 1] = array[i];
      i--;
    }
    array[i + 1] = key;
  }
}

/**
 * Returns an array, in which all elements are sorted that are not in the
 * specified interval
 *
 * @param a     the array, in which all elements should be sorted that are not in the
 *              specified interval
 * @param lower the lower value of the interval
 * @param upper the upper value of the interval 
 * @return an array, in which all elements are sorted that are not in the
 * specified interval
 * @throws LowerBiggerThanUpperException, if lower is not smaller than upper
 */
public int[] betweenNumbers(int[] a, int lower, int upper)
	throws LowerBiggerThanUpperException {
  if (lower > upper) {
    throw new LowerBiggerThanUpperException();
  }

  int[] sorted = new int[a.length];
  int size = 0;
  int i = 0;

  for (; i < a.length; i++) {
    // Copy in new array
    sorted[i] = a[i];
    // Compute interval
    if (a[i] <= lower || a[i] >= upper) {
      size++;
    }
    // Sort
    else if (size > 1) {
      insertionSort(sorted, i - size, i - 1);
      size = 0;
    }
  }
  // Sort
  if (size > 1) {
    insertionSort(sorted, i - size, i - 1);
  }
  return sorted;
}