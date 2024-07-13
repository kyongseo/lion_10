package com.example.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserDao {
//    private EntityManagerFactory emf; // 엔티티 매니저를 생성하는 팩토리 역할, 하나만 생성

//    // 기본 생성자
//    public UserDao() {
//        emf = Persistence.createEntityManagerFactory("UserPU");
//    }
//
//    public void close(){
//        if(emf != null){
//            emf.close();
//        }
//    }

    //delete
    public void deleteUser(User user) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.contains(user)?user : em.merge(user));

            em.getTransaction().commit();

        }finally {
            em.close();
        }
    }

    // update
    public void updateUSer(User user) {
        EntityManager em = Persistence.createEntityManagerFactory("jpa").createEntityManager();
        try {
            em.getTransaction().begin();

            User findUser = em.find(User.class, user.getId());

            em.persist(user);

            em.getTransaction().commit();

        }finally {
            em.close();
        }
    }

    // find
    public User finduser(Long id) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            User user = em.find(User.class, id);
            em.close();
            return user;
        }finally {
            em.close();
        }
    }

    // create
    public void creatUser(User user){
//        EntityManager entityManager = emf.createEntityManager();

        //  createEntityManager() --> EntityManager 인스턴스 생성
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        try{
            entityManager.getTransaction().begin(); // 데이터베이스 트랜잭션을 시작

            entityManager.persist(user); // 등록 영속성 컨텍스트에 저장

            entityManager.getTransaction().commit(); // 변경사항을 데이터베이스에 반영하고 트랜잭션을 종료
        }finally {
            entityManager.close();
        }

    }
}
