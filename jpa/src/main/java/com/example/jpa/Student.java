package com.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter@Setter
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 데이터베이스의 ID 자동 생성 기능을 사용하여 기본 키를 생성
    // 이 전략은 데이터베이스가 자동 증가(auto-increment) 필드를 지원할 때 사용
    private Long id; // BigInt type

    @Column(nullable = false) // null 값 허용하지 않는다.
    private String name; // Varchar type

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    public Student(String name, School school) {
        this.school = school;
        this.name = name;
    }
}
