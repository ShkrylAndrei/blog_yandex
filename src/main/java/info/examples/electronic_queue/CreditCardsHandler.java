package info.examples.electronic_queue;

// Обработчик для кредитных карт
public class CreditCardsHandler implements TicketHandler {
    @Override
    public void handle(Ticket ticket) {
        System.out.println("Окошко КАРТЫ: " + ticket);
        System.out.println("   → Выпуск карты, изменение лимита, подключение услуг...");
    }

    @Override
    public TicketType getSupportedType() {
        return TicketType.CREDIT_CARDS;
    }
}
