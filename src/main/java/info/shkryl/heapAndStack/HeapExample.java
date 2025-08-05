package info.shkryl.heapAndStack;

public class HeapExample {

    public static void main(String[] args) {
        MyClass obj = new MyClass(); // obj хранится в стеке, объект размещается в куче
    }
}
class MyClass {
    int x; // Поле объекта, x хранится в куче
}
