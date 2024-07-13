package hello.filter.filterexam4.controller;

import hello.filter.filterexam4.entity.User;
import hello.filter.filterexam4.filter.UserContext;
import hello.filter.filterexam4.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    //로그인 폼
    @GetMapping("/loginform")
    public String login() {
        return "/loginform";
    }


    //로그인
    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, HttpServletResponse response) {

        User byUser = userService.findByUsername(user.getUsername());

        // 사용자가 보낸 username 과 password 가 서버가 원하는 정보와 일치하는지 확인하고 --> 사용자 정보를 유지
        if (byUser != null && user.getPassword().equals(byUser.getPassword())) {
            // 실제 서비스애서는 id와 password 를 검사해서 진행하지만 여기선 간단하게... --> 쿠키를 사용하자
            Cookie cookie = new Cookie("auth",user.getUsername());
            cookie.setPath("/");
            cookie.setHttpOnly(true); // 자바스크립트로는 쿠키에 접근할 수 없다.

            // 이렇게 생성된 쿠키는 클라이언트에게 보내져야 한다.
            // 쿠키는 같은 이름의 쿠키가 2개 존재할 수 없다.
            // 같은 이름으로 들어오면 쿠키는 덮어진다.
            // 이것을 이용해서 로그아웃 구현 가능
            response.addCookie(cookie);

            return "redirect:/welcome";
            //  cookie.setMaxAge(24*60*60);하루동안 유지한다는 의미
        }else {
            return "redirect:/loginform";
        }
    }

    //로그아웃 구현
    @GetMapping("/logout")
    public String logout(HttpServletResponse response) {
        // 쿠키를 삭제하면 로그아웃이 되는데,
        // 브라우저의 쿠키는 서버에서 삭제할 수 없다.
        // 그래서 똑같은 이름의 쿠키를 만들어서 보낸다.
        Cookie cookie = new Cookie("auth", "");
        cookie.setPath("/");
        cookie.setMaxAge(0); // 쿠키 유지 시간

        response.addCookie(cookie);

        return "redirect:/loginform";
    }

    // welcome
    @GetMapping("/welcome")
    public String welcome() {

        User user = UserContext.getUser();
        // 유저가 로그인한 상태면 = 쿠키에 값이 유지된 상태
        if (user != null)
            return "welcome";
        else
            return "redirect:/loginform";
    }

    //info
    @GetMapping("/info")
    public String info() {

        User user = UserContext.getUser();
        // 유저가 로그인한 상태면 = 쿠키에 값이 유지된 상태
        if(user != null)
            return "info";
        else
            return "redirect:/loginform";
    }

}
