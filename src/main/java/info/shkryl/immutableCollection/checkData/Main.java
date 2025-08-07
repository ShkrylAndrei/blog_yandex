package info.shkryl.immutableCollection.checkData;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> externalList = new ArrayList<>(List.of("Math", "Physics"));
        StudentService service = new StudentService(externalList);

        externalList.add("Hacking"); // Меняем внешний список
        // Но service.validSubjects НЕ изменился!
        boolean result = service.isValidSubject(externalList.get(2));
        System.out.println(result);
    }
}
