package info.shkryl.useOptional.example2;

import java.util.Optional;

public class Main {
    private final static UserService userService = new UserService();

    public static void main(String[] args) {
        Optional<User> user = userService.findUserById(100);

        String displayName = user
                .map(User::getName)
                .map(String::toUpperCase)
                .orElse("Пользователь не найден");

        System.out.println(displayName);
    }
}
