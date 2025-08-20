package info.shkryl.workWithClone.example4;

public class Address implements Cloneable{
    private String city;

    public Address(String city) {
        this.city = city;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
}
