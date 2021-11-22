// Suppose the variable for the robot is called bot

// Move to x-coordinate
if (startX != destinationX) {
	// Adjust the direction of the robot so that it looks left
	if (startX - destinationX > 0) {
		while (!bot.isFacingLeft()) {
			bot.turnLeft();
		}
	} else {
		// Adjust the direction of the robot so that it looks right
		while (!bot.isFacingRight()) {
			bot.turnLeft();
		}
	}
	while (bot.getX() != destinationX)
		bot.move();
}
// Move to y-coordinate
if (startY != destinationY) {
	// Adjust direction of the robot so that it looks down
	if (startY - destinationY > 0) {
		while (!bot.isFacingDown()) {
			bot.turnLeft();
		}
	} else {
		// Adjust direction of the robot so that it looks up
		while (!bot.isFacingUp()) {
			bot.turnLeft();
		}
	}
	while (bot.getY() != destinationY) {
		bot.move();
	}
}