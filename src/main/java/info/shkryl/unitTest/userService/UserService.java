package info.shkryl.unitTest.userService;

import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserNameById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(User::getName).orElse("Unknown");
    }
}
