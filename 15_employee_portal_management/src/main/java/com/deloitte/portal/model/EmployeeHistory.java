package com.deloitte.portal.model;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name= "employement_history")
@Data
public class EmployeeHistory {

	@Id
	@Column(name="id")
	private Integer empHistoryId;
	
	@Column(name="emp_id", insertable = false, updatable = false)
	private Integer empId;
	
	@Column(name="organization_name")
	private String orgName;
	
	@Column(name="from_date")
	private Date fromDate;
	
	@Column(name="until_date")
	private Date toDate;
	
	private String location;
	
	private String country;
	
	private String post;
	
	@Column(name = "skill_used")
	private String skills;
	
	@ManyToOne()
	@JoinColumn(name = "emp_id")
	private Employee employee;
	
}
