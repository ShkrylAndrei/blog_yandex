package info.examples.electronic_queue;

public class OtherIssuesHandler implements TicketHandler{
    @Override
    public void handle(Ticket ticket) {
        System.out.println("Окошко Другие Вопросы: " + ticket);
        System.out.println("   → Консультация по другим вопросам...");
    }

    @Override
    public TicketType getSupportedType() {
        return TicketType.OTHER;
    }
}
