package info.shkryl.hibernate.example3;

import info.shkryl.hibernate.example1.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateData {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        User user = session.find(User.class, 1L);
        if (user != null) {
            user.setEmail("new-email@example.com");
            session.merge(user); // можно и без этого — при commit() изменения сохранятся
        }

        tx.commit();
        session.close();
    }
}
