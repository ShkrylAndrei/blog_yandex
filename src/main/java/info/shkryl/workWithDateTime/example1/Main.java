package info.shkryl.workWithDateTime.example1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        String formatted = sdf.format(now);
        System.out.println(formatted); // 05.04.2025 14:30
    }
}
