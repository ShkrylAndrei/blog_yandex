package info.shkryl.useException.exampleSeven;

public class Main {
    public static void main(String[] args) throws InsufficientFundsException {
        throw new InsufficientFundsException("Exception");
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
