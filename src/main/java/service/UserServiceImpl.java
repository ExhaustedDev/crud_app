package service;

import dao.UserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(@Autowired UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> readUsers() {
        return userDao.readUsers();
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void removeUser(User user) {
        userDao.removeUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserById(Long id) {
        return userDao.findUserById(id);
    }
}
