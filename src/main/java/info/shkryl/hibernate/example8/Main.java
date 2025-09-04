package info.shkryl.hibernate.example8;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        // HQL: ищем продукты дороже 100
        String hql = "FROM Product WHERE price > :minPrice";
        Query<Product> query = session.createQuery(hql, Product.class);

        // Устанавливаем параметр
        query.setParameter("minPrice", 100.0);

        // Выполняем запрос
        List<Product> products = query.list();

        for (Product p : products) {
            System.out.println(p.getName() + " — " + p.getPrice());
        }
        session.close();
    }
}
