package org.example.jdbc01;

import com.mysql.cj.result.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.List;

@SpringBootApplication
public class SpringJDBCApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringJDBCApplication.class, args);
    }

//    @Autowired
//    JdbcTemplate jdbcTemplate;

    @Bean
    public CommandLineRunner demo(JdbcTemplate jdbcTemplate) {
        return args -> {
            // user 입력
            String sql ="Insert into users(name, email) values(?,?)";
            jdbcTemplate.update(sql, "park","park@gamil.com");

            // read
            //RowMapper 를 이용해야하는 이유는 결과값을 담을 때 테이블의 컬럼과 User class 의 필드를 직접 매칭해주는 것
            // -> 테이블의 컬럼과 클래스의 필드가 완전히 일치하다면? 직접할 필요 xx
            // => BeanPropertyRowMapper 사용

//            List<User> users = jdbcTemplate.query("Select id, name, email from users", new BeanPropertyRowMapper<>(User.class));

//            for (User user : users) {
//                System.out.println(user);
//            } => 1

//            users.forEach(System.out::println); => 2

            RowMapper<User> rowMapper = (ResultSet rs, int rowNum) -> new User(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("email")
            );

            List<User> users = jdbcTemplate.query("select * from users", rowMapper);
            users.forEach(System.out::println); // =>2
            //users.forEach(user -> System.out.println(user)); -> toString 정의 되었을 때.. =>3 다 동일


        };
    }
}
