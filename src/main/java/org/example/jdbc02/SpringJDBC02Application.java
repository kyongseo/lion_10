package org.example.jdbc02;

import org.example.jdbc02.dao.User;
import org.example.jdbc02.dao.UserDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;

@SpringBootApplication
public class SpringJDBC02Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringJDBC02Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserDao userDao) {
        return args -> {
            // insert
            userDao.insertUser(new User(null, "lee","lee@gmail.com"));

            //update
            //userDao.updateUserEmail("hong","new.hong@gmail.com");
            // delete
//            userDao.deleteUser("hong");
//
//            //read
//            List<User> users = userDao.findAllUsers();
//            for (User user : users) {
//                System.out.println(user.getName() + " " + user.getEmail());
//            }


        };

    }
}
