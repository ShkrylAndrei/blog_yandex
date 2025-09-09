package info.shkryl.buyingFlyTicket.repository;

import info.shkryl.buyingFlyTicket.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Flight findByFlightNumber(String flightNumber);
}
