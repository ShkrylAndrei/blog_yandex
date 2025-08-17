package info.shkryl.useException.exampleEight;

public class Main {
    public static void main(String[] args) {
        throw new InvalidEmailException("Exception");
    }
}

class InvalidEmailException extends RuntimeException {
    public InvalidEmailException(String message) {
        super(message);
    }
}
