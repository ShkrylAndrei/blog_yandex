package info.algorithms.simpleBacktracking;

import java.util.*;

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack("", 0, 0, n, result);
        return result;
    }

    private static void backtrack(String current, int open, int close, int n, List<String> result) {
        // Базовый случай: если строка достигла длины 2*n — добавляем в результат
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        // Добавляем открывающую скобку, если не превысили лимит
        if (open < n) {
            backtrack(current + "(", open + 1, close, n, result);
        }

        // Добавляем закрывающую скобку, только если она "закрывает" какую-то открывающую
        if (close < open) {
            backtrack(current + ")", open, close + 1, n, result);
        }
    }

    // Тест
    public static void main(String[] args) {
        int n = 3;
        List<String> combinations = generateParenthesis(n);
        for (String s : combinations) {
            System.out.println(s);
        }
    }
}
