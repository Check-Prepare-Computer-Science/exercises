/**
 * Computes the total area of the specified geometry shapes.
 *
 * @param circles    an array of circles to add to the total area
 * @param rectangles an array of rectangles to add to the total area
 * @return the total area of the specified geometry shapes
 */
double computeTotalArea(Circle[] circles, Rectangle[] rectangles) {
  double sum = 0;
  for (int i = 0; i < circles.length; i++) {
    // or sum = sum + circles[i].computeArea();
    sum += circles[i].computeArea();
  }
  for (int i = 0; i < rectangles.length; i++) {
    // or sum = sum + rectangles[i].computeArea();
    sum += rectangles[i].computeArea();
  }
  return sum;
}