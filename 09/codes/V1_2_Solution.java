/**
 * Removes the element at the specified position in this list.
 *
 * @param pos the index of the element
 * @throws IndexOutOfBoundsException if the index is out of range 
 * (smaller than 0 or greater than the length of the list)
 */
public void delete(int pos) {
  // Out of bounds
  if (pos < 0) {
    throw new IndexOutOfBoundsException("Invalid position!");
  } else if (head == null) {
    return;
  }
  // If we delete the first element, we need to point the head of the list to its successor 
  else if (pos == 0) {
    head = head.next;
    return;
  }
  // Search for the index of the element to delete
  int index = 0;
  for (ListItem<T> p = head; p.next != null; p = p.next, index++) {
    // Adjust the pointer of the predecessor to point the successor of this element
    if (index + 1 == pos) {
      p.next = p.next.next;
      return;
    }
  }
  // Index is greater than the length of the list
  throw new IndexOutOfBoundsException("Invalid position!");
}