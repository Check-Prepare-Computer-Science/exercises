/**
 * Moves the robot the specified number of steps and put a coin on each step.
 * If the robot does not have any coins, although there are steps remaining,
 * turn this robot off.
 *
 * @param numberOfSteps the number of steps this robot should take
 */
public void coinMove(int numberOfSteps) {
  while (hasAnyCoins() && numberOfSteps > 0) {
    move();
    putCoin();
    numberOfSteps--;
  }
  if (numberOfSteps > 0) {
    turnOff();
  }
  putALlCoins();
}

/**
 * Places all remaining coins of this robot on the ground.
 */
public void putAllCoins() {
  while (hasAnyCoins()) {
    putCoin();
  }
}