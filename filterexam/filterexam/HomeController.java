package hello.filter.filterexam;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class HomeController {
    public HomeController() {
        log.info("HomeController 생성자 실행!")  ;
    }

    @GetMapping("/")
    public String home(){
        log.info("home() 실행");
        return "home";
    }

    @GetMapping("/hi")
    public String hi(){
        log.info("hi() 실행");
        return "hi";
    }

    @GetMapping("/hello")
    public String hello(){
        log.info("hello() 실행");
        return "hello";
    }
}