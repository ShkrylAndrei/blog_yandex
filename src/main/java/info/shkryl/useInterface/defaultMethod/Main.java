package info.shkryl.useInterface.defaultMethod;

public class Main {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        Animal myCat = new Cat();

        myDog.makeSound(); // Bark
        myDog.sleep();     // Sleeping...

        myCat.makeSound(); // Meow
        myCat.sleep();     // Sleeping...
    }
}
