package com.deloitte.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.deloitte.portal.model.Employee;
import com.deloitte.portal.repository.EmployeeRepository;

public class EmailValidation {

	@Autowired
	EmployeeRepository empRepo;
	
	public List<Employee> searchEmployeeById(int id) {
		if(empRepo.searchEmployeeById(id).isEmpty()) {
			return null;
		}
		return empRepo.searchEmployeeById(id);
	}
}
