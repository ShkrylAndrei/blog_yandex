package info.shkryl.workWithDateTime.example6;

import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        Instant start = Instant.now();
        // ... какая-то работа ...
        Instant end = Instant.now();

        System.out.println("Начало: " + start);
        System.out.println("Конец: " + end);

        // Разница
        long seconds = java.time.Duration.between(start, end).toSeconds();
    }
}
