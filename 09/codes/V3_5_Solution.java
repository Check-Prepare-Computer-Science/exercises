/**
 * Compresses the array.
 */
void compress() {
  ArrayListItem<T> compressed = head;
  int i = 0;
  for (ArrayListItem<T> p = head; p != null; p = p.next) {
    int j = 0;
    for (T element : p.a) {
      // Skip element, if it is null
      if (element == null) {
        j++;
        continue;
      }
      // If the array is full, reset
      if (i == compressed.a.length) {
        compressed.n = i;
        compressed = compressed.next;
        i = 0;
      }
      // Compress
      final T e = p.a[j];
      p.a[j] = null;
      compressed.a[i] = e;
      i++;
      j++;
    }
  }
  // Adjust the last array list item
  compressed.n = i;
  compressed.next = null;
}