package info.shkryl.useException.exampleFive;

public class Main {

    private int age;

    public static void main(String[] args) {
        Main main = new Main();
        main.setAge(200);
        System.out.println(main.getAge());
    }

    public void setAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Возраст должен быть от 0 до 150");
        }
        this.age = age;
    }

    private int getAge(){
        return this.age;
    }
}
