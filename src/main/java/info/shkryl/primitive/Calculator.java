package info.shkryl.primitive;

public class Calculator {

    public static void main(String[] args) {
        int a = 10;
        int b = 3;
        double result = (double) a / b; // 3.333...
        System.out.printf("Результат: %.2f%n", result); // 3.33
    }
}
