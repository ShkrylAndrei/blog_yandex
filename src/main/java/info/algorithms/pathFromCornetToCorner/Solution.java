package info.algorithms.pathFromCornetToCorner;

public class Solution {

    /**
     * Считает количество путей в сетке m x n без заблокированных клеток.
     * Сложность: O(min(m, n)), память: O(1)
     */
    public static long countPaths(int m, int n) {
        // Оптимизация: C(a, b) = C(a, a-b) — выбираем меньшее из (m-1) и (n-1)
        int k = Math.min(m - 1, n - 1);
        int totalSteps = m + n - 2;

        long result = 1;
        // Вычисляем C(totalSteps, k) итеративно:
        // C(n, k) = n*(n-1)*...*(n-k+1) / k!
        for (int i = 1; i <= k; i++) {
            result = result * (totalSteps - k + i) / i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("2x2: " + countPaths(2, 2));   // 2
        System.out.println("3x3: " + countPaths(3, 3));   // 6
        System.out.println("3x4: " + countPaths(3, 4));   // 10
        System.out.println("20x20: " + countPaths(20, 20)); // 137846528820
    }
}
