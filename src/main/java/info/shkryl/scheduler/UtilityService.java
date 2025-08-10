package info.shkryl.scheduler;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class UtilityService {

    // Получить выбор пользователя
    public int getChoice(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public LocalDate parseDate(String input) {
        try {
            return LocalDate.parse(input);
        } catch (DateTimeParseException e) {
            System.out.println("Неверный формат даты. Используйте ГГГГ-ММ-ДД");
            return null;
        }
    }

    public LocalTime parseTime(String input) {
        try {
            return LocalTime.parse(input);
        } catch (DateTimeParseException e) {
            System.out.println("Неверный формат времени. Используйте ЧЧ:ММ");
            return null;
        }
    }
}
