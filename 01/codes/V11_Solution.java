// Create a robot at position (0,0), looks to the right and has 99999
// coins
Robot robot = new Robot(0, 0, RIGHT, 99999);
// Move the robot to the end of the world and store the counter in a variable
int counter = 0;
while (robot.getX() < World.getWidth() - 1) {
	robot.move();
	counter = counter + 1;
}

// Turn the robot to the left (Direction.UP)
robot.turnLeft();

// The robot moves in the y-Direction and places a coin at every even
// position. The robot does this until the y-coordinate is greater than or equal
// to the size of the width of the world
for (int i = 0; i < counter; i++) {
	if (i % 2 == 0 && robot.hasAnyCoins()) {
		robot.putCoin();
	}
	robot.move();
}

// Turn the robot to the left (Direction.LEFT)
robot.turnLeft();
// Move the robot until it hits a wall
while (robot.isFrontClear()) {
	robot.move();
}

// Turn the robot to the left (Direction.DOWN)
robot.turnLeft();
// Move back to the starting point
while (robot.getX() != 0 || robot.getY() != 0) {
	robot.move();
}

// Turn the robot off
robot.turnOff();