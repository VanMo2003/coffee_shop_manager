package org.example.CnJava_Project.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "dish")
public class DishModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private String id;
	@Column(name = "name_dish")
	private String nameDish;
	@Column(name = "unit_price")
	private Double unitPrice;
	@Column(name = "dish_group")
	private int dishGroup;
}
