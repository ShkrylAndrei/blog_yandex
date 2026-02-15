package info.examples.elevator;

/**
 * Грузовой лифт — наследует базовую логику, но переопределяет детали
 */
public class FreightElevator extends Elevator {
    private final int maxWeightKg;
    private int currentWeightKg;

    public FreightElevator(int maxFloor, int maxWeightKg) {
        super(maxFloor); // Вызов конструктора родителя
        this.maxWeightKg = maxWeightKg;
        this.currentWeightKg = 0;
    }

    // 🚫 Переопределяем: грузовой лифт НЕ открывает двери автоматически
    @Override
    public void goToFloor(int targetFloor) {
        if (targetFloor < 1 || targetFloor > super.maxFloor) { // Защита от некорректного этажа
            System.out.println("Этаж " + targetFloor + " не существует!");
            return;
        }

        closeDoors(); // Закрываем двери
        moveSlowly(targetFloor); // Едем МЕДЛЕННО — груз тяжёлый!
        // Двери НЕ открываются автоматически — грузчик сам нажмёт кнопку
        System.out.println("Двери остаются закрытыми — нажмите кнопку 'Открыть'");
    }

    //Собственная реализация движения — медленнее на 50%
    private void moveSlowly(int targetFloor) {
        System.out.println("\n Грузовой лифт движется с " + getCurrentFloor() +
                " на " + targetFloor + "...");

        int step = (targetFloor > getCurrentFloor()) ? 1 : -1;
        while (getCurrentFloor() != targetFloor) {
            try {
                Thread.sleep(600); // Медленнее, чем у пассажирского (300 мс)
                // Используем сеттер через защищённый метод — инкапсуляция сохранена!
                setCurrentFloor(getCurrentFloor() + step);
                System.out.print(getCurrentFloor());
                System.out.flush();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("\n Груз доставлен на этаж " + getCurrentFloor());
    }

    // Специфичные для грузового лифта методы
    public void loadCargo(int weightKg) {
        if (currentWeightKg + weightKg > maxWeightKg) {
            System.out.println(" Перегрузка! Максимум " + maxWeightKg + " кг");
            return;
        }
        currentWeightKg += weightKg;
        System.out.println(" Загружено " + weightKg + " кг. Всего: " + currentWeightKg + "/" +
                maxWeightKg + " кг");
    }

    public void unloadCargo(int weightKg) {
        if (weightKg > currentWeightKg) {
            System.out.println(" Нельзя разгрузить больше, чем загружено");
            return;
        }
        currentWeightKg -= weightKg;
        System.out.println(" Разгружено " + weightKg + " кг. Осталось: " + currentWeightKg + " кг");
    }

    //  Защищённый метод для изменения этажа изнутри класса
    // (родительский класс не позволяет менять этаж напрямую — инкапсуляция!)
    protected void setCurrentFloor(int floor) {
        // В реальном коде здесь была бы проверка безопасности
        // Для примера упростим
        try {
            java.lang.reflect.Field field = Elevator.class.getDeclaredField("currentFloor");
            field.setAccessible(true);
            field.set(this, floor);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка установки этажа", e);
        }
    }
}
