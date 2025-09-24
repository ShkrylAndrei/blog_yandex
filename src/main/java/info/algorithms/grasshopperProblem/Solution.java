package info.algorithms.grasshopperProblem;

import java.util.Scanner;

/**
 * Задача о кузнечике: прыжки на 1, 2 или 3 клетки.
 * Найти количество способов добраться из клетки 0 в клетку N.
 * Решение с помощью динамического программирования.
 */
public class Solution {

    /**
     * Вычисляет количество способов добраться до клетки N.
     * @param n целевая клетка (0 <= n <= ...)
     * @return количество различных способов
     */
    public static long countWays(int n) {
        // Если N = 0 — кузнечик уже на месте
        if (n == 0) return 1;

        // Создаём массив для хранения количества способов для каждой клетки
        long[] dp = new long[n + 1];

        // Базовый случай: в клетке 0 — 1 способ (ничего не делать)
        dp[0] = 1;

        // Заполняем массив от 1 до N
        for (int i = 1; i <= n; i++) {
            // Способы попасть в клетку i:
            // — из i-1 (если i-1 >= 0)
            // — из i-2 (если i-2 >= 0)
            // — из i-3 (если i-3 >= 0)
            dp[i] = dp[i - 1]; // прыжок на 1

            if (i >= 2) dp[i] += dp[i - 2]; // прыжок на 2
            if (i >= 3) dp[i] += dp[i - 3]; // прыжок на 3
        }

        return dp[n];
    }

    // Тестирование
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите N (целевую клетку): ");
        int n = scanner.nextInt();
        scanner.close();

        long result = countWays(n);
        System.out.println("Количество способов: " + result);
    }
}
