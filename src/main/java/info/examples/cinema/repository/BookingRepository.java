package info.examples.cinema.repository;

import info.examples.cinema.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {
    boolean existsByShowtimeIdAndSeatId(Long showtimeId, Long seatId);
}
