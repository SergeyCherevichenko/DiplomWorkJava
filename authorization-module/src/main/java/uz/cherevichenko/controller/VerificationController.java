package uz.cherevichenko.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.cherevichenko.service.VerificationService;

@RestController
@RequestMapping(value = "/api/verification")
public class VerificationController {

    @Autowired
    private VerificationService verificationService;


    @GetMapping("/isAuthorized")
    public ResponseEntity<Boolean> isAuthorized(@RequestParam String phoneNumber) {
        boolean isAuthorized = verificationService.isAuthorized(phoneNumber);
        return ResponseEntity.ok(isAuthorized);
    }
}

