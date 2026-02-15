package info.examples.elevator;

public class ElevatorDemo {
    public static void main(String[] args) {
        System.out.println(" СИМУЛЯТОР ЛИФТОВ — ООП в действии\n");

        // Создаём разные лифты (инкапсуляция + наследование)
        Elevator passenger = new Elevator(10); // Пассажирский до 10 этажа
        FreightElevator freight = new FreightElevator(5, 1000);
        // Грузовой до 5 этажа, 1000 кг

        // Регистрируем в диспетчере (полиморфизм)
        BuildingDispatcher dispatcher = new BuildingDispatcher();
        dispatcher.registerElevator(passenger);
        dispatcher.registerElevator(freight);

        // Сценарий 1: вызов пассажира на 7 этаж
        System.out.println("\n Пассажир вызывает лифт на 7 этаж...");
        dispatcher.sendNearestElevatorTo(7);

        // Сценарий 2: грузчик вызывает лифт на 3 этаж
        System.out.println("\n Грузчик вызывает лифт на 3 этаж...");
        freight.loadCargo(300); // Загружаем груз ДО вызова
        dispatcher.sendNearestElevatorTo(3);

        // Сценарий 3: экстренная ситуация
        dispatcher.stopAllElevators();
    }
}
