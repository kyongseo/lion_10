package sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import sample.bean.Book;

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
    @Scope("prototype")
    public Book book3() {
        return new Book();
    }
}