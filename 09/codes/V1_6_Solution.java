/**
 * Converts a list to an array.
 *
 * @param type the class type of the new array
 * @return an array by converting a list
 * @see Array#newInstance(Class, int)
 */
@SuppressWarnings("unchecked")
public T[] listIntoArray(Class<?> type) {
  int size = 0;
  for (MyLinkedList<T> p = head; p != null; p = p.next) {
    size++;
  }
  T[] result = (T[]) Array.newInstance(type, size);
  int i = 0;
  for (ListItem<T> p = head; p != null; p = p.next, i++) {
    result[i] = p.key;
  }
  return result;
}