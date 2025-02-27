package org.example.day11.도서관리시스템;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int year;


    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.year = publicationYear;
    }

    public int getYear() {// get으로 입력받은 year를 리턴할거
        return this.year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }
}
