package info.shkryl.workWithDateTime.example3;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1990, 5, 15);

        // Разница в днях
        long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(birthday, today);
        System.out.println("Прошло дней: " + daysBetween);
    }
}
