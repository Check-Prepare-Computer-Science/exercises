/**
 * Removes the first occurrence of the specified element from this list, if there is one.
 *
 * @param key the element to be removed from this list, if there is one
 */
public void delete(T key) {
  // Cannot delete an element if the list is empty
  if (head == null) {
    return;
  }
  // If we delete the first element, the head of the list must point to its successor
  else if (head.key.equals(key)) {
    head = head.next;
  }
  // Search the element to delete
  for (ListItem<T> p = head; p.next != null; p = p.next) {
    // Adjust pointer of the predecessor to point to the successor of this element
    if (p.next.key.equals(key)) {
      p.next = p.next.next;
      // We are finished after we delete the element
      break;
    }
  }
}