package uz.cherevichenko.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import uz.cherevichenko.config.TwilioConfig;
import uz.cherevichenko.model.VerificationCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class VerificationService {

    private final String accountSid;
    private final String authToken;
    private final String fromPhone;
    private final TwilioConfig twilioConfig;

    @Autowired
    public VerificationService(
            @Value("${twilio.account_sid}") String accountSid,
            @Value("${twilio.auth_token}") String authToken,
            @Value("${twilio.from_number}") String fromPhone, TwilioConfig twilioConfig) {
        this.accountSid = accountSid;
        this.authToken = authToken;
        this.fromPhone = fromPhone;
        this.twilioConfig = twilioConfig;
        Twilio.init(accountSid, authToken);
    }
    public boolean isAuthorized(String phoneNumber) {
        return twilioConfig.getAuthorizedPhones().contains(phoneNumber);
    }
}