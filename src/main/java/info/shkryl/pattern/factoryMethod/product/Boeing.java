package info.shkryl.pattern.factoryMethod.product;

import info.shkryl.pattern.factoryMethod.Airplane;

public class Boeing implements Airplane {
    @Override
    public void fly() {
        System.out.println("✈️ Boeing взлетает с максимальной скоростью!");
    }
}


