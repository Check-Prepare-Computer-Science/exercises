/**
 * Returns a list of single element lists.
 *
 * @return a list of single element lists
 */
public MyLinkedList<MyLinkedList<T>> listInLists() {
  MyLinkedList<MyLinkedList<T>> result = new MyLinkedList<>();
  // Build the new list
  ListItem<MyLinkedList<T>> head = null;
  // References the last element of the list
  ListItem<MyLinkedList<T>> tail = head;
  for (ListItem<T> p = this.head; p != null; p = p.next) {
    ListItem<T> item = new ListItem<>();
    item.key = p.key;

    MyLinkedList<T> list = new MyLinkedList<>();
    list.head = item;

    ListItem<MyLinkedList<T>> itemList = new ListItem<>();
    itemList.key = list;

    // If head is empty, then the new created list item object is the new head
    if (head == null) {
      head = tail = itemList;
    }
    // Add elements to the last one
    else {
      tail.next = itemList;
      tail = tail.next;
    }
  }
  result.head = head;
  return result;
}