/**
 * Prints a random dice number between 1 and 6 (inclusive).
 */
void diceRoll() {
  // Min + (int) (Math.random() * ((Max - Min) + 1)) = [Min, Max]
  int number = 1 + (int) (Math.random() * ((6 - 1) + 1));
  System.out.println(number);
}