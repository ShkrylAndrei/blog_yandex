package info.examples.electronic_queue;

import java.util.ArrayList;
import java.util.List;

public class BankQueueSystem {
    // Храним талоны как List (интерфейс!), а не ArrayList
    private final List<Ticket> queue = new ArrayList<>();

    // Выдать талон
    public void issueTicket(TicketType type) {
        Ticket ticket = new Ticket(type);
        queue.add(ticket);
        System.out.println("🖨Выдан: " + ticket);
    }

    // Обработать следующий талон
    public void processNextTicket() {
        if (queue.isEmpty()) {
            System.out.println("Очередь пуста");
            return;
        }

        Ticket ticket = queue.remove(0); // FIFO — первый пришёл, первый ушёл
        TicketHandler handler = TicketHandlerFactory.getHandler(ticket.getType());
        handler.handle(ticket);
    }

    // Показать текущую очередь
    public void printQueue() {
        if (queue.isEmpty()) {
            System.out.println("Очередь пуста");
            return;
        }
        System.out.println("\n Текущая очередь:");
        for (int i = 0; i < queue.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + queue.get(i));
        }
        System.out.println();
    }
}
