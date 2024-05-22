package org.example.멋사10기.study;

import java.util.Objects;

public class Test {
    String name;
    String number;
    int year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return Objects.equals(number, test.number);
    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hashCode(number);
//    }


    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", year=" + year +
                '}';
    }
}
