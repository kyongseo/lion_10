package org.example.springjdbc08;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    // 입력이 되면 자동으로 생성된 pk 값을 리턴 받고 싶어서..
    //SimpleJdbcInsert

    private SimpleJdbcInsert simpleJdbcInsert;

    @PostConstruct
    public void init(){
        simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("users").usingGeneratedKeyColumns("id");
    }

    public User insertUser(User user){

        Map<String, Object> params = new HashMap<>();
        params.put("name", user.getName());
        params.put("email", user.getEmail());
        // 컬럼명

        Number pk = simpleJdbcInsert.executeAndReturnKey(params);
        user.setId(pk.longValue());

        return user;
    }
}
