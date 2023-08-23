package web.test;

import org.springframework.beans.factory.annotation.Autowired;
import web.dao.JpaUserDAO;
import web.dao.JpaUserDAOImpl;
import web.models.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import javax.persistence.EntityManager;

public class Test {

    public static void main(String[] args) {
        JpaUserDAO userService = new JpaUserDAOImpl();

        User user = new User("Oleg", "Ivanov", "9-9-9-9-9","oleg@gmail.com");
        userService.saveUser(user);
        System.out.println(user);
    }
}
