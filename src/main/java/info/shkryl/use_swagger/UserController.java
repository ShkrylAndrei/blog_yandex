package info.shkryl.use_swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Контроллер для управления пользователями.
 * Группируем операции под тегом "Пользователи" в Swagger UI.
 */
@Tag(name = "Пользователи", description = "Операции с пользователями: создание, поиск и т.д.")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Operation(
            summary = "Создать нового пользователя",
            description = "Принимает данные пользователя и создаёт его в системе. " +
                    "Возвращает подтверждение и email созданного пользователя."
    )
    @ApiResponse(
            responseCode = "201",
            description = "Пользователь успешно создан",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
    )
    @ApiResponse(responseCode = "400", description = "Ошибка валидации входных данных")
    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody CreateUserRequest request) {
        // Логика создания...
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Пользователь создан: " + request.getEmail());
    }

    @Operation(summary = "Получить пользователя по email")
    @ApiResponse(responseCode = "200", description = "Пользователь найден")
    @ApiResponse(responseCode = "404", description = "Пользователь не найден")
    @GetMapping("/{email}")
    public ResponseEntity<String> getUserByEmail(
            @Parameter(description = "Email пользователя", required = true)
            @PathVariable String email) {
        // Логика поиска...
        return ResponseEntity.ok("Пользователь: " + email);
    }
}
