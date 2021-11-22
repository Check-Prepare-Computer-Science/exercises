/**
 * Returns the index of the element, if this array list contains it.
 *
 * @param element the element we want to find in the array list
 * @return index the index of the first equal element to the given element
 * or -1, if it the element is not in the array list
 */
int contains(T element) {
  int index = 0;
  // Find correct array
  for (ArrayListItem<T> p = head; p != null; p = p.next) {
    // Check elements of the array
    for (int i = 0; i < p.n; i++) {
      if (p.a[i].equals(element)) {
        index += i;
        return index;
      }
    }
    // Go to the next array
    index += p.n;
  }
  return -1;
}