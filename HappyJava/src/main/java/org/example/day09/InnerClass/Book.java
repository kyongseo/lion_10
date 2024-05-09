package org.example.day09.InnerClass;

import java.util.Scanner;

public class Book {
    private String title;
   private Author author;

    public Book(String title) {
        this.title = title;
        this.author = new Author();
    }

    public String getAuthorName() {
        return author.getName();
    }

    public void setAuthorName(String name) {
        author.setName(name);
    }

    public void print(){
        System.out.println("Boot title : " + title);
        System.out.println("Author name : " + getAuthorName());

    }

    public class Author{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Book book = new Book("Hello Java");
        book.setAuthorName("John Doe");
        book.print();
    }
}
