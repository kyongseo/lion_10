package com.example.jpa;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * 싱글톤 규칙
 */
public class JPAUtil {

    private JPAUtil(){}

    private static final EntityManagerFactory emfInstance =
            Persistence.createEntityManagerFactory("UserPU");

    public static EntityManagerFactory getEntityManagerFactory() {
        return emfInstance;
    }

    // 어플리케이션이 종료될때 자동으로 close() 메서드가 호출되도록 구현
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (emfInstance != null) {
                System.out.println("-------------------------emf close--------------------");
                emfInstance.close();
            }
        }));
    }
}
