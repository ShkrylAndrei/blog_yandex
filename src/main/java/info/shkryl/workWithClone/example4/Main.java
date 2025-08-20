package info.shkryl.workWithClone.example4;

public class Main {
    public static void main(String[] args) {
        Address addr = new Address("Москва");
        Employee emp1 = new Employee("Иван", addr);

        try {
            Employee emp2 = (Employee) emp1.clone();
            emp2.getAddress().setCity("СПб"); // Меняем копию

            System.out.println(emp1.getAddress().getCity()); // Вывод: "Москва"
            System.out.println(emp2.getAddress().getCity()); // Вывод: "СПб"
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
