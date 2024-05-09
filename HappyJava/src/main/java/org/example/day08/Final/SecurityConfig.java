package org.example.day08.Final;

/**
 * final 클래스
 */
public final class SecurityConfig {
    private static final String ENCRYPTION_KEY = "Complexkey123";

    // 생성자를 private으로 선언하여 외부에서 인스턴스화 방지
    private SecurityConfig(){

    }

    public static String getEncryptionKey() {
        return ENCRYPTION_KEY;
    }
}