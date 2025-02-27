package org.example.springjdbc06;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringJdbc06Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringJdbc06Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserDao userDao) {
        return args -> {
            User user = new User(null,"Esther","esther@gamil.com");
            userDao.insertUser(user);

            System.out.println("user 입력 성공");
        };
    }
}
