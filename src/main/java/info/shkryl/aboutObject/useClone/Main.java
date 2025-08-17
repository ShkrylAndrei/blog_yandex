package info.shkryl.aboutObject.useClone;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Bob", 25);
        try {
            Person p2 = (Person) p1.clone();
            System.out.println(p1 == p2); // false — разные объекты
            System.out.println(p1.equals(p2)); // true — если equals переопределён
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
