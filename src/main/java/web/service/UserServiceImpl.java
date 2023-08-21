package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.JpaUserDAO;
import web.models.User;


import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService{

    private JpaUserDAO jpaUserDAO;

    public UserServiceImpl() {
    }

    public UserServiceImpl(JpaUserDAO jpaUserDAO) {
        this.jpaUserDAO = jpaUserDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return jpaUserDAO.getAllUsers();
    }

    @Override
    public void saveUser(User user) {
        jpaUserDAO.saveUser(user);
    }

    @Override
    public User getUser(int id) {
        return jpaUserDAO.getUser(id);
    }

    @Override
    public void deleteUser(int id) {
        jpaUserDAO.deleteUser(id);
    }
}
