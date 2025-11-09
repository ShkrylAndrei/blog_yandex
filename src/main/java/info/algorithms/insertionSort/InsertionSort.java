package info.algorithms.insertionSort;

public class InsertionSort {

    /**
     * Метод сортирует массив целых чисел по возрастанию.
     *
     * Как это работает?
     * - Мы начинаем со второго элемента (индекс 1).
     * - Каждый новый элемент мы "вставляем" в правильное место среди тех,
     *   что уже стоят перед ним (и уже отсортированы).
     */
    public static void insertionSort(int[] arr) {
        // Начинаем со второго элемента — первый уже "отсортирован" сам по себе
        for (int i = 1; i < arr.length; i++) {
            // Текущий элемент, который мы хотим "вставить"
            int key = arr[i];

            // Индекс элемента перед ним — туда мы будем "двигаться назад"
            int j = i - 1;

            // Пока мы не вышли за начало массива И предыдущий элемент больше key...
            while (j >= 0 && arr[j] > key) {
                // ...сдвигаем больший элемент вперёд (делаем место для key)
                arr[j + 1] = arr[j];
                j--; // идём ещё левее
            }

            // Вставляем key на его правильное место
            arr[j + 1] = key;
        }
    }

    /**
     * Вспомогательный метод для вывода массива на экран.
     */
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    /**
     * Главный метод — здесь всё запускается.
     */
    public static void main(String[] args) {
        // Наш "беспорядок" — как игрушки на полу
        int[] toys = {5, 2, 4, 6, 1, 3};

        System.out.println("Было (в беспорядке):");
        printArray(toys);

        // Сортируем!
        insertionSort(toys);

        System.out.println("Стало (по порядку!):");
        printArray(toys);
    }
}
