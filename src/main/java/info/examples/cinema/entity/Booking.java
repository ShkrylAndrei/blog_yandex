package info.examples.cinema.entity;

import info.examples.cinema.utility.BookingStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
public class Booking {
    @Id
    private UUID id = UUID.randomUUID();

    private Long showtimeId;
    private Long seatId;
    private LocalDateTime bookedAt = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private BookingStatus status = BookingStatus.CONFIRMED;
}
