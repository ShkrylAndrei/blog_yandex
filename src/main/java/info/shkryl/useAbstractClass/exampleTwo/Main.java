package info.shkryl.useAbstractClass.exampleTwo;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        circle.displayType();
        System.out.println("Area: " + circle.area());

        Shape rectangle = new Rectangle(4, 6);
        rectangle.displayType();
        System.out.println("Area: " + rectangle.area());
    }
}
