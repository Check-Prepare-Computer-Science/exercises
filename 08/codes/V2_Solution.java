double foo(double[] numbers, double n) {
  LinkedList<Double> list = new LinkedList<>();
  try {
    for (double x : numbers) {
      if (x > 0 && x <= n && x % 2 != 0) {
        list.add(x);
      }
    }
  } catch (NullPointerException e) {
    System.out.println(e.getMessage());
  }
  Collections.sort(list);
  try {
    return list.getLast();
  } catch (NoSuchElementException e) {
    System.out.println(e.getMessage());
  }
  return 0;
}