package info.shkryl.buyingFlyTicket.controller;

import info.shkryl.buyingFlyTicket.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public String bookTicket(@RequestParam String flightNumber) {
        return bookingService.bookTicket(flightNumber);
    }
}
