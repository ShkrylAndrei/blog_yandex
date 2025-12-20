package info.shkryl.validation_data_in_controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {

    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody CreateUserRequest request) {
        // Если данные невалидны — Spring автоматически выбросит MethodArgumentNotValidException
        // и не дойдёт до этой строки
        return ResponseEntity.status(HttpStatus.CREATED).body("Пользователь создан: " + request.getEmail());
    }

    @GetMapping
    public ResponseEntity<String> getUsers(
            @RequestParam(defaultValue = "0") @Min(0) int page,
            @RequestParam(defaultValue = "10") @Min(1) @Max(100) int size) {

        return ResponseEntity.ok("Page: " + page + ", Size: " + size);
    }
}
