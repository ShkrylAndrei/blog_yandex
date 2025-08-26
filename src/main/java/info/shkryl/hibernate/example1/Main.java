package info.shkryl.hibernate.example1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        // 1. Создаём SessionFactory (один раз)
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        // 2. Открываем Session
        Session session = sessionFactory.openSession();
        // 3. Начинаем транзакцию
        Transaction tx = session.beginTransaction();
        try {
            // 4. Работаем с данными
            User user = new User();
            user.setName("Анна");
            user.setEmail("anna@example.com");

            session.persist(user); // сохраняем объект

            // 5. Фиксируем изменения
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback(); // откат при ошибке
            e.printStackTrace();
        } finally {
            session.close(); // всегда закрываем!
        }
    }
}
