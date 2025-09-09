package info.shkryl.buyingFlyTicket.util;

import info.shkryl.buyingFlyTicket.entity.Flight;
import info.shkryl.buyingFlyTicket.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public void run(String... args) {
        flightRepository.save(new Flight("FL123", 10));
        flightRepository.save(new Flight("FL456", 20));
    }
}
