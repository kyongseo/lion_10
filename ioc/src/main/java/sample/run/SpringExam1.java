package sample.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sample.bean.MyBean;
import sample.config.MyBeanConfig;

// 빈을 생성하는 하는 방법
// 1. 직접 사용 -> 인스턴스 객체 생성하기
// 2. 스프링 ioc 컨테이너 사용하기


public class SpringExam1 {

    public static void main(String[] args) {

        /**
         * 1. 직접 사용하는 경우
         */
        System.out.println("직접 사용해보기");
        MyBean bean = new MyBean();
        bean.setName("park");

        System.out.println(bean);

        // new 해서 객체 생성하고... 좀 너무 복잡하다! ==> 그래서 ioc 컨테이너를 이용하자
        System.out.println("======================================");

        /**
         * 2. 스프링 ioc container 를 사용하는 경우
         *  2-1) 스프링 컨포넌트 애노테이션으로 빈으로 사용할 것이라고 알려줘야 빈으로 등록 가능 -> 하지만 컴포넌트 스캔은 org.. 폴더에 있어야 함
         *  2-2) 자바 파일을 통해서 알려줌 --> config 라는 패키지를 만들어서 @Bean 애노테이션을 달아서 메서드 생성하여 빈 등록
         *  2-3) xml을 통해서 알려줌 -> <bean id = "???" class "sample.MyBean"/> 으로 등록하여 사용 -- (현재는 사용하지 않음)
         *  지금 예제들은 전부 2-2) 방법 사용
         */

        // (1) BeanFactory -- 빈을 생성하는데 간단한 기능만 포함 -> aop 기술은 사용 불가

        // (2) ApplicationContext 을 사용하여 빈 사용하기
        System.out.println("ApplicationContext 생성 전");

        // -> 공장이 생성될 때 어떤 빈을 생성해야 할지 알아야 함 -> MyBeanConfig.class 에 있는 빈을 등록해달라고 하는 구문
        // MyBeanConfig.class 에 @Bean 어노테이션이 붙은 애들은 다 출력
        ApplicationContext context = new AnnotationConfigApplicationContext(MyBeanConfig.class);

        System.out.println("ApplicationContext 생성 후");

        // (2-1) 아이디를 알려줌
        MyBean bean1 = (MyBean)context.getBean("myBean"); // 아이디를 알려줌

        bean1.setName("ks");
        System.out.println("bean1 : " + bean1);

        // (2-2) 빈에 아이디가 아닌 타입을 넣어서 호츌하기
        // MyBean bean2 = context.getBean("myBean.class"); // 해당 타입의 객체가 하나만 존재할 경우는 오류가 없음
        // 하지만 빈이 2개 이상 존재할 경우에는 오류 발생. 즉, 아래처럼 작성
        // 아이디가 아닌 타입만 알려준 것 -> 즉, 유추해서 하나만 골라줌

        MyBean bean2 = context.getBean("myBean2", MyBean.class);

        bean2.setName("park");
        System.out.println("bean2 : " + bean2);

        // == 은 주소, .equals은 값이 같은지..
        if (bean2 == bean1) {
            System.out.println("bean1과 bean2은 주소가 같아요. 같은 인스턴스입니다.");
        } else {
            System.out.println("bean1과 bean2는 다른 인스턴스입니다.");
        }

        MyBean bean3 = context.getBean("myBean", MyBean.class);
        bean3.setName("lee");
        System.out.println("bean3 : " + bean3);

        if (bean3 == bean1) {
            System.out.println("bean1과 bean3은 같은 인스턴스입니다.");
        }

        // (2-3) @Scope("prototype") 으로 생성하기
        // 얘는 새로운 빈을 매번 등록한다는 의미

        System.out.println("============@Scope 생성하기============");

        MyBean bean4 = context.getBean("myBean3", MyBean.class);
        bean4.setName("hong");

        MyBean bean5 = context.getBean("myBean3", MyBean.class);
        bean5.setName("lee");

        System.out.println("bean4 : " + bean4);
        System.out.println("bean5 : " + bean5);

        MyBean bean6 = context.getBean("myBean4", MyBean.class);
        System.out.println("bean6 : " + bean6);

    }
}
