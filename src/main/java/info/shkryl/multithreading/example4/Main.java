package info.shkryl.multithreading.example4;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Поток прерван. Завершаюсь...");
                    return;
                }
                System.out.println("Работаю: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Сон прерван!");
                    Thread.currentThread().interrupt(); // восстанавливаем флаг
                    return;
                }
            }
        });

        worker.start();
        Thread.sleep(500);
        worker.interrupt(); // отправляем сигнал
    }
}
