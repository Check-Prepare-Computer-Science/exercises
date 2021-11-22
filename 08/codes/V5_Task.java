class A {

}

class B extends A {

}

class C extends B {

}

public class G {

  public static void m(List<B> a, List<? extends B> b, List<? super B> c) {
    a.add(new C()); //
    b.add(new B()); //
    c.add(new C()); //
    a.add(new B()); //
    b.add(new A()); //
    c.add(new B()); //
    a.add(new A()); //
    b.add(null);    //
    c.add(new A()); //
    b.add(new C()); //
  }

  public static void main(String args[]) {
    m(new Vector<B>(), new Vector<C>(), new Vector<A>());
  }
}