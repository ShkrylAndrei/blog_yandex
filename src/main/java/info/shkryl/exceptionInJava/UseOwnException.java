package info.shkryl.exceptionInJava;

// Проверяемое исключение
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class UseOwnException {

    private int balance = 1000;
    // Использование
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Недостаточно средств на счёте");
        }
        balance -= amount;
    }
}
