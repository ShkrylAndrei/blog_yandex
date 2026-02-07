package info.algorithms.nearestones;

public class NearestOnes {
    public static void printNearestOnes(int[] arr) {
        int n = arr.length;

        // Шаг 1: пройтись слева → запомнить ближайшую единицу слева для каждого индекса
        int[] leftDist = new int[n];
        int lastOne = -1; // позиция последней встреченной единицы

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                lastOne = i;
                leftDist[i] = 0; // для самой единицы расстояние = 0
            } else {
                leftDist[i] = (lastOne == -1) ? Integer.MAX_VALUE : i - lastOne;
            }
        }

        // Шаг 2: пройтись справа → запомнить ближайшую единицу справа
        int[] rightDist = new int[n];
        lastOne = -1;

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 1) {
                lastOne = i;
                rightDist[i] = 0;
            } else {
                rightDist[i] = (lastOne == -1) ? Integer.MAX_VALUE : lastOne - i;
            }
        }

        // Шаг 3: для каждого нуля вывести результат
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                int left = (leftDist[i] == Integer.MAX_VALUE) ? -1 : i - leftDist[i];
                int right = (rightDist[i] == Integer.MAX_VALUE) ? -1 : i + rightDist[i];

                System.out.printf("Индекс %d: слева=%d, справа=%d%n",
                        i, left, right);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 0, 1, 0, 0, 0, 1};
        printNearestOnes(arr);
    }
}
