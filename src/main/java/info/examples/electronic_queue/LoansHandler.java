package info.examples.electronic_queue;

public class LoansHandler implements TicketHandler{
    @Override
    public void handle(Ticket ticket) {
        System.out.println("Окошко КРЕДИТЫ: " + ticket);
        System.out.println("   → Консультация по кредитам...");
    }

    @Override
    public TicketType getSupportedType() {
        return TicketType.LOANS;
    }
}
