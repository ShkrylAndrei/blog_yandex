package info.algorithms.dp;

public class FibonacciSimple {

    public static int calculate(int n) {
        if (n <= 1) return n;
        return calculate(n - 1) + calculate(n - 2);
    }

    public static void main(String[] args) {
       int result = FibonacciSimple.calculate(10);
        System.out.println(result);
    }
}
