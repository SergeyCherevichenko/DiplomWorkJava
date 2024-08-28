package uz.cherevichenko.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uz.cherevichenko.service.SmsService;
import uz.cherevichenko.service.UserService;
import uz.cherevichenko.service.VerificationService;

import java.io.IOException;

@RestController
@RequestMapping("/api/auth")

public class AuthController {

    private final SmsService smsService;
    private final UserService userService;
    private final VerificationService verificationService;

    @Autowired
    public AuthController(SmsService smsService, UserService userService, VerificationService verificationService) {
        this.smsService = smsService;
        this.userService = userService;
        this.verificationService = verificationService;
    }

    @PostMapping("/send-code")


    public ResponseEntity<String> sendVerificationCode(@RequestParam("phoneNumber") String phoneNumber) {
        System.out.println("Received phone number: " + phoneNumber);
        String code = generateVerificationCode();
        try {
            smsService.sendSms(phoneNumber, "Your verification code is: " + code);
            userService.saveVerificationCode(phoneNumber, code);
            return ResponseEntity.ok("Verification code sent");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Failed to send verification code");
        }
    }

    @PostMapping("/verify-code")
    public void verifyCode(@RequestParam("phoneNumber") String phoneNumber,
                           @RequestParam("code") String code,
                           HttpServletRequest request,
                           HttpServletResponse response) throws IOException {
        boolean isValid = verificationService.isAuthorized(phoneNumber);

        if (isValid) {
            HttpSession session = request.getSession(true);
            session.setAttribute("authenticatedUser", phoneNumber);
            // Перенаправление на /map
            response.sendRedirect("/map");
        } else {
            // Обработка ошибки
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid code");
        }
    }

    private String generateVerificationCode() {
        return String.format("%06d", (int) (Math.random() * 1000000));
    }
}