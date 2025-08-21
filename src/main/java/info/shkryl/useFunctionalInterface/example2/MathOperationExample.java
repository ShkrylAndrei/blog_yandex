package info.shkryl.useFunctionalInterface.example2;

public class MathOperationExample {
    public static void main(String[] args) {
        MathOperation addition = (a, b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;

        System.out.println("Addition: " + performOperation(5, 3, addition)); // 8
        System.out.println("Subtraction: " + performOperation(5, 3, subtraction)); // 2
    }

    public static int performOperation(int a, int b, MathOperation operation) {
        return operation.operation(a, b);
    }
}
