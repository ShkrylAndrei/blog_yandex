package info.shkryl.useStatic.example2;

public class MathUtils {
    public static int add(int a, int b) {
        return a + b;
    }

    public static double max(double a, double b) {
        return a > b ? a : b;
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }
}