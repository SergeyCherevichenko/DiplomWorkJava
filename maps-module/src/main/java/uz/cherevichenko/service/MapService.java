package uz.cherevichenko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.cherevichenko.model.MapObject;
import uz.cherevichenko.repository.MapObjectRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MapService {

    @Autowired
    private MapObjectRepository mapObjectRepository;



    public List<MapObject> getAllMapObjects() {
        return mapObjectRepository.findAll();
    }

    public Optional<MapObject> getMapObjectById(Long id) {
        return mapObjectRepository.findById(id);
    }



    public MapObject saveMapObject(MapObject mapObject) {
        return mapObjectRepository.save(mapObject);
    }

    public void deleteMapObject(Long id) {
        mapObjectRepository.deleteById(id);
    }
}
