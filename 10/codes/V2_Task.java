/**
 * Computes the average of even numbers.
 *
 * @param numbers the array to compute the avearage of even numbers
 * @return the average of even numbers
 */
double averageOfEvenNumbers(int[] numbers) {
  int sum = 0, count = 0;
  for (int i = 0; i < numbers.length; i++) {
    // Only count even numbers and positive
    if (numbers[i] > 0 && numbers[i] % 2 == 0) {
      sum += numbers[i];
      count++;
    }
  }
  // int/int = int, one of the operand must be double to get a double as result
  return ((double) sum) / count;
}