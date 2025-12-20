package info.shkryl.handler_controller_error;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String email) {
        super("Пользователь с email '" + email + "' не найден");
    }
}
