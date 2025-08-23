package info.shkryl.multithreading.example1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Главный поток: " + Thread.currentThread().getName());

        Thread worker = new Thread(() -> {
            System.out.println("Работаю в потоке: " + Thread.currentThread().getName());
        });
        worker.start(); // запускает поток
    }
}
