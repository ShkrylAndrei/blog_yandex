package info.shkryl.priorityQueue.example1;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HospitalQueue {
    public static void main(String[] args) {
        // Создаём очередь с приоритетом: чем меньше число — тем выше приоритет
        PriorityQueue<Patient> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.priority));

        // Добавляем пациентов
        queue.add(new Patient("Иван", 3));
        queue.add(new Patient("Мария", 1)); // критический
        queue.add(new Patient("Сергей", 4));
        queue.add(new Patient("Анна", 1)); // тоже критический

        // Обслуживаем
        System.out.println("Очередь на приём:");
        while (!queue.isEmpty()) {
            System.out.println("Приём: " + queue.poll());
        }
    }
}
