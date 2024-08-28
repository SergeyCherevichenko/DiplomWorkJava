package uz.cherevichenko.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.cherevichenko.config.TwilioConfig;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;





@Service
public class SmsService {

    private final TwilioConfig twilioConfig;

    @Autowired
    public SmsService(TwilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;
        // Инициализация Twilio при запуске
        Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());
    }

    public void sendSms(String toPhoneNumber, String messageBody) {
        if (twilioConfig.isTestMode()) {
            // В тестовом режиме просто логируем сообщение
            System.out.println("Тестовый режим: Сообщение не отправляется. Номер: " + toPhoneNumber + ", Сообщение: " + messageBody);
        } else {
            // В обычном режиме отправляем сообщение
            if (twilioConfig.getAuthorizedPhones().contains(toPhoneNumber)) {
                Message message = Message.creator(
                        new PhoneNumber(toPhoneNumber),
                        new PhoneNumber(twilioConfig.getFromNumber()), // Ваш Twilio номер
                        messageBody
                ).create();

                // Логирование успешной отправки
                System.out.println("Сообщение отправлено на номер: " + toPhoneNumber);
            } else {
                // Логирование или выброс исключения
                System.out.println("Попытка отправки сообщения на неразрешенный номер: " + toPhoneNumber);
                throw new IllegalArgumentException("Телефонный номер не разрешен для отправки сообщений.");
            }
        }
    }
}
