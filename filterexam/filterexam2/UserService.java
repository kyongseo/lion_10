package hello.filter.filterexam2;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void list(){
        User user = UserContext.getUser();

        // user 의 유무에 따라서 비즈니스가 처리 될 수 있음
        System.out.println(user);
    }
}
