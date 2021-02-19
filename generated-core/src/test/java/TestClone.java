public class TestClone {
    public static void main(String[] args) throws Throwable {
        System.out.println(new A(10).clone());
    }
}

class A implements Cloneable {
    final int x;

    public A(int x) {
        this.x = x;
    }

    @Override
    protected A clone() throws CloneNotSupportedException {
        return (A) super.clone();
    }
}
