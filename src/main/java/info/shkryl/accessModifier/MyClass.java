package info.shkryl.accessModifier;

public class MyClass {
    private int data; // Доступно только внутри MyClass

    private void myMethod() {
        System.out.println("This is a private method.");
    }
}