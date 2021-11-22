/**
 * Inserts the row number to each line to the given file.
 *
 * @param path path of the file, where we insert row numbers to each line
 * @throws IOException
 */
void insertRowNumbers(String path) throws IOException {
  BufferedReader reader = new BufferedReader(
	new InputStreamReader(new FileInputStream(path)));
  StringBuilder sb = new StringBuilder();
  String line;
  int i = 1;
  while ((line = reader.readLine()) != null) {
    sb.append(i).append("\n").append(line).append("\n");
    i++;
  }
  reader.close();
  BufferedWriter writer = new BufferedWriter(
      new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));
  witer.write(sb.toString());
  writer.close();
}