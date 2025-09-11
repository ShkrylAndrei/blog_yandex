package info.shkryl.springApplicationEvents;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StatisticsUpdater {

    private int totalBookings = 0;

    @EventListener
    public void onTicketBooked(TicketBookedEvent event) {
        totalBookings++;
        System.out.println("📊 Обновлено: всего бронирований = " + totalBookings);
    }

    public int getTotalBookings() {
        return totalBookings;
    }
}
