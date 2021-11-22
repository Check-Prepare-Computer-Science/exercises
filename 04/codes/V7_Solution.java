/**
 * Splits the specified array into integers and doubles.
 * 
 * @param a the array to split
 * @return the splitted array as {@link ArrayTuple}
 */
public static ArrayTuple split(double[] a) {
  // Counters to determine the length of the arrays
  int integers = 0;
  int doubles = 0;
  for (double d : a) {
    if (d == (int) d) {
      integers++;
    } else {
      doubles++;
    }
  }
    
  // Initialize arrays
  int[] iArr = new int[integers];
  double[] dArr = new double[doubles];
  integers = 0;
  doubles = 0;
  
  // Copy values
  for (int i = 0; i < a.length; i++) {
	double d = a[i];
    if (d == (int) d) {
      iArr[integers] = (int) d;
      integers++;
    } else {
      dArr[doubles] = d;
      doubles++;
    }
  }

  ArrayTuple tuple = new ArrayTuple();
  tuple.iArr = iArr;
  tuple.dArr = dArr;
  return tuple;
}