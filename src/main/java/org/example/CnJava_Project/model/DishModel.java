package org.example.CnJava_Project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "dish")
public class DishModel {
	@Id
	@Column(name = "id")
	String id;
	@Column(name = "name_dish")
	String nameDish;
	@Column(name = "unit_price")
	Double unitPrice;
}
