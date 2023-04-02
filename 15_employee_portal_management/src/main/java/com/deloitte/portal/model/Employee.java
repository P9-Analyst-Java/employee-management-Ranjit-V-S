package com.deloitte.portal.model;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.deloitte.portal.constraints.AadhaarNoConstraint;
import com.deloitte.portal.constraints.AgeConstraint;
import com.deloitte.portal.constraints.PanNoConstraint;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "employees")
@Table(name = "employees", uniqueConstraints = {@UniqueConstraint(columnNames = {"email_id","office_mail","emp_id"})})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	@Id
	@Column(name="emp_id",unique = true, nullable = false)
	@NotNull(message = "Please input valid Id")
	private Integer empId;
	
	@NotEmpty(message = "Input between 1 to 50 characters")
	@Pattern(regexp = "(?=.*[a-zA-Z]).{1,50}$", message="Please input alphabets only!")
	@Column(name="first_name")
	private String firstName;
	
	@NotEmpty(message = "Input between 1 to 50 characters")
	@Pattern(regexp ="(?=.*[a-zA-Z]).{1,50}$", message="Please input alphabets only!")
	@Column(name="last_name")
	private String lastName;
	
	@NotBlank(message = "Please input valid gender!")
	private String gender;
	
	@AgeConstraint(message = "Please input a valid date, age must be >=20")
	private String dob;
	
	@Column(name="pan_num", nullable = true)
	@PanNoConstraint(message = "Please input alphanumeric only! 10 characters required")
	private String panNo;
	
	@Column(name="aadhaar_num")
	@AadhaarNoConstraint(message = "Please input numeric only! Maximum 12 characters")
	private String aadhaarNo;
	
	@NotEmpty(message = "Please input valid mobile #")
	@Size(max = 10, message = "Please input 10 characters only!")
	@Pattern(regexp = "(?=.*[0-9]).{10}$", message="Please input alphanumeric only! Maximum 10 characters")
	@Column(name = "mobile_num")
	private String mobileNo;
	
	@NotEmpty(message = "Please input an email!")
	@Email(message = "Please input a valid email!")
	@Column(name="email_id", unique = true, nullable = false)
	private String emailId;
	
	@NotEmpty(message = "Please input an email!")
	@Email(message = "Please input a valid email or Email is already taken!")
	@Column(name="office_mail", unique = true, nullable = false)
	private String officeEmailId;
	
	@Size(max= 200, message = "Text should not exceed 200 characters!")
	@Column(name="permanent_address")
	private String permanentAddress;
	
	@Size(max= 200, message = "Text should not exceed 200 characters!")
	@Column(name="present_address")
	private String presentAddress;
	
	@NotBlank(message = "Please select a valid blood group!")
	@Column(name="blood_group")
	private String bloodGroup;
	
	@Lob
	@Column(name="profile_pict")
	private byte[] profilePic;
	
	//public MultipartFile img;
	
	@NotBlank(message = "Please input a valid DoJ!")
	private String doj;
	
	@NotNull(message = "Please select a value between 7 to 30!")
	@Min(value = 7,message = "Please select a value between 7 to 30!")
	@Max(value = 30, message = "Please select a value between 7 to 30!")
	@Column(name="emp_level")
	private Integer empLevel;
	
	@NotEmpty(message = "Please input valid post!")
	@Size(max = 30, message = "Please input 30 characters only!")
	@Pattern(regexp = "(?=.*[a-zA-Z]).{1,30}$", message="Please input alphabets only!")
	@Column(name="post_name")
	private String postName;
	
	@NotNull(message = "Please input valid basic pay!")
	@Min(value = 100, message="Please input between 3 to 8 characters!")
	@Max(value = 99999999, message="Please input between 3 to 8 characters!")
	@Column(name="basic_pay")
	private Integer basicPay;
	
	@NotNull(message = "Please input valid house allowance!")
	@Min(value = 100,message="Please input between 3 to 5 characters!")
	@Max(value = 99999, message="Please input between 3 to 5 characters!")
	@Column(name="house_allowance")
	private Integer houseAllowance;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
	private List<EmployeeHistory> history;
	
}
