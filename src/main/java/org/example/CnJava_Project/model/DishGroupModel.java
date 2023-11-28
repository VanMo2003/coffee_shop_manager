package org.example.CnJava_Project.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "dish_group")
public class DishGroupModel {
	@Id
	@Column(name = "id")
	private int idDishGroup;
	@Column(name = "name_dish_group")
	private String nameDishGroup;
}
