package com.deloitte.portal.constraints;

import java.util.List;

import com.deloitte.portal.model.Employee;
import com.deloitte.portal.service.EmailValidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmpIdValidator implements ConstraintValidator<EmpIdConstraint, Integer>{

	EmailValidation emailValidation= new EmailValidation();
	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		List<Employee> emp = emailValidation.searchEmployeeById(value);
		
		if(emp == null) {
			return true;
		}
		return false;
	}

}
