package uz.cherevichenko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uz.cherevichenko.service.VerificationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthControllerMaps {

    @Autowired
    private VerificationService verificationService;

    @PostMapping("/login")
    public String login(@RequestParam("phoneNumber") String phoneNumber, HttpServletRequest request, Model model) {
        if (verificationService.isAuthorized(phoneNumber)) {
            HttpSession session = request.getSession(true); // Создание новой сессии, если ее нет
            session.setAttribute("authenticatedUser", phoneNumber);
            return "redirect:/map";
        } else {
            model.addAttribute("error", "Unauthorized phone number");
            return "login"; // Возвращаемся на страницу авторизации с ошибкой
        }
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Возвращаем страницу авторизации
    }
}
