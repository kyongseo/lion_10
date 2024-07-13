package hello.filter.filterexam4.service;

import hello.filter.filterexam4.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
@Rollback(value = false)
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void registerUser() {
        User user = new User();
        user.setName("ks");
        user.setPassword("1234");
        user.setUsername("ks");
        user.setEmail("ks@gmail.com");

        User user1 = userService.register(user);

        assertNotNull(user1.getId());
    }

}