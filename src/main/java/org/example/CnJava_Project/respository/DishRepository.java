package org.example.CnJava_Project.respository;

import org.example.CnJava_Project.model.DishModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface DishRepository extends JpaRepository<DishModel, String> {
//	@Query(value = "UPDATE projectcnjava.employees " +
//			"SET id = :id," +
//			" nameDish = :nameDish," +
//			" unitPice = :unitPice," +
//			" WHERE (id = :id);",
//			nativeQuery = true)
//	void updateEmployee(
//			@Param("id") String id,
//			@Param("nameDish")String nameDish,
//			@Param("unitPice") Double unitPrice
//	);
}
