package hello.filter.filterexam3;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @GetMapping("/login")
    public String loginForm() {
        return "/loginform";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, HttpServletResponse response) {

        System.out.println("Username: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());

        // 사용자가 보낸 username 과 password 가 서버가 원하는 정보와 일치하는지 확인하고 --> 사용자 정보를 유지
        if (user.getUsername().equals("ks") && user.getPassword().equals("1234")) {
            // 실제 서비스애서는 id와 password 를 검사해서 진행하지만 여기선 간단하게... --> 쿠키를 사용하자
            Cookie cookie = new Cookie("auth","ks");
            cookie.setPath("/");

            // 이렇게 생성된 쿠키는 클라이언트에게 보내져야 한다.
            response.addCookie(cookie);
            //  cookie.setMaxAge(24*60*60);하루동안 유지한다는 의미
        }
        return "redirect:/welcome";
    }

    @GetMapping("/welcome")
    public String welcome() {
        User user = UserContext.getUser();
        if (user != null) {
            return "welcome";
        }else {
            return "redirect:/loginform";
        }
    }

    @GetMapping("/info")
    public String info(HttpServletRequest request){
//        // 아무나 보여줄 수 있는 페이지는 아니고,
//        // 로그인한 사용자에게만 보여준다.
//        String auth = null;
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("auth")) {
//                    auth = cookie.getValue();
//                    break;
//                }
//            }
//        }
//
//        if (auth != null) {
//            return "info";
//        }else {
//            return "redirect:/loginform";
//        }
        User user = UserContext.getUser();
        if(user != null)
            return "info";
        else
            return "redirect:/loginform";
    }
}
