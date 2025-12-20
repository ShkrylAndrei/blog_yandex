package info.shkryl.handler_controller_error;

import info.shkryl.handler_controller_error.CreateUserRequest;
import info.shkryl.handler_controller_error.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    // Валидация → обрабатывается GlobalExceptionHandler
    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody CreateUserRequest request) {
        // Логика создания...
        return ResponseEntity.status(HttpStatus.CREATED).body("User created");
    }

    // Бизнес-ошибка → обрабатывается GlobalExceptionHandler
    @GetMapping("/{email}")
    public ResponseEntity<String> getUser(@PathVariable String email) {
        // Может выбросить UserNotFoundException
        findByEmail(email);
        return ResponseEntity.ok("User found");
    }

    private String findByEmail(String email){
        if (email.isBlank()){
            throw new UserNotFoundException("User not found");
        }
        return "User found";
    }
}
