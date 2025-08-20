package info.shkryl.workWithDateTime.example2;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Текущая дата и время
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Сейчас: " + now); // 2025-04-05T14:30:45.123

        // Создание конкретной даты
        LocalDateTime meeting = LocalDateTime.of(2025, 4, 10, 15, 30);
        System.out.println("Встреча: " + meeting); // 2025-04-10T15:30

        // Манипуляции
        LocalDateTime tomorrow = now.plusDays(1);
        LocalDateTime nextWeek = now.plusWeeks(1);
        LocalDateTime past = now.minusHours(3);

        System.out.println("Завтра: " + tomorrow);
    }
}
