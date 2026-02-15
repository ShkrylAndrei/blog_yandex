package info.examples.elevator;

/**
 * Интерфейс управления лифтом — контракт для всех типов
 */
public interface ElevatorControl {
    void goToFloor(int floor);
    int getCurrentFloor();
    default void emergencyStop() {
        System.out.println("Экстренная остановка!");
    }
}
