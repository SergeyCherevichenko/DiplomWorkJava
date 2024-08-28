package uz.cherevichenko.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.cherevichenko.model.ObjectEntity;

public interface ObjectRepository extends JpaRepository<ObjectEntity, Long> {
}

