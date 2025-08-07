package info.shkryl.immutableCollection;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Example2 {

    public static void main(String[] args) {
        // Список
        List<String> names = List.of("Анна", "Иван", "Мария");

        // Множество
        Set<Integer> numbers = Set.of(1, 2, 3);

        // Карта
        Map<String, Integer> ages = Map.of(
                "Анна", 25,
                "Иван", 30
        );

        // names.add("Петя"); // Ошибка!
    }
}
