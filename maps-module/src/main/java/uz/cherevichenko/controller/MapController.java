package uz.cherevichenko.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import uz.cherevichenko.model.MapObject;
import uz.cherevichenko.repository.MapObjectRepository;
import uz.cherevichenko.service.VerificationService;

@Controller
@RequiredArgsConstructor
public class MapController {


    private final MapObjectRepository mapObjectRepository;
    private final VerificationService verificationService;

    @GetMapping("/map")
    public String getMap(HttpServletRequest request, HttpServletResponse response, Model model) {
        HttpSession session = request.getSession(false); // false чтобы не создавать новую сессию
        if (session != null && session.getAttribute("authenticatedUser") != null) {
            String phoneNumber = (String) session.getAttribute("authenticatedUser");

            if (phoneNumber != null && verificationService.isAuthorized(phoneNumber)) {
                // Настройка заголовков кэширования
                response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
                response.setHeader("Pragma", "no-cache");
                response.setDateHeader("Expires", 0);

                Iterable<MapObject> mapObjects = mapObjectRepository.findAll();
                model.addAttribute("mapObjects", mapObjects);
                return "map"; // Возвращаем имя шаблона
            } else {
                return "redirect:/login"; // Если пользователь не авторизован
            }
        } else {
            return "redirect:/login"; // Если сессия отсутствует
        }
    }
}
