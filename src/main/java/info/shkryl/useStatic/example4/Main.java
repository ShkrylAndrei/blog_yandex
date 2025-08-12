package info.shkryl.useStatic.example4;

public class Main {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer.Inner();
        inner.display(); // Я — Outer
    }
}
