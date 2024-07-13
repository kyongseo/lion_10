package com.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonExamMain {

    public static void main(String[] args) {
        // find();
         create();
    }

    private static void find() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Person person = em.find(Person.class, 1L);

            log.info("Person: {}", person.getName());
            log.info("Passport: {}", person.getPassport().getPassportNumber());

            Passport passport = em.find(Passport.class, 1L);

            log.info("Person: {}", passport.getPerson().getName());
            log.info("Passport: {}", passport.getPassportNumber());

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }

    private static void create(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

        em.getTransaction().begin();

        try{

            Person person = new Person();
            person.setName("KyongSeo");
            Passport passport = new Passport();
            passport.setPassportNumber("123456");

            // 연관관계 설정
            passport.setPerson(person);
            person.setPassport(passport);

            em.persist(person);

            em.getTransaction().commit();

        } catch (Exception e){
            if(em.getTransaction().isActive())  em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    private static void update(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

        em.getTransaction().begin();

        try{

            Person person = em.find(Person.class, 1L);
            person.setName("New ks");

            em.getTransaction().commit();

        } catch (Exception e){
            if(em.getTransaction().isActive())  em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    private static void delete(){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

        em.getTransaction().begin();

        try{
//            Person person = em.find(Person.class, 1L);
//            em.remove(person);
            
            Passport passport = em.find(Passport.class, 2L);
            if (passport != null) {
                passport.getPerson().setPassport(null);
            }
            em.remove(passport);

            em.getTransaction().commit();

        } catch (Exception e){
            if(em.getTransaction().isActive())  em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
