package info.shkryl.useAbstractClass.exampleOne;

abstract class Animal {
    // Абстрактный метод
    abstract void makeSound();

    // Обычный метод
    void sleep() {
        System.out.println("Sleeping...");
    }
}
