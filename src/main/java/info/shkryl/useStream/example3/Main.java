package info.shkryl.useStream.example3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Анна", 25, true),
                new User("Борис", 17, true),
                new User("Вика", 30, false),
                new User("Дмитрий", 22, true),
                new User("Елена", 19, true)
        );

        List<String> result = users.stream()
                .filter(User::isActive)                    // только активные
                .filter(u -> u.getAge() > 18)             // старше 18
                .limit(3)                                 // первые 3
                .map(u -> u.getName().toUpperCase())      // в верхний регистр
                .collect(Collectors.toList());            // в список

        System.out.println(result); // [АННА, ДМИТРИЙ, ЕЛЕНА]
    }
}
