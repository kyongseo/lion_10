package org.example.day11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age; // 나이를 기준으로 오름차순
       // return this.name.compareTo(o.name); // 이름
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();

        list.add(new Person("kang", 30));
        list.add(new Person("kim", 20));
        list.add(new Person("hong", 40));

        Collections.sort(list);

        for (Person person : list) {
            System.out.println(person);
        }
    }
}
