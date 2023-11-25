package org.example.CnJava_Project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class InfoShopModel {
	@Id
	@Column(name = "name_shop")
	private String nameShop;
	@Column(name = "total_table")
	private int totalTable;
}
