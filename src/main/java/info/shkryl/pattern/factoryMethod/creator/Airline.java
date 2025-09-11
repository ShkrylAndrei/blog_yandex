package info.shkryl.pattern.factoryMethod.creator;

import info.shkryl.pattern.factoryMethod.Airplane;

public abstract class Airline {

    // 🏭 Фабричный метод — создаёт самолёт
    protected abstract Airplane createAirplane();

    // Общая логика бронирования
    public final String bookTicket(String destination) {
        Airplane airplane = createAirplane(); // ← Создаём через фабричный метод
        airplane.fly(); // ← Летим!
        return "Билет забронирован на рейс в " + destination + " с компанией " + this.getClass().getSimpleName();
    }
}
