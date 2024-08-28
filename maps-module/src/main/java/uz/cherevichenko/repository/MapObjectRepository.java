package uz.cherevichenko.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.cherevichenko.model.MapObject;

import java.util.List;

public interface MapObjectRepository extends JpaRepository<MapObject, Long> {
    List<MapObject> findByNameContaining(String name);
    List<MapObject> findByLatitudeAndLongitude(double latitude, double longitude);
    List<MapObject> findAll();
}
