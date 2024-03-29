package org.example.CnJava_Project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table(name = "table_data")
public class TableDataModel {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "status")
	private String status;
	@Column(name = "list_order")
	private String listOrder;
	@Column(name = "time_order")
	private String timeOrder;
}
