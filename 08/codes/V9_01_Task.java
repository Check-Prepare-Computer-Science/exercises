/**
 * Defines generic arithmetic operations.
 *
 * @param <T> the type of the arithmetic elements
 */
public interface Arithmetic<T> {

  /**
   * @returns the generic arithmetic representation of zero.
   */
  T zero();

  /**
   * Returns the result of the addition of a and b.
   *
   * @param a the first summand
   * @param b the second summand
   * @return the result of the addition of a and b
   */
  T add(T a, T b);

  /**
   * Returns the result of the multiplication of a and b.
   *
   * @param a the first multiplicand
   * @param b the second multiplicand
   * @return the result of the multiplication of a and b
   */
  T mul(T a, T b);
}