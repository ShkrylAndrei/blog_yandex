package info.shkryl.atm;

public class ATM {

    // Данные пользователей: [id][0=PIN, 1=баланс]
    private static int[][] accounts = {
            {1, 1234, 5000},  // id=1, PIN=1234, баланс=5000
            {2, 5678, 3000},  // id=2, PIN=5678, баланс=3000
            {3, 0000, 10000}  // id=3, PIN=0000, баланс=10000
    };

    private static int currentAccountId = -1; // -1 = не авторизован

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в банкомат!");

        int pin = getInput("Введите ваш PIN-код: ");
        if (authenticate(pin)) {
            showMenu();
        } else {
            System.out.println("Неверный PIN-код. Доступ запрещён.");
        }
    }

    /**
     * Проверка PIN-кода
     */
    private static boolean authenticate(int pin) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i][1] == pin) {
                currentAccountId = i;
                System.out.println("Добро пожаловать, пользователь " + accounts[i][0] + "!");
                return true;
            }
        }
        return false;
    }

    /**
     * Отображение меню
     */
    private static void showMenu() {
        while (true) {
            System.out.println("\n--- Меню ---");
            System.out.println("1. Просмотр баланса");
            System.out.println("2. Снятие денег");
            System.out.println("3. Пополнение счёта");
            System.out.println("4. Выход");
            int choice = getInput("Выберите действие: ");

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    System.out.println("Спасибо за использование банкомата. До свидания!");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    /**
     * Просмотр баланса
     */
    private static void checkBalance() {
        int balance = accounts[currentAccountId][2];
        System.out.println("Ваш баланс: " + balance + " руб.");
    }

    /**
     * Снятие денег
     */
    private static void withdraw() {
        int amount = getInput("Введите сумму для снятия: ");
        int balance = accounts[currentAccountId][2];

        if (amount <= 0) {
            System.out.println("Сумма должна быть больше нуля.");
        } else if (amount > balance) {
            System.out.println("Недостаточно средств.");
        } else {
            accounts[currentAccountId][2] -= amount;
            System.out.println("Успешно снято " + amount + " руб. Остаток: " + accounts[currentAccountId][2]);
        }
    }

    /**
     * Пополнение счёта
     */
    private static void deposit() {
        int amount = getInput("Введите сумму для пополнения: ");

        if (amount <= 0) {
            System.out.println("Сумма должна быть больше нуля.");
        } else {
            accounts[currentAccountId][2] += amount;
            System.out.println("Счёт пополнен на " + amount + " руб. Новый баланс: " + accounts[currentAccountId][2]);
        }
    }

    /**
     * Ввод с консоли
     */
    private static int getInput(String prompt) {
        System.out.print(prompt);
        try {
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Ошибка ввода, возвращаем 0");
            return 0;
        }
    }
}
