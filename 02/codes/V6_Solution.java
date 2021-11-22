/**
 * Returns the primitive type where the number fits in the range of values.
 *
 * @param n the number to check
 * @return the smallest primitive type, where the number fits in the range of values
 */
char smallestPDT(long n) {
	// Cast the value to another primitive type and check if its value is the same as before
	// the cast. If the value is not the same, then the value is outside the value range of
	// the tested primitive type
	
	if (n == (byte) n) { return 'b'; }
	else if (n == (short) n) { return 's'; }
	else if (n == (int) n) { return 'i'; }
	return 'l';
}

/**
 * Returns the primitive type for each number in the specified array, where it fits
 * in the range of values.
 *
 * @param a the array containing numbers to check 
 * @return the primitive type for each number in the specified array, where it fits
 * in the range of values
 */
char[] smallestPDTs(long[] a) {
	char[] result = new char[a.length];
	for (int i = 0; i < result.length; i++) {
		result[i] = smallestPDT(a[i]);
	}
	return result;
}