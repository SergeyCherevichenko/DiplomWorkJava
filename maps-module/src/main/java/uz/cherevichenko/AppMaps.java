package uz.cherevichenko;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uz.cherevichenko.model.ObjectEntity;
import uz.cherevichenko.repository.ObjectRepository;

@SpringBootApplication
public class AppMaps implements CommandLineRunner {

    String authorizedPhones = System.getenv("TWILIO_AUTHORIZED_PHONES");

    private final ObjectRepository objectRepository;

    @Autowired
    public AppMaps(ObjectRepository objectRepository) {
        this.objectRepository = objectRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(AppMaps.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Создаем объект аэропорта
        ObjectEntity airport = new ObjectEntity();
        airport.setName("Ташкентский Международный Аэропорт");
        airport.setCoordinates("41.262575, 69.265201");
        airport.setDescription("http://localhost:8080/css/uploads/description/airport_tashkent_discription.docx");
        airport.setContacts("+998 71 140-28-28");
        airport.setScheme("http://localhost:8080/css/uploads/scheme/tashkent-airport-sheme.jpg");
        airport.setVideo3D("http://localhost:8080/css/uploads/videos/airport_tashkent_video.mp4");
        airport.setModel3D("http://localhost:8080/css/uploads/scheme/tashkent-airport-sheme.jpg");
        airport.setPhoto("http://localhost:8080/css/uploads/photos/aurport_tashkent_photos.jpg");
        airport.setVideo("http://localhost:8080/css/uploads/videos/airport_tashkent_video.mp4");

        ObjectEntity mfa = new ObjectEntity();
        mfa.setName("Министерство Иностранных дел РУз");
        mfa.setCoordinates("41.310625233915, 69.2572293690221");
        mfa.setDescription("http://localhost:8080/css/uploads/description/MFA_RUz.docx");
        mfa.setContacts("+998 71 240-24-24");
        mfa.setScheme("http://localhost:8080/css/uploads/photos/MFA_RUz.jpg");
        mfa.setVideo3D("http://localhost:8080/css/uploads/videos/MFARUz.png");
        mfa.setModel3D("http://localhost:8080/css/uploads/photos/MFA_RUz.jpg");
        mfa.setPhoto("http://localhost:8080/css/uploads/photos/MFA_RUz.jpg");
        mfa.setVideo("http://localhost:8080/css/uploads/videos/MFARUz.png");

        // Сохраняем объект в базу данных
        objectRepository.save(airport);
        objectRepository.save(mfa);
    }
}

