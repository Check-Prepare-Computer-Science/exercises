class A {

}

class B extends A {

}

class C extends B {

}

public class G {

  public static void m(List<B> a, List<? extends B> b, List<? super B> c) {
    a.add(new C()); // Okay
    b.add(new B()); // Fehler
    c.add(new C()); // Okay
    a.add(new B()); // Okay
    b.add(new A()); // Fehler
    c.add(new B()); // Okay
    a.add(new A()); // Fehler
    b.add(null);    // Okay
    c.add(new A()); // Fehler
    b.add(new C()); // Fehler
  }

  public static void main(String args[]) {
    m(new Vector<B>(), new Vector<C>(), new Vector<A>());
  }
}