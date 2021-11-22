/**
 * Removes the element at the given index.
 *
 * @param i the index of the element to be removed
 * @throws IndexOutOfBoundsException if the index is out of range (smaller than 0 or greater than
 * the array)
 */
void remove(int i) {
  ArrayListItem<T> p = head;
  // Predecessor
  ArrayListItem<T> px = null;
  // Index start by 0, but p.n by 1, if there are elements in the array
  int pos = i + 1;
  // Find correct array
  while (p != null && pos > p.n) {
    pos -= p.n;
    px = p;
    p = p.next;
  }
  pos--;
  // Check for valid index
  if (p == null || pos < 0) {
    throw new IndexOutOfBoundsException(i);
  }
  // Shift elements to the left
  p.n--;
  for (int j = pos; j < p.n; j++) {
    p.a[j] = p.a[j + 1];
  }
  p.a[p.n] = null;
  // If the array is empty
  if (p.n == 0) {
    if (px == null) {
      head = head.next;
    } else {
      px.next = null;
    }
  }
}