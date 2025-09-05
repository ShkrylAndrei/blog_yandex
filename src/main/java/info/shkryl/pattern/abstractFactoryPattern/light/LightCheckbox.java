package info.shkryl.pattern.abstractFactoryPattern.light;

import info.shkryl.pattern.abstractFactoryPattern.element.Checkbox;

public class LightCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Рисуем светлый чекбокс");
    }
}
