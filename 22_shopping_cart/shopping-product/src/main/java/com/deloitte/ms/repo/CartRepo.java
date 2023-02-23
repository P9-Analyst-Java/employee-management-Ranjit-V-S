package com.deloitte.ms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deloitte.ms.entity.CartDetails;

@Repository
public interface CartRepo extends JpaRepository<CartDetails, Long>{

	@Query(value = "select * from cart c where c.customername=:name", nativeQuery = true)
	List<CartDetails> getCartByCustomername(@Param("name")String customername);
	
}
