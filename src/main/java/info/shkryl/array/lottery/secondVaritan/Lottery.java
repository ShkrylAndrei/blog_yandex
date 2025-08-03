package info.shkryl.array.lottery.secondVaritan;

import java.util.Random;

public class Lottery {

    private static String[] firstNames = {"Анна", "Иван", "Мария", "Сергей", "Елена", "Дмитрий"};
    private static String[] lastNames = {"Иванов", "Петров", "Сидорова", "Козлов", "Морозов", "Новикова"};

    private static String generateFio() {
        String firstName = firstNames[new Random().nextInt(firstNames.length)];
        String lastName = lastNames[new Random().nextInt(lastNames.length)];
        return lastName + " " + firstName;
    }

    public static void main(String[] args) {
        final int TOTAL = 1_000_000;
        Ticket[] tickets = new Ticket[TOTAL];
        Random random = new Random();

        // Заполняем все билеты
        for (int i = 0; i < TOTAL; i++) {
            long date = System.currentTimeMillis() - random.nextInt(100_000_000); // случайная дата
            String fio = generateFio();
            tickets[i] = new Ticket(i, date, fio);
        }

        // Выводим первые 100 на экран
        System.out.println("Победители лотереи:");
        for (int i = 0; i < 100; i++) {
            Ticket t = tickets[i];
            System.out.println("№" + t.numberTicket + " — " + t.fioOwner);
        }
    }
}
