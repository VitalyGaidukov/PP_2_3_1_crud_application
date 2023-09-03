package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.JpaUserDAO;
import web.dao.JpaUserDAOImpl;
import web.models.User;


import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final JpaUserDAO jpaUserDAO;

    @Autowired
    public UserServiceImpl(JpaUserDAO jpaUserDAO) {
        this.jpaUserDAO = jpaUserDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return jpaUserDAO.getAllUsers();
    }

    @Override
    public void saveUser(User user) {
        jpaUserDAO.saveUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(int id) {
        return jpaUserDAO.getUser(id);
    }

    @Override
    public void deleteUser(int id) {
        jpaUserDAO.deleteUser(id);
    }

    @Override
    public void updateUser(User user) {
        jpaUserDAO.updateUser(user);
    }
}
