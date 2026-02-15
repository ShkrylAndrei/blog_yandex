package info.examples.elevator;
/**
 * Базовый лифт — инкапсулирует своё состояние
 * Принцип: "Я сам решаю, как изменяться"
 */
public class Elevator implements ElevatorControl {
    // 🔒 Приватные поля — никто не изменит напрямую
    private int currentFloor;
    protected int maxFloor;
    private Direction direction;
    private boolean doorsOpen;

    // Перечисление направления — типобезопасность вместо "up/down" строк
    public enum Direction { UP, DOWN, IDLE }

    // Состояние дверей — тоже инкапсулировано!
    private enum DoorState { OPEN, CLOSED }

    public Elevator(int maxFloor) {
        this.maxFloor = maxFloor;
        this.currentFloor = 1; // Лифты всегда начинают с 1-го этажа
        this.direction = Direction.IDLE;
        this.doorsOpen = false;
    }

    // Публичный интерфейс: "Приехать на этаж"
    public void goToFloor(int targetFloor) {
        if (targetFloor < 1 || targetFloor > maxFloor) {
            System.out.println(" Этаж " + targetFloor + " не существует!");
            return;
        }

        // Инкапсуляция в действии: лифт сам решает, как ехать
        closeDoors(); // Сначала закрыть двери — иначе катастрофа!
        move(targetFloor);
        openDoors();
    }

    // Приватные методы — детали реализации скрыты
    private void move(int targetFloor) {
        direction = (targetFloor > currentFloor) ? Direction.UP : Direction.DOWN;

        System.out.println("\n Движемся с " + currentFloor + " на " + targetFloor +
                " (" + direction + ")...");

        // Анимация движения — для наглядности
        int step = (targetFloor > currentFloor) ? 1 : -1;
        while (currentFloor != targetFloor) {
            try {
                Thread.sleep(300); // Задержка для плавности
                currentFloor += step;
                System.out.print( currentFloor);
                System.out.flush();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Прибыли на этаж " + currentFloor);
        direction = Direction.IDLE;
    }

    protected void openDoors() {
        if (!doorsOpen) {
            doorsOpen = true;
            System.out.println("Двери открыты");
        }
    }

    protected void closeDoors() {
        if (doorsOpen) {
            doorsOpen = false;
            System.out.println("Двери закрыты");
        }
    }

    // Геттеры — безопасный доступ к состоянию
    public int getCurrentFloor() {
        return currentFloor;
    }

    public boolean isDoorsOpen() {
        return doorsOpen;
    }
}
