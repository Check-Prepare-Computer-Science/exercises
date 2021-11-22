public class LambdaScope {

  public int x = 0;

  class InnerClass {

    public int x = 11;

    void methodInInnerClass(int x) {
      int z = 55;

      Consumer<Integer> myConsumer = (y) -> {
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("this.x = " + this.x);
        System.out.println("LambdaScope.this.x = " + LambdaScope.this.x);
        System.out.println("z = " + z);
      };
      myConsumer.accept(x);
    }
  }

  public static void main(String[] args) {
    LambdaScope scope = new LambdaScope();
    LambdaScope.InnerClass fl = scope.new InnerClass();
    fl.methodInInnerClass(123);
  }
}