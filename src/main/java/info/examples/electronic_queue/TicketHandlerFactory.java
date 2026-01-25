package info.examples.electronic_queue;

import java.util.EnumMap;
import java.util.Map;

public class TicketHandlerFactory {
    private static final Map<TicketType, TicketHandler> handlers = new EnumMap<>(TicketType.class);

    static {
        // Инициализация всех обработчиков при старте
        handlers.put(TicketType.DEPOSITS, new DepositsHandler());
        handlers.put(TicketType.CREDIT_CARDS, new CreditCardsHandler());
        handlers.put(TicketType.LOANS, new LoansHandler());
        handlers.put(TicketType.OTHER, new OtherIssuesHandler());
    }

    public static TicketHandler getHandler(TicketType type) {
        TicketHandler handler = handlers.get(type);
        if (handler == null) {
            throw new IllegalArgumentException("Неизвестный тип талона: " + type);
        }
        return handler;
    }
}
