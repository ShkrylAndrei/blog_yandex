package info.examples.electronic_queue;

public class Main {
    public static void main(String[] args) {
        BankQueueSystem system = new BankQueueSystem();

        // Имитация выдачи талонов
        system.issueTicket(TicketType.CREDIT_CARDS);
        system.issueTicket(TicketType.DEPOSITS);
        system.issueTicket(TicketType.OTHER);
        system.issueTicket(TicketType.LOANS);

        system.printQueue();

        // Обработка по одному
        system.processNextTicket(); // карты
        system.processNextTicket(); // вклады
        system.processNextTicket(); // другие
        system.processNextTicket(); // кредиты

        system.printQueue(); // пусто
    }
}
