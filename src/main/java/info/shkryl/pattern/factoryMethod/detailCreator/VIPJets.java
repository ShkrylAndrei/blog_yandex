package info.shkryl.pattern.factoryMethod.detailCreator;

import info.shkryl.pattern.factoryMethod.Airplane;
import info.shkryl.pattern.factoryMethod.creator.Airline;
import info.shkryl.pattern.factoryMethod.product.PrivateJet;

public class VIPJets extends Airline {
    @Override
    protected Airplane createAirplane() {
        return new PrivateJet(); // ← Только для избранных
    }
}
