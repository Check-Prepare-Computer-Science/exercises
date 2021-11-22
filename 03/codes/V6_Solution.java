/**
 * Returns the longest sequence in the array that has equal values at the positions i and 
 * array.length-i-1 in the array. If there is none, returns 0.
 *
 * @param arr array, where we try to find the longest sequence
 * @return the longest sequence
 */
int maxMirror(int[] arr) {
  // Store the length of the maximum sequence
  int max = 0;
  // Store the length of the currently computed sequence
  int current;
  
  // Check the elements for a sequence by going forward in the array 
  for (int i = 0; i < arr.length; i++) {
    // Check the elements for a sequence by going backward in the array
    for (int j = arr.length - 1; j > i; j--) {
      // Interval in the array that we want to check
      int left = i;
      int right = j;
      current = 0;
      // Compute the length of the sequence
      while (left < right && arr[left] == arr[right]) {
        current++;
        left++;
        right--;
      }
      // Check, if it is the longest subsequence and, if yes, overwrite the maximum sequence
      if (max < current) {
        max = current;
      }
    }
  }
  return max;
}