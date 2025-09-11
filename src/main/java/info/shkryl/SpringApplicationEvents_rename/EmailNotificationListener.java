package info.shkryl.SpringApplicationEvents_rename;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationListener {

    @EventListener
    public void handleTicketBooking(TicketBookedEvent event) {
        System.out.println("Отправляем email на " + event.getPassengerEmail() +
                " о бронировании рейса " + event.getFlightNumber());
        // Здесь может быть реальная отправка через SMTP
    }
}
