package info.shkryl.useFunctionalInterface.example1;

import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> printMessage = message -> System.out.println(message);
        printMessage.accept("Hello, world!");
    }
}
