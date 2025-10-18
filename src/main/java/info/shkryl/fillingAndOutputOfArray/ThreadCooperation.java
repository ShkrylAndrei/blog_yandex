package info.shkryl.fillingAndOutputOfArray;

public class ThreadCooperation {
    /**
     * Общий буфер для обмена данными между потоками.
     */
    static class SharedBuffer {
        private final int[] buffer = new int[3];
        private boolean isEmpty = true; // true = можно писать, false = можно читать
        private int roundsCompleted = 0; // сколько полных циклов (запись + чтение) завершено
        private static final int TOTAL_ROUNDS = 2; // всего 2 цикла
    }

    public static void main(String[] args) throws InterruptedException {
        SharedBuffer shared = new SharedBuffer();

        // Поток-производитель: заполняет массив
        Thread writer = new Thread(() -> {
            try {
                while (shared.roundsCompleted < SharedBuffer.TOTAL_ROUNDS) {
                    synchronized (shared) {
                        // Ждём, пока буфер станет пустым (готов к записи)
                        while (!shared.isEmpty) {
                            shared.wait(); // отпускаем монитор и ждём
                        }

                        // Заполняем буфер
                        for (int i = 0; i < shared.buffer.length; i++) {
                            shared.buffer[i] = i + 1;
                        }
                        shared.isEmpty = false; // теперь буфер полон

                        System.out.println("Поток Writer: заполнил массив "
                                + java.util.Arrays.toString(shared.buffer));
                        shared.notify(); // пробуждаем Reader
                    }
                    Thread.sleep(100); // небольшая пауза для наглядности
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Writer");

        // Поток-потребитель: выводит и очищает массив
        Thread reader = new Thread(() -> {
            try {
                while (shared.roundsCompleted < SharedBuffer.TOTAL_ROUNDS) {
                    synchronized (shared) {
                        // Ждём, пока буфер станет полным (готов к чтению)
                        while (shared.isEmpty) {
                            shared.wait(); // отпускаем монитор и ждём
                        }

                        // Выводим содержимое
                        System.out.println("Поток Reader: прочитал массив "
                                + java.util.Arrays.toString(shared.buffer));

                        // Очищаем буфер
                        java.util.Arrays.fill(shared.buffer, 0);
                        shared.isEmpty = true; // теперь буфер пуст

                        shared.roundsCompleted++; // завершён один полный цикл
                        System.out.println("Поток Reader: очистил массив. Цикл "
                                + shared.roundsCompleted + " завершён.");
                        shared.notify(); // пробуждаем Writer
                    }
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Reader");

        // Запускаем потоки
        writer.start();
        reader.start();

        // Дожидаемся завершения обоих
        writer.join();
        reader.join();

        System.out.println("Программа завершена.");
    }
}
