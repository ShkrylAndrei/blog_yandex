package info.shkryl.useInterface.defaultMethod;

interface Animal {
    void makeSound();

    default void sleep() {
        System.out.println("Sleeping...");
    }
}
