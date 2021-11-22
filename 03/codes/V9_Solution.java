/**
 * A direction turner robot that can turn to all available
 * {@link Direction}.
 */
public class DirectionTurner extends Robot {

  /**
   * Constructs a direction turner robot at the specified position 
   * and direction. The robot contains
   * the specified amount of coins.
   *
   * @param x             the x-coordinate of the robot
   * @param y             the y-coordinate of the robot
   * @param direction     the direction of the robot
   * @param numberOfCoins the number of coins the robot have
   */
  public DirectionTurner(int x, int y, Direction direction, int numberOfCoins) {
    super(x, y, direction, numberOfCoins);
  }

  /**
   * Turns this robot to {@link Direction#UP}.
   */
  public void turnUp() {
    while (!isFacingUp()) { turnLeft(); }
  }

  /**
   * Turns this robot to {@link Direction#DOWN}.
   */
  public void turnDown() {
    while (!isFacingDown()) { turnLeft(); }
  }

  /**
   * Turns this robot to {@link Direction#LEFT}.
   */
  public void turnLeft() {
    while (!isFacingLeft()) { turnLeft(); }
  }

  /**
   * Turns this robot to {@link Direction#RIGHT}.
   */
  public void turnRight() {
    while (!isFacingRight()) { turnLeft(); }
  }
}