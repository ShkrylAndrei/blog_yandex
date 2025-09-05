package info.shkryl.pattern.abstractFactoryPattern.light;

import info.shkryl.pattern.abstractFactoryPattern.element.Button;

public class LightButton implements Button {
    public void paint() {
        System.out.println("Рисуем светлую кнопку");
    }
}
