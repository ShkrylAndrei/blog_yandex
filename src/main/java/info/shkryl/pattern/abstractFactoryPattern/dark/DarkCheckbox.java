package info.shkryl.pattern.abstractFactoryPattern.dark;

import info.shkryl.pattern.abstractFactoryPattern.element.Checkbox;

public class DarkCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Рисуем тёмный чекбокс");
    }
}
