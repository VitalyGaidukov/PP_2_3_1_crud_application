package web.dao;

import web.models.User;

import java.util.List;

public interface JpaUserDAO {
    List<User> getAllUsers();

    void saveUser(User user);

    User getUser(int id);

    void deleteUser(int id);
}

