package info.shkryl.bankAccount.variantFirst;

public class BankAccountClassic {
    static class Account {
        private int balance = 10_000;
        private volatile int waitingThreads = 0;
        private final Object lock = new Object();

        public void operate(String threadName) throws InterruptedException {
            while (true) {
                synchronized (lock) {
                    // Проверка на завершение: все 3 потока ждут
                    if (waitingThreads == 3) {
                        System.out.println("Все потоки ожидают пополнения, но никто не может пополнить счёт. Завершение работы.");
                        return;
                    }

                    int amount = (int) (Math.random() * 5000) + 1;
                    boolean isDeposit = Math.random() < 0.5;

                    if (isDeposit) {
                        balance += amount;
                        System.out.printf("[%s] Пополнил счёт на %d. Баланс: %d%n", threadName, amount, balance);
                        lock.notifyAll(); // Пробуждаем всех, кто ждёт снятия
                    } else {
                        if (balance >= amount) {
                            balance -= amount;
                            System.out.printf("[%s] Снял %d. Баланс: %d%n", threadName, amount, balance);
                        } else {
                            System.out.printf("[%s] Недостаточно средств для снятия %d. Жду пополнения...%n", threadName, amount);
                            waitingThreads++;
                            try {
                                lock.wait(3000); // Ждём максимум 3 секунды
                            } finally {
                                waitingThreads--;
                            }
                            continue; // Повторяем попытку
                        }
                    }
                }
                Thread.sleep(200); // Небольшая пауза между операциями
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();

        Thread t1 = new Thread(() -> {
            try { account.operate("Поток-1"); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }, "Поток-1");

        Thread t2 = new Thread(() -> {
            try { account.operate("Поток-2"); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }, "Поток-2");

        Thread t3 = new Thread(() -> {
            try { account.operate("Поток-3"); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }, "Поток-3");

        t1.start();
        t2.start();
        t3.start();
        // Дожидаемся, пока хотя бы один поток не завершится (по условию завершения)
        Thread.sleep(10_000); // Максимальное время работы
        // Принудительно завершаем, если не завершились
        if (t1.isAlive() || t2.isAlive() || t3.isAlive()) {
            System.out.println("Программа завершена по таймауту.");
        }
    }
}
