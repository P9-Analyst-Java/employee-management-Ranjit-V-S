package com.deloitte.ms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartid")
	private Integer cartid;
	
	@Column(name = "stock")
	private Integer stock;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "customername")
	private String customername;
	
	@Column(name = "productname")
	private String productname;
	
	@Column(name = "price")
	private long price;

	public CartDetails(Integer stock, String category, String customername, String productname, long price) {
		super();
		this.stock = stock;
		this.category = category;
		this.customername = customername;
		this.productname = productname;
		this.price = price;
	}
	
	
}
