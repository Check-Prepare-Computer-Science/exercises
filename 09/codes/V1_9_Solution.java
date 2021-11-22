/**
 * Returns a single list by converting the specified list of lists.
 *
 * @param lsts the list of lists
 * @return a single list by converting the specified list of lists
 * @see MyLinkedList#add(Object)
 */
public MyLinkedList<T> listsInList(MyLinkedList<MyLinkedList<T>> lsts) {
  MyLinkedList<T> list = new MyLinkedList<>();
  // Build a new list
  ListItem<T> head = null;
  // References the last element of the list, faster performance
  ListItem<T> tail = head;
  // Iterate over all MyLinkedList
  for (ListItem<MyLinkedList<T>> l = lsts.head; l != null; l = l.next) {
    // Iterate over ListItem
    for (ListItem<T> p = l.key.head; p != null; p = p.next) {
      ListItem<T> item = new ListItem<>();
      item.key = p.key;
      // If head is empty, then the new created list item object is the new head
      if (head == null) {
        head = tail = item;
      }
      // Add elements to the last one
      else {
        tail.next = item;
        tail = tail.next;
      }
    }
  }
  list.head = head;
  return list;
}