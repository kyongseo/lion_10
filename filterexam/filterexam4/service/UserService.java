package hello.filter.filterexam4.service;

import hello.filter.filterexam4.entity.Role;
import hello.filter.filterexam4.entity.User;
import hello.filter.filterexam4.repository.RoleRepository;
import hello.filter.filterexam4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    //회원가입
    @Transactional(readOnly = false)
    public User register(User user) {
        //회원가입을 위해서 Role 을 알아와서 Role 정보를 같이 넣어줘야 한다.
        //이 메서드를 통해 회원가입하는 회원은 일반 회원이라고 가정하고 Role_User 로 Role 을 얻어와서 저장해보자.
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(Collections.singleton(userRole));

        return userRepository.save(user);
    }


    //회원정보 보기 -- 사용자 확인
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
