package org.example.CnJava_Project.respository;

import org.example.CnJava_Project.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, String> {
//	@Query(value = "UPDATE projectcnjava.employees " +
//			"SET cccd = :cccd," +
//			" birth_place = :birthPlace," +
//			" date_of_birth = :dateOfBirth," +
//			" full_name = :fullName," +
//			" number_phone = :numberPhone," +
//			" role = :role," +
//			" sex = :sex" +
//			" WHERE (cccd = :cccd);",
//		nativeQuery = true)
//	void updateEmployee(
//			@Param("cccd") String cccd,
//			@Param("fullName")String fullName,
//			@Param("dateOfBirth") Date dateOfBirth,
//			@Param("birthPlace")String birthPlace,
//			@Param("numberPhone")String numberPhone,
//			@Param("role")boolean role,
//			@Param("sex")boolean sex
//	);
}
