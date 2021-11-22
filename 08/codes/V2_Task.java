double foo(double[] numbers, double n) {
  LinkedList<Double> list = new LinkedList<>();
  for (double x : numbers) {
    if (x > 0 && x <= n && x % 2 != 0) {
      list.add(x);
    }
  }
  Collections.sort(list);
  return list.getLast();
}