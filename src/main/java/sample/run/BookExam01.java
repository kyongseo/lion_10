package sample.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sample.bean.Book;
import sample.config.BookConfig;

public class BookExam01 {

    public static void main(String[] args) {
        System.out.println("ApplicationContext 생성 전!");
        // ApplicationContext 을 사용하여 빈 사용하기
        // 공장이 생성될 때 어떤 빈을 생성해야 할지 알아야 함 -> BookConfig.class 에 있는 @Bean 을 등록해달라고 하는 구문
        ApplicationContext context = new AnnotationConfigApplicationContext(BookConfig.class);
        System.out.println("ApplicationContext 생성 후!");

        // 아이디를 알려줌 => BookConfig
        Book book1 = (Book) context.getBean("book1", Book.class);
        book1.setTitle("모두의 자바");
        book1.setPrice(20000);
        System.out.println("book1 : " + book1);

        Book book2 = (Book) context.getBean("book2", Book.class);
        book2.setTitle("자바의 모든 것");
        System.out.println("book2 : " + book2); // 자바의 모든 것

        Book book3 = (Book) context.getBean("book2", Book.class);
        book3.setTitle("자바의 모든 것 또다르게");

        System.out.println("book3 : " + book3); //자바의 모든 것 또다르게

        System.out.println("book2 : " + book2); //자바의 모든 것 또다르게 -> 싱글톤 패턴으로 인해 바뀜

        if (book2 == book3)
            System.out.println("book2, book3 두 bean이 같습니다");
        else System.out.println("book2, book3 두 bean이 다릅니다");

        System.out.println("==============================================");

        //Scope
        Book book4 = context.getBean("book3", Book.class);
        book4.setTitle("book4 제목");

        Book book5 = context.getBean("book3", Book.class);
        book5.setTitle("book5 제목");

        System.out.println("book4 : " + book4); //book4 제목
        System.out.println("book5 : " + book5); //book5 제목

        System.out.println("book3 : " + book3); //book3의 제목 // Scope를 이용하여 프로토타입으로 바꿔줌
        System.out.println("book2 : " + book2); //book3의 제목 // Scope를 이용하여 프로토타입으로 바꿔줌

        if (book4 == book5)
            System.out.println("book4, book5 두 bean이 같습니다");
        else System.out.println("book4, book5 두 bean이 다릅니다");
    }
}