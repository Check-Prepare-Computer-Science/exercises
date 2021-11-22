/**
 * Lays a {@link Coin} on every given {@link java.awt.Point} and then goes to the center
 * of the {@link World}.
 * 
 * @param robot  the {@link Robot} protagonist
 * @param points an array of points containing the coordinates of the pattern
 */
public static void putCoins(Robot robot, Point[] points) {
	for (Point point : points) {
		moveToPoint(robot, point);
		robot.putCoin();
	}
	goToPoint(r, new Point(5, 2));
	setDirection(r, UP);
}