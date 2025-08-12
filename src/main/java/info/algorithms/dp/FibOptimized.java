package info.algorithms.dp;

public class FibOptimized {

    public static int calculate(int n){
        if (n <= 1) return n;

        int prev2 = 0, prev1 = 1;
        int current = 0;

        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }

    public static void main(String[] args) {
        int result = FibOptimized.calculate(10);
        System.out.println(result);
    }
}
