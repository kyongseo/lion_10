package org.example.jdbc02.dao;

import com.mysql.cj.protocol.Resultset;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@RequiredArgsConstructor // final 이 붙은 아이들만 생성자를 기본으로 만들어준다.
@Repository
public class UserDaoImpl implements UserDao{
    //JDBCTemplate 객체 이용해서 구현
    //필드 기반
//    @Autowired
    private final JdbcTemplate jdbcTemplate;

    // 생성자 기반
//    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    //설정자 기반
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }


    @Override
    public void insertUser(User user) {
        String sql = "insert into users(name, email) values(?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getEmail());
    }

    @Override
    public List<User> findAllUsers() {
//        List users = jdbcTemplate.query("select * from users", new BeanPropertyRowMapper<>(User.class));
//        return users;
//    }
//        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);

        RowMapper<User> rowMapper = (ResultSet rs, int rowNum) -> new User(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("email")
        );
        return jdbcTemplate.query("select * from users", rowMapper);
    }

    @Override
    public void updateUserEmail(String name, String email) {
        jdbcTemplate.update("update users set email = ? where name = ?", email, name);
    }

    @Override
    public void deleteUser(String name) {
        jdbcTemplate.update("delete from users where name = ?", name);
    }
}
