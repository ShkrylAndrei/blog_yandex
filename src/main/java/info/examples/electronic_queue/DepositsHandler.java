package info.examples.electronic_queue;

// Обработчик для вкладов
public class DepositsHandler implements TicketHandler {
    @Override
    public void handle(Ticket ticket) {
        System.out.println("Окошко ВКЛАДЫ: " + ticket);
        System.out.println("   → Консультация по депозитам, открытие счёта...");
    }

    @Override
    public TicketType getSupportedType() {
        return TicketType.DEPOSITS;
    }
}

