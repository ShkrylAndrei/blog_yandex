package info.shkryl.hibernate.example10;

import info.shkryl.hibernate.example9.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        String hql = "FROM Product ORDER BY name";
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query<Product> query = session.createQuery(hql, Product.class);

        int page = 2;
        int pageSize = 10;

        // Пропустить (page - 1) * pageSize записей
        query.setFirstResult((page - 1) * pageSize);
        // Максимум pageSize записей
        query.setMaxResults(pageSize);

        List<Product> products = query.list();
    }
}
