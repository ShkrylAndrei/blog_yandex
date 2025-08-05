package info.shkryl.heapAndStack;

public class StackExample {

    public void method1() {
        int a = 10; // Локальная переменная a хранится в стеке
        method2();
    }
    public void method2() {
        int b = 20; // Локальная переменная b хранится в стеке
    }
    public static void main(String[] args) {
        StackExample example = new StackExample();
        example.method1();
    }
}
