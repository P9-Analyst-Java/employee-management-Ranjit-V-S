package com.deloitte.ms.entity;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String username;
	
	private String password;
	
	private String name;
	
	private String email;
	
	private String phoneNo;
	
	private String address;
	
	public List<GrantedAuthority> getAuthorities(){
		return List.of(()-> "read");
	}
}
