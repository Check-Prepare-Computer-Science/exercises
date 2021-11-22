int width = 3;
int height = 5;

// Number of total coins to place - 4 for edges (put coins only once on every edge)
int coins = 2 * width + 2 * height - 4;

Robot putbot = new Robot(0, 0, Direction.RIGHT, coins);
Robot pickbot = new Robot(0, 0, Direction.RIGHT, 0);

// Marker to change directions
boolean swap = false;
int i = 1;

// Put coins until we placed all of them
while (putbot.hasAnyCoins()) {
	putbot.putCoin();

	// If we reached a corner, we change the direction of the bot
	if (!swap && i == width || swap && i == height) {
		swap = !swap;
		i = 1;
		putbot.turnLeft();
	}

	putbot.move();
	i++;
}

// Reset variables
swap = false;
i = 1;
// Counter for coins
int counter = 0;

// Pick up coins until we picked up all (we can have a variable amount of coins) of them
while (counter < coins) {
	pickbot.pickCoin();
	counter++;

	// If we reached a corner, we change the direction of the bot
	if (!swap && i == width || swap && i == height) {
		swap = !swap;
		i = 1;
		pickbot.turnLeft();
	}

	pickbot.move();
	i++;
}