package info.shkryl.useInterface;

class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }

    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }
}
