package info.shkryl.pattern.factoryMethod.detailCreator;

import info.shkryl.pattern.factoryMethod.Airplane;
import info.shkryl.pattern.factoryMethod.creator.Airline;
import info.shkryl.pattern.factoryMethod.product.Airbus;

public class AirbusAirlines extends Airline {
    @Override
    protected Airplane createAirplane() {
        return new Airbus(); // ← Создаём Airbus
    }
}
