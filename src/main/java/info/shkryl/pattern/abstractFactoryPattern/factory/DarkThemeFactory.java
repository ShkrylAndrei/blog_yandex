package info.shkryl.pattern.abstractFactoryPattern.factory;

import info.shkryl.pattern.abstractFactoryPattern.GUIFactory;
import info.shkryl.pattern.abstractFactoryPattern.dark.DarkButton;
import info.shkryl.pattern.abstractFactoryPattern.dark.DarkCheckbox;
import info.shkryl.pattern.abstractFactoryPattern.element.Button;
import info.shkryl.pattern.abstractFactoryPattern.element.Checkbox;

// Фабрика для тёмной темы
public class DarkThemeFactory implements GUIFactory {
    public Button createButton() {
        return new DarkButton();
    }

    public Checkbox createCheckbox() {
        return new DarkCheckbox();
    }
}