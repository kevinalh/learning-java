public class TestBox {
    Integer i;
    int j;
    public static void main(String[] args) {
        // This will fail at runtime since the Integer
        // instance variable is initialized as
        // null instead of pointing to a 0 primitive.
        TestBox t = new TestBox();
        t.go();
    }
    public void go() {
        j = i;
        System.out.println(j);
        System.out.println(i);
    }
}
