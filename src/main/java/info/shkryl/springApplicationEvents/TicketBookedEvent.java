package info.shkryl.springApplicationEvents;

import java.time.LocalDateTime;

public class TicketBookedEvent {
    private final String flightNumber;
    private final String passengerEmail;
    private final LocalDateTime bookingTime;

    public TicketBookedEvent(String flightNumber, String passengerEmail) {
        this.flightNumber = flightNumber;
        this.passengerEmail = passengerEmail;
        this.bookingTime = LocalDateTime.now();
    }

    // Геттеры
    public String getFlightNumber() { return flightNumber; }
    public String getPassengerEmail() { return passengerEmail; }
    public LocalDateTime getBookingTime() { return bookingTime; }
}
