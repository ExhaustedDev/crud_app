package dao;

import model.User;

import java.util.List;

public interface UserDao {
    void createUser(User user);
    List<User> readUsers();
    void updateUser(User user);
    void removeUser(User user);
    User findUserById(Long id);
}
