package org.example.CnJava_Project.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "bill")
public class BillModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "number_table")
	private int numberTable;
	@Column(name = "order_date")
	private String orderDate;
	@Column(name = "list_dish")
	private String listDish;
	@Column(name = "total_money")
	private Double totalMoney;
}
