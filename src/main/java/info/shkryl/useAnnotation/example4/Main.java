package info.shkryl.useAnnotation.example4;

public class Main {
    public static void main(String[] args) {
        Calculator calculator= (a, b) -> a + b;
        int result= calculator.calculate(2,3);
        System.out.println(result);
    }
}
