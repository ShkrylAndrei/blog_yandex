package info.shkryl.pattern.abstractFactoryPattern;

import info.shkryl.pattern.abstractFactoryPattern.element.Button;
import info.shkryl.pattern.abstractFactoryPattern.element.Checkbox;

// Абстрактная фабрика для создания семейства компонентов
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}