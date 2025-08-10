package info.shkryl.scheduler;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class TaskService {

    private final UtilityService utilityService;

    public TaskService() {
        this.utilityService = new UtilityService();
    }

    public void addTask(Scanner scanner, Map<LocalDate, List<Task>> schedule) {
        System.out.print("Введите дату (ГГГГ-ММ-ДД): ");
        LocalDate date = utilityService.parseDate(scanner.nextLine());
        if (date == null) return;

        System.out.print("Введите время (ЧЧ:ММ): ");
        LocalTime time = utilityService.parseTime(scanner.nextLine());
        if (time == null) return;

        System.out.print("Введите описание задачи: ");
        String description = scanner.nextLine();

        // Получаем список задач на эту дату
        List<Task> tasks = schedule.get(date);
        if (tasks == null) {
            tasks = new ArrayList<>();
            schedule.put(date, tasks);
        }

        // Добавляем новую задачу
        tasks.add(new Task(description, time));

        // Сортируем по времени
        tasks.sort(Comparator.comparing(Task::getTime));

        System.out.println("Задача добавлена!");
    }

    public void deleteTask(Scanner scanner, Map<LocalDate, List<Task>> schedule) {
        System.out.print("Введите дату (ГГГГ-ММ-ДД): ");
        LocalDate date = utilityService.parseDate(scanner.nextLine());
        if (date == null) return;

        List<Task> tasks = schedule.get(date);
        if (tasks == null || tasks.isEmpty()) {
            System.out.println("На эту дату нет задач.");
            return;
        }
        System.out.println("Задачи на " + date + ":");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }

        System.out.print("Введите номер задачи для удаления: ");
        int number = utilityService.getChoice(scanner);
        if (number < 1 || number > tasks.size()) {
            System.out.println("Неверный номер.");
            return;
        }

        Task removed = tasks.remove(number - 1);
        System.out.println("Удалено: " + removed);
        // Если список пуст — можно удалить дату из Map
        if (tasks.isEmpty()) {
            schedule.remove(date);
        }
    }

    public void viewTasks(Scanner scanner, Map<LocalDate, List<Task>> schedule) {
        System.out.print("Введите дату (ГГГГ-ММ-ДД): ");
        LocalDate date = utilityService.parseDate(scanner.nextLine());
        if (date == null) return;

        List<Task> tasks = schedule.get(date);

        if (tasks == null || tasks.isEmpty()) {
            System.out.println("На " + date + " задач нет.");
        } else {
            System.out.println("\nЗадачи на " + date + ":");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}
