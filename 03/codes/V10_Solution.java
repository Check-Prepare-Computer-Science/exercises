/**
 * A team robot class that contains multiple robots that form a team. All robots in the team
 * will execute the same operations.
 */
class TeamRobot extends Robot {

  /**
   * The robots to form a team.
   */
  private Robot[] partners;

  /**
   * Constructs a team robot at the specified position, with the specified direction and amount of coins.
   *
   * @param x             the x-coordinate of the center robot
   * @param y             the y-coordinate of the center robot
   * @param direction     the direction of the robots
   * @param numberOfCoins the amount of coins of the robots
   * @param left          the amount of robots to the left of the center robot
   * @param right         the amount of robots to the right of the center robot
   */
  public TeamRobot(int x, int y, Direction direction, int numberOfCoins, int left,
      int right) {
    super(x, y, direction, numberOfCoins);
    partners = new Robot[left + right];
    for (int i = 0; i < left; i++) {
      partners[i] = new Robot(x - i - 1, y, direction, numberOfCoins);
    }
    for (int i = 0; i < right; i++) {
      partners[i + left] = new Robot(x + i + 1, y, direction, numberOfCoins);
    }
  }

  @Override
  public void move() {
    super.move();
    for (Robot r : partners) {
      r.move();
    }
  }

  @Override
  public void turnLeft() {
    super.turnLeft();
    for (Robot r : partners) {
      r.turnLeft();
    }
  }

  @Override
  public void putCoin() {
    super.putCoin();
    for (Robot r : partners) {
      r.putCoin();
    }
  }

  @Override
  public void pickCoin() {
    super.pickCoin();
    for (Robot r : partners) {
      r.pickCoin();
    }
  }
}