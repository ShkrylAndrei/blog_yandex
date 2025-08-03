package info.shkryl.array.lottery.firstVariant;

import java.util.Random;

public class Lottery {

    public static void main(String[] args) {
        final int TOTAL_TICKETS = 1_000_000;
        final int WINNING_COUNT = 100;

        // 1. Создаём массив
        int[] tickets = new int[TOTAL_TICKETS];

        // 2. Заполняем 100 случайных выигрышных мест
        Random random = new Random();
        int winsPlaced = 0;

        while (winsPlaced < WINNING_COUNT) {
            int index = random.nextInt(TOTAL_TICKETS);
            if (tickets[index] == 0) { // чтобы не перезаписать
                tickets[index] = random.nextInt(100) + 1; // от 1 до 100
                winsPlaced++;
            }
        }

        // 3. Выводим номера выигрышных билетов
        System.out.println("Выигрышные билеты:");
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] > 0) {
                System.out.println("Билет #" + i + ", выигрыш: " + tickets[i] + " руб.");
            }
        }
    }
}
