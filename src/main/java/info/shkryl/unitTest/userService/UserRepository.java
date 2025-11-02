package info.shkryl.unitTest.userService;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long id);
}
