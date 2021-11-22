public static void simpleSort(int[] array) {
  for (int i = 0; i < array.length; i++) {
    for (int j = i + 1; j < array.length; j++) {
      if (array[i] > array[j]) {
        int backup = array[i];
        array[i] = array[j];
        array[j] = backup;
      }
    }
  }
}