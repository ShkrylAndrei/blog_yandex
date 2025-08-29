package info.shkryl.hibernate.example5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        UserProfile profile = new UserProfile();
        profile.setPhone("+7 999 111-11-11");

        UserOfSystem user = new UserOfSystem();
        user.setName("Борис");
        user.setProfile(profile);

        session.merge(user); // профиль тоже сохранится!

        tx.commit();
        session.close();
    }
}
