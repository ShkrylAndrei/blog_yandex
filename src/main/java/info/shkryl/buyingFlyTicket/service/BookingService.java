package info.shkryl.buyingFlyTicket.service;

import info.shkryl.buyingFlyTicket.entity.Flight;
import info.shkryl.buyingFlyTicket.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class BookingService {

    @Autowired
    private FlightRepository flightRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public String bookTicket(String flightNumber) {
        Flight flight = flightRepository.findByFlightNumber(flightNumber);
        if (flight == null) {
            return "Flight not found!";
        }

        if (flight.getAvailableSeats() > 0) {
            flight.setAvailableSeats(flight.getAvailableSeats() - 1);
            flightRepository.save(flight);
            return "Ticket booked successfully!";
        } else {
            return "No available seats!";
        }
    }
}
