package com.deloitte.ms.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deloitte.ms.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{

	@Query(value="select * from product p where p.productid = :id", nativeQuery=true)
	public Product getProductsById(@Param("id")Integer productId);
	
	@Query(value="select * from product p where p.productname= :name", nativeQuery = true)
	public Product getProductsByName(@Param("name") String productname);
}
