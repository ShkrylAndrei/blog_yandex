package info.shkryl.pattern.builder.useBuilder;

public class Main {
    public static void main(String[] args) {
        // Собираем ноутбук мечты!
        Laptop gamingLaptop = new Laptop.Builder("ASUS", 32)
                .storage(1024)
                .processor("Intel i9")
                .screen(17.3)
                .backlitKeyboard(true)
                .build(); // 🎉 Готово!

        System.out.println(gamingLaptop);

        // Или простой офисный ноутбук
        Laptop officeLaptop = new Laptop.Builder("Lenovo", 8)
                .storage(512)
                .build();

        System.out.println(officeLaptop);
    }
}
