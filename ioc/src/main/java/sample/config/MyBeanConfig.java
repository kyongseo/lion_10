package sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import sample.bean.Book;
import sample.bean.MyBean;

// "sample" 폴더에서 @Component 가 붙은 파일을 찾아준다는 의미.
// 즉, Bean 을 사용할거면 클래스 위에 @Component 를 붙여야 함.
@ComponentScan(basePackages = "sample")
public class MyBeanConfig {

    @Bean
    public MyBean myBean(){
        System.out.printf("myBean() => ");
        return new MyBean();
    }

    @Bean
    public MyBean myBean2(){
        System.out.printf("myBean2() => ");
        return new MyBean();
    }

    @Bean
    public MyBean myBean21() {
        System.out.printf("myBean21() => ");
        return new MyBean();
    }

    @Bean
    @Scope("prototype")
    public MyBean myBean3(){
        return new MyBean();
    }

    @Bean
    public MyBean myBean4(){
        return new MyBean("haha", 10);
    }


}
