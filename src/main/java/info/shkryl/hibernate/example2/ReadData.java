package info.shkryl.hibernate.example2;

import info.shkryl.hibernate.example1.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadData {
    public static void main(String[] args) {
        // 1. Создаём SessionFactory (один раз)
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        // 2. Открываем Session
        Session session = sessionFactory.openSession();

        User user = session.find(User.class, 1L);

        if (user != null) {
            System.out.println("Найден: " + user.getName());
        }
        session.close();
    }
}
