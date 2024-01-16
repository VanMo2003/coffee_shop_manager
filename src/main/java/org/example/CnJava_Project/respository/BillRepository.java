package org.example.CnJava_Project.respository;

import org.example.CnJava_Project.model.BillModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<BillModel, Long> {
}
