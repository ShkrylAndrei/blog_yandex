package info.shkryl.workWithDateTime.example5;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) {
        // Текущее время в Москве
        ZonedDateTime moscow = ZonedDateTime.now(ZoneId.of("Europe/Moscow"));
        System.out.println("Москва: " + moscow);

        // Время в Нью-Йорке
        ZonedDateTime ny = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("Нью-Йорк: " + ny);

        // Конвертация
        ZonedDateTime utc = moscow.withZoneSameInstant(ZoneId.of("UTC"));
        System.out.println("UTC: " + utc);
    }
}
