package info.shkryl.pattern.builder.useBuilder;

public class Laptop {
    // Обязательные поля
    private final String brand;
    private final int ram;

    // Опциональные поля
    private final int storage;
    private final boolean hasSSD;
    private final String processor;
    private final double screen;
    private final boolean backlitKeyboard;

    // Приватный конструктор — создаётся только через Builder
    Laptop(Builder builder) {
        this.brand = builder.brand;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.hasSSD = builder.hasSSD;
        this.processor = builder.processor;
        this.screen = builder.screen;
        this.backlitKeyboard = builder.backlitKeyboard;
    }

    // Геттеры
    public String getBrand() { return brand; }
    public int getRam() { return ram; }
    public int getStorage() { return storage; }
    public boolean hasSSD() { return hasSSD; }
    public String getProcessor() { return processor; }
    public double getScreen() { return screen; }
    public boolean hasBacklitKeyboard() { return backlitKeyboard; }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", ram=" + ram +
                "GB, storage=" + storage +
                "GB, hasSSD=" + hasSSD +
                ", processor='" + processor + '\'' +
                ", screen=" + screen +
                "\", backlitKeyboard=" + backlitKeyboard +
                '}';
    }

    public static class Builder {
        // Обязательные параметры
        final String brand;
        final int ram;

        // Опциональные параметры (по умолчанию)
        int storage = 256;
        boolean hasSSD = true;
        String processor = "Intel i5";
        double screen = 15.6;
        boolean backlitKeyboard = false;

        // Конструктор для обязательных полей
        public Builder(String brand, int ram) {
            this.brand = brand;
            this.ram = ram;
        }

        // Методы для установки опциональных параметров (возвращают this)
        public Builder storage(int storage) {
            this.storage = storage;
            return this;
        }

        public Builder hasSSD(boolean hasSSD) {
            this.hasSSD = hasSSD;
            return this;
        }

        public Builder processor(String processor) {
            this.processor = processor;
            return this;
        }

        public Builder screen(double screen) {
            this.screen = screen;
            return this;
        }

        public Builder backlitKeyboard(boolean backlitKeyboard) {
            this.backlitKeyboard = backlitKeyboard;
            return this;
        }

        // Метод build() создаёт объект
        public Laptop build() {
            return new Laptop(this);
        }
    }
}
