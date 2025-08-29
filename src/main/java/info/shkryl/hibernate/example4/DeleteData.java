package info.shkryl.hibernate.example4;

import info.shkryl.hibernate.example1.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteData {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        User user = session.find(User.class, 1L);
        if (user != null) {
            session.remove(user);
        }

        tx.commit();
        session.close();
    }
}
