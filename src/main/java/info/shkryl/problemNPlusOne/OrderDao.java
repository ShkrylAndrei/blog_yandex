package info.shkryl.problemNPlusOne;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class OrderDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Order> findAllOrders() {
        return entityManager.createQuery("SELECT o FROM Order o", Order.class)
                .getResultList();
    }
}
