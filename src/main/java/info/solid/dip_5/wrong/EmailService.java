package info.solid.dip_5.wrong;

public class EmailService {
    public void send(String message) {
        System.out.println("Отправка email: " + message);
    }
}

class Notification {
    private EmailService emailService = new EmailService(); // Жёсткая зависимость

    public void alert(String message) {
        emailService.send(message);
    }
}
