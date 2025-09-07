package info.shkryl.springPlusHibernate.example1.service;

import info.shkryl.springPlusHibernate.example1.dao.UserDao;
import info.shkryl.springPlusHibernate.example1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    // Эта операция будет в одной транзакции
    @Transactional
    public void createUserAndList() {
        User user = new User("Alice", "alice@example.com");
        userDao.save(user);

        // Допустим, тут ошибка — тогда вся транзакция откатится
        System.out.println("Сохранён пользователь: " + user);

        List<User> users = userDao.findAll();
        users.forEach(System.out::println);
    }

    @Transactional
    public void bulkInsert() {
        userDao.save(new User("Bob", "bob@example.com"));
        userDao.save(new User("Charlie", "charlie@example.com"));
        userDao.save(new User("Diana", "diana@example.com"));
        // Если где-то ошибка — всё откатится
    }
}
