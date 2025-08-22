package info.shkryl.useOptional.example1;

public class Main {

    public static void main(String[] args) {
        User user = getUser();
        if (user != null) {
            String name = user.getName();
            if (name != null) {
                System.out.println(name.toUpperCase());
            }
        }
    }

    private static User getUser(){
        User user = new User("Andrei");
        return user;
    }
}
