package org.example.day10;

import org.example.day09.InnerClass.Book;

public class GenericPair <T1, T2> {
    private T1 first;
    private T2 second;

    public GenericPair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst(){
        return first;
    }

    public void setFirst(T1 first){
        this.first = first;
    }

    public T2 getSecond(){
        return second;
    }

    public void setSecond(T2 second){
        this.second = second;
    }

    public static void main(String[] args) {
        GenericPair<String, Integer> pair = new GenericPair<>("hello",4);
        String first = pair.getFirst();
        int second = pair.getSecond();

        GenericPair<Book, String> pair2 = new GenericPair<Book, String>(new Book("java"), "이길상");
        Book book = pair2.getFirst();
        String name = pair2.getSecond();
    }
}
