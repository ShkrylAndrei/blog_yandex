package info.examples.electronic_queue;

// Интерфейс обработчика талона
public interface TicketHandler {
    void handle(Ticket ticket);
    TicketType getSupportedType();
}
