package uz.cherevichenko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import uz.cherevichenko.config.TwilioConfig;

/**
 * Hello world!
 *
 */
@SpringBootApplication

public class App 
{
    public static void main( String[] args )
    {

        SpringApplication.run(App.class, args);
    }
}
