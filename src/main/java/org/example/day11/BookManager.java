package org.example.day11;

import java.util.*;

public class BookManager {
    Set<Book> books = new HashSet<>();

    public void addBook(Book book){
        if(books.add(book)) {
            System.out.println(book.toString() + " 도서를 추가합니다.");
        } else {
            System.out.println("이미 존재하는 도서입니다.");
        }
    }

    public void removeBook(Book book){
        System.out.println("---------------------------------------------------------------");
        if(books.remove(book)) {
            System.out.println(book.toString() + " 도서를 삭제합니다.");
        } else {
            System.out.println("해당 도서는 존재하지 않습니다.");
        }
    }

    public void displayBooks(){
        System.out.println("---------------------------------------------------------------");
        System.out.println("도서 목록");
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    public void sortBooksByYear(){
        System.out.println("---------------------------------------------------------------");
        System.out.println("출판년도 기준 오름차순 정렬합니다.");

        // set -> list
        ArrayList<Book> list = new ArrayList<>(books);

        // 기본타입이나 String 타입이 아니라, 사용자 정의 클래스 타입이기 때문에 직접 Comparator 인터페이스를 구현해야함
        list.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                // 결과가 음수인 경우 'o1'이 'o2'보다 먼저 온다는 의미
                // 결과가 양수인 경우 'o2'가 'o1'보다 먼저 온다는 의미
                // 결과가 0인 경우 순서는 변경 X
                return o1.getYear() - o2.getYear();
            }
        });

        for (Book book : list) {
            System.out.println(book.toString());
        }
    }
}