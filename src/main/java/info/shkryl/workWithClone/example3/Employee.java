package info.shkryl.workWithClone.example3;

public class Employee implements Cloneable {
    private String name;
    private Address address; // Ссылочный тип

    public Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // Поверхностное копирование!
    }

    // Геттеры и сеттеры
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }
}
