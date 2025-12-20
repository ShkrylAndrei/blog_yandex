package info.shkryl.use_swagger;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * DTO для создания пользователя.
 * Аннотации @Schema позволяют задать описание для Swagger UI.
 */
public class CreateUserRequest {

    @Schema(description = "Полное имя пользователя", example = "Иван Петров", required = true)
    @NotBlank(message = "Имя обязательно")
    @Size(min = 2, max = 100)
    private String name;

    @Schema(description = "Email пользователя", example = "ivan@example.com", required = true)
    @NotBlank
    @Email
    private String email;

    @Schema(description = "Пароль (минимум 8 символов)", example = "secret123", required = true)
    @NotBlank
    @Size(min = 8)
    private String password;

    // геттеры и сеттеры
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
