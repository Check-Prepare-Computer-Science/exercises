public class NoBreadException extends Exception {

  public NoBreadException(String topping) {
    super("There is no bread, only " + topping);
  }
}

@FunctionalInterface
public interface Lunch {

  String getTopping(String s) throws NoBreadException;
}