package org.example.CnJava_Project.respository;

import org.example.CnJava_Project.model.TableDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableDataRepository extends JpaRepository<TableDataModel, Integer> {
}
