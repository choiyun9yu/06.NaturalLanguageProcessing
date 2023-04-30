package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

        @GetMapping("hello") // 이렇게 하면 '/hello' 로 들어온 경우 아래 메소드를 실행시켜 준다.
        public String hello(Model model){
            model.addAttribute("data","hello!!");
            return "hello";
        }
}
