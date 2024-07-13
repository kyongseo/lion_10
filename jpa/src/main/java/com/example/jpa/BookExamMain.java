package com.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BookExamMain {
    public static void main(String[] args) {
        //  create();
        // read();
       delete();
        //  find();
        //   update();

    }

    public static void find() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try {
            Author author = em.find(Author.class, 1L);
            log.info("Author: {}", author.getName());

            for (Book book : author.getBooks()) {
                log.info("Book Title: {}", book.getTitle());
            }

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    private static void create(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Author author = new Author("박경서");
            Book book = new Book("ks_Book", author);

            author.getBooks().add(book);
            em.persist(author);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    private static void read(){
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Author author = em.find(Author.class, 1L);
            log.info("author : {}",author.getName());
            Book book = em.find(Book.class, 1L);
            log.info("book Name : {}",book.getTitle());
        }finally {
            em.close();
        }
    }

    private static void update(){
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            Book book = em.find(Book.class, 4L);
            book.setTitle("newParkBook");
            log.info("book Name : {}", book.getTitle());
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    private static void delete(){
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            em.remove(em.find(Book.class, 4L));
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
}