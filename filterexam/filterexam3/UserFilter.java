package hello.filter.filterexam3;

import hello.filter.filterexam3.UserContext;
import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class UserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
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

            User user = new User();
            user.setUsername(auth);

            UserContext.setUser(user);

            filterChain.doFilter(servletRequest, servletResponse);
        }finally {
            UserContext.clear();
        }


    }
}
