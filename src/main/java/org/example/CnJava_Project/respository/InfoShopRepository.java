package org.example.CnJava_Project.respository;

import org.example.CnJava_Project.model.InfoShopModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoShopRepository extends JpaRepository<InfoShopModel, String> {
}
