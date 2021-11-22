/**
 * Shifts all element of this list on position to the left.
 */
public void ringShiftLeft() {
  // Cannot shift an empty list
  if (head == null) {
    return;
  }
   /*
    * The new pointer of the successor of the first element should be
    * the successor of the last element.
    * The new pointer of the successor of the last element should be
    * pointing first element.
    * The second element of the list is now the first element in the new list
    */
  ListItem<T> begin = head;
  ListItem<T> next = head.next;
  ListItem<T> end = head;
  while (end.next != null) {
    end = end.next;
  }
  begin.next = end.next;
  end.next = begin;
  head = next;
}