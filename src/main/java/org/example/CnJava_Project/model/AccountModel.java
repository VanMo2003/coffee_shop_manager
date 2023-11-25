package org.example.CnJava_Project.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "account")
public class AccountModel {
	@Id
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "role")
	private boolean role;
}
