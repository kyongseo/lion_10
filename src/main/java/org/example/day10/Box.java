package org.example.day10;

public class Box <V> {

    private V value;

    public Box(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Box<String> stringBox = new Box<>("hello");
        String value = stringBox.getValue();

        System.out.println(value);

        Box<Integer> integerBox = new Box<>(110);
        int intvalue = integerBox.getValue();

        System.out.println(intvalue);
    }
}
