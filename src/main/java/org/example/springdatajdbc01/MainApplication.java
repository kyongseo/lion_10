package org.example.springdatajdbc01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository userRepository) {
        return args -> {
//            userRepository.save(new User("myks", "myks@gmaol.com"));
//
//            User user = userRepository.findById(12L).get();
//            System.out.println(user.getName());
//
//            //System.out.println(userRepository.findByName("myks"));
//            List<User> users = userRepository.findByName("park");
//            users.forEach(u -> System.out.println(u.getName()));

            PageRequest pageRequest = PageRequest.of(0, 3);
            Page<User> allUser = userRepository.findAllUsersWithPagination(pageRequest);

            allUser.forEach(user -> System.out.println(user.getName()+", "+ user.getEmail()));
        };
    }
}
