package info.shkryl.workWithDateTime.example4;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        LocalTime workStart = LocalTime.of(9, 0);

        boolean isWorking = now.isAfter(workStart) && now.isBefore(LocalTime.of(18, 0));
        System.out.println("Рабочее время: " + isWorking);
    }
}
