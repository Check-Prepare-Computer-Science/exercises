/**
 * Returns the key of the third last element of this list, if there is one.
 *
 * @return the key of the third last element of this list, if there is one
 */
public T beforeBeforeLast() {
  ListItem<T> p = head;
  // List must have at least 3 elements, else we return null
  if (p == null || p.next == null || p.next.next == null) {
    return null;
  }
  // Search for the third last element
  while (p.next.next.next != null) {
    p = p.next;
  }
  return p.key;
}