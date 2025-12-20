package info.shkryl.handler_controller_error;

import java.time.LocalDateTime;

/**
 * Единый формат ответа при возникновении ошибки.
 * Используется во всех контроллерах через GlobalExceptionHandler.
 */
public class ErrorResponse {

    private final LocalDateTime timestamp;
    private final int status;
    private final String error;
    private final String message;

    // Конструктор для удобного создания
    public ErrorResponse(int status, String error, String message) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.message = message;
    }

    // Геттеры (без сеттеров — объект immutable)
    public LocalDateTime getTimestamp() { return timestamp; }
    public int getStatus() { return status; }
    public String getError() { return error; }
    public String getMessage() { return message; }
}
