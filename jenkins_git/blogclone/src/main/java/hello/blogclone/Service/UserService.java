package hello.blogclone.Service;

import hello.blogclone.domain.Role;
import hello.blogclone.domain.RoleName;
import hello.blogclone.domain.User;
import hello.blogclone.repository.RoleRepository;
import hello.blogclone.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @PostConstruct
    public void init() {
        //초기 관리자 계정 생성
        if (!userRepository.findByUserName("admin").isPresent()) {
            User adminUser = new User();
            adminUser.setUserName("admin");
            adminUser.setPassword("1111");
            adminUser.setEmail("admin@gmail.com");
            adminUser.setUserNick("관리자");
            adminUser.setRegistrationDate(LocalDate.now());
            adminUser.addRole(roleRepository.findByRoleName(RoleName.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Role not found")));
            userRepository.save(adminUser);
        }
    }

    public User registerUser(String username, String email, String password, String usernick) {
        User user = new User();
        user.setUserName(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setUserNick(usernick);
        user.setRegistrationDate(LocalDate.now());
        user.addRole(roleRepository.findByRoleName(RoleName.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Role not found")));
        return userRepository.save(user);
    }


    public Optional<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    //사용자 있나없나
    public boolean validateUser(String username, String password) {
        Optional<User> userOptional = userRepository.findByUserName(username);
        return userOptional.isPresent() && userOptional.get().getPassword().equals(password);
    }
}