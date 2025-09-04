package info.shkryl.hibernate.example9;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        // Получаем запрос по имени
        Query<Product> query = session.createNamedQuery("Product.findByCategory", Product.class);
        query.setParameter("cat", "Books");

        List<Product> books = query.list();

        for (Product p : books) {
            System.out.println(p.getName());
        }

        session.close();
    }
}
