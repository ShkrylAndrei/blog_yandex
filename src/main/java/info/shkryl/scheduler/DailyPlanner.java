package info.shkryl.scheduler;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DailyPlanner {

    private final TaskService taskService;
    private final UtilityService utilityService;

    // Карта: дата → список задач
    private Map<LocalDate, List<Task>> schedule;
    private final Scanner scanner;

    public DailyPlanner() {
        this.taskService = new TaskService();
        this.utilityService = new UtilityService();
        this.schedule = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        DailyPlanner planner = new DailyPlanner();
        planner.run();
    }

    // Главный цикл программы
    public void run() {
        System.out.println("🎯 Добро пожаловать в Ежедневник!");

        while (true) {
            showMenu();
            int choice = utilityService.getChoice(scanner);

            switch (choice) {
                case 1:
                    taskService.addTask(scanner,schedule);
                    break;
                case 2:
                    taskService.viewTasks(scanner,schedule);
                    break;
                case 3:
                    taskService.deleteTask(scanner,schedule);
                    break;
                case 4:
                    System.out.println("До свидания!");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    // Показать меню
    private void showMenu() {
        System.out.println("\n--- Меню Ежедневника ---");
        System.out.println("1. Добавить задачу");
        System.out.println("2. Просмотреть задачи на дату");
        System.out.println("3. Удалить задачу");
        System.out.println("4. Выход");
        System.out.print("Выберите действие: ");
    }
}