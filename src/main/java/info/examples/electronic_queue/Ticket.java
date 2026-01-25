package info.examples.electronic_queue;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

// Базовый класс талона
public class Ticket {
    private static final AtomicLong counter = new AtomicLong(1);

    private final long id;
    private final TicketType type; // тип талона — enum
    private final LocalDateTime issuedAt;

    public Ticket(TicketType type) {
        this.id = counter.getAndIncrement();
        this.type = type;
        this.issuedAt = LocalDateTime.now();
    }

    // Геттеры
    public long getId() { return id; }
    public TicketType getType() { return type; }
    public LocalDateTime getIssuedAt() { return issuedAt; }

    @Override
    public String toString() {
        return String.format("Талон #%d [%s] выдан в %s",
                id, type.getDisplayName(), issuedAt.toLocalTime());
    }
}
