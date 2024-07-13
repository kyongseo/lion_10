package hello.filter.filterexam3;

import hello.filter.filterexam3.UserFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FilterRegistrationBean
 */
@Configuration
public class FilterConfig {

    @Bean // 필터를 등록할 때 @ 방법보디 config 방법을 이용하면 더 직관적이고 디테일한 설정 가능
    public FilterRegistrationBean<UserFilter> authenticationFilter() {
        FilterRegistrationBean<hello.filter.filterexam3.UserFilter> registrationBean = new FilterRegistrationBean<>();
        UserFilter userFilter = new UserFilter();
        registrationBean.setFilter(userFilter);
        registrationBean.addUrlPatterns("/*"); // 요청 주소들을 의미함
        registrationBean.setOrder(1); // 필터 실행시 우선 순위 적용.. 숫자가 작을수록 높다
        return registrationBean;
    }
}
