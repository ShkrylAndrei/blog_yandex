package info.shkryl.springApplicationEvents;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class LoggingEventListener {

    @EventListener
    public void logBooking(TicketBookedEvent event) {
        System.out.println("[LOG] Билет на рейс " + event.getFlightNumber() +
                " забронирован для " + event.getPassengerEmail() +
                " в " + event.getBookingTime());
    }
}
