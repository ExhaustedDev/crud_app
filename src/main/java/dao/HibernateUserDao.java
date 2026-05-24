package dao;

import model.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Primary
@Repository
public class HibernateUserDao implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> readUsers() {
        TypedQuery<User> users = entityManager.createQuery("from User u", User.class);

        return users.getResultList();
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void removeUser(User user) {
        if (user == null) {
            return;
        }

        User foundUser = entityManager.find(User.class, user.getId());

        if (foundUser != null) {
            entityManager.remove(foundUser);
        }
    }

    @Override
    public User findUserById(Long id) {
        return entityManager.find(User.class, id);
    }

}
