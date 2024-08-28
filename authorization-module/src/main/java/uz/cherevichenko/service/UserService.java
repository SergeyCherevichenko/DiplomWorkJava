package uz.cherevichenko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.cherevichenko.config.TwilioConfig;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final Map<String, String> verificationCodes = new HashMap<>();
    private final TwilioConfig twilioConfig;

    @Autowired
    public UserService(TwilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;
    }

    public void saveVerificationCode(String phoneNumber, String code) {
        verificationCodes.put(phoneNumber, code);
    }

    public boolean verifyCode(String phoneNumber, String code) {
        return code.equals(verificationCodes.get(phoneNumber));
    }

    public boolean isAuthorizedPhone(String phoneNumber) {
        return twilioConfig.getAuthorizedPhones().contains(phoneNumber);
    }
}
