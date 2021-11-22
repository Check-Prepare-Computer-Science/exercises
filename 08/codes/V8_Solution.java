/**
 * Transforms the list into a map.
 *
 * @param input the list to be transformed
 * @param <X> the type of the key
 * @param <Y> the type of first element in the pair
 * @param <Z> the type of the second element in the pair
 * @return the transformed list as a map
 */
public static <X, Y, Z> Map<X, Pair<Y, Z>> intoMap(List<Triple<X, Y, Z>> input) {
  Map<X, Pair<Y, Z>> result = new HashMap<>();
  for (Triple<X, Y, Z> i : input) {
    result.put(i.x, new Pair<Y, Z>(i.y, i.z));
  }
  return result;
}