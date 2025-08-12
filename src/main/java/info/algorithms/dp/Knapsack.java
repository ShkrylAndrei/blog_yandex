package info.algorithms.dp;

public class Knapsack {
    public static int knapsack(int W, int[] weights, int[] values) {
        int n = weights.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                int weight = weights[i - 1];
                int value = values[i - 1];

                if (weight > w) {
                    // Предмет не помещается
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // Берём максимум: не берём или берём предмет
                    dp[i][w] = Math.max(
                            dp[i - 1][w],                      // не берём
                            dp[i - 1][w - weight] + value      // берём
                    );
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int W = 50;

        System.out.println(knapsack(W, weights, values)); // Вывод: 220
    }
}
