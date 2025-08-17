package info.shkryl.aboutObject.useHashCode;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Ivan",27);
        int hashCode = person.hashCode();
        System.out.println(hashCode);
    }
}
