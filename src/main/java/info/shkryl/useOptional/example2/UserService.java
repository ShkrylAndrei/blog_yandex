package info.shkryl.useOptional.example2;

import java.util.Optional;

public class UserService {
    public Optional<User> findUserById(int id) {
        return Optional.of(new User("Andrei"));
    }
}
