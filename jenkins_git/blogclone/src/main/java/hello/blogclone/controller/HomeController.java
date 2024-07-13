package hello.blogclone.controller;

import hello.blogclone.Service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import hello.blogclone.domain.Role;
import hello.blogclone.domain.RoleName;
import hello.blogclone.domain.User;
import hello.blogclone.repository.RoleRepository;
import hello.blogclone.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class HomeController {

//    private final UserService userService;
//
//    // 메인 홈 화면
//    @GetMapping("/")
//    public String showHomePage(Model model, @CookieValue(value = "username", defaultValue = "") String username) {
//        if (!username.isEmpty()) {
//            Optional<User> userOptional = userService.findByUserName(username);
//            if (userOptional.isPresent()) {
//                User user = userOptional.get();
//                model.addAttribute("nickname", user.getUserNick());
//                model.addAttribute("username", user.getUserName());
//            }
//        } else {
//            model.addAttribute("username", "");
//        }
//
//        Iterable<Post> blogPosts = postService.getAllPosts();
//        model.addAttribute("blogPosts", blogPosts);
//        return "home";
//    }
//
//    @GetMapping("/logout")
//    public String logoutUser (HttpServletResponse response){
//        Cookie cookie = new Cookie("username", null);
//        cookie.setMaxAge(0);
//        response.addCookie(cookie);
//        return "redirect:/";
//    }
}
