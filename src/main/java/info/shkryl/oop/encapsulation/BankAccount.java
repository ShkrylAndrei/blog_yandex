package info.shkryl.oop.encapsulation;

public class BankAccount {
    private double balance; // приватное поле — нельзя изменить напрямую

    public void deposit(double amount) {
            balance += amount;
            System.out.println("Пополнено на: " + amount);
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit(1000);
        System.out.println(account.getBalance()); // 1000.0
        // account.balance = -5000; — ОШИБКА! Поле приватное
    }
}