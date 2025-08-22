package info.shkryl.useOptional.example3;

import java.util.Optional;

public class Main {
    public static Optional<Integer> parseInt(String str) {
        try {
            return Optional.of(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
        // Использование:
        parseInt("123")
                .ifPresent(n -> System.out.println("Число: " + n));
    }
}
