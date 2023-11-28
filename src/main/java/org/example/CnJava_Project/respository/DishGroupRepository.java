package org.example.CnJava_Project.respository;

import org.example.CnJava_Project.model.DishGroupModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishGroupRepository extends JpaRepository<DishGroupModel, Integer> {
}
