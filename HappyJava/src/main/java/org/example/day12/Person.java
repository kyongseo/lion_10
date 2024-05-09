package org.example.day12;

import java.io.Serializable;

// 객체 직렬화 => 바이트 형태로 데이터 변환: 직렬화
// 바이트로 변환된 데이터를 다시 객체로 변환: 역직렬화
// Serializable 인터페이스를 상속받은 클래스는 직렬화될 수 있는 자격을 가진다.
public class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
