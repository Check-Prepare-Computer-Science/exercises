/**
 * Computes the total area of all the specified geometry shapes.
 *
 * @param circles    an array of circles to add to the total area
 * @param rectangles an array of rectangles to add to the total area
 * @return the total area of the specified geometry shapes
 */
double computeTotalArea(Circle[] circles, Rectangle[] rectangles) {
  double sum = 0;
	
  for (Circle circle : circles) { sum += circle.computeArea(); }
  for (Rectangle rectangle : rectangles) { sum += rectangle.computeArea(); }
  return sum;
}