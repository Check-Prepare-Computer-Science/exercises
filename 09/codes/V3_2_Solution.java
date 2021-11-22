/**
 * Returns the element at the given index.
 *
 * @param index the index of the element
 * @return the element at the given index
 * @throws IndexOutOfBoundsException if the index is out of range (smaller than 0 or greater than
 * the array)
 */
T get(int index) {
  ArrayListItem<T> p = head;
  // Index starts at 0, but p.n by 1, if there are elements in the array
  int pos = index + 1;
  // Find the correct array
  while (p != null && pos > p.n) {
    pos -= p.n;
    p = p.next;
  }
  pos--;
  // Check for valid index
  if (p == null || pos < 0) {
    throw new IndexOutOfBoundsException(index);
  }
  return p.a[pos];
}
