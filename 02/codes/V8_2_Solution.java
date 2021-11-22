/**
 * Lets a given {@link Robot} move to a given {@link java.awt.Point}.
 * 
 * @param robot the {@link Robot} to move
 * @param point the targeted point
 */
public static void moveToPoint(Robot robot, Point point) {
	// Move the robot to the given coordinate
	while (robot.getX() != point.getX() || robot.getY() != point.getY()) {
		// Move right
		if (robot.getX() < point.getX()) {
			setDirection(robot, RIGHT);
			robot.move();
		}
		// Move left
		else if (robot.getX() > point.getX()) {
			setDirection(robot, LEFT);
			robot.move();
		}
		// Move up
		else if (robot.getY() < point.getY()) {
			setDirection(robot, UP);
			robot.move();
		}
		// Move down
		else {
			setDirection(robot, DOWN);
			robot.move();
		}
	}
}