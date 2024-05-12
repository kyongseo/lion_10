package sample.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sample.bean.Book;
import sample.config.BookConfig;

public class BookExam01 {

    public static void main(String[] args) {
        System.out.println("ApplicationContext 생성 전!");
        ApplicationContext context = new AnnotationConfigApplicationContext(BookConfig.class);
        System.out.println("ApplicationContext 생성 후!");

        Book book1 = (Book) context.getBean("book1", Book.class);
        book1.setTitle("모두의 자바");
        book1.setPrice(20000);
        System.out.println(book1);

//        Book book2 = context.getBean("book2", Book.class);
//        book2.setTitle("자바의 모든 것");
//        System.out.println(book2); // 자바의 모든 것
//
//        Book book22 = context.getBean("book2", Book.class);
//        book22.setTitle("자바의 모든 것 또다르게");
//        System.out.println(book22); //자바의 모든 것 또다르게
//        System.out.println(book2); //자바의 모든 것 또다르게 -> 싱글톤 패턴으로 인해 바뀜
//
//        if (book2 == book22)
//            System.out.println("두 bean이 같습니다");
//        else System.out.println("두 bean이 다릅니다");
//
//        //Scope
//        Book book3 = context.getBean("book3", Book.class);
//        book3.setTitle("book3의 제목");
//        Book book4 = context.getBean("book3", Book.class);
//        book4.setTitle("book4의 제목");
//
//        System.out.println(book3); //book3의 제목
//        System.out.println(book4); //book4의 제목
//        System.out.println(book3); //book3의 제목 // Scope를 이용하여 프로토타입으로 바꿔줌
//
//        if (book3 == book4)
//            System.out.println("두 bean이 같습니다");
//        else System.out.println("두 bean이 다릅니다");
    }
}