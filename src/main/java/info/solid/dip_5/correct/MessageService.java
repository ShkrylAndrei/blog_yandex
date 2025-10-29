package info.solid.dip_5.correct;

public interface MessageService {
    void sendMessage(String message);
}

class EmailService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Email: " + message);
    }
}

class SMSService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("SMS: " + message);
    }
}

class Notification {
    private final MessageService service;

    public Notification(MessageService service) {
        this.service = service; // Внедрение зависимости
    }

    public void alert(String message) {
        service.sendMessage(message);
    }
}
