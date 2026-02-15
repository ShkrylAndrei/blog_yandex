package info.examples.elevator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BuildingDispatcher {
    private List<ElevatorControl> elevators = new ArrayList<>();

    public void registerElevator(ElevatorControl elevator) {
        elevators.add(elevator);
        System.out.println("Зарегистрирован лифт на этаже " + elevator.getCurrentFloor());
    }

    // Полиморфизм в действии: метод не знает тип лифта!
    public void sendNearestElevatorTo(int floor) {
        System.out.println("\n Диспетчер: вызов на этаж " + floor);

        ElevatorControl nearest = elevators.stream()
                .min(Comparator.comparingInt(e -> Math.abs(e.getCurrentFloor() - floor))
                )
                .orElse(null);

        if (nearest != null) {
            System.out.println(" Ближайший лифт на этаже " + nearest.getCurrentFloor());
            nearest.goToFloor(floor); // Вызываем ОДИНАКОВО для всех типов!
        }
    }

    // Ещё пример полиморфизма: экстренная остановка для ВСЕХ
    public void stopAllElevators() {
        System.out.println("\n ДИСПЕТЧЕР: экстренная остановка всех лифтов!");
        elevators.forEach(ElevatorControl::emergencyStop);
    }
}
