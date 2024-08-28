package uz.cherevichenko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.cherevichenko.model.ObjectEntity;
import uz.cherevichenko.repository.ObjectRepository;

@Service
public class ObjectService {

    @Autowired
    private ObjectRepository objectRepository;


    public ObjectEntity saveObject(ObjectEntity object) {
        return objectRepository.save(object);
    }

    // Другие методы, если необходимо
}

