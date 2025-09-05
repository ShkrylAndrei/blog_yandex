package info.shkryl.pattern.abstractFactoryPattern.factory;

import info.shkryl.pattern.abstractFactoryPattern.GUIFactory;
import info.shkryl.pattern.abstractFactoryPattern.element.Button;
import info.shkryl.pattern.abstractFactoryPattern.element.Checkbox;
import info.shkryl.pattern.abstractFactoryPattern.light.LightButton;
import info.shkryl.pattern.abstractFactoryPattern.light.LightCheckbox;

// Фабрика для светлой темы
public class LightThemeFactory implements GUIFactory {
    public Button createButton() {
        return new LightButton();
    }

    public Checkbox createCheckbox() {
        return new LightCheckbox();
    }
}
