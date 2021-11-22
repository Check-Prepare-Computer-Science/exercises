double averageOfEvenNumbers(int[] numbers) {
  return Arrays.stream(numbers).filter(x -> x > 0 && x % 2 == 0).average().getAsDouble();
}