package info.shkryl.springApplicationEvents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public String bookTicket(
            @RequestParam String flightNumber,
            @RequestParam String email) {
        return bookingService.bookTicket(flightNumber, email);
    }
}
