package info.shkryl.priorityQueue.example2;

import java.util.PriorityQueue;

public class TaskScheduler {

    public static void main(String[] args) {
        // Очередь задач: сначала выполняем самые короткие
        PriorityQueue<Integer> tasks = new PriorityQueue<>(); // min-heap
        tasks.add(5); // задача на 5 минут
        tasks.add(2);
        tasks.add(8);
        tasks.add(1);
        tasks.add(4);

        int totalTime = 0;
        int waitingTime = 0;

        System.out.println("Выполнение задач:");
        while (!tasks.isEmpty()) {
            int task = tasks.poll();
            waitingTime += totalTime; // время ожидания = сумма времени предыдущих задач
            totalTime += task;
            System.out.println("Выполнена задача за " + task + " мин");
        }

        System.out.println("Общее время ожидания: " + waitingTime + " мин");
    }
}
