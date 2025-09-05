package info.shkryl.pattern.abstractFactoryPattern;

import info.shkryl.pattern.abstractFactoryPattern.element.Button;
import info.shkryl.pattern.abstractFactoryPattern.element.Checkbox;
import info.shkryl.pattern.abstractFactoryPattern.factory.DarkThemeFactory;
import info.shkryl.pattern.abstractFactoryPattern.factory.LightThemeFactory;

public class Application {
    private Button button;
    private Checkbox checkbox;

    // Конструктор принимает фабрику
    public Application(GUIFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }

    // Для демонстрации
    public static void main(String[] args) {
        // Выбираем тему из настроек (например, из конфига)
        String theme = "dark"; // или "light"

        GUIFactory factory;
        if ("dark".equals(theme)) {
            factory = new DarkThemeFactory();
        } else {
            factory = new LightThemeFactory();
        }

        Application app = new Application(factory);
        app.paint();
    }
}
