package info.shkryl.pattern.factoryMethod.product;

import info.shkryl.pattern.factoryMethod.Airplane;

public class Airbus implements Airplane {
    @Override
    public void fly() {
        System.out.println("🛫 Airbus начинает полёт плавно и тихо.");
    }
}

