package hello.blogclone.controller;

import hello.blogclone.Service.UserService;
import hello.blogclone.domain.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/userregform")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/userregform")
    public String registerUser(@RequestParam("username") String username, @RequestParam("email") String email,
                               @RequestParam("password") String password, @RequestParam("usernick") String usernick) {
        userService.registerUser(username, email, password, usernick);
        return "redirect:/loginform";
    }

    @GetMapping("/loginform")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/loginform")
    public String loginUser(@RequestParam("username") String username,
                            @RequestParam("password") String password, HttpServletResponse response) {
        if (userService.validateUser(username, password)) {
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60 * 60 * 24); //하루
            response.addCookie(cookie);
            return "redirect:/";
        }
        return "redirect:/loginform?error";
    }

    @GetMapping("/@{username}")
    public String showMyPage(@PathVariable("username") String username, Model model) {
        Optional<User> userOptional = userService.findByUserName(username);
        if (userOptional.isPresent()) {
            model.addAttribute("user", userOptional.get());
            return "mypage";
        }
        return "redirect:/loginform";
    }
}