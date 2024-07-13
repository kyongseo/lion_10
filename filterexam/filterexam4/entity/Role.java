package hello.filter.filterexam4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter @Setter
public class Role {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // 롤을 통해서 user 정보를 알아볼 필요가 있을까..?
    // --> 아니다
}
