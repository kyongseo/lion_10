package org.example.jdbc01;

import lombok.*;

/**
 * Lombok : 롬복에서 생성자, getter 메서드 등 지원해줌
 */
@AllArgsConstructor // 생성자(3개)
@Getter
@ToString
@NoArgsConstructor // default 생성자
@Setter
public class User {
    private Long id;
    private String name;
    private String email;

//    public User(Long id, String name, String email) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//
//    public String getEmail() {
//        return email;
//    }
}
