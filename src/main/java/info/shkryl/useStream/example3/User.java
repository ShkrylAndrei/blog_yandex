package info.shkryl.useStream.example3;

class User {
    private String name;
    private int age;
    private boolean active;

    public User(String name, int age, boolean active) {
        this.name = name;
        this.age = age;
        this.active = active;
    }

    //Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
