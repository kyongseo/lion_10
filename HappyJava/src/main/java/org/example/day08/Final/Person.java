package org.example.day08.Final;

// final 필드
public class Person {
    // 식별 번호 => final 로 선언되어 있어, 객체 생성 시에만 설정되며 이후에는 변경할 수 없습니다
    private final int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
