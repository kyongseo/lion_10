package org.example.day10;

public class NonGenericPair {

    private Object first;
    private Object second;

    public NonGenericPair(Object first, Object second) {
        this.first = first;
        this.second = second;
    }

    public Object getFirst() {
        return first;
    }

    public void setFirst(Object first) {
        this.first = first;
    }

    public Object getSecond() {
        return second;
    }

    public void setSecond(Object second) {
        this.second = second;
    }

    public static void main(String[] args) {
        NonGenericPair pair = new NonGenericPair("Hello",5);
        String first = (String) pair.getFirst(); // 형변환  필요
        int second = (Integer) pair.getSecond(); // 형변환 필요

        NonGenericPair pair2 = new NonGenericPair(1.2f,"Hi");
        Float firstFloat = (Float) pair2.getFirst();
        String firstString = (String) pair2.getSecond();
    }
}
