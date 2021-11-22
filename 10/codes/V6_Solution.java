/**
 * Returns a list of the bakeries sorted by total price within the specified distance.
 *
 * @param bakeries    the collection of bakeries which should be filtered
 * @param maxDistance tbe maximum distance of a bakery to be considered
 * @return a list of the bakeries sorted by total price within the specified distance
 */
List<BakeryOffer> sortedBakeryOffers(Collection<Bakery> bakeries,
    double maxDistance) {
  return bakeries.stream().filter(bakery -> bakery.distance <= maxDistance)
      .map(b -> new BakeryOffer(b, b.price))
      .sorted(Comparator.comparingDouble(o -> o.totalPrice)).collect(Collectors.toList());
}