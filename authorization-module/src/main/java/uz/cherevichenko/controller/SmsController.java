package uz.cherevichenko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import uz.cherevichenko.service.SmsService;

@RestController
@RequestMapping("/api/sms")
public class SmsController {

    private final SmsService smsService;

    @Autowired
    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/send")

    public String sendSms(@RequestParam String phoneNumber, @RequestParam String message) {
        try {
            smsService.sendSms(phoneNumber, message);
            return "SMS отправлено на номер: " + phoneNumber;
        } catch (Exception e) {
            return "Ошибка отправки SMS: " + e.getMessage();
        }
    }
}