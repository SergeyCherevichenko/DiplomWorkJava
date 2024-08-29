package uz.cherevichenko.model;

import jakarta.persistence.*;




@Entity
public class ObjectEntity {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getVideo3D() {
        return video3D;
    }

    public void setVideo3D(String video3D) {
        this.video3D = video3D;
    }

    public String getModel3D() {
        return model3D;
    }

    public void setModel3D(String model3D) {
        this.model3D = model3D;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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