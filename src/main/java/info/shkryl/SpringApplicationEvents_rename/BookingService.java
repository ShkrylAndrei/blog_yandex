package info.shkryl.SpringApplicationEvents_rename;

import info.shkryl.buyingFlyTicket.entity.Flight;
import info.shkryl.buyingFlyTicket.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private ApplicationEventPublisher eventPublisher; // ← Автоматически внедряется

    @Transactional
    public String bookTicket(String flightNumber, String email) {
        Flight flight = flightRepository.findByFlightNumber(flightNumber);
        if (flight == null) {
            return "Flight not found!";
        }
        if (flight.getAvailableSeats() > 0) {
            flight.setAvailableSeats(flight.getAvailableSeats() - 1);
            flightRepository.save(flight);

            // 🚀 Публикуем событие!
            eventPublisher.publishEvent(
                    new TicketBookedEvent(flightNumber, email)
            );
            return "Ticket booked successfully!";
        } else {
            return "No available seats!";
        }
    }
}
