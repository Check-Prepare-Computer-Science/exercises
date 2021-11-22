/**
 * Replaces the element at the given index with the specified element.
 *
 * @param e element to be stored at the specified position
 * @param i index of the element to replace
 * @throws IndexOutOfBoundsException if the index is out of range (smaller than 0 or greater than
 * the array)
 */
void set(T e,int i){
    ArrayListItem<T> p=head;
    // Index starts at 0, but p.n by 1, if there are elements in the array
    int pos=i+1;
    // Find the correct array
    while(p!=null&&pos>p.n){
    pos-=p.n;
    p=p.next;
    }
    pos--;
    // Check for valid index
    if(p==null||pos< 0||p.a[pos]==null){
    throw new IndexOutOfBoundsException(i);
    }
    p.a[pos]=e;
}