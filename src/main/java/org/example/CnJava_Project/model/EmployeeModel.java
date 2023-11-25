package org.example.CnJava_Project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "employees")
public class EmployeeModel {
	@Id
	@Column(name = "cccd")
	private String cccd;
	@Column(name = "full_name")
	private String fullName;
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	@Column(name = "birth_place")
	private String BirthPlace;
	@Column(name = "number_phone")
	private String numberPhone;
	@Column(name = "sex")
	private boolean sex;
	@Column(name = "role")
	private boolean role;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
}
