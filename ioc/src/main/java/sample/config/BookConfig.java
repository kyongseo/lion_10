package sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import sample.bean.Book;

/**
 * 자바 파일을 통해서 알려줌 -- config 라는 패키지를 만들어서 @Bean 애노테이션을 달아서 메서드 생성하여 빈 등록
 */
@ComponentScan(basePackages = "sample.bean")
public class BookConfig {

    @Bean
    public Book book1() {
        return new Book();
    }

    @Bean
    public Book book2() {
        return new Book();
    }

    @Bean
    public Book book21() {
        return new Book();
    }

    @Bean
    @Scope("prototype")
    public Book book3() {
        return new Book();
    }
}