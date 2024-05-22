package org.example.springjdbc05;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
public class SpringJdbc05Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringJdbc05Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(JdbcTemplate jdbcTemplate){
        return args -> {
            String sql = "Select id, name, email from users";
            User user = jdbcTemplate.query(sql, new UserResultSetExtractor());
            System.out.println(user);
        };
    }

    private static class UserResultSetExtractor implements ResultSetExtractor<User> {
        // ResultSetExtractor -> 결과 집합 전체를 단일 객체 하나로 변환하는데 사용됨
        // 여러 테이블에서 조인된 결과를 받아서 하나의 복합 객체로 매핑
        // -> 특정 조건에 떠러 다양한 타입의 객체를 리스트에 추가할 때 사용 가능
        @Override
        public User extractData(ResultSet rs) throws SQLException, DataAccessException {

            User user = new User();
            if(rs.next()) {
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));

                // List<Role>
            }

            return user;
        }
    }
}
