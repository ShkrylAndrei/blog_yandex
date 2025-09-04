package info.shkryl.hibernate.example8;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainUpdatePrice {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        String hql = "UPDATE Product SET price = price * 1.1 WHERE category = :category";
        Query query = session.createQuery(hql);
        query.setParameter("category", "Electronics");

        int updatedCount = query.executeUpdate(); // важно: executeUpdate()!
        System.out.println("Обновлено записей: " + updatedCount);

        tx.commit();
    }
}
