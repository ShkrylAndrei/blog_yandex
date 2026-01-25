package info.examples.electronic_queue;

// Enum с описанием и логикой маршрутизации
public enum TicketType {
    DEPOSITS("Вклады"),
    CREDIT_CARDS("Кредитные карты и продукты"),
    LOANS("Кредиты"),
    OTHER("Другие вопросы");

    private final String displayName;

    TicketType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
