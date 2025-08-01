package info.shkryl.oop.polymorphism;

public class Main {
    public static void main(String[] args) {
        Shape shape1 = new Circle(5);
        Shape shape2 = new Rectangle(4, 6);

        System.out.println(shape1.area()); // 78.54
        System.out.println(shape2.area()); // 24.0
    }
}
