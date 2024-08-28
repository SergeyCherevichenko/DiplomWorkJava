package uz.cherevichenko.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class ObjectEntity {

    // Геттеры и сеттеры
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String coordinates; // Может хранить в формате "lat, long"
    private String description;
    private String contacts;
    private String scheme;
    private String video3D;
    private String model3D;
    private String photo;
    private String video;

    // Конструкторы, геттеры и сеттеры

    public ObjectEntity() {
   }

    public ObjectEntity(String name, String coordinates, String description, String contacts,
                        String scheme, String video3D, String model3D, String photo, String video) {
        this.name = name;
        this.coordinates = coordinates;
        this.description = description;
        this.contacts = contacts;
        this.scheme = scheme;
        this.video3D = video3D;
        this.model3D = model3D;
        this.photo = photo;
        this.video = video;
    }

}