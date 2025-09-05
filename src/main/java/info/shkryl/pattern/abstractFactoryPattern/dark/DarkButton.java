package info.shkryl.pattern.abstractFactoryPattern.dark;

import info.shkryl.pattern.abstractFactoryPattern.element.Button;

public class DarkButton implements Button {
    public void paint() {
        System.out.println("Рисуем тёмную кнопку");
    }
}
