package uz.cherevichenko.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import uz.cherevichenko.model.ObjectEntity;
import uz.cherevichenko.repository.ObjectRepository;


import java.util.List;

@RestController
@RequestMapping("/api/objects")
public class ObjectController {

    @Autowired
    private ObjectRepository objectRepository;

    @GetMapping
    public List<ObjectEntity> getAllObjects() {
        return objectRepository.findAll();
    }
}

