/**
 * Checks, whether two robots are equal. The two robots are equal, if they have the same
 * coordinates, the same direction and an equal amount of coins.
 *
 * @param a the first robot
 * @param b the second robot
 * @return {@code true} only if the robots a and b are equal
 */
int robotEqual(Robot a, Robot b) {
  // Check if the coordinates match
  if (a.getX() == b.getX() && a.getY() == b.getY()) {
    // Check if the directions and amount of coins match
    if (a.getDirection() == b.getDirection() &&
        a.getNumberOfCoins() == b.getNumberOfCoins()) {
      return 2;
    } else {
      return 1;
    }
  }
  return 0;
}