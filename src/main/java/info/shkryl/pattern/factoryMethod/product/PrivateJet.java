package info.shkryl.pattern.factoryMethod.product;

import info.shkryl.pattern.factoryMethod.Airplane;

public class PrivateJet implements Airplane {
    @Override
    public void fly() {
        System.out.println("💎 Частный джет взлетает — VIP только!");
    }
}
