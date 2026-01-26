package info.examples.cinema.controller;

import info.examples.cinema.entity.Booking;
import info.examples.cinema.entity.Film;
import info.examples.cinema.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    private BookingRepository bookingRepo;

    @PostMapping("/book")
    public ResponseEntity<String> bookSeat(
            @RequestParam Long showtimeId,
            @RequestParam Long seatId) {

        // КРИТИЧЕСКАЯ СЕКЦИЯ — см. раздел 5!
        if (bookingRepo.existsByShowtimeIdAndSeatId(showtimeId, seatId)) {
            return ResponseEntity.badRequest().body("Место уже занято!");
        }

        try {
            Booking booking = new Booking();
            booking.setShowtimeId(showtimeId);
            booking.setSeatId(seatId);
            bookingRepo.save(booking);
            return ResponseEntity.ok("Успех!");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body("Место занято!");
        }
    }
}
