package com.deloitte.ms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product{

	@Id
	@Column(name = "productid")
	private int productId;
	
	@Column(name = "productname")
	private String productName;
	
	@Column(name = "productcategory")
	private String productCategory;
	
	@Column(name = "productprice")
	private long productPrice;
	
	@Column(name = "stocks")
	private int stocks;
}
