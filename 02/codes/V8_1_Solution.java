/**
 * Lets the given {@link Robot} look in a desired {@link Direction}.
 * 
 * @param robot     the robot to turn
 * @param direction the desired direction
 */
public static void setDirection(Robot robot, Direction direction) {
	while (robot.getDirection() != direction) {
		robot.turnLeft();
	}
}