package info.shkryl.problemNPlusOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    public void printOrdersWithItems() {
        List<Order> orders = orderDao.findAllOrders(); // ← 1 запрос

        for (Order order : orders) {
            System.out.println("Order: " + order.getCustomerName());
            // При первом обращении к items — Hibernate делает запрос в БД!
            for (OrderItem item : order.getItems()) { // ← N запросов!
                System.out.println("  - " + item.getProductName());
            }
        }
    }
}
