/**
 * Adds all previous values of the array to index i.
 * 
 * @param a array of integers
 */
void sumUp(int[] a) {
	for (int i = 1; i < a.length; i++) {
		a[i] += a[i - 1];
	}
}