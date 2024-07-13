package com.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeExamMain {
    public static void main(String[] args) {
     //find();
        create();
        //update();
      //  delete();
    }

    private static void find() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {

            Project project = em.find(Project.class,1L);
            log.info("Project Name : {}", project.getClass());
            log.info("Project Name : {}", project.getName());


            em.getTransaction().commit();
        }catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }finally {
            em.close();
        }
    }

    /**
     * 영속성 컨텍스트 안에는 1차캐시 말고도, “쓰기 지연 sql 저장소”가 있음.
     * .persist()하면, jpa가 엔티티를 분석을 해서 “쓰기 지연 sql 저장소”에다가 쿼리문을 보관해 놓음
     * 차곡 차곡 여기다가 쿼리문을 저장해 놓음
     * 이 쿼리가 언제 날라가냐? --> Transaction.commit()할 때. --> 플러쉬라고 함 이 때 실제 db에 커밋됨
     * 쿼리를 모았다가 디비에 한방에 보내는 것
     */
    private static void create() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {

            Employee employee = new Employee();
            employee.setName("park");

            Project project = new Project();
            project.setName("Like lion");

            employee.getProjects().add(project);
            project.getEmployees().add(employee);

            // .persist()하면, jpa가 엔티티를 분석을 해서 “쓰기 지연 sql 저장소”에다가 쿼리문을 보관해 놓음
            em.persist(employee);
            em.persist(project);

            // 이 쿼리가 언제 날라가냐? --> Transaction.commit()할 때. --> 플러쉬라고 함 이 때 실제 db에 커밋됨
            em.getTransaction().commit();

        }catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }finally {
            em.close();
        }
    }

    /**
     * commit()을 하면 flush()가 호출
     * 엔티티와 스냅샷을 비교함
     * db 에서 가져오든 해서 최초로 영속성 컨텍스트에 들어온 상태를 스냅샷을 띄워 둠
     * 비교를 해보고 어 memberA가 바꼈네? 하면 쓰기 지연 SQL 저장소에다가 UPDATE 쿼리를 저장해 두고, 이걸 DB에 날려줌
     */
    private static void update() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try {
            Employee employee = em.find(Employee.class, 1L);
            employee.setName("KyongSeo");

            // 1번 사원이 2번 프로젝트에서 빠지게 하고 싶다면?
            Project project = em.find(Project.class, 2L);
            project.getEmployees().remove(employee);


            em.getTransaction().commit(); // commit()을 하면 flush()가 호출
            // db 에서 가져오든 해서 최초로 영속성 컨텍스트에 들어온 상태를 스냅샷을 띄워 둠

        }catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }finally {
            em.close();
        }
    }

    /**
     * Em.remove() 하면 delete 쿼리 생성
     * 커밋 시점에 날라감
     * jpa는 값을 바꾸면 트랜잭션 커밋 시점에 알아서 업데이트 쿼리가 날아가는 구나. 라고 생각하고, 따로 persist()를 안하는게 정답임.
     */
    private static void delete() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {

            Employee employee = em.find(Employee.class, 3L);
            em.remove(employee);

//            Project project = em.find(Project.class, 3L);
//            project.getEmployees().remove(employee);

            em.getTransaction().commit();

        }catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }finally {
            em.close();
        }
    }
}
