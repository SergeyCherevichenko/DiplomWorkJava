package uz.cherevichenko.exception_handler.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "exception.handler")
public class ErrorHandlerProperties {
    // Геттеры и сеттеры
    private boolean enabled = true;
    private boolean resourceNotFoundEnabled = true;
    private boolean accessDeniedEnabled = true;
    private boolean invalidInputEnabled = true;

}
