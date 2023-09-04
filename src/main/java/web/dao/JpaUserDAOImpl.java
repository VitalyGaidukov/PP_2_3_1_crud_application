package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;


@Repository
public class JpaUserDAOImpl implements JpaUserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        Query queue = entityManager.createQuery("delete from User u where u.id =:id");
        queue.setParameter("id", id);
        queue.executeUpdate();
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }
}