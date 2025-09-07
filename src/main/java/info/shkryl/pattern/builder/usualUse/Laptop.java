package info.shkryl.pattern.builder.usualUse;

public class Laptop {
    private String brand;
    private int ram;
    private int storage;
    private boolean hasSSD;
    private String processor;
    private double screen;
    private boolean backlitKeyboard;

    public Laptop() {
    }

    public Laptop(String brand) {
        this.brand = brand;
    }

    public Laptop(String brand, int ram) {
        this.brand = brand;
        this.ram = ram;
    }

    public Laptop(String brand, int ram, int storage) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
    }

    public Laptop(String brand, int ram, int storage, boolean hasSSD) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.hasSSD = hasSSD;
    }

    //... и т.д.
}
