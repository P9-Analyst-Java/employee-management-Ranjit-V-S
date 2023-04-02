package com.deloitte.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.deloitte.portal.model.EmpImg;

@Repository
public interface EmpImgRepo extends JpaRepository<EmpImg, Long>{
	
	@Query(value="select * from employees_img where emp_id= :id", nativeQuery = true)
	EmpImg getImgById(int id);
}
