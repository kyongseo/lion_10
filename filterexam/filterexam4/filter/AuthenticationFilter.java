package hello.filter.filterexam4.filter;

import hello.filter.filterexam4.entity.User;
import hello.filter.filterexam4.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Filter 인터페이스를 상속
 * doFilter => 실제 필터링 작업을 수행합니다. 요청이 필터를 통과할 때마다 호출
 */
public class AuthenticationFilter implements Filter {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            HttpServletRequest request = (HttpServletRequest) servletRequest;

            String path = request.getRequestURI(); // 요청주소 ex) /welcome, /login, / admin/list 등이 URI! localhost 뒤에 나오는 값
            String auth = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("auth")) {
                        auth = cookie.getValue();
                        break;
                    }
                }
            }

            // 인증된 사용자라면..
            if (auth != null) {

                // 요청 url 에 따라서 http://localhost:8080/admin -- Role 이  Role_Admin 인 사용자에게만 인가되도록 구현
                User user = userService.findByUsername(auth);
                if (user != null) {

                    user.setUsername(auth);
                    UserContext.setUser(user);

                    //
                    if (path.equals("/admin") && user.getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_ADMIN"))
                            || (path.equals("/welcome") && user.getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_USER")))
                    ){

                        filterChain.doFilter(request, servletResponse);
                        UserContext.clear();
                        return;

                    }
                }

                // 권한이 없는 사용자가 접근한다면
                if (path.equals("/admin") || path.equals("/info")){
                    response.sendRedirect("/access-denied");
                }else {
                    filterChain.doFilter(servletRequest, servletResponse);
                    UserContext.clear();
                }

//                User user = new User();
//                user.setUsername(auth);
//                UserContext.setUser(user);
            }
            filterChain.doFilter(servletRequest, servletResponse);
        }finally {
            UserContext.clear();
        }
    }
}
