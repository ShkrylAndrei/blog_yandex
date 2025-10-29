package info.solid.srp_1.correct;

import info.solid.srp_1.dto.Order;

public class OrderProcessor {
    private final OrderRepository repository;
    private final NotificationService notificationService;

    public OrderProcessor(OrderRepository repository, NotificationService notificationService) {
        this.repository = repository;
        this.notificationService = notificationService;
    }

    public void processOrder(Order order) {
        // Логика обработки
        repository.save(order);
        notificationService.sendNotification(order.getCustomerEmail(), "Заказ принят");
    }
}

class OrderRepository {
    public void save(Order order) {
        // Сохранение в БД или файл
    }
}

class NotificationService {
    public void sendNotification(String email, String message) {
        // Отправка email
    }
}
