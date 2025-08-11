package info.shkryl.useInterface;

class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow");
    }

    @Override
    public void eat() {
        System.out.println("Cat is eating");
    }
}
