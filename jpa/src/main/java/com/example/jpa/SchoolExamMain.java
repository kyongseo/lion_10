package com.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SchoolExamMain {
    private static void find(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
//            School school = em.find(School.class, 1L);
//            log.info("School Name : {}",school.getName());
//
//            for (Student student : school.getStudents()) {
//                log.info("Student name : {}",student.getName());
//            }

            Student student = em.find(Student.class, 5L);
            log.info("stduent name : "+ student.getName());
            log.info("School name : {}",student.getSchool().getName());
        }finally {
            em.close();
        }
    }
    private static void create(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            School school = new School("like school");

            Student student1 = new Student("강경미",school);
            Student student2 = new Student("이나연", school);
            Student student3 = new Student("한승균", school);

            school.getStudents().add(student1);
            school.getStudents().add(student2);
            school.getStudents().add(student3);

            em.persist(school);

            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    private static void update(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            School school = em.find(School.class,2L);
            school.setName("update School Name");

            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    private static void delete(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try{
            School school = em.find(School.class, 1L);
            em.remove(school);

            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    public static void main(String[] args) {
//       find();
//        create();
//        update();
        delete();

    }
}
