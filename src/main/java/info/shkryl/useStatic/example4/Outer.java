package info.shkryl.useStatic.example4;

public class Outer {
    private static String className = "Outer";

    // Статический вложенный класс
    public static class Inner {
        public void display() {
            System.out.println("Я — " + className); // Может обращаться к static-полям
        }
    }
}