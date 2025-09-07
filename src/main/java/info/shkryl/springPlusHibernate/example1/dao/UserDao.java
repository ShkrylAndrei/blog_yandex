package info.shkryl.springPlusHibernate.example1.dao;

import info.shkryl.springPlusHibernate.example1.entity.User;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    private final HibernateTemplate hibernateTemplate;

    // Spring автоматически внедрит HibernateTemplate
    public UserDao(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public void save(User user) {
        hibernateTemplate.save(user);
    }

    public User findById(Long id) {
        return hibernateTemplate.get(User.class, id);
    }

    public List<User> findAll() {
        return (List<User>) hibernateTemplate.find("FROM User");
    }

    public void update(User user) {
        hibernateTemplate.update(user);
    }

    public void delete(User user) {
        hibernateTemplate.delete(user);
    }
}
