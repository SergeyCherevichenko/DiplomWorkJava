package uz.cherevichenko.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import uz.cherevichenko.config.TwilioConfig;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "twilio")
public class TwilioConfig {
    private String accountSid;
    private String authToken;
    private String fromNumber;
    private String trialNumber;
    private boolean enabled;
    private boolean testMode;
    private List<String> authorizedPhones;
}
