/**
 * Adds the specified element to the end of this list.
 *
 * @param key the element to be added to this list
 */
public void add(T key) {
  ListItem<T> item = new ListItem<>();
  item.key = key;
  // List is empty, so the new list item object is the new head
  if (head == null) {
    head = item;
  } else {
    ListItem<T> p = head;
    // Last element is p and its successor is null
    while (p.next != null) {
      p = p.next;
    }
    p.next = item;
  }
}