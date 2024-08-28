package uz.cherevichenko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class LoginController {

    @GetMapping("/login")

    public String login() {
        return "login"; // Убедитесь, что у вас есть страница login.html в папке templates
    }
}