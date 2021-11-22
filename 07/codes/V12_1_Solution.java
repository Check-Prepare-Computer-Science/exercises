public class X {

  public int a[];
  public boolean writable[];

  public X(int n) {
    a = new int[n];
    writable = new boolean[n];
    for (int i = 0; i < writable.length; i++) {
      writable[i] = true;
    }
  }

  public void save(int n) throws ArrayStoreException {
    for (int i = 0; i < writable.length; i++) {
      // Only if true, do the following operation
      if (writable[i]) { // equal to writable[i] == true
        writable[i] = false;
        a[i] = n;
        return;
      }
    }
    throw new ArrayStoreException("no free space left");
  }
}