/**
 * Removes all elements with square number indices of this list.
 */
public void deleteSquareNumbers() {
  // Index 0 and 1 are square numbers
  if (head == null || head.next == null) {
    return;
  }
  ListItem<T> p = head.next;
  int position = 2;
  int base = 2;
  while (p.next != null) {
    // Removing all other elements with square numbers
    if (position == base * base) {
      p.next = p.next.next;
      base++;
    } else {
      p = p.next;
    }
    position++;
  }
  // Index 0 and 1 are square numbers
  head = head.next.next;
}