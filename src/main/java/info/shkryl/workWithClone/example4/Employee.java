package info.shkryl.workWithClone.example4;

public class Employee implements Cloneable {
    private String name;
    private Address address; // Ссылочный тип

    public Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Employee cloned = (Employee) super.clone();
        cloned.address = (Address) this.address.clone(); // Предполагаем, что Address тоже клонируем
        return cloned;
    }

    // Геттеры и сеттеры
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }
}
