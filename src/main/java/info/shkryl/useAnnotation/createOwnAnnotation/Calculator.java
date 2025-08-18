package info.shkryl.useAnnotation.createOwnAnnotation;

public class Calculator {
    @LogExecution("Сложение двух чисел")
    public int add(int a, int b) {
        return a + b;
    }
    @LogExecution(value = "Умножение", logParameters = false)
    public int multiply(int a, int b) {
        return a * b;
    }
}
