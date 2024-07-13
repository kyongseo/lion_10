package hello.filter.filterexam4.repository;

import hello.filter.filterexam4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // id는 의미없는 값이니깐 username으로 찾아오는 메서드 필요

    User findByUsername(String username);
}
