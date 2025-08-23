package info.shkryl.multithreading.example2;

public class Main {
    public static void main(String[] args) {
        // Способ 2: Интерфейс (лучше!)
        Runnable task = () -> System.out.println("Я — задача!");

        new MyThread().start();
        new Thread(task).start();
    }
}

// Способ 1: Наследование
class MyThread extends Thread {
    public void run() {
        System.out.println("Я — поток!");
    }
}


