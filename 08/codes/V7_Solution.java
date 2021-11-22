/**
 * A utility class for performing array specific operations.
 */
class ArrayUtils {

  /**
   * Prints the specified array to the console.
   *
   * @param <T>   the type of the elements in the array
   * @param array the array to be printed
   */
  public static <T> void printArray(T[] array) {
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i]);
      if (i < array.length - 1) {
        System.out.print(" ; ");
      }
    }
    System.out.println();
  }

  /**
   * Returns the index of the specified element in the array, if it exists, else returns -1.
   *
   * @param <T>   the type of the elements in the array
   * @param array the array where the element is searched for
   * @param value the value to be searched in the array
   * @return the index of the given element in the array if it exists, else return -1.
   */
  public static <T> int getArrayIndex(T[] array, T value) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] == value) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Sorts the array.
   *
   * @param <T>   the type of the elements in the array
   * @param array the array to be sorted
   */
  public static <T extends Comparable<? super T>> void simpleSort(T[] array) {
    for (int i = 0; i < array.length; i++) {
      for (int j = i + 1; j < array.length; j++) {
        // Swap
        if (array[i].compareTo(array[j]) > 0) {
          T backup = array[i];
          array[i] = array[j];
          array[j] = backup;
        }
      }
    }
  }
}